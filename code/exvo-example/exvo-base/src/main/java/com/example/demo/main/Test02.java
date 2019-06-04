package com.example.demo.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Date: 2019/4/12
 * @Author: wu yang
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        SimpleDateFormat DATE_TIME_FORMAT_EXAC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = "2018-11-01 12:34:56";
//
        LocalDateTime localDateTime = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(localDateTime.getYear());
//        System.out.println(localDateTime.getMonthValue());
//        System.out.println(localDateTime.getDayOfMonth());
//        System.out.println(localDateTime.getHour());
//        System.out.println(localDateTime.getMinute());
//        System.out.println(localDateTime.getSecond());

//        LocalDateTime localDateTime = LocalDateTime.now();
//        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(from);

        try {
            Date date = DATE_TIME_FORMAT_EXAC.parse(startDate);
            LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            System.out.println(localDateTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void test(){
        int[] num = {1,2,2,3,4,5,6,7,8,9};
        int sum = 7;
        findSum(num,sum);
    }

    public static void findSum(int[] num,int sum){
        int left=0;
        int right=0;

        for(int i=0;i<num.length;i++){
            int curSum = 0;
            left = i;
            right = i;
            while(curSum<sum){
                curSum += num[right++];
            }
            if(curSum==sum){
                for(int j=left;j<right;j++){
                    System.out.print(num[j]+" ");
                }
                System.out.println();
            }
        }
    }


}
