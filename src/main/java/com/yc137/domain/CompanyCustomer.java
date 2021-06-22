package com.yc137.domain;

public class CompanyCustomer {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private String customerName;

    private String customerType;

    private String legalPerson;

    private String tel;

    private String email;

    private String address;

    private Integer followPerson;

    private String remarks;



    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Integer followPerson) {
        this.followPerson = followPerson;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "CompanyCustomer{" +
                "rid=" + rid +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", followPerson=" + followPerson +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}