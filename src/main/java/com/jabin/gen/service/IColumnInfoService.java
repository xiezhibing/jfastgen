package com.jabin.gen.service;

import java.io.Serializable;
import java.util.List;

import com.jabin.gen.model.entity.ColumnInfo;
import com.jabin.gen.model.entity.TableInfo;

/**
 * TODO（描述类的职责）
 * @author XieZhibing
 * @date 2017年8月26日 下午9:06:16
 * @version <b>1.0.0</b>
 */
public interface IColumnInfoService extends Serializable {

	public List<TableInfo> queryTableList(String tableSchema);
	
	public List<ColumnInfo> queryColumnList(String tableSchema, String tableName);
	
}
