package com.yc137.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FollowsRecord {
    private static final long serialVersionUID = 1L;
    private Integer rid;

    private Integer customerId;

    private String recordContent;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDateTime recordTime;

    private Integer recordId;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate nextFollow;

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

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public LocalDate getNextFollow() {
        return nextFollow;
    }

    public void setNextFollow(LocalDate nextFollow) {
        this.nextFollow = nextFollow;
    }
}