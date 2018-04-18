package com.legend.module.core.model.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页工具类
 *
 * @author hupeiD
 * @date 2018/3//17
 */
@Data
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页数
     */
    private Integer currentPage;

    /**
     * 分页
     *
     * @param totalCount  总记录数
     * @param currentPage 当前页数
     * @param pageSize    每页记录数
     */
    public PageUtils(Integer totalCount, Integer currentPage, Integer pageSize) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

}
