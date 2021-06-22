package com.yc137.domain;

/**
 * @author William
 */
public class PotentialCustomer {
    private static final long serialVersionUID = 1L;

    private TUser user;

    private Integer rid;

    private String companyName;

    private String tel;

    private String address;

    private Integer followPerson;

    private String signed;

    private String followUp;

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed;
    }

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    @Override
    public String toString() {
        return "PotentialCustomer{" +
                "rid=" + rid +
                ", companyName='" + companyName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", followPerson=" + followPerson +
                ", signed='" + signed + '\'' +
                ", followUp='" + followUp + '\'' +
                '}';
    }
}