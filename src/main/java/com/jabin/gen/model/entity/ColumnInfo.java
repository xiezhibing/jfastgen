package com.jabin.gen.model.entity;

import java.io.Serializable;

/**
 * TODO 数据表列
 * @author XieZhibing
 * @date 2017年8月26日 下午8:57:22
 * @version <b>1.0.0</b>
 */
public class ColumnInfo implements Serializable {

	/**
	 * TODO（变量描述）
	 */
	private static final long serialVersionUID = 1L;

	/** 数据库名 */
	private String tableSchema;
	/** 表名 */
	private String tableName;
	/** 列名 */
	private String columnName;
	/** 列类型 */
	private String columnType;
	/** 列注释 */
	private String columnComment;
	/** 主外键列标识: PRI */
	private String columnKey;
	/** 自增列标识: auto_increment  */
	private String extra;

	/** 数据库名 */
	public String getTableSchema() {
		return tableSchema;
	}

	/** 数据库名 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	/** 表名 */
	public String getTableName() {
		return tableName;
	}

	/** 表名 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/** 列名 */
	public String getColumnName() {
		return columnName;
	}

	/** 列名 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/** 列类型 */
	public String getColumnType() {
		return columnType;
	}

	/** 列类型 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/** 列注释 */
	public String getColumnComment() {
		return columnComment;
	}

	/** 列注释 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	/** 主外键列标识: PRI */
	public String getColumnKey() {
		return columnKey;
	}

	/** 主外键列标识: PRI */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/** 自增列标识: auto_increment  */
	public String getExtra() {
		return extra;
	}

	/** 自增列标识: auto_increment  */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return String.format(
				"ColumnInfo [tableSchema=%s, tableName=%s, columnName=%s, columnType=%s, columnComment=%s, columnKey=%s, extra=%s]",
				tableSchema, tableName, columnName, columnType, columnComment, columnKey, extra);
	}

}
