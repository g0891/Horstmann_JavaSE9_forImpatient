package ch02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Ch02_01 {
    public static void main(String[] args) {
        String[] days = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.println(String.join("    ", days));
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        Month month = date.getMonth();
        int shift = date.getDayOfWeek().getValue() % 7;
        for (int i = 0; i < shift; i++) {
            System.out.print("       ");
        }
        while (date.getMonth() == month) {
            System.out.printf("%2d     ", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }
}
