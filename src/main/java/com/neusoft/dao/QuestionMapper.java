package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.CollectionQuestion;
import com.neusoft.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //收藏问题
    int collectionQuestionById(CollectionQuestion collectionQuestion);

    //根据当前用户id检验是否已经收藏该问题
    List<String> selectCollectionQuestionIdByUserId(@Param("userId")String userId,@Param("questionId")String questionId);

    //取消收藏问题
    int deleteCollectionQuestion(@Param("collectionQuestionId")String collectionQuestionId);

    //我的收藏问列表
    Page<Question> selectMyCollectionQuestion(@Param("userId")String userId);

    //所有问题的回复
    Page<AnswerQuestion>selectAllAnswerQuestion();

    //删除问题的回复根据回答id
    int deleteQuestionAnswerById(@Param("answerId")String answerId);
}