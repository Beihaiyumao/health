package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthReport;
import com.neusoft.entity.HealthReportAnswers;
import com.neusoft.entity.HealthReportQuestion;
import com.neusoft.entity.HealthReportResult;
import org.apache.ibatis.annotations.Param;

/**
 * 健康报告
 * 2019/2/18
 */
public interface HealthReportMapper {
    //新增报告类目
    int addHealthReport(HealthReport healthReport);

    //删除报告类目
    int deleteHealthReport(String healthReportId);

    //修改报告类目
    int updateHealthReport(HealthReport healthReport);

    //查询报告类目
    Page<HealthReport> selectHealthReport(@Param("title")String title);

    //新增题目
    int addHealthReportQuestion(HealthReportQuestion healthReportQuestion);

    //删除报告题目
    int deleteHealthReportQuestion(String healthReportQuestionId);

    //修改报告题目
    int updateHealthReportQuestion(HealthReportQuestion healthReportQuestion);

    //查询报告题目
    Page<HealthReportQuestion> selectHealthReportQuestion(@Param("title")String title);

    //新增问题选项
    int addHealthReportAnswers(HealthReportAnswers healthReportAnswers);

    //删除问题选项
    int deleteHealthReportAnswers(String healthReportAnswerId);

    //修改问题选项
    int updateHealthReportAnswers(HealthReportAnswers healthReportAnswers);

    //查询所有问题选项
    Page<HealthReportAnswers> selectHealthReportAnswers(@Param("optionContent") String optionContent);

    //新增报告结果
    int addHealthReportResult(HealthReportResult healthReportResult);

    //删除报告结果
    int deleteHealthReportResult(String healthReportResultId);

    //修改报告结果
    int updateHealthReportResult(HealthReportResult healthReportResult);

    //查询所有报告结果
    Page<HealthReportResult> selectHealthReportResult(@Param("result")String result);

}