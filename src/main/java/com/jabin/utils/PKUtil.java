package com.jabin.utils;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 主键工具
 * @author Zhibing.Xie
 *
 */
public class PKUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PKUtil.class);
	
	public static String uuid(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		
		String uuid = uuid();
		logger.debug("uuid:{}, length:{}", uuid, uuid.length());
	}

}
