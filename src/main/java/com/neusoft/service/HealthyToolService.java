package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.DataDictionary.HealthToolType;
import com.neusoft.dao.HealthyToolMapper;
import com.neusoft.entity.HealthToolResult;
import com.neusoft.entity.Result;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.P11Util;

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
        //检验用户输入的数值是否有误 身高:cm , 体重: kg
        double height1 = height / 100;
        if (height1 <= 0.50 || weight <= 0.00 || height1 >= 2.50 || weight >= 150.00) {
            return new Result(200, "请输入正确的数据", false);
        } else {
            double calBMI = weight / (height1 * height1);
            //BMI保留两位小数
            DecimalFormat df = new DecimalFormat(".00");
            double calBMI2 = Double.parseDouble(df.format(calBMI));
            HealthToolResult bmiHealthToolResult = healthToolResult(HealthToolType.BMI.getCode(), calBMI, 0);
            if (bmiHealthToolResult == null) {
                return new Result(200, "请输入正确的数据", false);
            }
            return new Result(100, "您的BMI值是:" + calBMI2 + ",身体状态:" + bmiHealthToolResult.getResultMsg() + ",医生建议:" + bmiHealthToolResult.getProposal(), true);
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
            //WHR保留两位小数
            DecimalFormat df = new DecimalFormat(".00");
            double whrResult2 = Double.parseDouble(df.format(whrResult));
            HealthToolResult whrHealthToolResult = healthToolResult(HealthToolType.WHR.getCode(), whrResult, sex);
            if (whrHealthToolResult == null) {
                return new Result(200, "请输入正确的数据", false);
            }
            return new Result(100, "您的腰臀比值是:" + whrResult2 + ",属于" + whrHealthToolResult.getResultMsg() + ",温馨提醒:" + whrHealthToolResult.getProposal(), true);
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
        //检验用户输入的数值是否有误 身高:cm , 体重: kg
        double height1 = height / 100;
        if (height1 <= 0.50 || weight <= 0.00 || height1 >= 2.50 || weight >= 150.00 || age <= 0.00 || age >= 120.00) {
            return new Result(200, "请输入正确的数据", false);
        }
        if (sex == 0) {
            double denResult = 66 + 13.7 * weight + 500 * height1 - 6.8 * age;
            DecimalFormat df = new DecimalFormat(".00");
            double denResult2 = Double.parseDouble(df.format(denResult));
            return new Result(100, "您每日所需能量:" + denResult2 + "Kcal", true);
        } else {
            double denResult = 655 + 9.5 * weight + 180 * height1 - 4.7 * age;
            DecimalFormat df = new DecimalFormat(".00");
            double denResult2 = Double.parseDouble(df.format(denResult));
            return new Result(100, "您每日所需能量:" + denResult2 + "Kcal", true);
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
        //检验用户输入的数值是否有误 身高:cm , 体重: kg
        double height1 = height / 100;
        if (height1 <= 0.50 || weight <= 0.00 || height1 >= 2.50 || weight >= 150.00) {
            return new Result(200, "请输入正确的数据", false);
        } else {
            double cdbwResult = 22 * height1 * height1;
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

    /**
     * 所有BMI结果
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthToolResult> selectAllBMIResult(Integer pageNum, Integer pageSize, String toolType) {
        PageHelper.startPage(pageNum, pageSize);
        return healthyToolMapper.selectAllBMIResult(toolType);
    }

    /**
     * 删除结果
     *
     * @param healthToolId
     * @return
     */
    public Result deleteToolResultById(String healthToolId) {
        return SystemTool.delete(healthyToolMapper.deleteToolResultById(healthToolId));
    }

    /**
     * 更新结果
     *
     * @param healthToolResult
     * @return
     */
    public Result updateToolResult(HealthToolResult healthToolResult) {
        return SystemTool.update(healthyToolMapper.updateToolResult(healthToolResult));
    }

    /**
     * 新增健康结果
     *
     * @param healthToolResult
     * @return
     */
    public Result insertToolResult(HealthToolResult healthToolResult) {
        healthToolResult.setHealthToolId(SystemTool.uuid());
        healthToolResult.setCreateTime(SystemTool.getDateTime());
        return SystemTool.insert(healthyToolMapper.insertToolResult(healthToolResult));
    }

    /**
     * 根据id查询结果
     *
     * @param healthToolId
     * @return
     */
    public Result selectToolResultById(String healthToolId) {
        HealthToolResult healthToolResult = healthyToolMapper.selectToolResultById(healthToolId);
        if (healthToolResult != null) {
            return new Result(100, "成功", true, healthToolResult);
        } else {
            return new Result(200, "未知错误", false);
        }
    }
}
