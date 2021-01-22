package com.example.Cut;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Record {
    public String time;
    public String amount;
    private String datePattern = "yyyy-MM-dd HH:mm:ss";

    Record(String date, double amount) {
        String sign = "";
        if (amount > 0)
            sign = "+";
        this.amount = sign + amount;

//        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
//        this.time = sdf.format(date);
        this.time =date;

//        System.out.println(this.time);
    }
}
