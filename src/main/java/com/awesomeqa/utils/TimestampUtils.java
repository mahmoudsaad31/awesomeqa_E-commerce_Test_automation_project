package com.awesomeqa.utils;

import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtils {

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println();
    }

    public static String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return formatter.format(date);
    }
}
