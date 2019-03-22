package io.parcelx.base.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * @author Zhibing.Xie
 * @since 2017-11-01
 */
public class BaseEntity implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date modifyTime;
	
	/**
	 * 获得id
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获得createTime
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置createTime
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获得modifyTime
	 * @return Date
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置modifyTime
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
