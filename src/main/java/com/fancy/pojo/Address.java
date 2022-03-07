package com.fancy.pojo;

public class Address {
    private Integer addressid;

    private Integer uid;

    private String cnee;

    private String phone;

    private String address;

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCnee() {
        return cnee;
    }

    public void setCnee(String cnee) {
        this.cnee = cnee == null ? null : cnee.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}