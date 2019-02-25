package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.entity.*;
import com.neusoft.service.HealthReportService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 健康报告
 * create:2019/2/18 xiaoyc
 */
@RestController
@RequestMapping("/healthReport")
public class HealthReportController {
    @Autowired
    private HealthReportService healthReportService;

    /**
     * 新增报告类目
     *
     * @param healthReport
     * @return
     */
    @PostMapping("/addHealthReport")
    public Result addHealthReport(@RequestBody HealthReport healthReport) {
        return healthReportService.addHealthReport(healthReport);
    }

    /**
     * 删除报告类目
     *
     * @param healthReportId
     * @return
     */
    @GetMapping("/deleteHealthReport")
    public Result deleteHealthReport(@RequestParam("healthReportId") String healthReportId) {
        return healthReportService.deleteHealthReport(healthReportId);
    }

    /**
     * 修改报告类目
     *
     * @param healthReport
     * @return
     */
    @PostMapping("/updateHealthReport")
    public Result updateHealthReport(@RequestBody HealthReport healthReport) {
        return healthReportService.updateHealthReport(healthReport);
    }

    /**
     * 查询健康报告
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectHealthReport")
    public PageInfo<HealthReport> selectHealthReport(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                     @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                     @RequestParam("title") String title) {
        Page<HealthReport> healthReports = healthReportService.selectHealthReport(pageNum, pageSize, title);
        PageInfo<HealthReport> reportPageInfo = new PageInfo<>(healthReports);
        return reportPageInfo;
    }

    /**
     * 新增报告问题
     *
     * @param healthReportQuestion
     * @return
     */
    @PostMapping("addHealthReportQuestion")
    public Result addHealthReportQuestion(@RequestBody HealthReportQuestion healthReportQuestion) {
        return healthReportService.addHealthReportQuestion(healthReportQuestion);
    }

    /**
     * 删除报告问题
     *
     * @param healthReportQuestionId
     * @return
     */
    @GetMapping("/deleteHealthReportQuestion")
    public Result deleteHealthReportQuestion(@RequestParam("healthReportQuestionId") String healthReportQuestionId) {
        return healthReportService.deleteHealthReportQuestion(healthReportQuestionId);
    }

    /**
     * 修改报告问题
     *
     * @param healthReportQuestion
     * @return
     */
    @PostMapping("/updateHealthReportQuestion")
    public Result updateHealthReportQuestion(@RequestBody HealthReportQuestion healthReportQuestion) {
        return healthReportService.updateHealthReportQuestion(healthReportQuestion);
    }

    /**
     * 查询报告问题
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    @GetMapping("/selectHealthReportQuestion")
    public PageInfo<HealthReportQuestion> selectHealthReportQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                     @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                     @RequestParam("title") String title) {
        Page<HealthReportQuestion> healthReportQuestions = healthReportService.selectHealthReportQuestion(pageNum, pageSize, title);
        PageInfo<HealthReportQuestion> pageInfo = new PageInfo<>(healthReportQuestions);
        return pageInfo;
    }

    /**
     * 新增问题选项
     *
     * @param healthReportAnswers
     * @return
     */
    @PostMapping("/addHealthReportAnswers")
    public Result addHealthReportAnswers(@RequestBody HealthReportAnswers healthReportAnswers) {
        return healthReportService.addHealthReportAnswers(healthReportAnswers);
    }

    /**
     * 删除问题选项
     *
     * @param healthReportAnswerId
     * @return
     */
    @GetMapping("/deleteHealthReportAnswers")
    public Result deleteHealthReportAnswers(@RequestParam("healthReportAnswerId") String healthReportAnswerId) {
        return healthReportService.deleteHealthReportAnswers(healthReportAnswerId);
    }

    /**
     * 修改问题选项
     *
     * @param healthReportAnswers
     * @return
     */
    @PostMapping("/updateHealthReportAnswers")
    public Result updateHealthReportAnswers(@RequestBody HealthReportAnswers healthReportAnswers) {
        return healthReportService.updateHealthReportAnswers(healthReportAnswers);
    }

    /**
     * 查询所有问题选项
     *
     * @param pageNum
     * @param pageSize
     * @param optionContent
     * @return
     */
    @GetMapping("/selectHealthReportAnswers")
    public PageInfo<HealthReportAnswers> selectHealthReportAnswers(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                   @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                   @RequestParam("optionContent") String optionContent) {
        Page<HealthReportAnswers> healthReportAnswers = healthReportService.selectHealthReportAnswers(pageNum, pageSize, optionContent);
        PageInfo<HealthReportAnswers> pageInfo = new PageInfo<>(healthReportAnswers);
        return pageInfo;
    }

    /**
     * 新增报告结果
     *
     * @param healthReportResult
     * @return
     */
    @PostMapping("/addHealthReportResult")
    public Result addHealthReportResult(@RequestBody HealthReportResult healthReportResult) {
        return healthReportService.addHealthReportResult(healthReportResult);
    }

    /**
     * 删除报告结果
     *
     * @param healthReportResultId
     * @return
     */
    @GetMapping("/deleteHealthReportResult")
    public Result deleteHealthReportResult(@RequestParam("healthReportResultId") String healthReportResultId) {
        return healthReportService.deleteHealthReportResult(healthReportResultId);
    }

    /**
     * 修改报告结果
     *
     * @param healthReportResult
     * @return
     */
    @PostMapping("/updateHealthReportResult")
    public Result updateHealthReportResult(@RequestBody HealthReportResult healthReportResult) {
        return healthReportService.updateHealthReportResult(healthReportResult);
    }

    /**
     * 查看报告结果
     *
     * @param pageNum
     * @param pageSize
     * @param result
     * @return
     */
    @GetMapping("/selectHealthReportResult")
    public PageInfo<HealthReportResult> selectHealthReportResult(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                 @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                 @RequestParam("result") String result) {
        Page<HealthReportResult> healthReportResults = healthReportService.selectHealthReportResult(pageNum, pageSize, result);
        PageInfo<HealthReportResult> pageInfo = new PageInfo<>(healthReportResults);
        return pageInfo;
    }

    /**
     * 根据报告id获取报告
     *
     * @param pageNum
     * @param pageSize
     * @param healthReportId
     * @return
     */
    @GetMapping("selectAllQuestionnaireByHealthReportId")
    public PageInfo<Questionnaire> selectAllQuestionnaireByHealthReportId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                          @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                          @RequestParam("healthReportId") String healthReportId) {
        Page<Questionnaire> questionnairePage = healthReportService.selectAllQuestionnaireByHealthReportId(pageNum, pageSize, healthReportId);
        PageInfo<Questionnaire> pageInfo = new PageInfo<>(questionnairePage);
        return pageInfo;
    }
}
