package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.HealthToolResult;
import org.apache.ibatis.annotations.Param;

/**
 * 健康工具Mapper
 * create: xiaoyc 2019/2/14
 */
public interface HealthyToolMapper {

    //根据计算结果比对
    HealthToolResult healthToolResult(@Param("type") String type, @Param("calResult") double calResult, @Param("sex") int sex);

    //所有健康工具结果列表
    Page<HealthToolResult> selectAllBMIResult(@Param("toolType") String toolType);

    //根据id删除工具结果
    int deleteToolResultById(@Param("healthToolId") String healthToolId);

    //修改结果
    int updateToolResult(HealthToolResult healthToolResult);

    //新增结果
    int insertToolResult(HealthToolResult healthToolResult);

    //根据id查询结果
    HealthToolResult selectToolResultById(@Param("healthToolId") String healthToolId);
}
