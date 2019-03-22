package com.jabin.gen.constant;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO 公共配置
 * 
 * @author XieZhibing
 * @date 2017年8月27日 下午8:52:21
 * @version <b>1.0.0</b>
 */
public class FastGenConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 作者 */
	private String author = Constants.DEFAULT_AUTHOR;
	/** 模板路径 */
	private String tmplDir = Constants.DEFAULT_TMPL_DIR;
	/** java文件输出路径 */
	private String javaFileOutDir = Constants.DEFAULT_JAVA_DIR;
	/** javaMock文件输出路径 */
	private String javaMockFileOutDir = Constants.DEFAULT_JAVA_MOCK_DIR;
	/** html文件目录 */
	private String htmlFileOutDir = Constants.DEFAULT_HTML_DIR;
	/** 项目类包的根路径 */
	private String rootPackage = "";
	/** PO、VO类的包名称 */
	private String povoPackage = Constants.PACKAGE_MODEL;
	/** 项目类的模块名称, moduleName优先级大于 firstPrefix4ModuleName */
	private String moduleName = "";
	/** 第一个表前缀作为模块名称 */
	private boolean firstPrefix4ModuleName = true;
	/** 忽略的列 */
	private String[] ignoredColumns = new String[0];
	/** 忽略的模板 */
	private Set<String> ignoredTempl = new HashSet<String>();
	/** 生成java代码 */
	private boolean genJava = true;
	/** 生成Html代码 */
	private boolean genHtml = true;

	/** 作者 */
	public String getAuthor() {
		return author;
	}

	/** 作者 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/** 模板路径 */
	public String getTmplDir() {
		return tmplDir;
	}

	/** 模板路径 */
	public void setTmplDir(String tmplDir) {
		this.tmplDir = tmplDir;
	}

	/** 文件输出路径 */
	public String getJavaFileOutDir() {
		return javaFileOutDir;
	}

	/** 文件输出路径 */
	public void setJavaFileOutDir(String javaFileOutDir) {
		this.javaFileOutDir = javaFileOutDir;
	}
	/** MOCK文件输出路径 */
	public String getJavaMockFileOutDir() {
		return javaMockFileOutDir;
	}
	/** MOCK文件输出路径 */
	public void setJavaMockFileOutDir(String javaMockFileOutDir) {
		this.javaMockFileOutDir = javaMockFileOutDir;
	}

	/** html文件目录 */
	public String getHtmlFileOutDir() {
		return htmlFileOutDir;
	}

	/** html文件目录 */
	public void setHtmlFileOutDir(String htmlFileOutDir) {
		this.htmlFileOutDir = htmlFileOutDir;
	}

	/** 项目类包的根路径 */
	public String getRootPackage() {
		return rootPackage;
	}

	/** 项目类包的根路径 */
	public void setRootPackage(String rootPackage) {
		this.rootPackage = rootPackage;
	}

	/** 模型类包名 */
	public String getPovoPackage() {
		if (povoPackage == null || povoPackage.trim().length() < 1 || povoPackage.trim().equals("null")) {
			return Constants.PACKAGE_MODEL;
		}
		return povoPackage;
	}

	/** 模型类包名 */
	public void setPovoPackage(String povoPackage) {
		this.povoPackage = povoPackage;
	}

	/** 项目类的模块名称, moduleName优先级大于 firstPrefix4ModuleName */
	public String getModuleName() {
		return moduleName;
	}

	/** 项目类的模块名称, moduleName优先级大于 firstPrefix4ModuleName */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/** 第一个表前缀作为模块名称 */
	public boolean isFirstPrefix4ModuleName() {
		return firstPrefix4ModuleName;
	}

	/** 第一个表前缀作为模块名称 */
	public void setFirstPrefix4ModuleName(boolean firstPrefix4ModuleName) {
		this.firstPrefix4ModuleName = firstPrefix4ModuleName;
	}

	/** 忽略的列 */
	public String[] getIgnoredColumns() {
		return ignoredColumns;
	}

	/** 忽略的列 */
	public void setIgnoredColumns(String[] ignoredColumns) {
		this.ignoredColumns = ignoredColumns;
	}

	/** 忽略的模板 */
	public Set<String> getIgnoredTempl() {
		return ignoredTempl;
	}

	/** 忽略的模板 */
	public void setIgnoredTempl(Set<String> ignoredTempl) {
		this.ignoredTempl = ignoredTempl;
	}

	/** 生成java代码 */
	public boolean isGenJava() {
		return genJava;
	}

	/** 生成java代码 */
	public void setGenJava(boolean genJava) {
		this.genJava = genJava;
	}

	/** 生成Html代码 */
	public boolean isGenHtml() {
		return genHtml;
	}

	/** 生成Html代码 */
	public void setGenHtml(boolean genHtml) {
		this.genHtml = genHtml;
	}

}
