package com.telrun.rledenev.dryKissYagni;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
    
    public static String formatTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDateTimeForDisplay(Date date) {
        return String.format("%s %s", formatDateForDisplay(date), formatTimeForDisplay(date));
    }
}