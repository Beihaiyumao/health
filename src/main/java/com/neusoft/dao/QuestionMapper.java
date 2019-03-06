package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Question;

public interface QuestionMapper {
    //删除问题
    int deleteByPrimaryKey(String questionId);

    //用户提出问题
    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    //问题列表
    Page<Question> selectAllQuestion();

    //模糊查询问题
    Page<Question> selectQuestionByTitle(String title);

    //我的问题列表
    Page<Question> selectQuestionByUserId(String userId);

    //根据问题id查询回答
    Page<AnswerQuestion> selectAnswerQuestionByQuestionId(String questionId);
}