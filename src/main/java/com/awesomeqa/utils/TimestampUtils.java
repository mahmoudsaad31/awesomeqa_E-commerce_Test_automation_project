package com.awesomeqa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtils {

    public static String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        return formatter.format(date);
    }
}
