package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Question;
import com.neusoft.entity.Result;
import com.neusoft.service.QuestionService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 患者提问问题模块
 */
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 新增问题
     *
     * @param question
     * @return
     */
    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    public Result insertQuestion(@RequestBody Question question) {
        return questionService.insertQuestion(question);

    }

    /**
     * 问题列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/allQuestion", method = RequestMethod.POST)
    public PageInfo<Question> selectAllQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Question> allQuestion = questionService.selectAllQuestion(pageNum, pageSize);
        PageInfo<Question> pageInfo = new PageInfo<>(allQuestion);
        return pageInfo;
    }

    /**
     * 模糊查询问题
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    @RequestMapping(value = "/selectQuestionByTitle", method = RequestMethod.POST)
    public PageInfo<Question> selectQuestionByTitle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                    @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                    @RequestParam("title") String title) {
        Page<Question> questions = questionService.selectQuestionByTitle(pageNum, pageSize, title);
        PageInfo<Question> pageInfo = new PageInfo<>(questions);
        return pageInfo;
    }

    /**
     * 删除问题
     *
     * @param questionId
     * @return
     */
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public Result deleteQuestion(@RequestParam("questionId") String questionId) {
        return questionService.deleteQuestion(questionId);

    }

    /**
     * 我的问题列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @RequestMapping(value = "/myQuestion", method = RequestMethod.POST)
    public PageInfo<Question> myQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                         @RequestParam("userId") String userId) {
        Page<Question> myQuestion = questionService.selectQuestionByUser(pageNum, pageSize, userId);
        PageInfo<Question> pageInfo = new PageInfo<>(myQuestion);
        return pageInfo;
    }

    /**
     * 问题下的所有回复
     *
     * @param pageNum
     * @param pageSize
     * @param questionId
     * @return
     */
    @PostMapping("/questionAnswer")
    public PageInfo<AnswerQuestion> selectAnswerQuestionByQuestionId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                     @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                     @RequestParam("questionId") String questionId) {
        Page<AnswerQuestion> allAnswerQuestion = questionService.selectAnswerQuestionByQuestionId(pageNum, pageSize, questionId);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(allAnswerQuestion);
        return pageInfo;
    }
}
