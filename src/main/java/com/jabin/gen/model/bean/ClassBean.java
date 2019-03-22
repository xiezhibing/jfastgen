package com.jabin.gen.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类信息
 * @author XieZhibing
 * @date 2017年8月27日 下午1:32:24
 * @version <b>1.0.0</b>
 */
public class ClassBean implements Serializable {

	/**
	 * TODO（变量描述）
	 */
	private static final long serialVersionUID = 1L;

	/** 项目类的模块名称 */
	private String moduleName = "";
	/** 实体表名 */
	private String tableName;
	/** 主键列：保证唯一主键, 只取第一个主键字段 */
	private String primaryColumn;

	/** 实体类名 */
	private String entityClassName;
	/** 实体对象名 */
	private String entityObjectName;
	/** 主键字段: 保证唯一主键, 只取第一个主键字段 */
	private FieldBean primaryField;
	/** 实体类注释 */
	private String entityComment;
	/** 类的包路径信息 */
	private PackageBean packageBean;

	/** 引用类 */
	private List<String> importClassList = new ArrayList<String>();
	/** 所有列, 包含忽略列 */
	private List<String> allColumnList = new ArrayList<String>();
	/** 所有非忽略、非主键列 */
	private List<String> generalColumnList = new ArrayList<String>();
	/** 忽略的列 */
	private List<String> ignoredColumnList = new ArrayList<String>();

	/** 所有字段, 包含忽略列 */
	private List<FieldBean> allFieldList = new ArrayList<FieldBean>();
	/** 所有非忽略、非主键字段 */
	private List<FieldBean> generalFieldList = new ArrayList<FieldBean>();
	/** 忽略的字段 */
	private List<FieldBean> ignoreFieldList = new ArrayList<FieldBean>();

	/** 类的包路径信息 */
	public PackageBean getPackageBean() {
		return packageBean;
	}

	/** 类的包路径信息 */
	public void setPackageBean(PackageBean packageBean) {
		this.packageBean = packageBean;
	}

	/** 项目类的模块名称 */
	public String getModuleName() {
		return moduleName;
	}

	/** 项目类的模块名称 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/** 实体表名 */
	public String getTableName() {
		return tableName;
	}

	/** 实体表名 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/** 主键列：保证唯一主键, 只取第一个主键字段 */
	public String getPrimaryColumn() {
		return primaryColumn;
	}

	/** 主键列：保证唯一主键, 只取第一个主键字段 */
	public void setPrimaryColumn(String primaryColumn) {
		this.primaryColumn = primaryColumn;
	}

	/** 实体类名 */
	public String getEntityClassName() {
		return entityClassName;
	}

	/** 实体类名 */
	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	/** 实体对象名 */
	public String getEntityObjectName() {
		return entityObjectName;
	}

	/** 实体对象名 */
	public void setEntityObjectName(String entityObjectName) {
		this.entityObjectName = entityObjectName;
	}

	/** 主键字段: 保证唯一主键, 只取第一个主键字段 */
	public FieldBean getPrimaryField() {
		return primaryField;
	}

	/** 主键字段: 保证唯一主键, 只取第一个主键字段 */
	public void setPrimaryField(FieldBean primaryField) {
		this.primaryField = primaryField;
	}

	/** 实体类注释 */
	public String getEntityComment() {
		return entityComment;
	}

	/** 实体类注释 */
	public void setEntityComment(String entityComment) {
		this.entityComment = entityComment;
	}
		
	/** 引用类 */
	public List<String> getImportClassList() {
		return importClassList;
	}
	
	/** 引用类 */
	public void setImportClassList(List<String> importClassList) {
		this.importClassList = importClassList;
	}

	/** 所有列, 包含忽略列 */
	public List<String> getAllColumnList() {
		return this.allColumnList;
	}

	/** 所有列, 包含忽略列 */
	public void setAllColumnList(List<String> allColumnList) {
		this.allColumnList = allColumnList;
	}

	/** 所有非忽略、非主键列 */
	public List<String> getGeneralColumnList() {
		return this.generalColumnList;
	}

	/** 所有非忽略、非主键列 */
	public void setGeneralColumnList(List<String> generalColumnList) {
		this.generalColumnList = generalColumnList;
	}

	/** 忽略的列 */
	public List<String> getIgnoredColumnList() {
		return this.ignoredColumnList;
	}

	/** 忽略的列 */
	public void setIgnoredColumnList(List<String> ignoredColumnList) {
		this.ignoredColumnList = ignoredColumnList;
	}

	/** 所有字段, 包含忽略列 */
	public List<FieldBean> getAllFieldList() {
		return this.allFieldList;
	}

	/** 所有字段, 包含忽略列 */
	public void setAllFieldList(List<FieldBean> allFieldList) {
		this.allFieldList = allFieldList;
	}

	/** 所有非忽略、非主键字段 */
	public List<FieldBean> getGeneralFieldList() {
		return this.generalFieldList;
	}

	/** 所有非忽略、非主键字段 */
	public void setGeneralFieldList(List<FieldBean> generalFieldList) {
		this.generalFieldList = generalFieldList;
	}

	/** 忽略的字段 */
	public List<FieldBean> getIgnoreFieldList() {
		return this.ignoreFieldList;
	}

	/** 忽略的字段 */
	public void setIgnoreFieldList(List<FieldBean> ignoreFieldList) {
		this.ignoreFieldList = ignoreFieldList;
	}

}
