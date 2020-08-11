package automated_testing_tdd.bai_tap.next_day_calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NextDayCalculator {
    public static String findNextDay(String date) throws ParseException {
        // Tạo đối tượng Date :
        Date dateFormat;
        // Tạo định dạng :
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // Tạo đối tượng Calendar :
        Calendar calendar = Calendar.getInstance();
        // Chuyển từ String date về đối tượng :
        dateFormat = simpleDateFormat.parse(date);
        // Set thời gian :
        calendar.setTime(dateFormat);
        // Cộng lên 1 ngày :
        calendar.add(Calendar.DATE,1);
        // Trả về chuỗi rồi return :
        return simpleDateFormat.format(calendar.getTime());
    }
}