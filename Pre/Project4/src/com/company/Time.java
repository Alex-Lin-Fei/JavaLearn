package com.company;

//时间类
public class Time {

//    时间类的数据成员  小时 分钟  秒
    private int hour;
    private int minute;
    private int second;


//    时间类的无参构造函数
    public Time() {
//        获取系统当前时间
        double time=System.currentTimeMillis()%(3600000*24);

        this.hour=(int)time/3600000;
        this.minute=(int)((time-3600000*this.hour)/60000);
        this.second=(int)(time-60000*this.minute-3600000*this.hour)/1000;

    }

//    时间类的有参构造函数

    public Time(double millisecond) {
        double time=millisecond%(3600000*24);

        this.hour=(int)time/3600000;
        this.minute=(int)((time-3600000*this.hour)/60000);
        this.second=(int)(time-60000*this.minute-3600000*this.hour)/1000;
    }

//    获取对象数据成员信息

    public int getHour() { return this.hour; }
    public int getMinute() { return this.minute; }
    public int getSecond() { return this.second; }

}
