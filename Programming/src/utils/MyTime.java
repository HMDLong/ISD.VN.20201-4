package utils;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyTime {
	public static int getDifferenceTimes(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return (int)TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }
	
	public static String minutesToTimeFormat(int minutes) {
	  int hour = minutes / 60;
	  int minute = minutes % 60;
	  return String.format("%d:%02d:00", hour, minute);
	}
}
