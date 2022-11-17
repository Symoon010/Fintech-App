package com.fintechapp.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
@Service
public class  DateTimeService {

    public String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentTime = LocalDateTime.now();
        return dtf.format(currentTime);
    }

    public static String previousDateString(String dateString) {
        String result ="";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date myDate = dateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_YEAR, -30);
            Date previousDate = calendar.getTime();
            result = dateFormat.format(previousDate);

            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return result;
    }

    public String getCurrentTime(){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            LocalDateTime currentTime = LocalDateTime.now();
            return dtf.format(currentTime);
     }

     public Long getTimeDifference(String firstEntryTime, String lastEntryTime) throws ParseException {
         SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
         // In the try block, we will try to find the difference
         try {
             // Use parse method to get date object of both dates
             Date date1 = obj.parse(firstEntryTime);
             Date date2 = obj.parse(lastEntryTime);
             // Calucalte time difference in milliseconds
             long time_difference = date2.getTime() - date1.getTime();
//             // Calucalte time difference in days
//             long days_difference = (time_difference / (1000*60*60*24)) % 365;
//             // Calucalte time difference in years
//             long years_difference = (time_difference / (1000l*60*60*24*365));
//             // Calucalte time difference in seconds
//             long seconds_difference = (time_difference / 1000)% 60;
//             // Calucalte time difference in minutes
//             long minutes_difference = (time_difference / (1000*60)) % 60;
             // Calucalte time difference in hours
             long hours_difference = (time_difference / (1000*60*60)) % 24;
             return  hours_difference;
         }
         catch (ParseException e) {
             e.printStackTrace();
         }
         return  0L;
     }
 }
