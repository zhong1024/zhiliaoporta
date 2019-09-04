package com.zhiliaoportal.cn.zhiliaoporta.util;

import io.netty.handler.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

/**
 * 数据类型转换工具类
 *
 * @author Mr.Zhong
 * @create2019-08-06 11:32
 */
public class Hex22String {

    /**
     * 将普通字符串转换为16进制字符串
     *
     * @param str       普通字符串
     * @param lowerCase 转换后的字母为是否为小写  可不传默认为true
     * @param charset   编码格式  可不传默认为Charset.defaultCharset()
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String str2HexStr(String str, boolean lowerCase, String charset) throws UnsupportedEncodingException {
        return Hex.encodeHexString(str.getBytes(charset), lowerCase);
    }


    /**
     * 将16进制字符串转换为普通字符串
     *
     * @param hexStr  16进制字符串
     * @param charset 编码格式 可不传默认为Charset.defaultCharset()
     * @return
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hexStr2Str(String hexStr, String charset) throws Exception {
        byte[] bytes = Hex.decodeHex(hexStr);
        return new String(bytes, charset);
    }


    /**
     * 将16进制字符串转换为byte数组
     *
     * @param hexItr 16进制字符串
     * @return
     */
    public static byte[] hexItr2Arr(String hexItr) throws Exception {
        return Hex.decodeHex(hexItr);
    }


    /**
     * byte数组转化为16进制字符串
     *
     * @param arr       数组
     * @param lowerCase 转换后的字母为是否为小写 可不传默认为true
     * @return
     */
    public static String arr2HexStr(byte[] arr, boolean lowerCase) {
        return Hex.encodeHexString(arr, lowerCase);
    }


    /**
     * 将普通字符串转换为指定格式的byte数组
     *
     * @param str     普通字符串
     * @param charset 编码格式 可不传默认为Charset.defaultCharset()
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] str2Arr(String str, String charset) throws UnsupportedEncodingException {
        return str.getBytes(charset);
    }


    /**
     * 将byte数组转换为指定编码格式的普通字符串
     *
     * @param arr     byte数组
     * @param charset 编码格式 可不传默认为Charset.defaultCharset()
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String arr2Str(byte[] arr, String charset) throws UnsupportedEncodingException {
        return new String(arr, charset);
    }


    /**
     * int转byte
     * @param val
     * @return
     */
    public static byte[] intToByte(int val){
        byte[] b = new byte[4];
        b[0] = (byte)(val & 0xff);
        b[1] = (byte)((val >> 8) & 0xff);
        b[2] = (byte)((val >> 16) & 0xff);
        b[3] = (byte)((val >> 24) & 0xff);
        return b;
    }


}
