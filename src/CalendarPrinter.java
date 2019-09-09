import javax.print.DocFlavor;

public class CalendarPrinter {
    private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private final static String[] MONTHS_OF_YEAR = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP",
            "OCT", "NOV", "DEC"};

    /**
     * Calculates the number of centuries (rounded down) that is represented by the
     * specified year (ie. the integer part of year/100).
     *
     * @param year to compute the century of (based on the Gregorian Calendar AD)
     *             String must contain the digits of a single non-negative int for
     *             year.
     * @return number of centuries in the specified year
     */
    public static int getCentury(String year) {
        int yearInt = Integer.parseInt(year);
        int century = (int) Math.floor(yearInt / 100);
        return century;
    }

    /**
     * Calculates the number of years between the specified year, and the first year
     * in the specified year's century. This number is always between 0 - 99.
     *
     * @param year to compute the year within century of (Gregorian Calendar AD)
     *             String must contain the digits of a single non-negative int for
     *             year.
     * @return number of years since first year in the current century
     */
    public static int getYearWithinCentury(String year) {
        int century = getCentury(year) * 100; // get century and multiplied by 100, or first year's century
        int specifiedYear = Integer.parseInt(year) - century;
        return specifiedYear;
    }

    /**
     * This method computes whether the specified year is a leap year or not.
     *
     * @param yearString is the year that is being checked for leap-year-ness String
     *                   must contain the digits of a single non-negative int for
     *                   year.
     * @return true when the specified year is a leap year, and false otherwise
     */
    public static boolean getIsLeapYear(String yearString) {
        // Note implementation tips in Appendix I below.
//		if (year is not divisible by 4) then (it is a common year)
//		else if (year is not divisible by 100) then (it is a leap year)
//		else if (year is not divisible by 400) then (it is a common year)
//		else (it is a leap year)
        // Pseudocode for the leap year
        int getYear = Integer.parseInt(yearString);

        if (getYear % 4 != 0) {
            return false; // common year
        } else if (getYear % 100 != 0) {
            return true; // leap year
        } else if (getYear % 400 != 0) {
            return false; // common year
        } else {
            return true; // leap year otherwise
        }
    }

    /**
     * Converts the name or abbreviation for any month into the index of that
     * month's abbreviation within MONTHS_OF_YEAR. Matches the specified month based
     * only on the first three characters, and is case in-sensitive.
     *
     * @param month which may or may not be abbreviated to 3 or more characters
     * @return the index within MONTHS_OF_YEAR that a match is found at and returns
     * -1, when no match is found
     */
    public static int getMonthIndex(String month) {
        String abbMon = month.substring(0, 3)/*.toUpperCase()*/;
        for (int i = 0; i < MONTHS_OF_YEAR.length; i++) { // visit all the elements in the array
            if (MONTHS_OF_YEAR[i].equalsIgnoreCase(abbMon)) { // [] for array, list;
                return i;
            }
        }
        return -1; // if MONTHS_OF_YEAR[i] != abbMon;
//         for each??
//        int count = 0;
//        for(String mon : MONTHS_OF_YEAR) {
//
//            if (mon.equalsIgnoreCase(abbMon)) {
//                return count;
//            }
//            count++;
//        }
    }

    /**
     * Calculates the number of days in the specified month, while taking into
     * consideration whether or not the specified year is a leap year.
     *
     * @param month which may or may not be abbreviated to 3 or more characters
     * @param year  of month that days are being counted for (Gregorian Calendar AD)
     *              String must contain the digits of a single non-negative int for
     *              year.
     * @return the number of days in the specified month (between 28-31)
     */
    public static int getNumberOfDaysInMonth(String month, String year) { // 31days: 1, 3, 5, 7, 8, 10, 12
        // 30 days: 4, 6, 9, 11
        // affected by leap year: 2
        boolean isLeapYear = getIsLeapYear(year); // check if it is leap year or not
        int monthIndex = getMonthIndex(month); // get a value = Mon - 1;

        boolean check31 = monthIndex == 0 || monthIndex == 2 || monthIndex == 4 || monthIndex == 6 || monthIndex == 7 || monthIndex == 9 || monthIndex == 11;
        if (isLeapYear) { // check if it is a leap year or not
            if (check31) {
                return 31;
            } else if (monthIndex == 1) { // check if it is February
                return 29; // because of leap year
            } else {
                return 30;
            }
        } else {
            if (check31) {
                return 31;
            } else if (monthIndex == 1) { // check if it is February
                return 28; // because of common year
            } else {
                return 30;
            }
        }
    }

    /**
     * Calculates the index of the first day of the week in a specified month. The
     * index returned corresponds to position of this first day of the week within
     * the DAYS_OF_WEEK class field.
     *
     * @param month which may or may not be abbreviated to 3 or more characters
     * @param year  of month to determine the first day from (Gregorian Calendar AD)
     *              String must contain the digits of a single non-negative int for
     *              year.
     * @return index within DAYS_OF_WEEK of specified month's first day
     */
    public static int getFirstDayOfWeekInMonth(String month, String year) {
        // Note implementation tips in Appendix I below.
        return 0;
    }

    /**
     * Creates and initializes a 2D String array to reflect the specified month. The
     * first row of this array [0] should contain labels representing the days of
     * the week, starting with Monday, as abbreviated in DAYS_OF_WEEK. Every later
     * row should contain dates under the corresponding days of week. Entries with
     * no corresponding date in the current month should be filled with a single
     * period. There should not be any extra rows that are either blank, unused, or
     * completely filled with periods. For example, the contents for September of
     * 2019 should look as follows, where each horizontal row is stored in different
     * array within the 2d result:
     * <p>
     * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     * 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 . . . . . .
     *
     * @param month which may or may not be abbreviated to 3 or more characters
     * @param year  of month generate calendar for (Gregorian Calendar AD) String
     *              must contain the digits of a single non-negative int for year.
     * @return 2d array of strings depicting the contents of a calendar
     */
    public static String[][] generateCalendar(String month, String year) {
        return null;
    }
}