package io.parcelx.config;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.lang.reflect.Method;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xaloe.mongodb.util.data.Result;
//import com.xaloe.mongodb.util.redis.TokenUtil;
//
///**
// * 
// * TODO 登录拦截器
// * @author XieZhibing
// * @date 2018年8月21日 下午6:45:19
// * @version <b>1.0.0</b>
// */
//@Configuration
//public class OpenApiAuthInterceptor implements HandlerInterceptor, Serializable {
//	
//	/**  */
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = LoggerFactory.getLogger(OpenApiAuthInterceptor.class);
//	
//	private static String KEY = "key";
//	private static String SIGN = "sign";
//	
//	/**
//	 * preHandle将在Controller处理之前进行调用，当preHandle的返回值为false的时候整个请求就结束了。
//	 */
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			Method method = handlerMethod.getMethod();
//			
//			// OpenApiAuth注解
//			OpenApiAuth annotation = method.getAnnotation(OpenApiAuth.class);
//			if (annotation == null) {
//				return true;
//			}
//			
//			//检查用户key有效性
//			String key = this.getParam(request, KEY);
//			if(StringUtils.isEmpty(key)){
//				logger.debug("无效的key:{}", key);
//				Result result = new Result(Result.FAIL, "key无效");
//				writeErrorResponse(response, result);
//				return false;
//			}
//			
//			String sign = this.getParam(request, SIGN);
//			if(StringUtils.isEmpty(sign)){
//				logger.debug("无效的sign:{}", sign);
//				Result result = new Result(Result.FAIL, "sign无效");
//				writeErrorResponse(response, result);
//				return false;
//			}
//			
//			
//			//校验key
//			if (TokenUtil.validate(key)) {
//				return true;
//			}
//
//			logger.debug("无效的key:{}", key);
//			Result result = new Result(Result.FAIL, "key无效");
//			writeErrorResponse(response, result);
//			return false;
//		}
//		
//		return false;
//	}
//	
//	/**
//	 * postHandle是在Controller的方法调用之后, 在DispatcherServlet进行视图的渲染之前执行
//	 */
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub		
//	}
//
//	/**
//	 * afterCompletion将在DispatcherServlet渲染了视图后执行，这个方法的主要作用是用于清理资源的。
//	 */
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		// TODO Auto-generated method stub
//	}
//	
//	private void writeErrorResponse(HttpServletResponse response, Result result) {
//		response.setContentType("application/json;charset=UTF-8");
//		try {
//			PrintWriter writer = response.getWriter();
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(result);
//			writer.write(json);
//		} catch (IOException e) {
//		}
//	}
//	
//	private String getParam(HttpServletRequest request, String paramName){
//		String param = request.getHeader(paramName);
//		if(StringUtils.isEmpty(param)){
//			param = request.getParameter(paramName);
//		}
//		return param;
//	}
//}
