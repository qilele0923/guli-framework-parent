package com.test;

import cn.hutool.core.convert.Convert;
import java.util.List;

/**
 * @author qi on 2019-10-11 15:17
 */
public class ConvertDemo {

  public static void main(String[] args) {

    int a=1;
    System.out.println(Convert.toStr(a));

    long[] b = {1,2,3,4,5};
    System.out.println(Convert.toStr(b));


    String[] c = { "1", "2", "3", "4" };
    System.out.println(Convert.toIntArray(c));

    long[] cc = {1,2,3,4,5};
    System.out.println(Convert.toIntArray(cc));

    String aa = "2017-05-06";
    System.out.println(Convert.toDate(aa));

    Object[] aaa = {"a", "你", "好", "", 1};
    List<?> list = Convert.convert(List.class, aaa);
//从4.1.11开始可以这么用
    System.out.println(Convert.toList(aaa));


  }
}
