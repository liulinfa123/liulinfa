package com.app.utils;

import com.app.configure.SensitivityProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ben
 * @Date: 2018/12/4 10:35
 */
@Component
@Slf4j
public class SecurityUtil {

    public static String salt;

    public static List<String> encryptApiField;

    public static List<String> decryptApiField;

    public SecurityUtil(SensitivityProperties sensitivity) {
        salt = sensitivity.getSalt();
        encryptApiField = sensitivity.getEncryptApiField();
        decryptApiField = sensitivity.getDecryptApiField();
    }

    private final static int KEY_SIZE = 16;

    /**
     *  加密
     * @param content
     * @return
     */
    public static String encrypt(String content){
        try{
            if (StringUtils.isNotBlank(content) && StringUtils.isNotBlank(salt)) {
                return encryptMethod(content,salt);
            }
        }catch (Exception e){
            log.error("Oops, SecurityUtils aes_encrypt '{}' has exception, return origin content", content);
        }
        return content;
    }

    /**
     * aes128 加密
     *
     * @param content
     *            需要加密的内容
     * @param secretKey
     *            密钥
     * @return 加密后的16进制字符串
     * @throws Exception
     */
    public static String encryptMethod(String content, String secretKey) throws Exception{
        try{
            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes("ASCII"), KEY_SIZE);
            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cleartext = content.getBytes("UTF-8");
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(Hex.encodeHex(ciphertextBytes));
        }catch (Exception e){
            log.error("Oops, AESOperator encrypt {} occur exception", content);
            throw e;
        }
    }

    /**
     * aes128 解密
     *
     * @param content
     *            需要解密的内容
     * @return 解密内容
     * @throws Exception
     */
    public static String decrypt(String content){
        if (!StringUtils.isEmpty(content) && !StringUtils.isEmpty(salt)) {
            try{
               return decryptMethod(content,salt);
            }catch (Exception e){
                log.error("Oops, SecurityUtils aes_decrypt '{}' has exception, return origin content", content);
            }
        }
        return content;
    }

    /**
     * aes128 解密
     *
     * @param hexContent
     *            待解密的16进制字符串
     * @param secretKey
     *            密钥
     * @return 解密后的内容
     * @throws Exception
     */
    public static String decryptMethod(String hexContent, String secretKey) throws Exception {
        try {
            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes("ASCII"), KEY_SIZE);
            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher decipher = Cipher.getInstance("AES");
            decipher.init(Cipher.DECRYPT_MODE, key);
            char[] cleartext = hexContent.toCharArray();
            byte[] decodeHex = Hex.decodeHex(cleartext);
            byte[] ciphertextBytes = decipher.doFinal(decodeHex);
            return new String(ciphertextBytes);
        } catch (Exception e) {
            log.info("Oops, AESOperator decrypt {} occur exception", hexContent);
            throw e;
        }

    }





}
