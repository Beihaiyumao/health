package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.CollectionQuestion;
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
    @RequestMapping(value = "/allQuestion", method = RequestMethod.GET)
    public PageInfo<Question> selectAllQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                @RequestParam("genre") String genre) {
        //未分类查询
        if (genre.isEmpty()) {
            Page<Question> allQuestion = questionService.selectAllQuestion(pageNum, pageSize);
            PageInfo<Question> pageInfo = new PageInfo<>(allQuestion);
            return pageInfo;
        }
        //分类查询
        else {
            Page<Question> allQuestion = questionService.selectAllQuestionByGenre(pageNum, pageSize, genre);
            PageInfo<Question> pageInfo = new PageInfo<>(allQuestion);
            return pageInfo;
        }
    }

    /**
     * 模糊查询问题
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    @RequestMapping(value = "/selectQuestionByTitle", method = RequestMethod.GET)
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
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
    public Result deleteQuestion(@RequestParam("questionId") String questionId) {
        return questionService.deleteQuestion(questionId);

    }

    /**
     * 问题下的所有回复
     *
     * @param pageNum
     * @param pageSize
     * @param questionId
     * @return
     */
    @GetMapping("/questionAnswer")
    public PageInfo<AnswerQuestion> selectAnswerQuestionByQuestionId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                     @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                     @RequestParam("questionId") String questionId) {
        Page<AnswerQuestion> allAnswerQuestion = questionService.selectAnswerQuestionByQuestionId(pageNum, pageSize, questionId);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(allAnswerQuestion);
        return pageInfo;
    }

    /**
     * 根据问题id查询问题详情
     *
     * @param questionId
     * @return
     */
    @GetMapping("/selectQuestionDetailById")
    public Result selectByPrimaryKey(@RequestParam("questionId") String questionId) {
        return questionService.selectByPrimaryKey(questionId);
    }

    /**
     * 收藏问题
     *
     * @param collectionQuestion
     * @return
     */
    @PostMapping("/collectionQuestion")
    public Result collectionQuestionById(@RequestBody CollectionQuestion collectionQuestion) {
        return questionService.collectionQuestionById(collectionQuestion);
    }

    /**
     * 取消收藏问题
     *
     * @param collectionQuestionId
     * @return
     */
    @GetMapping("deleteCollectionQuestion")
    public Result deleteCollectionQuestion(@RequestParam("collectionQuestionId") String collectionQuestionId) {
        return questionService.deleteCollectionQuestion(collectionQuestionId);
    }

    /**
     * 我的收藏问题列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @GetMapping("/selectMyCollectionQuestion")
    public PageInfo<Question> selectMyCollectionQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                         @RequestParam("userId") String userId) {
        Page<Question> questionPage = questionService.selectMyCollectionQuestion(pageNum, pageSize, userId);
        PageInfo<Question> pageInfo = new PageInfo<>(questionPage);
        return pageInfo;
    }

    /**
     * 判断是否收藏了
     *
     * @param userId
     * @param questionId
     * @return
     */
    @GetMapping("/collectionQuestionIsTrue")
    public Result selectCollectionQuestionIdByUserId(@RequestParam("userId") String userId, @RequestParam("questionId") String questionId) {
        return questionService.collectionQuestionIsTrue(userId, questionId);
    }

    /**
     * 所有问题的回答
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllAnswerQuestion")
    public PageInfo<AnswerQuestion> selectAllAnswerQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<AnswerQuestion> answerQuestions = questionService.selectAllAnswerQuestion(pageNum, pageSize);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(answerQuestions);
        return pageInfo;
    }

    /**
     * 根据回答id删除回答
     *
     * @param answerId
     * @return
     */
    @GetMapping("/deleteQuestionAnswerById")
    public Result deleteQuestionAnswerById(@RequestParam("answerId") String answerId) {
        return questionService.deleteQuestionAnswerById(answerId);
    }

    /**
     * 我回答的问题
     *
     * @param pageNum
     * @param pageSize
     * @param doctorId
     * @return
     */
    @GetMapping("/selectMyAnswerQuestion")
    public PageInfo<AnswerQuestion> selectMyAnswerQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                           @RequestParam("doctorId") String doctorId) {
        Page<AnswerQuestion> answerQuestionPage = questionService.selectMyAnswerQuestion(pageNum, pageSize, doctorId);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(answerQuestionPage);
        return pageInfo;
    }
}
