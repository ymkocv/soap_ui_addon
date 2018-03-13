import addon.DatesOptions;
import addon.RandomsOptions;

import java.text.ParseException;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws ParseException {

        String pattern = "dd-MM-yyyy HH:mm:ss";
        String testDate = DatesOptions.getCurrentDateTime(pattern);//"05-03-2018 15:15:00";

        Date date = DatesOptions.parseDate(testDate, pattern);
        System.out.println(date);
        String modifiedDay = DatesOptions.dateAddDay(date, pattern, 1);
        String modifiedMonth = DatesOptions.dateAddMonth(date, pattern, 2);
        String modifiedYear = DatesOptions.dateAddYear(date, pattern, -1);
        String modifiedHour = DatesOptions.dateAddHour(date, pattern, -2);
        System.out.println(modifiedDay + "\n" + modifiedMonth + "\n" + modifiedYear + "\n" + modifiedHour);

        RandomsOptions.generateRandomInt(5,101);
        RandomsOptions.generateRandomString(6);
        RandomsOptions.generateEmail(15);
        RandomsOptions.generateUID();
        System.out.println(System.currentTimeMillis());
    }

}
