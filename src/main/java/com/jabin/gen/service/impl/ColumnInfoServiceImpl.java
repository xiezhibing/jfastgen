package com.jabin.gen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabin.gen.model.entity.ColumnInfo;
import com.jabin.gen.model.entity.TableInfo;
import com.jabin.gen.mapper.ColumnInfoMapper;
import com.jabin.gen.service.IColumnInfoService;

/**
 * TODO（描述类的职责）
 * @author XieZhibing
 * @date 2017年8月26日 下午9:07:06
 * @version <b>1.0.0</b>
 */
@Service("columnInfoService")
public class ColumnInfoServiceImpl implements IColumnInfoService {

	/**
	 * TODO（变量描述）
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ColumnInfoMapper columnInfoMapper;

	@Override
	public List<TableInfo> queryTableList(String tableSchema) {
		// TODO Auto-generated method stub
		return columnInfoMapper.queryTableList(tableSchema);
	}

	@Override
	public List<ColumnInfo> queryColumnList(String tableSchema, String tableName) {
		// TODO Auto-generated method stub
		return columnInfoMapper.queryColumnList(tableSchema, tableName);
	}
	
}
