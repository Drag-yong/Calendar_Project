import java.util.Calendar;

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

        if (output)
            System.out.println("testGetMonthIndex() passed.");
        else
            System.out.println("testGetMonthIndex() failed.");

        return output;
    }

    public static boolean testGetNumberOfDaysInMonth() {
        boolean output = true;

        if (CalendarPrinter.getNumberOfDaysInMonth("February", "2020") != 29) {
            System.out.println("The days of February in 2020 is 29");
            output = false;
        }
        if (CalendarPrinter.getNumberOfDaysInMonth("April", "2019") != 30) {
            System.out.println("The days of April in 2019 is 30");
            output = false;
        }
        if (CalendarPrinter.getNumberOfDaysInMonth("December", "2018") != 31) {
            System.out.println("The days of December in 2019 is 31");
            output = false;
        }

        if (output)
            System.out.println("testGetNumberOfDaysInMonth() passed.");
        else
            System.out.println("testGetNumberOfDaysInMonth() failed.");

        return output;
    }

    public static boolean testGetFirstDayOfWeekInMonth() {
        boolean output = true;


        return output;
    }

    public static void main(String[] args) {
        boolean a = testGetCentury();
        boolean b = testGetYearWithinMonth();
        boolean c = testGetIsLeapYear();
        boolean d = testGetNumberOfDaysInMonth();
        boolean e = testGetFirstDayOfWeekInMonth();

        if (a && b && c && d && e)
            System.out.println("All tests passed!");
    }
}
