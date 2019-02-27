package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthDiaryFood;
import com.neusoft.entity.HealthDiarySport;
import com.neusoft.entity.Result;
import com.neusoft.service.HealthDiaryService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 健康日志
 * 2019/2/26
 */
@RestController
@RequestMapping("/healthDiary")
public class HealthDiaryController {
    @Autowired
    private HealthDiaryService healthDiaryService;

    /**
     * 新增运动日志
     *
     * @param healthDiarySport
     * @return
     */
    @PostMapping("/insertHealthDiarySport")
    public Result insertHealthDiarySport(@RequestBody HealthDiarySport healthDiarySport) {
        return healthDiaryService.insertHealthDiarySport(healthDiarySport);
    }

    /**
     * 删除运动日志
     *
     * @param healthDiarySportId
     * @return
     */
    @GetMapping("/deleteHealthDiarySport")
    public Result deleteHealthDiarySport(@RequestParam("healthDiarySportId") String healthDiarySportId) {
        return healthDiaryService.deleteHealthDiarySport(healthDiarySportId);
    }

    /**
     * 我的运动日志
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @GetMapping("/selectMyHealthDiarySport")
    public PageInfo<HealthDiarySport> selectMyHealthDiarySport(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                               @RequestParam("userId") String userId) {
        Page<HealthDiarySport> healthDiarySportPage = healthDiaryService.selectMyHealthDiarySport(pageNum, pageSize, userId);
        PageInfo<HealthDiarySport> pageInfo = new PageInfo<>(healthDiarySportPage);
        return pageInfo;
    }

    /**
     * 所有运动日志
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllHealthDiarySport")
    public PageInfo<HealthDiarySport> selectAllHealthDiarySport(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthDiarySport> healthDiarySportPage = healthDiaryService.selectAllHealthDiarySport(pageNum, pageSize);
        PageInfo<HealthDiarySport> pageInfo = new PageInfo<>(healthDiarySportPage);
        return pageInfo;
    }

    /**
     * 新增膳食日志
     *
     * @param healthDiaryFood
     * @return
     */
    @PostMapping("/insertHealthDiaryFood")
    public Result insertHealthDiaryFood(@RequestBody HealthDiaryFood healthDiaryFood) {
        return healthDiaryService.insertHealthDiaryFood(healthDiaryFood);
    }

    /**
     * 删除膳食日志
     *
     * @param healthDiaryFoodId
     * @return
     */
    @GetMapping("/deleteHealthDiaryFood")
    public Result deleteHealthDiaryFood(@RequestParam("healthDiaryFoodId") String healthDiaryFoodId) {
        return healthDiaryService.deleteHealthDiaryFood(healthDiaryFoodId);
    }

    /**
     * 我的膳食日志
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @GetMapping("/selectMyHealthDiaryFood")
    public PageInfo<HealthDiaryFood> selectMyHealthDiaryFood(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                             @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                             @RequestParam("userId") String userId) {
        Page<HealthDiaryFood> healthDiaryFoodPage = healthDiaryService.selectMyHealthDiaryFood(pageNum, pageSize, userId);
        PageInfo<HealthDiaryFood> pageInfo = new PageInfo<>(healthDiaryFoodPage);
        return pageInfo;
    }

    /**
     * 所有膳食日志
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllHealthDiaryFood")
    public PageInfo<HealthDiaryFood> selectAllHealthDiaryFood(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                              @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthDiaryFood> healthDiaryFoodPage = healthDiaryService.selectAllHealthDiaryFood(pageNum, pageSize);
        PageInfo<HealthDiaryFood> pageInfo = new PageInfo<>(healthDiaryFoodPage);
        return pageInfo;
    }
}
