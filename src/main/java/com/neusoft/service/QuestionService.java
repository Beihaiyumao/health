package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.dao.QuestionMapper;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Question;
import com.neusoft.entity.Result;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 新增问题
     *
     * @param question
     * @return
     */
    public Result insertQuestion(Question question) {
        question.setQuestionId(SystemTool.uuid());
        question.setCreateTime(SystemTool.getDateTime());
        int code = questionMapper.insert(question);
        if (code == 1) {
            return new Result(100, "发布问题成功", true);
        } else {
            return new Result(200, "发布问题失败", false);
        }
    }

    /**
     * 问题列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Question> selectAllQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return questionMapper.selectAllQuestion();
    }

    /**
     * 模糊查询问题
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    public Page<Question> selectQuestionByTitle(Integer pageNum, Integer pageSize, String title) {
        PageHelper.startPage(pageNum, pageSize);
        return questionMapper.selectQuestionByTitle(title);
    }

    /**
     * 删除问题
     *
     * @param questionId
     * @return
     */
    public Result deleteQuestion(String questionId) {
        int code = questionMapper.deleteByPrimaryKey(questionId);
        if (code == 1) {
            return new Result(100, "删除问题成功", true);
        } else {
            return new Result(200, "删除问题失败", false);
        }
    }

    /**
     * 我的问题列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    public Page<Question> selectQuestionByUser(Integer pageNum, Integer pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        return questionMapper.selectQuestionByUserId(userId);
    }

    /**
     * 问题下的所有回复
     *
     * @param pageNum
     * @param pageSize
     * @param questionId
     * @return
     */
    public Page<AnswerQuestion> selectAnswerQuestionByQuestionId(Integer pageNum, Integer pageSize, String questionId) {
        PageHelper.startPage(pageNum, pageSize);
        return questionMapper.selectAnswerQuestionByQuestionId(questionId);
    }

    /**
     * 根据问题id查询问题内容
     *
     * @param questionId
     * @return
     */
    public Result selectByPrimaryKey(String questionId) {
        Question question = questionMapper.selectByPrimaryKey(questionId);
        if (question != null) {
            return new Result(100, "获取成功", true, question);
        } else {
            return new Result(200, "获取失败", false);
        }
    }
}
