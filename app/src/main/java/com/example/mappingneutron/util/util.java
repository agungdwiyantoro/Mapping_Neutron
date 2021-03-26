package com.example.mappingneutron.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class util {

    public static Date getCurrentDate(){
        return Calendar.getInstance().getTime();
    }

    public static String convertDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
    }
}
