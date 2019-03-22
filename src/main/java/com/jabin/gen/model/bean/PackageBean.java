package com.jabin.gen.model.bean;

import java.io.Serializable;

import com.jabin.utils.StringUtil;
import com.jabin.gen.constant.Constants;

/**
 * TODO 包信息
 * @author XieZhibing
 * @date 2017年10月14日 下午3:45:17
 * @version <b>1.0.0</b>
 */
public class PackageBean implements Serializable {

	/***/
	private static final long serialVersionUID = 1L;

	//***************** 包路径 ********************//
	/** 实体类名称 */
	private String entityClassName;
	/** 项目类的模块名称 */
	private String moduleName = "";
	/** 包的根路径 */
	private String rootPackage;
	/** PO、VO类的包名称 */
	private String povoModel;
	/** Entity(PO)类 包路径 */
	private String entityPackage;
	/** Bean(VO)类 包路径 */
	private String beanPackage;
	/** Markdown 包路径 */
	private String markdownPackage;
	/** Mapper类包路径 */
	private String mapperPackage;
	/** Mapper类的Xml包路径 */
	private String mapperXmlPackage;
	/** Service类包路径 */
	private String servicePackage;
	/** ServiceImpl包路径 */
	private String serviceImplPackage;
	/** Controller包路径 */
	private String controllerPackage;
	/** java mock 包路径 */
	private String mockPackage;
	//***************** 文件路径 ********************//
	/** Entity类文件路径 */
	private String entityPath;
	/** Bean类文件路径 */
	private String beanPath;
	/** Entity类字段说明Markdown路径 */
	private String markdownPath;
	/** Mapper类文件路径 */
	private String mapperPath;
	/** Mapper的Xml文件路径 */
	private String mapperXmlPath;
	/** Service类文件路径 */
	private String servicePath;
	/** ServiceImpl文件路径 */
	private String serviceImplPath;
	/** Controller文件路径 */
	private String controllerPath;
	/** list页面文件路径 */
	private String pageListPath;
	/** edit页面文件路径 */
	private String pageEditPath;
	/** mock类路径 */
	private String mockPath;

	/**
	 * 构造 
	 * @author XieZhibing
	 * @date 2017年10月14日 下午4:39:45
	 */
	public PackageBean() {		
	}
	
	/**
	 * 构造 组合后package: com.jabin.user
	 * @author XieZhibing
	 * @date 2017年10月14日 下午4:39:59
	 * @param entityClassName
	 * @param rootPackage 根目录 com.jabin
	 * @param moduleName 模块名称 user
	 * @param povoModel PO、VO类的包名称 com.xaloe.model, 实体类com.xaloe.model.user.UserInfo
	 */
	public PackageBean(String entityClassName, String rootPackage, String moduleName, String povoModel) {
		this.entityClassName = entityClassName;
		this.moduleName = moduleName;
		this.rootPackage = rootPackage;
		this.povoModel = povoModel;
	}

	/** 实体类名称 */
	public String getEntityClassName() {
		return entityClassName;
	}
	
