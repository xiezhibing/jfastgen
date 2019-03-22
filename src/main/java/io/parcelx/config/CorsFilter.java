package io.parcelx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 跨域过滤器
// * @author XieZhibing
// *
// */
//@WebFilter(urlPatterns = { "/**"}, filterName = "corsFilter")
//public class CorsFilter implements Filter {
//
//	private static Logger logger = LoggerFactory.getLogger(CorsFilter.class);
//	
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//		// 1. 设置允许跨域的配置
//		// 这里填写你允许进行跨域的主机IP（正式上线时可以动态配置具体允许的域名和IP）
//		String origin = request.getHeader(HttpHeaders.ORIGIN);
//		if(!StringUtils.isEmpty(origin) ){
//			response.setHeader("Access-Control-Allow-Origin", origin);	
//		}
//		
//		response.setHeader("Access-Control-Max-Age","3600");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Cache-Control,Pragma,Content-Type,token");		
//		
//		// 2. 设置字符编码
//		response.setCharacterEncoding("UTF-8");
//		
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * 项目初始化时获取行情，写入客户端
//	 * 注意：默认3s获取一次
//	 * @param filterConfig
//	 * @throws ServletException
//	 */
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		
//		
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//
//}