package mdao.common;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTime {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //获得当前月份，以便于识别要存入哪个表
    public  static String  getMonth(){
        String monthNew=sdf.format(new Date());
        String month=monthNew.substring(4,6);
        return month;
    }
    //获得上个月的月份
    public  static String   getlastMonth(){
        String monthNew=sdf.format(new Date());
        String month=monthNew.substring(4,6);
        String lastmonth=null;
        if(Integer.parseInt(month)==1){
            lastmonth="12";
        }else if(Integer.parseInt(month)>1&&Integer.parseInt(month)<=10){
            lastmonth="0"+String.valueOf(Integer.parseInt(month)-1);
        }
        if(Integer.parseInt(month)>10){
            lastmonth=String.valueOf(Integer.parseInt(month)-1);
        }
        return  lastmonth;
    }
    //获得当前时间，以便于插入数据时存储
    public static String getNew(){
        String newTime=sdf2.format(new Date());
        return newTime;
    }
    public static int getYear_month_(){
        String TimeNew=sdf.format(new Date());
        String year_month_=TimeNew.substring(0,6);
        return Integer.parseInt(year_month_);
    }
    public static int getYear_month_day_(){
        String TimeNew=sdf.format(new Date());
        String year_month_day_=TimeNew.substring(0,8);
        return Integer.parseInt(year_month_day_);
    }

}
