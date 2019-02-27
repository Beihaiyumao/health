package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.dao.HealthReportMapper;
import com.neusoft.entity.*;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 健康报告
 * create:2019/2/18 xiaoyc
 */
@Service
public class HealthReportService {
    @Autowired
    private HealthReportMapper healthReportMapper;

    /**
     * 新增报告类目
     *
     * @param healthReport
     * @return
     */
    public Result addHealthReport(HealthReport healthReport) {
        healthReport.setCreateTime(SystemTool.getDateTime());
        healthReport.setHealthReportId(SystemTool.uuid());
        int code = healthReportMapper.addHealthReport(healthReport);
        return SystemTool.insert(code);
    }

    /**
     * 删除报告类目
     *
     * @param healthReportId
     * @return
     */
    public Result deleteHealthReport(String healthReportId) {
        int code = healthReportMapper.deleteHealthReport(healthReportId);
        return SystemTool.delete(code);
    }

    /**
     * 修改报告类目
     *
     * @param healthReport
     * @return
     */
    public Result updateHealthReport(HealthReport healthReport) {
        healthReport.setCreateTime(SystemTool.getDateTime());
        int code = healthReportMapper.updateHealthReport(healthReport);
        return SystemTool.update(code);
    }

    /**
     * 查询健康报告
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthReport> selectHealthReport(Integer pageNum, Integer pageSize, String title) {
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return healthReportMapper.selectHealthReport(title);
    }

    /**
     * 新增报告问题
     *
     * @param healthReportQuestion
     * @return
     */
    public Result addHealthReportQuestion(HealthReportQuestion healthReportQuestion) {
        healthReportQuestion.setCreateTime(SystemTool.getDateTime());
        healthReportQuestion.setHealthReportQuestionId(SystemTool.uuid());
        int code = healthReportMapper.addHealthReportQuestion(healthReportQuestion);
        return SystemTool.insert(code);
    }

    /**
     * 删除报告问题
     *
     * @param healthReportQuestionId
     * @return
     */
    public Result deleteHealthReportQuestion(String healthReportQuestionId) {
        int code = healthReportMapper.deleteHealthReportQuestion(healthReportQuestionId);
        return SystemTool.delete(code);
    }

    /**
     * 修改报告问题
     *
     * @param healthReportQuestion
     * @return
     */
    public Result updateHealthReportQuestion(HealthReportQuestion healthReportQuestion) {
        healthReportQuestion.setCreateTime(SystemTool.getDateTime());
        int code = healthReportMapper.updateHealthReportQuestion(healthReportQuestion);
        return SystemTool.update(code);
    }

    /**
     * 查询报告问题
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    public Page<HealthReportQuestion> selectHealthReportQuestion(Integer pageNum, Integer pageSize, String title) {
        PageHelper.startPage(pageNum, pageSize);
        return healthReportMapper.selectHealthReportQuestion(title);
    }

    /**
     * 新增问题选项
     *
     * @param healthReportAnswers
     * @return
     */
    public Result addHealthReportAnswers(HealthReportAnswers healthReportAnswers) {
        healthReportAnswers.setCreateTime(SystemTool.getDateTime());
        healthReportAnswers.setHealthReportAnswerId(SystemTool.uuid());
        int code = healthReportMapper.addHealthReportAnswers(healthReportAnswers);
        return SystemTool.insert(code);
    }

    /**
     * 删除问题选项
     *
     * @param healthReportAnswerId
     * @return
     */
    public Result deleteHealthReportAnswers(String healthReportAnswerId) {
        int code = healthReportMapper.deleteHealthReportAnswers(healthReportAnswerId);
        return SystemTool.delete(code);
    }

    /**
     * 修改问题选项
     *
     * @param healthReportAnswers
     * @return
     */
    public Result updateHealthReportAnswers(HealthReportAnswers healthReportAnswers) {
        healthReportAnswers.setCreateTime(SystemTool.getDateTime());
        int code = healthReportMapper.updateHealthReportAnswers(healthReportAnswers);
        return SystemTool.update(code);
    }

