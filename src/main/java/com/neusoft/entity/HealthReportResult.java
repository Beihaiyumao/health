package com.neusoft.entity;

import java.util.Date;

/**
 * 健康报告结果集
 * 2019/2/19
 */
public class HealthReportResult {

    private String healthReportResultId;//id

    private String healthReportId;//所属健康报告id

    private Double markBegin;//分值开始

    private Double markEnd;//分值结束

    private String result;//结果

    private Date createTime;//创建时间

    public String getHealthReportResultId() {
        return healthReportResultId;
    }

    public void setHealthReportResultId(String healthReportResultId) {
        this.healthReportResultId = healthReportResultId == null ? null : healthReportResultId.trim();
    }

    public String getHealthReportId() {
        return healthReportId;
    }

    public void setHealthReportId(String healthReportId) {
        this.healthReportId = healthReportId == null ? null : healthReportId.trim();
    }

    public Double getMarkBegin() {
        return markBegin;
    }

    public void setMarkBegin(Double markBegin) {
        this.markBegin = markBegin;
    }

    public Double getMarkEnd() {
        return markEnd;
    }

    public void setMarkEnd(Double markEnd) {
        this.markEnd = markEnd;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}