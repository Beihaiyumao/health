package com.neusoft.dao;

import com.neusoft.entity.HealthToolResult;
import org.apache.ibatis.annotations.Param;

/**
 * 健康工具Mapper
 * create: xiaoyc 2019/2/14
 */
public interface HealthyToolMapper {

    //根据计算结果比对
    HealthToolResult healthToolResult(@Param("type") String type, @Param("calResult") double calResult, @Param("sex") int sex);
}
