package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.dao.HealthReportMapper;
import com.neusoft.entity.*;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (code == 1) {
            return new Result(100, "添加成功", true);
        } else {
            return new Result(200, "添加失败", false);
        }
    }

    /**
     * 删除报告类目
     *
     * @param healthReportId
     * @return
     */
    public Result deleteHealthReport(String healthReportId) {
        int code = healthReportMapper.deleteHealthReport(healthReportId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "修改成功", true);
        } else {
            return new Result(200, "修改失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "添加成功", true);
        } else {
            return new Result(200, "添加失败", false);
        }
    }

    /**
     * 删除报告问题
     *
     * @param healthReportQuestionId
     * @return
     */
    public Result deleteHealthReportQuestion(String healthReportQuestionId) {
        int code = healthReportMapper.deleteHealthReportQuestion(healthReportQuestionId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "修改成功", true);
        } else {
            return new Result(200, "修改失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "添加成功", true);
        } else {
            return new Result(200, "添加失败", false);
        }
    }

    /**
     * 删除问题选项
     *
     * @param healthReportAnswerId
     * @return
     */
    public Result deleteHealthReportAnswers(String healthReportAnswerId) {
        int code = healthReportMapper.deleteHealthReportAnswers(healthReportAnswerId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "修改成功", true);
        } else {
            return new Result(200, "修改失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "添加成功", true);
        } else {
            return new Result(200, "添加失败", false);
        }
    }

    /**
     * 删除报告结果
     *
     * @param healthReportResultId
     * @return
     */
    public Result deleteHealthReportResult(String healthReportResultId) {
        int code = healthReportMapper.deleteHealthReportResult(healthReportResultId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
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
        if (code == 1) {
            return new Result(100, "修改成功", true);
        } else {
            return new Result(200, "修改失败", false);
        }
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
}
