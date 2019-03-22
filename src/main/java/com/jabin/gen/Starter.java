package com.jabin.gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.jabin.gen.model.bean.ClassBean;
import com.jabin.gen.model.bean.PackageBean;
import com.jabin.gen.constant.Constants;
import com.jabin.gen.constant.FastGenConfig;
import com.jabin.gen.model.entity.ColumnInfo;
import com.jabin.gen.model.entity.TableInfo;
import com.jabin.gen.service.IColumnInfoService;
import com.jabin.utils.StringUtil;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * TODO（描述类的职责）
 * @author XieZhibing
 * @date 2017年8月26日 下午9:16:52
 * @version <b>1.0.0</b>
 */
public class Starter extends AbstractStarter {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(Starter.class);	
	
	/**
	 * 启动方法
	 * @param args
	 */
	public static void main(String[] args) {
		FastGenConfig config = new FastGenConfig();
		config.setAuthor("jabin-fastgen");
		config.setTmplDir("template/springboot/");
		config.setJavaFileOutDir("D:/out/demo/src/main/java/");
//		config.setHtmlFileOutDir("D:/out/demo/src/main/webapp/html/");
		
		config.setRootPackage("com.meosun.booker");		
		config.setFirstPrefix4ModuleName(true);
		config.setIgnoredColumns(new String[]{"id", "create_time", "creater_id", "modify_time", "modifier_id", "dr"});
		
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:config/spring.xml");
		new Starter().execute(application, config);
		((ClassPathXmlApplicationContext) application).close();
	}
	
	/**
	 * 生成文件
	 * @param config
	 */
	public void execute(ApplicationContext application, FastGenConfig config){
		
		IColumnInfoService columnInfoService = application.getBean("columnInfoService", IColumnInfoService.class);				
		DataSource dataSource = application.getBean("dataSource", DruidDataSource.class);		
		String tableSchema = this.getTableSchema(dataSource);		
		logger.info("tableSchema:{}", tableSchema);
		
		if(StringUtil.isEmpty(tableSchema)){
			logger.info("Schema无效!");
			return;
		}
		
		List<TableInfo> tableList = columnInfoService.queryTableList(tableSchema);
		if(tableList == null || tableList.size() == 0){
			logger.info("没有查询到Schema:{}的表", tableSchema);
			return;
		}
		
		for (TableInfo tableInfo : tableList) {
			//表名
			String tableName = tableInfo.getTableName();
			List<ColumnInfo> columnList = columnInfoService.queryColumnList(tableSchema, tableName);
			if(columnList == null || columnList.size() == 0){
				logger.info("没有查询到Schema:{}的表:{}", tableSchema, tableName);
				continue;
			}			
			tableInfo.getColumnList().addAll(columnList);
			
			//转化为ClassBean对象			
			ClassBean classBean = this.table2Class(tableInfo, config);
			
			//生成文件
			this.generate(classBean, config);
		}
		
		logger.info("代码目录：{}", config.getJavaFileOutDir());		
		logger.info("代码目录：{}", config.getHtmlFileOutDir());
		
		//打开文件输出目录
		File javafileDir = new File(config.getJavaFileOutDir());
		this.openOutDir(javafileDir.getParent());
	}
	
