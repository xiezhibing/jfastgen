package io.parcelx.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.format.datetime.DateFormatter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xaloe.mongodb.util.redis.RedisUtil;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//	
//	@Autowired
//	RedisTemplate<String, Object> redisTemplate;
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		
//		registry.addInterceptor(new OpenApiAuthInterceptor()).addPathPatterns("/**")
//			.excludePathPatterns("/**.html", "/**.htm", "/**.js",
//				"/**.css", "/**.png", "/**.jpg", "/**.jpeg", "/**.bmp", "/**.gif", "/**.svg", "/**.av*", "/**.rm*", "/**.mv*", "/**.flv*",
//				"/**.doc", "/**.xls", "/**.xlsx", "/**.pdf");
//	}
////
////	@Override
////	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////		//1.需要先定义一个convert 转换消息的对象
////		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
////		
////		//2.添加fastJson的配置信息,比如，是否需要格式化返回的json数据
////		FastJsonConfig fastJsonConfig = new FastJsonConfig();
////		fastJsonConfig.setSerializerFeatures(
////			SerializerFeature.WriteNullStringAsEmpty,
////			SerializerFeature.WriteNullNumberAsZero, 
////			SerializerFeature.WriteNullBooleanAsFalse,
////			SerializerFeature.WriteNullListAsEmpty, 
////			SerializerFeature.WriteDateUseDateFormat);
////		//3.在convert中添加配置信息
////		converter.setFastJsonConfig(fastJsonConfig);
////		
////		//4. 处理中文乱码问题
////		List<MediaType> fastMediaTypes = new ArrayList<>();
////		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
////		converter.setSupportedMediaTypes(fastMediaTypes);
////		
////		//5. 添加转换器
////		converters.add(converter);
////		super.configureMessageConverters(converters);
////	}
////	
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss.SSS"));
//	}
////	
////	@Override
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		registry.addResourceHandler("/**/**.html").addResourceLocations("classpath:/templates/");
////		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
////		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
////		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
////		
////	}
////	
//	
//	@Bean
//    @SuppressWarnings("all")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(factory);
//        
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(mapper);
//        
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        // key采用String的序列化方式
//        template.setKeySerializer(stringRedisSerializer);
//        // hash的key也采用String的序列化方式
//        template.setHashKeySerializer(stringRedisSerializer);
//        // value序列化方式采用jackson
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        // hash的value序列化方式采用jackson
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        
//        new RedisUtil().setRedisTemplate(template);
//        
//        return template;
//    }
//	
//}