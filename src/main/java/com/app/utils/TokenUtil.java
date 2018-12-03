package com.app.utils;

import com.app.admin.dao.UserBackstageDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: ben
 * @Date: 2018/11/29 17:00
 */
@Component
public class TokenUtil {

    public static Map<String,String> map;
    static {
        map = new HashMap<>();
    }


    @Autowired
    private UserBackstageDao userBackstageDao;

    private TokenUtil(){}

    private static final TokenUtil instance = new TokenUtil();

    public static TokenUtil getInstance() {
        return instance;
    }

    public String makeToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成token放入session
     * @param request
     * @param tokenServerkey
     */
    public static void createToken(HttpServletRequest request, String tokenServerkey){
        String token = TokenUtil.getInstance().makeToken();
        request.getSession().setAttribute(tokenServerkey, token);
    }

    /**
     * 移除token
     * @param request
     * @param tokenServerkey
     */
    public static void removeToken(HttpServletRequest request,String tokenServerkey){
        request.getSession().removeAttribute(tokenServerkey);
    }

    /**
     *  判断请求中的token与我们的token一不一致
     * @param request
     * @return
     */
    public static boolean judgeTokenIsEqual(HttpServletRequest request){
        String id = request.getParameter("id");
        String tokenServer = request.getParameter("token");
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(tokenServer)) {
            return false;
        }
        String token = map.get(id);
        if(StringUtils.isEmpty(token)){
            return false;
        }
        if(!tokenServer.equals(token)){
            return false;
        }
        return true;
    }
}
