package com.debater.debaterserver.util;

import java.sql.Timestamp;

public class Utility {

    public static Timestamp getCurrentTimeGMT(){
        return new Timestamp(System.currentTimeMillis());
    }
}
