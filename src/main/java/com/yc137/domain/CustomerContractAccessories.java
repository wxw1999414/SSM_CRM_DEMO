package com.yc137.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CustomerContractAccessories {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private Integer contractId;

    private String accessoriesName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime accessoriesTime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAccessoriesName() {
        return accessoriesName;
    }

    public void setAccessoriesName(String accessoriesName) {
        this.accessoriesName = accessoriesName;
    }

    public LocalDateTime getAccessoriesTime() {
        return accessoriesTime;
    }

    public void setAccessoriesTime(LocalDateTime accessoriesTime) {
        this.accessoriesTime = accessoriesTime;
    }
}