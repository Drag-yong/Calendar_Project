public class CalendarTester {
    public static boolean testGetCentury() {
        boolean output = true;

        if (CalendarPrinter.getCentury("2") != 0) {
            System.out.println("The century of 2 is 0");
            output = false;
        }
        if (CalendarPrinter.getCentury("2019") != 20) {
            System.out.println("The century of 2019 is 20");
            output = false;
        }
        if (CalendarPrinter.getCentury("44444") != 444) {
            System.out.println("The century of 44444 is 444");
            output = false;
        }

        if (output)
            System.out.println("testGetCentury() passed.");
        else
            System.out.println("testGetCentury() failed.");

        return output;
    }

    public static boolean testGetYearWithinMonth() {
        boolean output = true;

        if (CalendarPrinter.getYearWithinCentury("23") != 23) {
            System.out.println("23 of the year within century is 23");
            output = false;
        }
        if (CalendarPrinter.getYearWithinCentury("15392") != 92) {
            System.out.println("15392 of the year within century is 92");
            output = false;
        }
        if (CalendarPrinter.getYearWithinCentury("2019") != 19) {
            System.out.println("2019 of the year within century is 19");
            output = false;
        }
        if (output)
            System.out.println("testGetYearWithinMonth() passed.");
        else
            System.out.println("testGetYearWithinMonth() failed.");

        return output;
    }

    public static boolean testGetIsLeapYear() {
        boolean output = true;

        if (!CalendarPrinter.getIsLeapYear("2020")) {
            System.out.println("2020 is a leap year");
            output = false;
        }
        if (CalendarPrinter.getIsLeapYear("1700")) {
            System.out.println("1700 is not a leap year");
            output = false;
        }
        if (CalendarPrinter.getIsLeapYear("1800")) {
            System.out.println("1800 is not a leap year");
            output = false;
        }
        if (CalendarPrinter.getIsLeapYear("1900")) {
            System.out.println("1900 is not a leap year");
            output = false;
        }
        if (!CalendarPrinter.getIsLeapYear("2000")) {
            System.out.println("2000 is a leap year");
            output = false;
        }
        if (CalendarPrinter.getIsLeapYear("2019")) {
            System.out.println("2019 is not a leap year");
            output = false;
        }

        if (output)
            System.out.println("testGetIsLeapYear() passed.");
        else
            System.out.println("testGetIsLeapYear() failed.");

        return output;
    }

    public static boolean testGetMonthIndex() {
        boolean output = true;

        if (CalendarPrinter.getMonthIndex("january") != 0) {
            System.out.println("The index of \"january\" is 0");
            output = false;
        }
        if (CalendarPrinter.getMonthIndex("JaNuArY") != 0) {
            System.out.println("The index of \"JaNuArY\" is 0");
            output = false;
        }
        if (CalendarPrinter.getMonthIndex("March") != 2) {
            System.out.println("The index of \"March\" is 2");
            output = false;
        }
        if (CalendarPrinter.getMonthIndex("MARCH") != 2) {
            System.out.println("The index of \"MARCH\" is 2");
            output = false;
        }
        if (CalendarPrinter.getMonthIndex("Something String") != -1) {
            System.out.println("\"Something String\" is not a part of months!");
            output = false;
        }

        if (output)
            System.out.println("testGetMonthIndex() passed.");
        else
            System.out.println("testGetMonthIndex() failed.");

        return output;
    }

    public static boolean testGetNumberOfDaysInMonth() {
        boolean output = true;
        int a = CalendarPrinter.getNumberOfDaysInMonth("February", "2020");
        int b = CalendarPrinter.getNumberOfDaysInMonth("April", "2019");
        int c = CalendarPrinter.getNumberOfDaysInMonth("December", "2018");
        int d = CalendarPrinter.getNumberOfDaysInMonth("January", "2000");
        int e = CalendarPrinter.getNumberOfDaysInMonth("January", "2020");

        if (a != 29) {
            System.out.println("The days of February in 2020 is 29");
            System.out.println("I got: " + a);
            output = false;
        }
        if (b != 30) {
            System.out.println("The days of April in 2019 is 30");
            System.out.println("I got: " + b);
            output = false;
        }
        if (c != 31) {
            System.out.println("The days of December in 2019 is 31");
            System.out.println("I got:" + c);
            output = false;
        }
        if (d != 31) {
            System.out.println("The days of January in 2000 is 31");
            System.out.println("I got: " + d);
            output = false;
        }
        if (e != 31) {
            System.out.println("The days of January in 2000 is 31");
            System.out.println("I got: " + e);
        }

        if (output)
            System.out.println("testGetNumberOfDaysInMonth() passed.");
        else
            System.out.println("testGetNumberOfDaysInMonth() failed.");

        return output;
    }

    public static boolean testGetFirstDayOfWeekInMonth() {
        boolean output = true;
        int a = CalendarPrinter.getFirstDayOfWeekInMonth("September", "2019");
        int b = CalendarPrinter.getFirstDayOfWeekInMonth("January", "2000");
        int c = CalendarPrinter.getFirstDayOfWeekInMonth("January", "2020");

        if (a != 6) {
            System.out.println("September 1, 2019 is Sunday, 6");
            System.out.println("I got: " + a);
            output = false;
        }
        if (b != 5) {
            System.out.println("January 1, 2000 is Saturday, 5");
            System.out.println("I got: " + b);
            output = false;
        }
        if (c != 2) {
            System.out.println("January 1, 2020 is Wednesday, 2");
            System.out.println("I got :" + c);
            output = false;
        }

        if (output)
            System.out.println("testGetFirstDayOfWeekInMonth() passed.");
        else
            System.out.println("testGetFirstDayOfWeekInMonth() failed.");

        return output;
    }

    public static boolean testGenerateCalendar() {
        boolean output = true;
        String[] days = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        String[][] calendar1 = new String[7][7]; // January 2000
        String[][] calendar2 = new String[6][7]; // February 2020
        String[][] calendar3 = new String[7][7]; // September 2019

        for (int i = 0; i < days.length; i++) { // fill the first line of three calendars
            calendar1[0][i] = days[i];
            calendar2[0][i] = days[i];
            calendar3[0][i] = days[i];
        }

        int daysFor1 = 1; // for calendar1, it will fill all the days inside the calendar1.
        int daysFor2 = 1; // for calendar2, same as daysFor1.
        int daysFor3 = 1; // for calendar3, same as daysFor1.

        for (int i = 1; i < 7; i++) { // Calendar for January 2000
            for (int j = 0; j < 7; j++) {
                if ((i == 1 && j < 5) || daysFor1 > 31) {
                    calendar1[i][j] = ".";
                } else {
                    calendar1[i][j] = "" + daysFor1;
                    daysFor1++;
                }
            }
        }

        for (int i = 1; i < 6; i++) { // Calendar for February 2020
            for (int j = 0; j < 7; j++) {
                if (i == 1 && j < 5) {
                    calendar2[i][j] = ".";
                } else {
                    calendar2[i][j] = "" + daysFor2;
                    daysFor2++;
                }
            }
        }

        for (int i = 1; i < 7; i++) { // Calendar for September 2019
            for (int j = 0; j < 7; j++) {
                if ((i == 1 && j < 6) || daysFor3 > 30) {
                    calendar3[i][j] = ".";
                } else {
                    calendar3[i][j] = "" + daysFor3;
                    daysFor3++;
                }
            }
        }

        if (!checkEqualCalendars(CalendarPrinter.generateCalendar("January", "2000"), calendar1)) {
            System.out.println("You created the wrong calendar for January 2000. This is the right calendar");
            output = printCalendar(calendar1);
        }
        if (!checkEqualCalendars(CalendarPrinter.generateCalendar("February", "2020"), calendar2)) {
            System.out.println("You created the wrong calendar for February 2020. This is the right calendar");
            output = printCalendar(calendar2);
        }
        if (!checkEqualCalendars(CalendarPrinter.generateCalendar("September", "2019"), calendar3)) {
            System.out.println("You created the wrong calendar for September 2019. This is the right calendar");
            output = printCalendar(calendar3);
        }

        if (output)
            System.out.println("testGenerateCalendar() passed.");
        else
            System.out.println("testGenerateCalendar() failed.");

        return output;
    }

    //////////////////
    //private method//
    //////////////////

    private static boolean printCalendar(String[][] calendar) {
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[0].length; j++) {
                System.out.print(calendar[i][j] + "  ");
            }
            System.out.println();
        }
        return false;
    }

    private static boolean checkEqualCalendars(String[][] calendar1, String[][] calendar2) {
        if (calendar1.length != calendar2.length || calendar1[0].length != calendar2[0].length)
            return false;

        for (int i = 0; i < calendar1.length; i++) {
            for (int j = 0; j < calendar1[0].length; j++) {
                if (!calendar1[i][j].equals(calendar2[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a = testGetCentury();
        System.out.println();
        boolean b = testGetYearWithinMonth();
        System.out.println();
        boolean c = testGetIsLeapYear();
        System.out.println();
        boolean d = testGetMonthIndex();
        System.out.println();
        boolean e = testGetNumberOfDaysInMonth();
        System.out.println();
        boolean f = testGetFirstDayOfWeekInMonth();
        System.out.println();
        boolean g = testGenerateCalendar();
        System.out.println();

        if (a && b && c && d && e && f && g)
            System.out.println("All tests passed!");
        else
            System.out.println("Good luck! You can pass all the tests!");
    }
}
