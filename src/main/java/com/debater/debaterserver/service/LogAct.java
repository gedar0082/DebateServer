package com.debater.debaterserver.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAct {

    public static final String TAG_TARGET_USER     = "[USER   ACTIONS] ";
    public static final String TAG_TARGET_SERVER   = "[SERVER ACTIONS] ";
    public static final String ACTION_AUTHENTICATION   = " - ACTION AUTHENTICATION - ";
    public static final String ACTION_REGISTRATION     = " - ACTION REGISTRATION   - ";
    public static final String START = " START ";
    public static final String END =   " END   ";


    public static String getDateTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return "[" + formatter.format(date) + "]";
    }

}
