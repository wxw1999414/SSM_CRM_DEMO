package com.yc137.domain;

import java.time.LocalDate;

public class ContractDetails {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private String contractNumber;

    private String stateone;

    private String statetwo;

    private String statethree;

    private String detailone;

    private String detailtwo;

    private String detailthree;

    private LocalDate timeone;

    private LocalDate timetwo;

    private LocalDate timethree;

    private String followPerson;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getStateone() {
        return stateone;
    }

    public void setStateone(String stateone) {
        this.stateone = stateone;
    }

    public String getStatetwo() {
        return statetwo;
    }

    public void setStatetwo(String statetwo) {
        this.statetwo = statetwo;
    }

    public String getStatethree() {
        return statethree;
    }

    public void setStatethree(String statethree) {
        this.statethree = statethree;
    }

    public String getDetailone() {
        return detailone;
    }

    public void setDetailone(String detailone) {
        this.detailone = detailone;
    }

    public String getDetailtwo() {
        return detailtwo;
    }

    public void setDetailtwo(String detailtwo) {
        this.detailtwo = detailtwo;
    }

    public String getDetailthree() {
        return detailthree;
    }

    public void setDetailthree(String detailthree) {
        this.detailthree = detailthree;
    }

    public LocalDate getTimeone() {
        return timeone;
    }

    public void setTimeone(LocalDate timeone) {
        this.timeone = timeone;
    }

    public LocalDate getTimetwo() {
        return timetwo;
    }

    public void setTimetwo(LocalDate timetwo) {
        this.timetwo = timetwo;
    }

    public LocalDate getTimethree() {
        return timethree;
    }

    public void setTimethree(LocalDate timethree) {
        this.timethree = timethree;
    }

    public String getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(String followPerson) {
        this.followPerson = followPerson;
    }
}