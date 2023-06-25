package com.mashibing.dp.mybatisPlus.domain;

import com.github.pagehelper.PageInfo;

public class PageReq {
    private PageInfo pageInfo = new PageInfo();

    public PageReq() {
    }
    public PageReq(PageInfo pageInfo){
        this.setPageInfo(pageInfo);
    }
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) throws NullPointerException{
        if (pageInfo == null){
            throw new NullPointerException();
        } else {
            this.pageInfo = pageInfo;
        }
    }
}
