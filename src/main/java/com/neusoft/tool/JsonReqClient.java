
package com.neusoft.tool;


import com.alibaba.fastjson.JSONObject;

/**
 * 短信验证码
 * 2019/3/18
 */
public class JsonReqClient extends AbsRestClient {

    @Override
    public String sendSms(String sid, String token, String appid, String templateid, String param, String mobile,
                          String uid) {

        String result = "";

        try {
            String url = "https://open.ucpaas.com/ol/sms/sendsms";

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("sid", sid);
            jsonObject.put("token", token);
            jsonObject.put("appid", appid);
            jsonObject.put("templateid", templateid);
            jsonObject.put("param", param);
            jsonObject.put("mobile", mobile);
            jsonObject.put("uid", uid);

            String body = jsonObject.toJSONString();

            System.out.println("body = " + body);

            result = HttpClientUtil.postJson(url, body, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
