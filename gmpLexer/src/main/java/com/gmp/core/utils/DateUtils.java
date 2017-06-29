package com.gmp.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tianye13 on 2017/6/29.
 */
public class DateUtils {
    public static String getStrDate(String format, Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(StringUtils.isNotBlank(format)){
            dateFormat=new SimpleDateFormat(format);
        }
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static Date setOfDayDate(Date date,int hour,int minute,int second,int millisecond){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        calendar.set(Calendar.MILLISECOND,millisecond);
        return calendar.getTime();
    }

    public static Date addMinute(Date date,int minute){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,minute);
        return calendar.getTime();
    }

    public static Date addSecond(Date date,int second){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,second);
        return calendar.getTime();
    }

    public static Date addMilliSecond(Date date,int milliSecond){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND,milliSecond);
        return calendar.getTime();
    }

    public static boolean isTimeOut(Date date){
        long curTime = new Date().getTime();
        long startTime = date.getTime();
        long diff = curTime - startTime;
        if(diff>0){
            return true;
        }
        return false;
    }
}
