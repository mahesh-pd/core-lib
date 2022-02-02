package com.paydala.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
