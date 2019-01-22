package com.neusoft.entity;

/**
 * 健康工具
 * 2019/1/22
 */
public class HealthTool {

    private double height;//身高

    private double weight; //体重

    private int age;  //年龄

    private int sex;  //性别0男1女

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}
