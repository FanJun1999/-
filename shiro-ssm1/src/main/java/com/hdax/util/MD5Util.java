package com.hdax.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    /**
     * md5加密
     *
     * @param value 要加密的值
     * @return md5加密后的值
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * 3次md5操作
     * @param value
     * @return
     */
    public static String md5Hex3(String value) {
        for (int i = 0; i < 3; i++) {
            value = DigestUtils.md5Hex(value);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(md5Hex("1234567"));
    }
}
