package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthToolResult;
import com.neusoft.entity.Result;
import com.neusoft.service.HealthyToolService;
import com.neusoft.tool.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 健康工具Controller
 * create: xiaoyc 2019/2/14
 */
@RestController
@RequestMapping("/healthyTool")
public class HealthyToolController {
    @Autowired
    private HealthyToolService healthyToolService;

    /**
     * bmi计算
     *
     * @param height
     * @param weight
     * @return
     */
    @GetMapping("/bmi")
    public Result bmiResult(@RequestParam("height") double height, @RequestParam("weight") double weight) {
        return healthyToolService.bmiResult(height, weight);
    }

    /**
     * 腰臀比计算
     *
     * @param waist
     * @param hip
     * @param sex
     * @return
     */
    @GetMapping("/whr")
    public Result whrResult(@RequestParam("waist") double waist, @RequestParam("hip") double hip, @RequestParam("sex") int sex) {
        return healthyToolService.whrResult(waist, hip, sex);
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
    @GetMapping("/den")
    public Result denResult(@RequestParam("height") double height, @RequestParam("weight") double weight, @RequestParam("age") int age
            , @RequestParam("sex") int sex) {
        return healthyToolService.denResult(height, weight, age, sex);
    }

    /**
     * 理想体重计算
     *
     * @param height
     * @param weight
     * @return
     */
    @GetMapping("/cdbw")
    public Result cdbwResult(@RequestParam("height") double height, @RequestParam("weight") double weight) {
        return healthyToolService.cdbwResult(height, weight);
    }

    /**
     * 所有健康工具结果
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllBMIResult")
    public PageInfo<HealthToolResult> selectAllBMIResult(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                         @RequestParam("toolType") String toolType) {
        Page<HealthToolResult> healthToolResultPage = healthyToolService.selectAllBMIResult(pageNum, pageSize, toolType);
        PageInfo<HealthToolResult> pageInfo = new PageInfo<>(healthToolResultPage);
        return pageInfo;
    }

    /**
     * 根据id删除结果
     *
     * @param healthToolId
     * @return
     */
    @GetMapping("/deleteToolResultById")
    public Result deleteToolResultById(@RequestParam("healthToolId") String healthToolId) {
        return healthyToolService.deleteToolResultById(healthToolId);
    }

    /**
     * 更新结果集
     *
     * @param healthToolResult
     * @return
     */
    @PostMapping("/updateToolResult")
    public Result updateToolResult(@RequestBody HealthToolResult healthToolResult) {
        return healthyToolService.updateToolResult(healthToolResult);
    }

    /**
     * 新增健康结果
     *
     * @param healthToolResult
     * @return
     */
    @PostMapping("/insertToolResult")
    public Result insertToolResult(@RequestBody HealthToolResult healthToolResult) {
        return healthyToolService.insertToolResult(healthToolResult);
    }

    /**
     * 根据id查询结果
     *
     * @param healthToolId
     * @return
     */
    @GetMapping("/selectToolResultById")
    public Result selectToolResultById(@RequestParam("healthToolId") String healthToolId) {
        return healthyToolService.selectToolResultById(healthToolId);
    }
}
