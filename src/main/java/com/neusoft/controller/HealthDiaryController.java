package com.neusoft.controller;

import com.github.pagehelper.Page;
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
}