	/** 实体类名称 */
	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}
	/** 项目类的模块名称 */
	public String getModuleName() {
		return moduleName;
	}
	/** 项目类的模块名称 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/** 包的根路径 */
	public String getRootPackage() {
		return rootPackage;
	}

	/** 包的根路径 */
	public void setRootPackage(String rootPackage) {
		this.rootPackage = rootPackage;
	}
	
	/** PO、VO类的包名称 */
	public String getPovoModel() {
		return povoModel;
	}
	
	/** PO、VO类的包名称 */
	public void setPovoModel(String povoModel) {
		this.povoModel = povoModel;
	}

	/** Entity(PO)类包路径 */
	public String getEntityPackage() {
		
		String pkg = this.getRootPackage();	
		if(StringUtil.isNotEmpty(this.getModuleName())) {
			pkg += "." + this.getModuleName();
		}
		if(StringUtil.isNotEmpty(this.getPovoModel())) {
			pkg += "." + this.getPovoModel();
		}
		entityPackage = pkg + "." + Constants.PACKAGE_ENTITY;
		
		return entityPackage;
	}

	/** Bean(VO)类包路径 */
	public String getBeanPackage() {
		
		String pkg = this.getRootPackage();
		if(StringUtil.isNotEmpty(this.getModuleName())) {
			pkg += "." + this.getModuleName();
		}
		if(StringUtil.isNotEmpty(this.getPovoModel())) {
			pkg += "." + this.getPovoModel();
		}
		beanPackage = pkg + "." +Constants.PACKAGE_BEAN;
		
		return beanPackage;
	}

	public String getMarkdownPackage() {

		if(StringUtil.isEmpty(this.getModuleName())) {
			markdownPackage = this.getRootPackage() + "." + Constants.PACKAGE_MARKDOWN;
		} else {
			markdownPackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_MARKDOWN;
		}
		
		return markdownPackage;
	}

	/** Mapper类包路径 */
	public String getMapperPackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			mapperPackage = this.getRootPackage() + "." + Constants.PACKAGE_MAPPER;
		} else {
			mapperPackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_MAPPER;
		}
		
		return mapperPackage;
	}

	/** Mapper类的Xml包路径 */
	public String getMapperXmlPackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			mapperXmlPackage = this.getRootPackage() + "." + Constants.PACKAGE_MAPPER_XML;	
		} else {
			mapperXmlPackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_MAPPER_XML;
		}
		
		return mapperXmlPackage;
	}

	/** Service类包路径 */
	public String getServicePackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			servicePackage = this.getRootPackage() + "." + Constants.PACKAGE_SERVICE;
		} else {
			servicePackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_SERVICE;
		}
		return servicePackage;
	}

	/** ServiceImpl类包路径 */
	public String getServiceImplPackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			serviceImplPackage = this.getRootPackage() + "." + Constants.PACKAGE_SERVICE_IMPL;
		} else {
			serviceImplPackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_SERVICE_IMPL;
		}
		
		return serviceImplPackage;
	}

	/** Controller类包路径 */
	public String getControllerPackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			controllerPackage = this.getRootPackage() + "." + Constants.PACKAGE_CONTROLLER;	
		} else {
			controllerPackage = this.getRootPackage() + "." + this.getModuleName() + "." + Constants.PACKAGE_CONTROLLER;
		}
		return controllerPackage;
	}

	/** Mock类包路径 */
	public String getMockPackage() {
		if(StringUtil.isEmpty(this.getModuleName())) {
			mockPackage = this.getRootPackage() + "." + Constants.PACKAGE_MOCK_CONTROLLER;
		} else {
			mockPackage = this.getRootPackage() + "." + Constants.PACKAGE_MOCK_CONTROLLER + "." + this.getModuleName();
		}
		return mockPackage;
	}

	/** Entity文件路径 */
	public String getEntityPath() {
		entityPath = this.getEntityPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_ENTITY + Constants.JAVA_SUFFIX;
		return entityPath;
	}

	/** Bean文件路径 */
	public String getBeanPath() {
		beanPath = this.getBeanPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_BEAN + Constants.JAVA_SUFFIX;		
		return beanPath;
	}

	/** Markdown文件路径 */
	public String getMarkdownPath() {
		markdownPath = this.getMarkdownPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.MARKDOWN_SUFFIX;
		return markdownPath;
	}

	/** Mapper文件路径 */
	public String getMapperPath() {
		mapperPath = this.getMapperPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_MAPPER + Constants.JAVA_SUFFIX;		
		return mapperPath;
	}

	/** Mapper的Xml文件路径 */
	public String getMapperXmlPath() {
		mapperXmlPath = this.getMapperXmlPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_MAPPER + Constants.XML_SUFFIX;
		return mapperXmlPath;
	}

	/** Service文件路径 */
	public String getServicePath() {
		servicePath = this.getServicePackage().replace(".", "/") + "/" + Constants.PREFIX_SERIVCE + this.getEntityClassName() + Constants.SUFFIX_SERIVCE + Constants.JAVA_SUFFIX;		
		return servicePath;
	}

	/** ServiceImpl文件路径 */
	public String getServiceImplPath() {
		serviceImplPath = this.getServiceImplPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_SERVICE_IMPL + Constants.JAVA_SUFFIX;
		return serviceImplPath;
	}

	/** Controller文件路径 */
	public String getControllerPath() {
		controllerPath = this.getControllerPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_CONTROLLER + Constants.JAVA_SUFFIX;
		return controllerPath;
	}

	/** list页面文件路径 */
	public String getPageListPath() {
		pageListPath = this.getModuleName().toLowerCase() + "/" + (this.getEntityClassName() + Constants.SUFFIX_PAGE_LIST + Constants.PAGE_SUFFIX).toLowerCase();
		return pageListPath;
	}

	/** edit页面文件路径 */
	public String getPageEditPath() {
		pageEditPath = this.getModuleName().toLowerCase() + "/" + (this.getEntityClassName() + Constants.SUFFIX_PAGE_EDIT + Constants.PAGE_SUFFIX).toLowerCase();
		return pageEditPath;
	}

	/** Mock文件路径 */
	public String getMockPath() {
		mockPath = this.getMockPackage().replace(".", "/") + "/" + this.getEntityClassName() + Constants.SUFFIX_MOCK_CONTROLLER + Constants.JAVA_SUFFIX;
		return mockPath;
	}
}
