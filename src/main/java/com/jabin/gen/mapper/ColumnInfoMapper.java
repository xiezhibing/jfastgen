package com.jabin.gen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jabin.gen.model.entity.ColumnInfo;
import com.jabin.gen.model.entity.TableInfo;

/**
 * TODO 表信息
 * @author XieZhibing
 * @date 2017年8月26日 下午8:36:16
 * @version <b>1.0.0</b>
 */
public interface ColumnInfoMapper {

	public List<TableInfo> queryTableList(String tableSchema);
	
	public List<ColumnInfo> queryColumnList(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
	
}
