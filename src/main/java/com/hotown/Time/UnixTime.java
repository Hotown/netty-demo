package com.hotown.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hotown on 17/9/1.
 */
public class UnixTime {
    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        Date date = new Date((value() - 2208988800L) * 100L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