    /**
     * 查询所有问题选项
     *
     * @param pageNum
     * @param pageSize
     * @param optionContent
     * @return
     */
    public Page<HealthReportAnswers> selectHealthReportAnswers(Integer pageNum, Integer pageSize, String optionContent) {
        PageHelper.startPage(pageNum, pageSize);
        return healthReportMapper.selectHealthReportAnswers(optionContent);
    }

    /**
     * 新增报告结果
     *
     * @param healthReportResult
     * @return
     */
    public Result addHealthReportResult(HealthReportResult healthReportResult) {
        healthReportResult.setCreateTime(SystemTool.getDateTime());
        healthReportResult.setHealthReportResultId(SystemTool.uuid());
        int code = healthReportMapper.addHealthReportResult(healthReportResult);
        return SystemTool.insert(code);
    }

    /**
     * 删除报告结果
     *
     * @param healthReportResultId
     * @return
     */
    public Result deleteHealthReportResult(String healthReportResultId) {
        int code = healthReportMapper.deleteHealthReportResult(healthReportResultId);
        return SystemTool.delete(code);
    }

    /**
     * 修改报告结果
     *
     * @param healthReportResult
     * @return
     */
    public Result updateHealthReportResult(HealthReportResult healthReportResult) {
        healthReportResult.setCreateTime(SystemTool.getDateTime());
        int code = healthReportMapper.updateHealthReportResult(healthReportResult);
        return SystemTool.update(code);
    }

    /**
     * 查询报告结果
     *
     * @param pageNum
     * @param pageSize
     * @param result
     * @return
     */
    public Page<HealthReportResult> selectHealthReportResult(Integer pageNum, Integer pageSize, String result) {
        PageHelper.startPage(pageNum, pageSize);
        return healthReportMapper.selectHealthReportResult(result);
    }

    /**
     * 根据报告id获取报告
     *
     * @param pageNum
     * @param pageSize
     * @param healthReportId
     * @return
     */
    public Page<Questionnaire> selectAllQuestionnaireByHealthReportId(Integer pageNum, Integer pageSize, String healthReportId) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Questionnaire> questionnaire = healthReportMapper.selectAllQuestionnaireByHealthReportId(healthReportId);
        for (int i = 0; i < questionnaire.size(); i++) {
            questionnaire.get(i).setHealthReportAnswersList(selectHealthReportAnswersByQuestionId(questionnaire.get(i).getHealthReportQuestionId()));
        }
        return questionnaire;
    }

    /**
     * 根据问题id查询问题选项
     *
     * @param healthReportQuestionId
     * @return
     */
    public List<HealthReportAnswers> selectHealthReportAnswersByQuestionId(String healthReportQuestionId) {
        return healthReportMapper.selectHealthReportAnswersByQuestionId(healthReportQuestionId);
    }

    /**
     * 报告结果
     *
     * @param healthReportId
     * @param mark
     * @return
     */
    public Result selectHealthReportResultById(String healthReportId, double mark, String userId) {

        String result = healthReportMapper.selectHealthReportResultById(healthReportId, mark);
        if (result == null || result.isEmpty()) {
            return SystemTool.error();
        } else {
            //保存用户报告结果
            UserHealthReportResult userHealthReportResult = new UserHealthReportResult();
            userHealthReportResult.setHealthReportId(healthReportId);
            userHealthReportResult.setMark(mark);
            userHealthReportResult.setUserId(userId);
            userHealthReportResult.setCreateTime(SystemTool.getDateTime());
            userHealthReportResult.setHealthReportResultUserId(SystemTool.uuid());
            insertUserHealthReportResult(userHealthReportResult);
            return SystemTool.result(result);
        }

    }

    /**
     * 保存用户报告结果
     *
     * @param userHealthReportResult
     */
    public void insertUserHealthReportResult(UserHealthReportResult userHealthReportResult) {
        healthReportMapper.insertUserHealthReportResult(userHealthReportResult);
    }
}
