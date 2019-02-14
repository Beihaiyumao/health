package com.neusoft.controller;

import com.neusoft.entity.Result;
import com.neusoft.service.HealthyToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
