package com.jabin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jabin.gen.Starter;
import com.jabin.gen.constant.FastGenConfig;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		FastGenConfig config = new FastGenConfig();
		config.setAuthor("jfastgen");
		config.setTmplDir("template/springboot2/");
//		config.setGenHtml(true);//不生成html
		config.setGenJava(true);
		
		config.setJavaFileOutDir("D:/out/demo/src/main/java/");
		config.setHtmlFileOutDir("D:/out/demo/src/main/webapps/html/");
		config.setJavaMockFileOutDir("D:/out/demo/src/test/java/");

		config.setRootPackage("io.parcelx");		
		config.setFirstPrefix4ModuleName(true);
		config.setIgnoredColumns(new String[]{"id", "create_time", "creater_id", "modify_time", "modifier_id", "dr"});
		
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:config/spring.xml");
		new Starter().execute(application, config);
		((ClassPathXmlApplicationContext) application).close();
	}
}
