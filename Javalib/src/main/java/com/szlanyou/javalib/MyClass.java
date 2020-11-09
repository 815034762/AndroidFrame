package com.szlanyou.javalib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;
import static java.text.DateFormat.*;

class MyClass {

    public static void main(String[] args) {
        System.out.println("Action Main is");
        System.out.println(isNight(null,null));
        System.out.println(isNight("2020-11-09 06:00:00","2020-11-09 18:00:00"));
        System.out.println(isNight("2020-11-09 18:00:00","2020-11-09 06:00:00"));
        System.out.println(isNight("2020-11-09 06:00:00","2020-11-09 06:00:00"));
    }

    /**
     * 日出：sunuptime   日落 sunsettime
     * @param sunuptime 日出
     * @param sunsettime 日落
     * @return
     */
    public static boolean isNight(String sunuptime, String sunsettime){
        String time = String.valueOf(format("yyyy-MM-dd HH:mm:ss", new Date().getTime()));
        return !((timeCompare(sunuptime, time) == 3 && timeCompare(time, sunsettime) == 3) || timeCompare(time, sunsettime) == 0 );
    }

    /**
     * 判断2个时间大小
     * yyyy-MM-dd HH:mm 格式（自己可以修改成想要的时间格式）
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int timeCompare(String startTime, String endTime) {
        int i = 0;
        //注意：传过来的时间格式必须要和这里填入的时间格式相同
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(endTime);//结束时间
            System.out.println(date1.getTime() - date2.getTime());
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime() < date1.getTime()) {
                //结束时间小于开始时间
                i = 1;
            } else if (date2.getTime() == date1.getTime()) {
                //开始时间与结束时间相同
                i = 2;
            } else if (date2.getTime() > date1.getTime()) {
                //结束时间大于开始时间
                i = 3;
            }
        } catch (Exception ignored) {
            System.out.println(ignored.getLocalizedMessage());
        }
        return i;
    }
}