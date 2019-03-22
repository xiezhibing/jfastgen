package io.parcelx.base.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.parcelx.base.model.BaseEntity;
import io.parcelx.util.PKUtil;
import io.parcelx.util.data.PageData;

/**
 * 业务实现基础类
 * @author Zhibing.Xie
 * @since 2017-11-01
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);		

	@Override
	public long add(T bean) {
		
		String uuid = PKUtil.uuid();
		bean.setId(uuid);
		logger.debug("id: {}", uuid);
		
		return getBaseMapper().add(bean);		
	}

	@Override
	public long update(T bean) {
		return getBaseMapper().update(bean);
	}
	
	@Override
	public long remove(String id) {
		return getBaseMapper().remove(id);
	}
	
	@Override
	public long revert(String id) {
		return getBaseMapper().revert(id);
	}
	
	@Override
	public T queryById(String id) {
		return getBaseMapper().queryById(id);
	}

	@Override
	public T queryOne(T bean) {
		return getBaseMapper().queryOne(bean);
	}

	@Override
	public List<T> queryList(T bean) {
		return getBaseMapper().queryList(bean);
	}
	

	@Override
	public PageData<T> queryPageList(T bean, Integer pageNum, Integer pageSize) {
		PageData<T> pageData = new PageData<T>(pageNum, pageSize);
		
		pageNum = pageNum - 1;
		if(pageNum < 0){
			pageNum = 0;
		}
		if(pageSize <= 0){
			pageSize = 10;
		}
		
		RowBounds rowBounds = new RowBounds(pageNum * pageSize, pageSize);		
		Long total = getBaseMapper().queryCount(bean, rowBounds);		
		if(total == null || total == 0){
			return pageData;
		}
		
		List<T> rows = getBaseMapper().queryList(bean, rowBounds);
		pageData.setRows(rows);
		pageData.setTotal(total);
		
		return pageData;
	}
}
