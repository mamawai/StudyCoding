package com.mashibing.dp.encryptExercise;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author huangshuai
 * @Description: 加解密密算法
 * @Date 2023/5/30 7:48 下午
 */
public class JasyptUtil {

    /**
     * @Author: huangshuai
     * @Description: textToEncrypt,需要加密的明文, salt，加密的盐，需要与解密保持一致, algorithm，加密算法，需要与解密算法保持一致
     * @Date: 2023/5/30
     * @Param textToEncrypt:
     * @Param salt:
     * @Param algorithm:
     * @Return: java.lang.String
     **/
    public static String encrypt(String textToEncrypt, String salt, String algorithm) {
        // 1. 创建加解密工具实例
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        // 2. 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(salt);
        // 3. 加密算法，需要与解密算法一致
        config.setAlgorithm(algorithm);
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations( "1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        // 4. 加密
        return encryptor.encrypt(textToEncrypt);
    }


    /**
     * @Author: huangshuai
     * @Description: textToDecrypt,需要解密的密文, alt，解密的盐，需要与加密保持一致, algorithm，解密算法，需要与加密算法保持一致
     * @Date: 2023/5/30
     * @Param textToDecrypt:
     * @Param salt:
     * @Param algorithm:
     * @Return: java.lang.String
     **/
    public static String decrypt(String textToDecrypt, String salt, String algorithm){
        // 1. 创建加解密工具实例
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        // 2. 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(salt);
        // 3. 解密算法，必须与加密算法一致
        config.setAlgorithm(algorithm);
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations( "1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        // 4. 解密
        return encryptor.decrypt(textToDecrypt);
    }

    public static void main(String[] args) {
//         System.out.println(encrypt("root", "DPR-DES", "PBEWithHmacSHA512AndAES_256"));
///*WTcufTyBc9nzRcXAoL7x8v7PelmsHbwrabFpgGfHdjO9SYobYPI3jbnS5gR15ZPz*/
        // PBEWithMD5AndDES
     //   System.out.println(decrypt("oWUdujX8aysmrWfuyd5fca6BzayTuQ+x+wNcDi8hN6B4UR03np5E5eUyGiKkrmyd", "DPR-DES", "PBEWithHmacSHA512AndAES_256"));
         System.out.println(encrypt("root", "DPR-DES", "PBEWithHMACSHA512AndAES_256"));
        System.out.println(decrypt("AZRaWvo5KevUFlAx4ycKGOndvKD0biuNiN4pUSQLRWRl08pAehjVEgLAGn7G+Vgu", "DPR-DES", "PBEWithHmacSHA512AndAES_256"));
        System.out.println(encrypt("733806", "DPR-DES", "PBEWithHmacSHA512AndAES_256"));

    }

}
