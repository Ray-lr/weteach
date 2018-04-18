package com.legend.module.core.model.utils;


import lombok.Data;

/**
 * 查询参数
 *
 * @author hp
 * @date 2018/3/17
 */
@Data
public class QueryUtils {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序方式
     */
    private String sort;

    public QueryUtils() {
        this(1, 10);
    }

    public QueryUtils(int currentPage, int pageSize) {
        this(1, 10, null, null);
    }

    public QueryUtils(int currentPage, int pageSize, String orderBy, String sort) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        this.sort = sort;
    }

}
