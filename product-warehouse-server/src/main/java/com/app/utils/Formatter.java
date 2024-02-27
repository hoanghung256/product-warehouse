package com.app.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hoang hung
 */
public class Formatter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    
    public static Date convertTimeStampToDate(Timestamp time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String timeString = time.toLocalDateTime().toLocalDate().toString();
        return formatter.parse(timeString);
    }

    public static String convertTimeStampToString(Timestamp time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(time);
    }
    
    public static Date convertStringToDate(String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(time);
    }
    
    public static String convertDateToString(String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(time);
    }
    
    public static Timestamp format(Timestamp time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        System.out.println(Timestamp.valueOf(formatter.format(new Date(time.getTime()))));
        return Timestamp.valueOf(formatter.format(new Date(time.getTime())));
    }
}
