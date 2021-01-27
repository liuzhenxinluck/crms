package com.bh.crms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public  static  String format1(String time,String format){
        return new SimpleDateFormat(format).format(time);

    }

    public static Date format3(String time, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(time);
    }
}
