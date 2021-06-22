package com.yc137.domain;

import java.time.LocalDateTime;

public class Contract {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private String number;

    private Integer customerId;

    private String content;

    private Double money;

    private String stages;

    private String state;

    private Integer htEndtime;

    private LocalDateTime date;

    private String remarks;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getStages() {
        return stages;
    }

    public void setStages(String stages) {
        this.stages = stages;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHtEndtime() {
        return htEndtime;
    }

    public void setHtEndtime(Integer htEndtime) {
        this.htEndtime = htEndtime;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}