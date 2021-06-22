package com.yc137.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContractReject {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private String contractNumber;

    private String reason;

    private String time;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ContractReject{" +
                "rid=" + rid +
                ", contractNumber='" + contractNumber + '\'' +
                ", reason='" + reason + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}