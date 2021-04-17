package com.xf.project.db.domain;

import java.time.LocalDateTime;

/**
 * @author xf
 * @version 1.0
 * @date 2021/4/12 13:40
 */
public class BaseEntity {
    private Long id;
    private int limit;
    private int page;
    private String lua;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getLua() {
        return lua;
    }

    public void setLua(String lua) {
        this.lua = lua;
    }
}
