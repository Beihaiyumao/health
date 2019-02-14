package com.neusoft.service;

import com.neusoft.dao.HealthyToolMapper;
import com.neusoft.entity.HealthToolResult;
import com.neusoft.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * 健康工具Service
 * create: xiaoyc 2019/2/14
 */
@Service
public class HealthyToolService {
    @Autowired
    private HealthyToolMapper healthyToolMapper;

    /**
     * bmi计算过程
     *
     * @param height
     * @param weight
     * @return
     */
    public Result bmiResult(double height, double weight) {
        //检验用户输入的数值是否有误 身高:m , 体重: kg
        if (height <= 0.00 || weight <= 0.00 || height >= 2.50 || weight >= 150.00) {
            return new Result(200, "请输入正确的数据", false);
        } else {
            double calBMI = weight / (height * height);
            HealthToolResult bmiHealthToolResult = healthToolResult("000300000010", calBMI, 0);
            if (bmiHealthToolResult == null) {
                return new Result(200, "请输入正确的数据", false);
            }
            return new Result(100, bmiHealthToolResult.getResultMsg() + bmiHealthToolResult.getProposal(), true);
        }
    }

    /**
     * 腰臀比计算
     *
     * @param waist
     * @param hip
     * @param sex
     * @return
     */
    public Result whrResult(double waist, double hip, int sex) {
        //检验用户输入的数值是否有误 腰围:cm , 臀围: cm , 性别：0 男 1 女
        if (waist <= 0.00 || hip <= 0.00 || waist >= 200.00 || hip >= 200.00) {
            return new Result(200, "请输入正确的数据", false);
        } else {
            double whrResult = waist / hip;
            HealthToolResult whrHealthToolResult = healthToolResult("000300000040", whrResult, sex);
            if (whrHealthToolResult == null) {
                return new Result(200, "请输入正确的数据", false);
            }
            return new Result(100, whrHealthToolResult.getResultMsg() + whrHealthToolResult.getProposal(), true);
        }
    }

    /**
     * 根据计算结果和数据库比对
     *
     * @param type
     * @param calResult
     * @param sex
     * @return
     */
    public HealthToolResult healthToolResult(String type, double calResult, int sex) {
        return healthyToolMapper.healthToolResult(type, calResult, sex);
    }

    /**
     * 每日能量需求计算
     *
     * @param height
     * @param weight
     * @param age
     * @param sex
     * @return
     */
    public Result denResult(double height, double weight, int age, int sex) {
        //检验用户输入的数值是否有误 身高:m , 体重: kg
        if (height <= 0.00 || weight <= 0.00 || height >= 2.50 || weight >= 150.00 || age <= 0.00 || age >= 120.00) {
            return new Result(200, "请输入正确的数据", false);
        }
        if (sex == 0) {
            double denResult = 66 + 13.7 * weight + 500 * height - 6.8 * age;
            return new Result(100, "" + denResult, true);
        } else {
            double denResult = 655 + 9.5 * weight + 180 * height - 4.7 * age;
            return new Result(100, "" + denResult, true);
        }
    }

    /**
     * 理想体重计算
     *
     * @param height
     * @param weight
     * @return
     */
    public Result cdbwResult(double height, double weight) {
        //检验用户输入的数值是否有误 身高:m , 体重: kg
        if (height <= 0.00 || weight <= 0.00 || height >= 2.50 || weight >= 150.00) {
            return new Result(200, "请输入正确的数据", false);
        } else {
            double cdbwResult = 22 * height * height;
            DecimalFormat df = new DecimalFormat(".00");
            //理想体重保存两位小数
            double cdbwResult2 = Double.parseDouble(df.format(cdbwResult));
            double cdbwMin = Double.parseDouble(df.format(cdbwResult * 0.9));
            double cdbwMax = Double.parseDouble(df.format(cdbwResult * 1.1));
            if (weight < cdbwResult * 0.9) {
                return new Result(100, "您的理想体重应是：" + cdbwResult2 + " kg，您的标准体重应是：" + cdbwMin + "kg ~ " + cdbwMax +
                        "kg，您的实际体重是：" + weight + "KG  属于偏廋", true);
            } else if (weight > cdbwResult * 1.1) {
                return new Result(100, "您的理想体重应是：" + cdbwResult2 + " kg，您的标准体重应是：" + cdbwMin + "kg ~ " + cdbwMax +
                        "kg，您的实际体重是：" + weight + "KG  属于偏胖", true);
            } else {
                return new Result(100, "您的理想体重应是：" + cdbwResult2 + " kg，您的标准体重应是：" + cdbwMin + "kg ~ " + cdbwMax +
                        "kg，您的实际体重是：" + weight + "KG  属于正常", true);
            }
        }

    }
}
