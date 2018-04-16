package com.legend.module.core.service.core.impl;

import com.github.pagehelper.PageHelper;
import com.legend.module.core.dao.mapper.LegendMapper;
import com.legend.module.core.entity.AbstractEntity;
import com.legend.module.core.service.core.LegendService;
import com.legend.module.core.utils.Query;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/1
 */
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractLegendService<T extends AbstractEntity> implements LegendService<T> {
    /**
     * 实现该接口，返回实现对应的mapper类
     *
     * @return mapper类，由子类实现
     */
    public abstract Mapper<T> getMapper();

    /**
     * 用于在该类中获得对应的子类的mapper类
     *
     * @return mapper
     */
    private LegendMapper<T> getLegendMapper() {
        return (LegendMapper<T>) getMapper();
    }

    /**
     * 得到由子类实现的example
     *
     * @param t       t
     * @param orderBy 排序字段
     * @param sort    排序方式
     * @return example
     */
    protected abstract Object getExample(T t, String orderBy, String sort);

    @Override
    public int save(T t) {
        return getLegendMapper().insertSelective(t);
    }

    @Override
    public int saveList(List<T> tList) {
        return getLegendMapper().insertList(tList);
    }

    @Override
    public int updateById(T t) {
        return getLegendMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByExample(T t, Object example) {
        return getLegendMapper().updateByExampleSelective(t, example);
    }

    @Override
    public int delete(int id) {
        return getLegendMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int updateDeleted(int id) {
        return getLegendMapper().updateDeletedById(id);
    }

    @Override
    public int deleteByExample(Object example) {
        return getLegendMapper().deleteByExample(example);
    }

    @Override
    public T getById(int id) {
        return getLegendMapper().selectByPrimaryKey(id);
    }

    @Override
    public T get(T t) {
        return getLegendMapper().selectOne(t);
    }

    @Override
    public T getByExample(Object example) {
        PageHelper.startPage(1, 1);
        List<T> ts = getLegendMapper().selectByExample(example);
        return ts != null && !ts.isEmpty() ? ts.get(0) : null;
    }

    @Override
    public List<T> getList() {
        return getLegendMapper().selectAll();
    }

    @Override
    public List<T> getList(T t) {
        return getLegendMapper().select(t);
    }

    @Override
    public List<T> getList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return getList();
    }

    @Override
    public List<T> getList(T t, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return getList(t);
    }

    @Override
    public List<T> getList(T t, String orderBy, String sort) {
        Object example = getExample(t, orderBy, sort);
        return getListByExample(example);
    }

    @Override
    public List<T> getList(T t, Integer currentPage, Integer pageSize, String orderBy, String sort) {
        PageHelper.startPage(currentPage, pageSize);
        return getList(t, orderBy, sort);
    }

    @Override
    public List<T> getList(T t, Query query) {
        PageHelper.startPage(query.getCurrentPage(), query.getPageSize());

        return getList(t, query.getCurrentPage(), query.getPageSize());
    }

    @Override
    public List<T> getListByExample(Object example) {
        return getLegendMapper().selectByExample(example);
    }

    @Override
    public List<T> getListByExample(Object example, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return getListByExample(example);
    }

    @Override
    public int getCount(T t) {
        return getLegendMapper().selectCount(t);
    }

    @Override
    public int getCountByExample(Object example) {
        return getLegendMapper().selectCountByExample(example);
    }

    @Override
    public List<? extends T> getGroupList(String name, T t) {
        Object example = getExample(t, null, null);
        return getGroupListByExample(name, example);
    }

    @Override
    public List<? extends T> getGroupList(String name, T t, Integer currentPage, Integer pageSize) {
        return getGroupList(name, t, currentPage, pageSize, null, null);
    }

    @Override
    public List<? extends T> getGroupList(String name, T t, Integer currentPage, Integer pageSize, String orderBy, String sort) {
        Object example = getExample(t, orderBy, sort);
        return getGroupListByExample(name, example, currentPage, pageSize);
    }

    @Override
    public List<? extends T> getGroupListByExample(String name, Object example) {
        return getLegendMapper().selectGroupByName(name, example);
    }

    @Override
    public List<? extends T> getGroupListByExample(String name, Object example, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return getGroupListByExample(name, example);
    }
}
