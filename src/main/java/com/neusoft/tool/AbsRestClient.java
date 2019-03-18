/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com.neusoft.tool;

/**
 * 短信验证码
 * 2019/3/18
 */
public abstract class AbsRestClient {

    /**
     * @param sid
     * @param token
     * @param appid
     * @param templateid
     * @param param
     * @param mobile
     * @param uid
     * @return
     */
    public abstract String sendSms(String sid, String token, String appid, String templateid, String param, String mobile, String uid);


}
