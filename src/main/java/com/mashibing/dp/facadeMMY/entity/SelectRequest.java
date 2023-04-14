package com.mashibing.dp.facadeMMY.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SelectRequest {
    @Override
    public String toString() {
        return "SelectRequest{" +
                "cid=" + cid +
                ", fdate='" + fdate + '\'' +
                ", sdate='" + sdate + '\'' +
                '}';
    }

    private Long cid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;

    public SelectRequest() {
    }

    public SelectRequest(Long cid, Date fdate, Date sdate) {
        this.cid = cid;
        this.fdate = fdate;
        this.sdate = sdate;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }
}
