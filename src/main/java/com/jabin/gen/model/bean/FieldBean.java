package com.jabin.gen.model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.jabin.gen.constant.MySqlColumnType;

import io.parcelx.util.DateUtil;
import io.parcelx.util.StringUtil;

/**
 * TODO 字段信息
 * 
 * @author XieZhibing
 * @date 2017年8月27日 下午1:57:30
 * @version <b>1.0.0</b>
 */
public class FieldBean {

	/** 列名 */
	private String columnName;
	/** 主键字段: true */
	private Boolean primaryKey;
	/** 自增字段: true */
	private Boolean autoIncrementKey;

	/** 字段名 */
	private String fieldName;
	/** 首字母大写字段名 */
	private String firstUpperName;
	/** 字段类型 */
	private String fieldType;
	/** 字段注释 */
	private String fieldComment;
	/** 模拟值 */
	private String mockValue;
	/** 字段注释, 不包含下拉项说明 */
	private String optionComment;
	/** 字段下拉项 */
	private List<FieldOptionBean> options = new ArrayList<FieldOptionBean>();

	/** 列名 */
	public String getColumnName() {
		return columnName;
	}

	/** 列名 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/** 主键字段: true */
	public Boolean getPrimaryKey() {
		return primaryKey;
	}

	/** 主键字段: true */
	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	/** 自增字段: true */
	public Boolean getAutoIncrementKey() {
		return autoIncrementKey;
	}

	/** 自增字段: true */
	public void setAutoIncrementKey(Boolean autoIncrementKey) {
		this.autoIncrementKey = autoIncrementKey;
	}

	/** 字段名 */
	public String getFieldName() {
		return fieldName;
	}

	/** 字段名 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/** 首字母大写字段名 */
	public String getFirstUpperName() {
		return firstUpperName;
	}

	/** 首字母大写字段名 */
	public void setFirstUpperName(String firstUpperName) {
		this.firstUpperName = firstUpperName;
	}

	/** 字段类型 */
	public String getFieldType() {
		return fieldType;
	}

	/** 字段类型 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	/** 字段注释 */
	public String getFieldComment() {
		return fieldComment;
	}

	/** 字段注释 */
	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}
	
	/** 模拟值 */
	public String getMockValue() {
		Random random = new Random();
		
		if(StringUtil.isNotEmpty(mockValue)){
			
			mockValue = String.valueOf(random.nextBoolean());
		
		} else if(MySqlColumnType.STRING.getSimpleName().equals(fieldType)){
			
			mockValue = StringUtil.randomString(20);
		
		} else if(MySqlColumnType.BOOLEAN.getSimpleName().equals(fieldType)){
			
			mockValue = String.valueOf(random.nextBoolean());
		
		} else if(MySqlColumnType.LONG.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.INTEGER.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.BIG_INTEGER.getSimpleName().equals(fieldType)){
			
			mockValue = String.valueOf(random.nextInt());
		
		} else if(MySqlColumnType.FLOAT.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.DOUBLE.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.BIG_DECIMAL.getSimpleName().equals(fieldType)){
			
			mockValue = String.valueOf(random.nextFloat());
			
		} else if(MySqlColumnType.DATE.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.TIME.getSimpleName().equals(fieldType) 
				|| MySqlColumnType.TIMESTAMP.getSimpleName().equals(fieldType)){
			
			mockValue = DateUtil.getDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss,SSS");
			
		} else if(MySqlColumnType.TIME.getSimpleName().equals(fieldType)){
			
			mockValue = DateUtil.getDateFormat(new Date(), "HH:mm:ss");
			
		} else {
			mockValue = "";
		}
		
		return mockValue;
	}
	
	/** 模拟值 */
	public void setMockValue(String mockValue) {
		this.mockValue = mockValue;
	}

	/** 字段注释, 不包含下拉项说明 */
	public String getOptionComment() {
		return optionComment;
	}

	/** 字段注释, 不包含下拉项说明 */
	public void setOptionComment(String optionComment) {
		this.optionComment = optionComment;
	}

	/** 字段下拉项 */
	public List<FieldOptionBean> getOptions() {
		return options;
	}

	/** 字段下拉项 */
	public void setOptions(List<FieldOptionBean> options) {
		this.options = options;
	}

}
