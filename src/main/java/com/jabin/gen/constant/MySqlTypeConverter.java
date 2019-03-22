package com.jabin.gen.constant;

import com.jabin.utils.StringUtil;

/**
 * TODO mysql字段类型转换
 * @author XieZhibing
 * @date 2017年8月26日 下午9:39:04
 * @version <b>1.0.0</b>
 */
public class MySqlTypeConverter {

	/**
	 * TODO 类型转换处理
	 * @author XieZhibing
	 * @date 2017年8月26日 下午9:40:42
	 * @param columnType
	 * @return
	 */
	public static MySqlColumnType convert(String columnType) {
		columnType = columnType.toLowerCase();
		
		if (columnType.contains("char") || columnType.contains("text")) {
			return MySqlColumnType.STRING;
		} else if (columnType.contains("bigint")) {
			return MySqlColumnType.LONG;
		} else if (columnType.contains("int")) {
			int columnLength = StringUtil.fetchColumnLength(columnType);
			if(columnLength > 11){
				return MySqlColumnType.LONG;
			}
			return MySqlColumnType.INTEGER;
		} else if (columnType.contains("date") || columnType.contains("time") || columnType.contains("year")) {
			return MySqlColumnType.DATE;
		} else if (columnType.contains("text")) {
			return MySqlColumnType.STRING;
		} else if (columnType.contains("bit")) {
			return MySqlColumnType.BOOLEAN;
		} else if (columnType.contains("decimal")) {
			return MySqlColumnType.BIG_DECIMAL;
		} else if (columnType.contains("blob")) {
			return MySqlColumnType.BYTE_ARRAY;
		} else if (columnType.contains("float")) {
			return MySqlColumnType.FLOAT;
		} else if (columnType.contains("double")) {
			return MySqlColumnType.DOUBLE;
		} else if (columnType.contains("json") || columnType.contains("enum")) {
			return MySqlColumnType.STRING;
		}
		return MySqlColumnType.STRING;
	}

}
