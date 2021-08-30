package ch4_oop.unit2_localdate;

import java.time.LocalDate;

/**
 * Prints out a calendar of the current month like this:
 * Mon Tue Wed Thi Fri Sat Sun
 *                          1
 *  2   3   4   5   6   7   8
 *  9  10  11  12  13  14  15
 * 16  17  18  19  20  21  22
 * 23  24  25  26  27  28  29
 * 30* 31
 *
 * Marks the current day as "*".
 */
public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        LocalDate firstDayOfMonth = today.minusDays(dayOfMonth - 1);

        String header = String.join(" ", "Mon", "Tue", "Wed", "Thi", "Fri", "Sat", "Sun");
        System.out.println(header);

        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 1..7
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print(" ".repeat(4)); // 4 spaces
        }

        for (LocalDate currentDay = firstDayOfMonth;
             currentDay.getMonthValue() == today.getMonthValue();
             currentDay = currentDay.plusDays(1)) {
            String dayNumber = String.valueOf(currentDay.getDayOfMonth());
            System.out.print((dayNumber.length() == 1 ? " " : "") + dayNumber);

            String currentDayEnding = today.equals(currentDay) ? "*" : " ";
            System.out.print(currentDayEnding);

            if (currentDay.getDayOfWeek().getValue() == 7) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
