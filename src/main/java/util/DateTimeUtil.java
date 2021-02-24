package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    public static String getCurDatetime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}
