package io.parcelx.base.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.parcelx.base.data.Result;
import io.parcelx.base.service.IBaseService;

/**
 * Controller基础类
 * @author Zhibing.Xie
 * @since 2017-11-01
 */
public abstract class BaseController<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public abstract IBaseService<T> getBaseService();

	/**
	 * 新增
	 * @param bean
	 */
	@ResponseBody
	@PostMapping(value="/add")
	public Result add(T bean){
		getBaseService().add(bean);
		logger.debug("保存成功");
		
		return new Result("200", "保存成功");
	}

	/**
	 * 更新
	 * @param bean
	 */
	@ResponseBody
	@PostMapping(value="/edit")
	public Result edit(T bean){
		getBaseService().update(bean);
		logger.debug("保存成功");
		
		return new Result("200", "保存成功");
	}
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryById")
	public Result queryById(String id){
		T data = getBaseService().queryById(id);
		
		return new Result("200", "查询成功", data);
	}
	
	/**
	 * 条件查询
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryOne")
	public Result queryOne(T bean){
		T data = getBaseService().queryOne(bean);
		
		return new Result("200", "查询成功", data);
	}
	
	/**
	 * 条件查询
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryList")
	public Result queryList(T bean){
		List<T> data = getBaseService().queryList(bean);
		
		return new Result("200", "查询成功", data);
	}
	
}
