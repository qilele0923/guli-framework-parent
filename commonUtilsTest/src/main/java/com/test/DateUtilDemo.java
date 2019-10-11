package com.test;

import cn.hutool.core.date.DateUtil;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qi on 2019-10-11 15:25
 */
public class DateUtilDemo {

  public static void main(String[] args) {

    //当前时间
    Date date = DateUtil.date();
    System.out.println(date);
//当前时间
    Date date2 = DateUtil.date(Calendar.getInstance());
    System.out.println(date2);
//当前时间
    Date date3 = DateUtil.date(System.currentTimeMillis());
    System.out.println(date3);
//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
    String now = DateUtil.now();
    System.out.println(now);
//当前日期字符串，格式：yyyy-MM-dd
    String today= DateUtil.today();
    System.out.println(today);


    String dateStr = "2017-03-01";
    Date date4 = DateUtil.parse(dateStr, "yyyy-MM-dd");
    System.out.println(date4);

    String dateStr1 = "2017-03-01";
    Date date5 = DateUtil.parse(dateStr);

//结果 2017/03/01
    String format = DateUtil.format(date5, "yyyy/MM/dd");

//常用格式的格式化，结果：2017-03-01
    String formatDate = DateUtil.formatDate(date5);

//结果：2017-03-01 00:00:00
    String formatDateTime = DateUtil.formatDateTime(date5);

//结果：00:00:00
    String formatTime = DateUtil.formatTime(date5);

  }

}
