package com.fancy.pojo;

public class Users {
    private Integer uid;

    private String uname;

    private Integer ustatus;

    private Integer ulevel;

    private Integer score;

    private byte[] upass;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public byte[] getUpass() {
        return upass;
    }

    public void setUpass(byte[] upass) {
        this.upass = upass;
    }
}