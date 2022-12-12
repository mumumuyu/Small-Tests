package com.lgd.util;

import com.alibaba.excel.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES128 算法，加密模式为ECB，填充模式为 pkcs7（实际就是pkcs5）
 */
public class AESUtil {
    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
    public static final String SALT = "PubTransDtDreamOPENTraffic)*UKI&HBHJUM<BTXUDHGE*&^#*E";

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key     加密密码
     * @return
     */
    public static byte[] encrypt(String content, String key) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String key) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            logger.debug("aes decrypt catch NoSuchAlgorithmException : {}", e.fillInStackTrace());
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            logger.debug("aes decrypt catch NoSuchPaddingException : {}", e.fillInStackTrace());
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            logger.debug("aes decrypt catch InvalidKeyException : {}", e.fillInStackTrace());
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            logger.debug("aes decrypt catch IllegalBlockSizeException : {}", e.fillInStackTrace());
            e.printStackTrace();
        } catch (BadPaddingException e) {
            logger.debug("aes decrypt catch BadPaddingException : {}", e.fillInStackTrace());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串加密
     *
     * @param content 要加密的字符串
     * @param key     加密的AES Key
     * @return
     */
    public static String encryptString(String content, String key) {
//        logger.debug("aes encryptString content:{},key：{}", content, key);
        if(content==null){
            return null;
        }
        return parseByte2HexStr(encrypt(content, key));
    }

    /**
     * 字符串解密
     *
     * @param content 要解密的字符串
     * @param key     解密的AES Key
     * @return
     */
    public static String decryptString(String content, String key) {
//        logger.debug("aes decryptString content:{},key：{}", content, key);
        if(content==null){
            return null;
        }
        byte[] decryptFrom = parseHexStr2Byte(content);
        byte[] decryptResult = decrypt(decryptFrom, key);
        return new String(decryptResult);
    }


    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 获取加盐的key
     *
     * @param key
     * @return
     */
    public static String getSaltKey(String key) {
        return key.substring(0, 9) + SALT + key.substring(9);
    }



    public static String decrypt(String encryptedData, String Base64Encodekey,String Base64Encodeiv)  {
        if (StringUtils.isBlank(encryptedData)) {
            return null;
        }
        try {
            // 被加密的数据
            byte[] dataByte = Base64.decode(encryptedData);
            // 加密秘钥
            byte[] keyByte = Base64.decode(Base64Encodekey);
            // 偏移量
            byte[] ivByte = Base64.decode(Base64Encodeiv);
            SecretKeySpec skeySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivByte);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            /**  先用base64解密 */
            byte[] original = cipher.doFinal(dataByte);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception e) {
            logger.info("decrypt error",e);
            return null;
        }
    }

//    public static void  main(String aregs[]){
//        String content = "1001020540";
//        String key =DateUtil.format(new Date(),DateUtil.DATE_FORMAT);
//        String encryptKey=getSaltKey(key);
//        System.out.println("key：" + key);
//        System.out.println("encryptKey：" + encryptKey);
//        try {
//            //加密
//            System.out.println("加密前：" + content);
//            String encrypt = AESUtil.encryptString(content, encryptKey);
//            System.out.println("加密后：" + encrypt);
//            //解密
//            String decrypt = AESUtil.decryptString(encrypt, encryptKey);
//            System.out.println("解密后：" + decrypt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


//    private static  String appId = "wx4f4bc4dec97d474b";
//    private static  String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
//    private static  String encryptedData =
//            "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZM"+
//                    "QmRzooG2xrDcvSnxIMXFufNstNGTyaGS"+
//                    "9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+"+
//                    "3hVbJSRgv+4lGOETKUQz6OYStslQ142d"+
//                    "NCuabNPGBzlooOmB231qMM85d2/fV6Ch"+
//                    "evvXvQP8Hkue1poOFtnEtpyxVLW1zAo6"+
//                    "/1Xx1COxFvrc2d7UL/lmHInNlxuacJXw"+
//                    "u0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn"+
//                    "/Hz7saL8xz+W//FRAUid1OksQaQx4CMs"+
//                    "8LOddcQhULW4ucetDf96JcR3g0gfRK4P"+
//                    "C7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB"+
//                    "6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns"+
//                    "/8wR2SiRS7MNACwTyrGvt9ts8p12PKFd"+
//                    "lqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYV"+
//                    "oKlaRv85IfVunYzO0IKXsyl7JCUjCpoG"+
//                    "20f0a04COwfneQAGGwd5oa+T8yO5hzuy"+
//                    "Db/XcxxmK01EpqOyuxINew==";
//    private static  String iv = "r7BXXKkLb8qrSNn05n0qiA==";
//
//    public static void main(String[] args) {
//
//        System.out.println(decrypt(encryptedData, sessionKey,iv));
//    }
}
