package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthDiaryFood;
import com.neusoft.entity.HealthDiarySport;
import org.apache.ibatis.annotations.Param;

public interface HealthDiaryMapper {
    //新增运动日志
    int insertHealthDiarySport(HealthDiarySport healthDiarySport);

    //删除运动日志
    int deleteHealthDiarySport(@Param("healthDiarySportId") String healthDiarySportId);

    //我的运动日志
    Page<HealthDiarySport> selectMyHealthDiarySport(@Param("userId") String userId);

    //全部运动日志
    Page<HealthDiarySport> selectAllHealthDiarySport();

    //新增膳食日志
    int insertHealthDiaryFood(HealthDiaryFood healthDiaryFood);

    //删除膳食日志
    int deleteHealthDiaryFood(@Param("healthDiaryFoodId") String healthDiaryFoodId);

    //我的膳食日志
    Page<HealthDiaryFood> selectMyHealthDiaryFood(@Param("userId") String userId);

    //所有膳食日志
    Page<HealthDiaryFood> selectAllHealthDiaryFood();

}
