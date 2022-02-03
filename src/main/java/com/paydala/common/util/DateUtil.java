package com.paydala.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    
    public final static Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    public static String toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }

    public static Date fromISO8601UTC(String dateStr) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);

        try {
            return df.parse(dateStr);
        } catch (ParseException e) {

        }

        return null;
    }
    
     public static java.util.Date gmtTimeDate()  {
        try {
            java.util.Date pdate = new java.util.Date();
            TimeZone tZone = TimeZone.getTimeZone("GMT");
            DateFormat dFormat = DateFormat.getDateTimeInstance();
            dFormat.setTimeZone(tZone);
            String formattedDate = dFormat.format(pdate);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");
            java.util.Date finalDate = simpleDateFormat.parse(formattedDate);

            return finalDate;
        } catch (ParseException ex) {
            LOG.error("Error parsing the date ", ex);
            return null;
        }
    }
     
     public static Instant getDateFromDateFilter(String dateFilter,Instant toDate){
        return  toDate.minus(getHoursFromDateFilter(dateFilter), ChronoUnit.HOURS);
    }

    private static int getHoursFromDateFilter(String dateFilter ){
        int number=getNumberFromDateFilter(dateFilter);
        if(dateFilter.contains("day"))
            return getHoursFromDay(number);
        else if(dateFilter.contains("hr"))
            return number;
        //TODO: Better handling for all. Rn only for 1 year
        return 8760;
    }

    private static int getHoursFromDay(int day ){
        return day*24;
    }

    private static int getNumberFromDateFilter(String dateFilter){
        return Integer.parseInt(dateFilter.replaceAll("[^0-9]", ""));
    }
}
