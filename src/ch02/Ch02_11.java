package ch02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import static java.time.LocalDate.*;
import static java.lang.System.*;

public class Ch02_11 {
    public static void main(String[] args) {
        String[] days = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        out.println(String.join("    ", days));
        LocalDate date = now().withDayOfMonth(1);
        Month month = date.getMonth();
        int shift = date.getDayOfWeek().getValue() % 7;
        for (int i = 0; i < shift; i++) {
            out.print("       ");
        }
        while (date.getMonth() == month) {
            out.printf("%2d     ", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                out.println();
            }
            date = date.plusDays(1);
        }
    }
}
