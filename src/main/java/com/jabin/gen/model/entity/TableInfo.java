package com.jabin.gen.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 数据库表
 * @author XieZhibing
 * @date 2017年8月26日 下午8:40:15
 * @version <b>1.0.0</b>
 */
public class TableInfo implements Serializable {

	/**
	 * TODO（变量描述）
	 */
	private static final long serialVersionUID = 1L;

	/** 数据库名 */
	private String tableSchema;
	/** 表名 */
	private String tableName;
	/** 表注释 */
	private String tableComment;
	/** 字段 */
	private List<ColumnInfo> columnList = new ArrayList<ColumnInfo>();

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public List<ColumnInfo> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<ColumnInfo> columnList) {
		this.columnList.addAll(columnList);
	}

	@Override
	public String toString() {
		return String.format("TableInfo [tableSchema=%s, tableName=%s, tableComment=%s]", tableSchema, tableName, tableComment);
	}

}
