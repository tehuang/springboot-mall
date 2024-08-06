package com.teresahuang.springbootmall.util;

import java.util.List;

public class Page <T>{
    private Integer limit;
    private Integer Offset;
    private Integer total;
    private List<T> result;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return Offset;
    }

    public void setOffset(Integer offset) {
        Offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
