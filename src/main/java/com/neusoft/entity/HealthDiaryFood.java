package com.neusoft.entity;

import java.util.Date;

/**
 * 健康日志-膳食日志
 */
public class HealthDiaryFood {

    private String healthDiaryFoodId;//id

    private String userId; //用户id

    private String mealTimes;//餐次

    private String foodBigType;//摄入大类

    private String foodSonType;//摄入小类

    private String foodName;//食物名称

    private Date foodTime;//吃饭时间

    private String foodAmount;//摄入量

    private Date createTime;//创建时间

    public String getHealthDiaryFoodId() {
        return healthDiaryFoodId;
    }

    public void setHealthDiaryFoodId(String healthDiaryFoodId) {
        this.healthDiaryFoodId = healthDiaryFoodId == null ? null : healthDiaryFoodId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMealTimes() {
        return mealTimes;
    }

    public void setMealTimes(String mealTimes) {
        this.mealTimes = mealTimes == null ? null : mealTimes.trim();
    }

    public String getFoodBigType() {
        return foodBigType;
    }

    public void setFoodBigType(String foodBigType) {
        this.foodBigType = foodBigType == null ? null : foodBigType.trim();
    }

    public String getFoodSonType() {
        return foodSonType;
    }

    public void setFoodSonType(String foodSonType) {
        this.foodSonType = foodSonType == null ? null : foodSonType.trim();
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public Date getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(Date foodTime) {
        this.foodTime = foodTime;
    }

    public String getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(String foodAmount) {
        this.foodAmount = foodAmount == null ? null : foodAmount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}