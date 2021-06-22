package com.yc137.domain;

import java.time.LocalDateTime;

public class CompanyCustomerAccessories {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private Integer customerId;

    private String accessoriesName;

    private LocalDateTime accessoriesTime;

    private String savePath;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "CompanyCustomerAccessories{" +
                "rid=" + rid +
                ", customerId=" + customerId +
                ", accessoriesName='" + accessoriesName + '\'' +
                ", accessoriesTime=" + accessoriesTime +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}