	/**
	 * TODO 生成文件
	 * @author XieZhibing
	 * @date 2017年10月14日 下午1:07:33
	 * @param classBean
	 */
	public void generate(ClassBean classBean, FastGenConfig config){
		//Velocity上下文
		VelocityContext context = new VelocityContext();
		
		context.put("moduleName", classBean.getModuleName());
		context.put("classBean", classBean);
		context.put("author", config.getAuthor());
		context.put("enableCache", true);
		context.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		//=================================== 可自行选择生成哪些代码 ===================================
		//包路径信息
		PackageBean packageBean = classBean.getPackageBean();
		//模板路径
		String tmplDir = config.getTmplDir();
		//输出目录
		String javaFileOutDir = config.getJavaFileOutDir();
		String javaMockFileOutDir = config.getJavaMockFileOutDir();
		if(config.isGenJava() && StringUtil.isNotEmpty(javaFileOutDir) && !javaFileOutDir.startsWith(Constants.DEFAULT_JAVA_DIR)){
			//生成Entity(PO)类
			this.generate(context, javaFileOutDir + packageBean.getEntityPath(), tmplDir + Constants.TEMPL_ENTITY);
			//生成Entity(VO)类
			this.generate(context, javaFileOutDir + packageBean.getBeanPath(), tmplDir + Constants.TEMPL_BEAN);
			//生成Mapper类
			this.generate(context, javaFileOutDir + packageBean.getMapperPath(), tmplDir + Constants.TEMPL_MAPPER);
			//生成Mapper类
			this.generate(context, javaFileOutDir + packageBean.getMapperXmlPath(), tmplDir + Constants.TEMPL_MAPPER_XML);
			//生成Service类
			this.generate(context, javaFileOutDir + packageBean.getServicePath(), tmplDir + Constants.TEMPL_SERVICE);
			//生成ServiceImpl类
			this.generate(context, javaFileOutDir + packageBean.getServiceImplPath(), tmplDir + Constants.TEMPL_SERVICE_IMPL);
			//生成Controller类
			this.generate(context, javaFileOutDir + packageBean.getControllerPath(), tmplDir + Constants.TEMPL_CONTROLLER);	
//			//生成Entity类字段Markdown说明
//			this.generate(context, javaFileOutDir + packageBean.getMarkdownPath(), tmplDir + Constants.TEMPL_MARKDOWN);
			//生成Mock Controller
			this.generate(context, javaMockFileOutDir + packageBean.getMockPath(), tmplDir + Constants.TEMPL_MOCK_CONTROLLER);

		}
		
		//生成list页面
		String htmlFileOutDir = config.getHtmlFileOutDir();
		if(config.isGenHtml() && StringUtil.isNotEmpty(htmlFileOutDir) && !javaFileOutDir.startsWith(Constants.DEFAULT_HTML_DIR)){
			//生成list页面
			this.generate(context, htmlFileOutDir + packageBean.getPageListPath(), tmplDir + Constants.TEMPL_PAGE_LIST);
			//生成edit页面
			this.generate(context, htmlFileOutDir + packageBean.getPageEditPath(), tmplDir + Constants.TEMPL_PAGE_EDIT);				
		}
		
	}
	
	/**
	 * TODO 使用模板生成文件
	 * @author XieZhibing
	 * @date 2017年10月14日 下午1:40:44
	 * @param context	上下文
	 * @param filePath	生成的文件
	 * @param tmplFile	模板文件
	 */
	public void generate(VelocityContext context, String filePath, String tmplFile) {
		
		try {
			Properties p = new Properties();
			p.setProperty("resource.loader", "class");
			p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			
			Velocity.init(p); 
			Template template = Velocity.getTemplate(tmplFile, Constants.DEFAULT_ENCODED);
			File parentFile = new File(filePath).getParentFile();
			logger.info("======代码生成目录dir: {}", parentFile.getAbsolutePath());
			
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, Constants.DEFAULT_ENCODED));
			template.merge(context, writer);
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TODO 打开文件输出目录
	 * @author XieZhibing
	 * @date 2017年10月21日 下午4:15:35
	 * @param fileOutDir
	 */
	public void openOutDir(String fileOutDir) {
		try {
			String osName = System.getProperty("os.name");
			if (osName != null) {
				if (osName.contains("Mac")) {
					Runtime.getRuntime().exec("open " + fileOutDir);
				} else if (osName.contains("Windows")) {
					Runtime.getRuntime().exec("cmd /c start " + fileOutDir);
				} else {
					logger.debug("文件输出目录:" + fileOutDir);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
