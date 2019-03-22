package com.jabin.gen.constant;

/**
 * TODO 表字段类型
 * @author XieZhibing
 * @date 2017年8月26日 下午9:38:45
 * @version <b>1.0.0</b>
 */
public enum MySqlColumnType {
	STRING("String", null),
	LONG("Long", null),
	ENUM("Enum", null),
	INTEGER("Integer", null),
	FLOAT("Float", null),
	DOUBLE("Double", null),
	BOOLEAN("Boolean", null),
	BYTE_ARRAY("byte[]", null),
	CHARACTER("Character", null),
	OBJECT("Object", null),
	DATE("Date", "java.util.Date"),
	TIME("Time", "java.sql.Time"),
	BLOB("Blob", "java.sql.Blob"),
	CLOB("Clob", "java.sql.Clob"),
	TIMESTAMP("Timestamp", "java.sql.Timestamp"),
	BIG_INTEGER("BigInteger", "java.math.BigInteger"),
	BIG_DECIMAL("BigDecimal", "java.math.BigDecimal");

	/** 缩写类名 */
	private final String simpleName;
	/** 完整类名 */
	private final String fullName;
	/**
	 * 构造 
	 * @author XieZhibing
	 * @date 2017年8月27日 下午7:03:52
	 * @param simpleName
	 * @param fullName
	 */
	private MySqlColumnType(String simpleName, String fullName) {
		this.simpleName = simpleName;
		this.fullName = fullName;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public String getFullName() {
		return fullName;
	}

	
}
