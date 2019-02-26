package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthDiarySport;
import org.apache.ibatis.annotations.Param;

public interface HealthDiaryMapper {
    //新增运动日志
    int insertHealthDiarySport(HealthDiarySport healthDiarySport);

    //删除运动日志
    int deleteHealthDiarySport(@Param("healthDiarySportId") String healthDiarySportId);
    //我的运动日志
    Page<HealthDiarySport> selectMyHealthDiarySport(@Param("userId") String userId);
}
