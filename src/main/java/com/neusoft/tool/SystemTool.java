package com.neusoft.tool;

import com.neusoft.entity.Result;

import java.util.Date;
import java.util.UUID;

/**
 * 工具类
 * 2018/12/25
 */
public class SystemTool {
    /**
     * 产生12位随机数
     *
     * @return
     */
    public static String uuid() {
        String s = UUID.randomUUID().toString();
        s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        String uuid = s.substring(0, 12);
        return uuid;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDateTime() {
        Date time = new java.sql.Date(new java.util.Date().getTime());
        return time;
    }

    /**
     * 新增数据
     *
     * @param code
     * @return
     */
    public static Result insert(int code) {
        if (code == 1) {
            return new Result(100, "添加成功", true);
        } else {
            return new Result(200, "添加失败", false);
        }
    }

    /**
     * 删除数据
     *
     * @param code
     * @return
     */
    public static Result delete(int code) {
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
    }

    /**
     * 修改数据
     *
     * @param code
     * @return
     */
    public static Result update(int code) {
        if (code == 1) {
            return new Result(100, "修改成功", true);
        } else {
            return new Result(200, "修改失败", false);
        }
    }
}
