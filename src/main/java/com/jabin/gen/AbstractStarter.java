package com.jabin.gen;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jabin.gen.model.bean.ClassBean;
import com.jabin.gen.model.bean.FieldBean;
import com.jabin.gen.model.bean.FieldOptionBean;
import com.jabin.gen.model.bean.PackageBean;
import com.jabin.gen.constant.Constants;
import com.jabin.gen.constant.FastGenConfig;
import com.jabin.gen.constant.MySqlColumnType;
import com.jabin.gen.constant.MySqlTypeConverter;
import com.jabin.gen.model.entity.ColumnInfo;
import com.jabin.gen.model.entity.TableInfo;
import com.jabin.utils.StringUtil;

/**
 * TODO（描述类的职责）
 * @author XieZhibing
 * @date 2017年8月26日 下午9:41:24
 * @version <b>1.0.0</b>
 */
public abstract class AbstractStarter implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(AbstractStarter.class);
	
	/**
	 * TODO 表对象转为类对象
	 * @author XieZhibing
	 * @date 2017年10月21日 下午5:51:09
	 * @param tableInfo
	 * @return
	 */
	public ClassBean table2Class(TableInfo tableInfo, FastGenConfig config) {
		//返回的类对象
		ClassBean classBean = new ClassBean();
		
		//检查列是否存在
		List<ColumnInfo> columnInfoList = tableInfo.getColumnList();
		if (columnInfoList == null || columnInfoList.size() == 0) {
			return classBean;
		}
		
		// 1. 添加所有的列到类中，并将转换的字段添加的类中
		this.processAllColumn(classBean, columnInfoList);
		
		// 2. 处理忽略的列
		this.processIgnoredColumn(classBean, config);
		
		// 3. 处理非忽略的列
		this.processNonIgnoredColumn(classBean, columnInfoList);		
		
		// 4. 处理表名、表描述
		this.processClassName(tableInfo, classBean);
		
		// 5. 处理 模块名、类名、对象名
		this.processModule(config, classBean);
		
		// 6. 转换类的包路径、类源代码的文件路径
		PackageBean packageBean = new PackageBean(classBean.getEntityClassName(), 
			config.getRootPackage(), classBean.getModuleName(), config.getPovoPackage());
		classBean.setPackageBean(packageBean);
		
		return classBean;
	}

	/**
	 * TODO 处理表名、类名、对象名
	 * @author XieZhibing
	 * @date 2017年10月22日 下午11:27:31
	 * @param tableInfo
	 * @param classBean
	 * @return
	 */
	public ClassBean processClassName(TableInfo tableInfo, ClassBean classBean) {
		String tableName = tableInfo.getTableName().toLowerCase();
		classBean.setTableName(tableName);
		classBean.setEntityComment(tableInfo.getTableComment());
		classBean.setEntityClassName(StringUtil.firstUpperCamel(tableName));
		classBean.setEntityObjectName(StringUtil.firstLowerCamel(tableName));
		return classBean;
	}

	/**
	 * TODO 处理模块名、类名、对象名
	 * @author XieZhibing
	 * @date 2017年10月22日 下午11:25:27
	 * @param config
	 * @param classBean
	 * @param tableName
	 */
	public ClassBean processModule(FastGenConfig config, ClassBean classBean) {
		
		//表名
		String tableName = classBean.getTableName().toLowerCase();
		//模块名
		String moduleName = config.getModuleName().toLowerCase();
		
		if(StringUtil.isNotEmpty(moduleName)) {
			classBean.setModuleName(moduleName);
		} else if(config.isFirstPrefix4ModuleName()) {
			//使用表前缀作为模块名规则
			String[] array = tableName.split("_");			
			//模块名
			moduleName = array[0].toLowerCase();
			classBean.setModuleName(moduleName);
			if(array.length <= 2){
				return classBean;
			}
			//重置实体类名、对象名
			String name = tableName.replaceFirst(moduleName, "");
			//重置实体类名、实体类对象名
			classBean.setEntityClassName(StringUtil.firstUpperCamel(name));
			classBean.setEntityObjectName(StringUtil.firstLowerCamel(name));		
		}
		return classBean;
	}
	
	/**
	 * TODO 为类转换所有的列和字段
	 * @author XieZhibing
	 * @date 2017年10月21日 下午6:49:21
	 * @param classBean
	 * @param columnInfoList
	 */
	public ClassBean processAllColumn(ClassBean classBean, List<ColumnInfo> columnInfoList) {
		
		for (ColumnInfo columnInfo : columnInfoList) {
			//添加字段
			classBean.getAllColumnList().add(columnInfo.getColumnName().toLowerCase());
			//添加列
			classBean.getAllFieldList().add(column2Field(columnInfo));
		}
		return classBean;
	}

	/**
	 * TODO 处理忽略的列
	 * @author XieZhibing
	 * @date 2017年10月21日 下午6:39:42
	 * @param config
	 * @param classBean
	 */
	public ClassBean processIgnoredColumn(ClassBean classBean, FastGenConfig config) {
		
		//忽略的列名	
		String[] ignoredColumns = config.getIgnoredColumns();
		if(ignoredColumns == null || ignoredColumns.length == 0) {
			return classBean;
		}
		
		//为类添加忽略的列
		for (String ignoredColumn : ignoredColumns) {
			//列名
			ignoredColumn = ignoredColumn.toLowerCase();
			//忽略的列必须是该表的列
			if (classBean.getAllColumnList().contains(ignoredColumn) 
					&& !classBean.getIgnoredColumnList().contains(ignoredColumn)) {
				classBean.getIgnoredColumnList().add(ignoredColumn);
			}
		}

		return classBean;
	}
	
	/**
	 * TODO 处理非忽略的列
	 * @author XieZhibing
	 * @date 2017年10月21日 下午7:05:37
	 * @param classBean
	 * @param columnInfoList
	 * @return
	 */
	public ClassBean processNonIgnoredColumn(ClassBean classBean, List<ColumnInfo> columnInfoList){
		
		//忽略的列
		List<String> ignoredColumnList = classBean.getIgnoredColumnList();
		
		for (ColumnInfo columnInfo : columnInfoList) {
			//列名
			String columnName = columnInfo.getColumnName().toLowerCase();
			if(ignoredColumnList.contains(columnName)){
				continue;
			}
			
			//转化列为字段
			FieldBean fieldInfo = column2Field(columnInfo);
			//主外键列标识: PRI 
			String columnKey = columnInfo.getColumnKey();
			//主键字段
			if (Constants.PRIMARY_KEY_VAL.equals(columnKey) && classBean.getPrimaryField() == null) {
				classBean.setPrimaryColumn(columnName);				
				classBean.setPrimaryField(fieldInfo);
			}
			
			//将未忽略、未标注为主键的列添加到普通列的列表中
			classBean.getGeneralColumnList().add(columnName);
			classBean.getGeneralFieldList().add(fieldInfo);
			
			// 为类添加将字段类型对应的引入类
			this.processImportClass(classBean, columnInfo);
		}
		
		return classBean;
	}

	/**
	 * TODO 为类添加将字段类型对应的引入类
	 * @author XieZhibing
	 * @date 2017年10月21日 下午7:31:05
	 * @param classBean
	 * @param columnInfo
	 */
	public void processImportClass(ClassBean classBean, ColumnInfo columnInfo) {
		// 字段类型转换
		MySqlColumnType fieldType = MySqlTypeConverter.convert(columnInfo.getColumnType());
		String fullName = fieldType.getFullName();
		if (fullName != null) {
			List<String> importClassList = classBean.getImportClassList();
			if(importClassList.size() == 0 || !importClassList.contains(fullName)){
				importClassList.add(fullName);	
			}
		}
	}
	
	/**
	 * TODO 列对象转为字段对象
	 * @author XieZhibing
	 * @date 2017年10月21日 下午5:50:44
	 * @param columnInfo
	 * @return
	 */
	public FieldBean column2Field(ColumnInfo columnInfo) {
		//字段对象
		FieldBean fieldBean = new FieldBean();
		
		//列名
		String columnName = columnInfo.getColumnName().toLowerCase();
		fieldBean.setColumnName(columnName);
		fieldBean.setFieldName(StringUtil.firstLowerCamel(columnName));
		fieldBean.setFirstUpperName(StringUtil.firstUpperCamel(columnName));
		fieldBean.setFieldType(MySqlTypeConverter.convert(columnInfo.getColumnType()).getSimpleName());
		fieldBean.setFieldComment(columnInfo.getColumnComment());
		fieldBean.setPrimaryKey(Constants.PRIMARY_KEY_VAL.equals(columnInfo.getColumnKey()));
		fieldBean.setAutoIncrementKey(Constants.AUTO_INCREMENT_VAL.equals(columnInfo.getExtra()));
		
		return analysisFieldComment(fieldBean);
	}
	
	/**
	 * TODO 得到数据库名称
	 * @author XieZhibing
	 * @date 2017年8月26日 下午9:44:27
	 * @param dataSource
	 * @return
	 */
	public String getTableSchema(DataSource dataSource){
		try {
			DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
			String url = metaData.getURL();
			if(url.contains("?")){
				url = url.substring(0, url.indexOf("?"));	
			}
			return url.substring(url.lastIndexOf("/")+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public FieldBean analysisFieldComment(FieldBean fieldBean){
		
		String fieldComment = fieldBean.getFieldComment();
		if(StringUtil.isEmpty(fieldComment)) {
			return fieldBean;
		}
		
		String[] splitComment = fieldComment.split(":");
		if(splitComment.length != 2) {
			return fieldBean;
		}
		
		if(StringUtil.isEmpty(splitComment[1])) {
			return fieldBean;
		}
		String comment = splitComment[1].trim().replace("[", "").replace("]", "");
		String[] splits = comment.split(",");
		if(splits == null || splits.length < 1){
			return fieldBean;
		}
		
		//下拉项
		List<FieldOptionBean> options = new ArrayList<FieldOptionBean>();
		for (String item : splits) {
			item = item.trim();
			String[] option = item.split(" ");
			if(option == null || option.length != 2) {
				continue;
			}
			
			options.add(new FieldOptionBean(option[0], option[1]));
		}
		logger.info(JSONObject.toJSONString(options));
		fieldBean.setOptionComment(splitComment[0]);
		fieldBean.setOptions(options);
		
		return fieldBean;
	}
}
