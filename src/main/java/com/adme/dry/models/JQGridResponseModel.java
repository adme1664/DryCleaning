package com.adme.dry.models;

import java.util.List;

/**
 * Created by Adme System on 6/29/2017.
 */
public class JQGridResponseModel<T> {
    private String page;
    private String sidx;
    private String sort;
    private String records;
    private String total;
    private List<T> rows;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
