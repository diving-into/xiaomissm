package com.fancy.pojo;

public class Orderdetail {
    private Integer odid;

    private String oid;

    private Integer pid;

    private Integer pnumber;

    private Double ptotal;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Double getPtotal() {
        return ptotal;
    }

    public void setPtotal(Double ptotal) {
        this.ptotal = ptotal;
    }
}