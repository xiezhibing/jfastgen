package com.jabin.gen.model.bean;

import java.io.Serializable;

/**
 * 下拉项类型字段
 * 
 * @author XieZhibing
 * 
 */
public class FieldOptionBean implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	/** 下拉项值 */
	private String value;
	/** 下拉项说明 */
	private String text;
	
	
	public FieldOptionBean() {
		super();
	}

	public FieldOptionBean(String value, String text) {
		super();
		this.value = value;
		this.text = text;
	}

	/** 下拉项值 */
	public String getValue() {
		return value;
	}

	/** 下拉项值 */
	public void setValue(String value) {
		this.value = value;
	}

	/** 下拉项说明 */
	public String getText() {
		return text;
	}

	/** 下拉项说明 */
	public void setText(String text) {
		this.text = text;
	}

}
