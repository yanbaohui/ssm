package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-14 20:57
 * 日期和字符串互转的工具类
 **/
public class DateUtils {
    public static String date2String(Date date, String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    public static Date String2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
