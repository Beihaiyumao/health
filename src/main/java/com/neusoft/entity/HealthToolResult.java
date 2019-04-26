package com.neusoft.entity;

import java.util.Date;

/**
 * 健康工具结果分析
 * 2019/1/22
 */
public class HealthToolResult {

    private String healthToolId; //id

    private String toolType; //工具类型

    private double resultCodeStart;//结果值开始

    private double resultCodeEnd;//结果值结束

    private String resultMsg;//结果内容

    private String proposal;//建议

    private int sex; //性别

    private Date createTime;

    public String getHealthToolId() {
        return healthToolId;
    }

    public void setHealthToolId(String healthToolId) {
        this.healthToolId = healthToolId == null ? null : healthToolId.trim();
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public double getResultCodeStart() {
        return resultCodeStart;
    }

    public void setResultCodeStart(double resultCodeStart) {
        this.resultCodeStart = resultCodeStart;
    }

    public double getResultCodeEnd() {
        return resultCodeEnd;
    }

    public void setResultCodeEnd(double resultCodeEnd) {
        this.resultCodeEnd = resultCodeEnd;
    }

    public void setResultCodeEnd(Integer resultCodeEnd) {
        this.resultCodeEnd = resultCodeEnd;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg == null ? null : resultMsg.trim();
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal == null ? null : proposal.trim();
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}