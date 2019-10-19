package org.janine.jian.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class ConfigEncryptUtils {

    /*加密Util*/
    public static String encrypt(String algorithm,String password,String plaintext){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        encryptor.setConfig(config);
        return encryptor.encrypt(plaintext);

    }

    /*解密Util*/
    public static String decrypt(String algorithm,String password,String ciphertext){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        encryptor.setConfig(config);
        return encryptor.decrypt(ciphertext);
    }

    public static void main(String[] args) {
        String algorithm = "PBEWithMD5AndDES";
        String password = "123456";
        System.out.println(ConfigEncryptUtils.encrypt(algorithm,password,"123456"));
        System.out.println(ConfigEncryptUtils.decrypt(algorithm,password,"Z5eGhE2Yv8jYS0+XMnwN3w=="));
    }
}
