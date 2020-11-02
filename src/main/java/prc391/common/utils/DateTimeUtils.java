package prc391.common.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String dateTimeToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        String result = df.format(date);

        return result;
    }
}
