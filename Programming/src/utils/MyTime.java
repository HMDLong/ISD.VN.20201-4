package utils;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyTime {
	public static int getDifferenceTimes(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return (int)TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
