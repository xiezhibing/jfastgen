package io.parcelx.base.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * 基础Mapper数据接口
 * @author Zhibing.Xie
 * @since 2017-11-01
 */
public interface BaseMapper<T> extends Serializable {

	/**
	 * 新增
	 * @param bean
	 */
	public long add(T bean);
	
	/**
	 * 更新
	 * @param bean
	 */
	public long update(T bean);
	
	/**
	 * 删除
	 * @param bean
	 */
	public long remove(String id);
	
	/**
	 * 恢复
	 * @param bean
	 */
	public long revert(String id);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public T queryById(String id);
	
	/**
	 * 条件查询单个对象
	 * @param bean
	 * @return
	 */
	public T queryOne(T bean);
	
	/**
	 * 条件查询
	 * @param bean
	 * @return
	 */
	public List<T> queryList(T bean);
	
	/**
	 * 条件查询
	 * @param bean
	 * @return
	 */
	public List<T> queryList(T bean, RowBounds rowBounds);
	
	/**
	 * 分页条件查询数量
	 * @param bean
	 * @param rowBounds
	 * @return
	 */
	public Long queryCount(T bean, RowBounds rowBounds);
}
