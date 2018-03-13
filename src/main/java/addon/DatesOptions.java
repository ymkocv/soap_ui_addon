package addon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import org.apache.log4j.*;

public class DatesOptions {

    /**
     * The method to get current date & time
     *
     * @param pattern       The format of the date
     * @return              The current date
     */

    public static String getCurrentDateTime(String pattern) {
        Calendar cal = Calendar.getInstance();
        return formatDate(cal.getTime(), pattern);
    }

    /**
     * The method to format date
     *
     * @param date          Date to format
     * @param pattern       The format of the date
     * @return              The formatted date
     */

    public static String formatDate(Date date, String pattern) {
        Optional.ofNullable(date).orElseThrow(() -> new IllegalArgumentException(""));
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * The method to parse date from string
     *
     * @param date          Date to parse
     * @param pattern       The format of the date
     * @return              The parsed date
     */

    public static Date parseDate(String date, String pattern) {
        Calendar cln = Calendar.getInstance();
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            Date testDate = df.parse(date);
            cln.setTime(testDate);
        } catch (Throwable e) {
            String error = "Can't parse date from the string because of: \n" + e.getLocalizedMessage();
            throw new RuntimeException(error, e);
        }
        return cln.getTime();

    }

    /**
     * General internal method to be used for date modifictions
     *
     * @param date          Date to modify
     * @param count         The value to encrease/decrease date (e.g.1)
     * @param calendarItem  The value of calendar item to change: day/month/etc
     * @return              Modified date
     */
    public static Date generalModificationOfDate(Date date, int count, int calendarItem) {

        Calendar cln = Calendar.getInstance();
        cln.setTime(date);
        cln.add(calendarItem, count);
        return cln.getTime();
    }

    /**
     * The method to be used for modifiction of a DAY for date
     *
     * @param date          Date to modify
     * @param count         The value to encrease/decrease date (e.g.1)
     * @param pattern       The format of the date needed
     * @return              Modified date
     */

    public static String dateAddDay(Date date, String pattern, int count) {

        Date newDate = generalModificationOfDate(date, count, Calendar.DATE);
        return formatDate(newDate, pattern);

    }

    /**
     * The method to be used for modifiction of a MONTH for date
     *
     * @param date          Date to modify
     * @param count         The value to encrease/decrease date (e.g.1)
     * @param pattern       The format of the date needed
     * @return              Modified date
     */

    public static String dateAddMonth(Date date, String pattern, int count) {

        Date newDate = generalModificationOfDate(date, count, Calendar.MONTH);
        return formatDate(newDate, pattern);

    }

    /**
     * The method to be used for modifiction of a YEAR for date
     *
     * @param date          Date to modify
     * @param count         The value to encrease/decrease date (e.g.1)
     * @param pattern       The format of the date needed
     * @return              Modified date
     */

    public static String dateAddYear(Date date, String pattern, int count) {

        Date newDate = generalModificationOfDate(date, count, Calendar.YEAR);
        return formatDate(newDate, pattern);

    }

    /**
     * The method to be used for modifiction of a HOUR for date
     *
     * @param date          Date to modify
     * @param count         The value to encrease/decrease date (e.g.1)
     * @param pattern       The format of the date needed
     * @return              Modified date
     */

    public static String dateAddHour(Date date, String pattern, int count) {

        Date newDate = generalModificationOfDate(date, count, Calendar.HOUR);
        return formatDate(newDate, pattern);

    }
}
