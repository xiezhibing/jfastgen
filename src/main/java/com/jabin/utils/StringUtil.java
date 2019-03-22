package com.jabin.utils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO（描述类的职责）
 * @author XieZhibing
 * @date 2017年8月27日 上午11:11:54
 * @version <b>1.0.0</b>
 */
public class StringUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	/**
	 * TODO 判断字符串是否为空
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:29:09
	 * @param cs
	 * @return
	 */
	public static boolean isEmpty(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * TODO 判断字符串是否不为空
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:29:47
	 * @param cs
	 * @return
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}
	
	/**
	 * TODO 转化为首字母大写的驼峰格式, 如:UserName
	 * @author XieZhibing
	 * @date 2017年8月27日 下午5:14:58
	 * @param param 如: user_name
	 * @return
	 */
	public static String firstUpperCamel(String param){
		return firstUpper(underlineToCamel(param));
	}
	
	/**
	 * TODO 转化为首字母小写的驼峰格式, 如:userName
	 * @author XieZhibing
	 * @date 2017年8月27日 下午5:17:09
	 * @param param 如: user_name
	 * @return
	 */
	public static String firstLowerCamel(String param){
		return firstLower(underlineToCamel(param));
	}
	
	/**
	 * TODO 首字母大写
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:26:53
	 * @param param
	 * @return
	 */
	public static String firstUpper(String param) {
	    return param.substring(0, 1).toUpperCase() + param.substring(1);
	}
	
	/**
	 * TODO 首字母小写
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:26:53
	 * @param param
	 * @return
	 */
	public static String firstLower(String param) {
	    return param.substring(0, 1).toLowerCase() + param.substring(1);
	}
	
	/**
	 * TODO 下划线格式转为驼峰格式
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:30:03
	 * @param param 如: user_name
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (isEmpty(param)) {
			return "";
		}
		String temp = param.toLowerCase();
		int len = temp.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = temp.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(temp.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 提取字段长度
	 * @param text
	 * @return
	 */
    public static int fetchColumnLength(String text) {
        String regex = "[^\\d]";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(text);
        String slength = matcher.replaceAll("");
        if(isEmpty(slength)){
        	return 0;
        }
		
		return Integer.valueOf(slength);
    }
    
	/**
	 * TODO 
	 * @author XieZhibing
	 * @date 2017年8月27日 上午11:11:54
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
