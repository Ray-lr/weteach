package com.legend.module.core.utils;


import com.legend.module.core.model.contant.arribute.Key;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author hp
 * @date 2018/3/17
 */
@Data
public class Query {
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

    public Query() {
        this(1, 10);
    }

    public Query(int currentPage, int pageSize) {
        this(1, 10, null, null);
    }

    public Query(int currentPage, int pageSize, String orderBy, String sort) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        this.sort = sort;
    }

}
