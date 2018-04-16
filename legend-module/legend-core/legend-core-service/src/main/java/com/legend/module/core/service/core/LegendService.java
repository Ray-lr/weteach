package com.legend.module.core.service.core;

import com.legend.module.core.utils.Query;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 公用的service接口
 * 使用时需得继承该接口，并且继承AbstractBaseService实现类，实现泛型
 * 同时注入mapper接口即可
 *
 * @author Administrator
 * @date 2018/3/1
 */
public interface LegendService<T> {
    /**
     * 保存单个t
     *
     * @param t t
     * @return 数据库操作结果
     */
    int save(T t);

    /**
     * 保存list t
     *
     * @param tList 保存list t
     * @return 数据库操作结果
     */
    int saveList(List<T> tList);

    /**
     * 更新单个t
     *
     * @param t t
     * @return 数据库操作结果
     */
    int updateById(T t);

    /**
     * 根据example进行条件的筛选，更新
     *
     * @param t       t
     * @param example 筛选条件的example
     * @return 数据库操作结果
     */
    int updateByExample(T t, Object example);

    /**
     * 根据id删除记录
     * <p color="red">慎用</p>
     *
     * @param id id
     * @return 数据库操作结果
     */
    int delete(int id);

    /**
     * 根据id逻辑删除记录，即更改is_deleted
     *
     * @param id id
     * @return 数据库操作结果
     */
    int updateDeleted(int id);

    /**
     * 根据example筛选条件进行删除
     * <p color="red">慎用</p>
     *
     * @param example 筛选条件用的example
     * @return 数据库操作结果
     */
    int deleteByExample(Object example);

    /**
     * 根据id查询记录
     *
     * @param id id
     * @return 数据库操作结果
     */
    T getById(int id);

    /**
     * 根据T条件查询T
     *
     * @param t t
     * @return 数据库操作结果
     */
    T get(T t);

    /**
     * 根据example条件筛选进行查询，查询结果往往不唯一，但只取第一个元素
     *
     * @param example 筛选条件的example
     * @return 数据库操作结果
     */
    T getByExample(Object example);

    /**
     * 查询所有
     *
     * @return 数据库操作结果
     */
    List<T> getList();

    /**
     * 根据t查询list集合
     *
     * @param t t
     * @return 数据库操作结果
     */
    List<T> getList(T t);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @return 数据库操作结果
     */
    List<T> getList(Integer currentPage, Integer pageSize);

    /**
     * 按t筛选条件进行分页查询
     *
     * @param t           t
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @return 数据库操作结果
     */
    List<T> getList(T t, Integer currentPage, Integer pageSize);


    /**
     * 根据t条件进行查询
     *
     * @param t     t
     * @param orderBy 排序字段
     * @param sort  排序方式
     * @return list t
     */
    List<T> getList(T t, String orderBy, String sort);

    /**
     * 根据t条件进行分页查询
     *
     * @param t           t
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @param orderBy       排序字段
     * @param sort        排序方式
     * @return list t
     */
    List<T> getList(T t, Integer currentPage, Integer pageSize, String orderBy, String sort);

    /**
     * 根据t筛选条件进行分页查询
     *
     * @param t     t
     * @param query 分页工具类,同时可以加入orderBy和sort
     * @return 数据库操作结果
     */
    List<T> getList(T t, Query query);
    
    /**
     * 根据example查询list
     *
     * @param example 筛选条件的example
     * @return 数据库操作结果
     */
    List<T> getListByExample(Object example);

    /**
     * 根据example筛选条件进行分页查询
     *
     * @param example     example筛选条件
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @return list t
     */
    List<T> getListByExample(Object example, Integer currentPage, Integer pageSize);

    /**
     * 根据t条件进行计数
     *
     * @param t t
     * @return 计数结果
     */
    int getCount(T t);

    /**
     * 根据example筛选条件进行计数
     *
     * @param example 筛选条件的exapmle
     * @return 计数寄过
     */
    int getCountByExample(Object example);


    /**
     * 根据name和条件分组查询
     *
     * @param name name
     * @param t    t
     * @return list t
     */
    List<? extends T> getGroupList(String name, T t);

    /**
     * 根据name和条件分组分页查询
     *
     * @param name        name
     * @param t           t
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @return list t
     */
    List<? extends T> getGroupList(String name, T t, Integer currentPage, Integer pageSize);

    /**
     * 根据name和条件分组查询
     * 如需接收group_count请自行在go包下面建TGo,否则将使用原来的接收,不打算支持拓展
     * 多余的参数未来可能会增加参数进行拓展
     *
     * @param name        name
     * @param t           t
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @param orderBy       排序字段
     * @param sort        排序方式
     * @return list t
     */
    List<? extends T> getGroupList(String name, T t, Integer currentPage, Integer pageSize, String orderBy, String sort);


    /**
     * 根据name和条件分组查询
     * 如需接收group_count请自行在go包下面建TGo,否则将使用原来的接收,不支持拓展
     *
     * @param name    name
     * @param example 筛选条件的example
     * @return list t
     */
    List<? extends T> getGroupListByExample(String name, Object example);

    /**
     * 根据name和条件分组分页查询
     *
     * @param name        name
     * @param example     筛选条件的example
     * @param currentPage 当前页码
     * @param pageSize    页显示条数
     * @return list t
     */
    List<? extends T> getGroupListByExample(String name, Object example, Integer currentPage, Integer pageSize);

}
