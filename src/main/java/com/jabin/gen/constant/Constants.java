package com.jabin.gen.constant;

/**
 * TODO 常量
 * @author XieZhibing
 * @date 2017年8月27日 上午11:38:35
 * @version <b>1.0.0</b>
 */
public class Constants {

	/***************************** 包路径常量 ****************************/
	/** model: Entity和Bean类的模块名 */
	public static final String PACKAGE_MODEL = "model";//model、domain
	/** Entity(PO)包名 */
	public static final String PACKAGE_ENTITY = "entity";
	/** Bean(VO)包名 */
	public static final String PACKAGE_BEAN = "bean";
	/** Markdown(VO)包名 */
	public static final String PACKAGE_MARKDOWN = "markdown";
	/** Mapper包名 */
	public static final String PACKAGE_MAPPER = "mapper";
	/**  Mapper XML包名 */
	public static final String PACKAGE_MAPPER_XML = "mapper.xml";
	/** Service包名 */
	public static final String PACKAGE_SERVICE = "service";
	/** Service Impl包名 */
	public static final String PACKAGE_SERVICE_IMPL = "service.impl";	
	/** Controller包名 */
	public static final String PACKAGE_CONTROLLER = "controller";
	/** Mock Controller包名 */
	public static final String PACKAGE_MOCK_CONTROLLER = "mock.controller";
	
	/***************************** 类名前缀常量 ****************************/
	public static final String PREFIX_SERIVCE = "I";
	/***************************** 类名后缀常量 ****************************/
	public static final String SUFFIX_ENTITY = "Entity";
	public static final String SUFFIX_BEAN = "Bean";	
	public static final String SUFFIX_SERIVCE = "Service";
	public static final String SUFFIX_SERVICE_IMPL = "ServiceImpl";
	public static final String SUFFIX_MAPPER = "Mapper";
	public static final String SUFFIX_CONTROLLER = "Controller";
	public static final String SUFFIX_MOCK_CONTROLLER = "MockController";
	public static final String SUFFIX_PAGE_LIST = "_list";
	public static final String SUFFIX_PAGE_EDIT = "_edit";

	/***************************** Velocity变量名称 ****************************/
	public static final String TEMPL_ENTITY = "entity.java.vm";
	public static final String TEMPL_BEAN = "bean.java.vm";
	public static final String TEMPL_MARKDOWN = "markdown.vm";
	public static final String TEMPL_MAPPER = "mapper.java.vm";
	public static final String TEMPL_MAPPER_XML = "mapper.xml.vm";
	public static final String TEMPL_SERVICE = "service.java.vm";
	public static final String TEMPL_SERVICE_IMPL = "serviceImpl.java.vm";
	public static final String TEMPL_CONTROLLER = "controller.java.vm";
	public static final String TEMPL_MOCK_CONTROLLER = "mock_controller_java.vm";
	public static final String TEMPL_PAGE_LIST = "page_list.vm";
	public static final String TEMPL_PAGE_EDIT = "page_edit.vm";
	
	/***************************** 文件名后缀 ****************************/
	public static final String JAVA_SUFFIX = ".java";
	public static final String MARKDOWN_SUFFIX = ".md";
	public static final String XML_SUFFIX = ".xml";
	public static final String PAGE_SUFFIX = ".html";
	
	/***************************** 默认值 ****************************/
	/** 默认作者 */
	public static final String DEFAULT_AUTHOR = "jabin-fastgen";
	/** 默认模板路径 */
	public static final String DEFAULT_TMPL_DIR = "/template/";
	/** java文件输出路径 */
	public static final String DEFAULT_JAVA_DIR = "/src/main/java/";
	/** java Mock文件输出路径 */
	public static final String DEFAULT_JAVA_MOCK_DIR = "/src/test/java/";
	/** html文件目录 */
	public static final String DEFAULT_HTML_DIR = "/src/main/webapp/html/";
	
	/***************************** 其他 ****************************/
	
	/** 主键字段标识 */
	public static final String PRIMARY_KEY_VAL="PRI";
	/** 自增字段标识 */
	public static final String AUTO_INCREMENT_VAL="auto_increment";
	/** 字符串编码 */
	public static final String DEFAULT_ENCODED= "UTF-8";
	/** 下划线 */
	public static final String UNDERLINE = "_";
}
