package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.dao.HealthDiaryMapper;
import com.neusoft.entity.HealthDiarySport;
import com.neusoft.entity.Result;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 健康日志Service
 * 2019/2/26
 */
@Service
public class HealthDiaryService {
    @Autowired
    private HealthDiaryMapper healthDiaryMapper;

    /**
     * 新增运动日志
     *
     * @param healthDiarySport
     * @return
     */
    public Result insertHealthDiarySport(HealthDiarySport healthDiarySport) {
        healthDiarySport.setCreateTime(SystemTool.getDateTime());
        healthDiarySport.setHealthDiarySportId(SystemTool.uuid());
        int code = healthDiaryMapper.insertHealthDiarySport(healthDiarySport);
        return SystemTool.insert(code);
    }

    /**
     * 删除运动日志
     *
     * @param healthDiarySportId
     * @return
     */
    public Result deleteHealthDiarySport(String healthDiarySportId) {
        int code = healthDiaryMapper.deleteHealthDiarySport(healthDiarySportId);
        return SystemTool.delete(code);
    }

    /**
     * 查询我的运动日志
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    public Page<HealthDiarySport> selectMyHealthDiarySport(Integer pageNum, Integer pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        return healthDiaryMapper.selectMyHealthDiarySport(userId);
    }
}
