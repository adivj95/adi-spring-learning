package com.adi.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-mm-dd");

    public static Date createdDateFromDateString(String dateString){
        Date date=null;
        if(null!= dateString){
            try {
                date= DATE_FORMAT.parse(dateString);
            }
            catch (ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
