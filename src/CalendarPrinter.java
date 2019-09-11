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
        return (int) Math.floor(Integer.parseInt(year) / 100);
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
        return Integer.parseInt(year) % 100;
    }

    /**
     * This method computes whether the specified year is a leap year or not.
     *
     * @param yearString is the year that is being checked for leap-years String
     *                   must contain the digits of a single non-negativt for
     *                   year.
     * @return true when the specified year is a leap year, and false otherwise
     */
    public static boolean getIsLeapYear(String yearString) {
        // Note implementation tips in Appendix I below.
/////////////////////////Pseudocode for the leap year/////////////////////////
//		if (year is not divisible by 4) then (it is a common year)          //
//		else if (year is not divisible by 100) then (it is a leap year)     //
//		else if (year is not divisible by 400) then (it is a common year)   //
//		else (it is a leap year)                                            //
//////////////////////////////////////////////////////////////////////////////
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


        if (monthIndex == 0 || monthIndex == 2 || monthIndex == 4 || monthIndex == 6 || monthIndex == 7 || monthIndex == 9 || monthIndex == 11) {
            return 31;
        } else if (monthIndex == 1) { // check if it is February
            if (isLeapYear) // check if it is a leap year or not
                return 29; // because of the leap year
            else
                return 28;
        } else {
            return 30;
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
        int q = 1; // First day

        int m; // The number of days in the month,  3 = March, 4 = April, 5 = May, ..., 14 = February
        int checkMonthIndex = getMonthIndex(month);
        if (checkMonthIndex < 2)
            m = checkMonthIndex + 13; // January = 13, February = 14
        else
            m = checkMonthIndex + 1; // March = 3, April = 4, ...

        int k = getYearWithinCentury(year); // the year of the century (year % 100)
        int j = getCentury(year); // the zero based century (year / 100)

//        System.out.printf("m=%d, k=%d, j=%d%n", m, k, j);

        int daysOfTheWeek = (q + Math.floorDiv(13 * (m + 1), 5) + k + Math.floorDiv(k, 4) + Math.floorDiv(j, 4) + 5 * j) % 7;
        // 0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday
        return (daysOfTheWeek + 5) % 7; // 5 = Sat, 6 = Sun, 0 = Mon, ...
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
     * MON TUE WED THU FRI SAT SUN
     *  .   .   .   .   .   .   1
     *  2   3   4   5   6   7   8
     *  9   10  11  12  13  14  15
     *  16  17  18  19  20  21  22
     *  23  24  25  26  27  28  29
     *  30  .   .   .   .   .   .
     *
     * @param month which may or may not be abbreviated to 3 or more characters
     * @param year  of month generate calendar for (Gregorian Calendar AD) String
     *              must contain the digits of a single non-negative int for year.
     * @return 2d array of strings depicting the contents of a calendar
     */
    public static String[][] generateCalendar(String month, String year) {
        int firstDate = getFirstDayOfWeekInMonth(month, year);
        int lastDay = getNumberOfDaysInMonth(month, year);

        String[][] calendar;
        if (firstDate > 5/*Only Sunday*/ && lastDay >= 30) {
            calendar = new String[7][7];
        } else if (firstDate > 4/*Saturday*/ && lastDay >= 31) {
            calendar = new String[7][7];
        } else if(!getIsLeapYear(year) && getMonthIndex(month) == 1 && firstDate == 0) { // Not leap year, February, started from monday
            calendar = new String[5][7];
        } else {
            calendar = new String[6][7];
        }

        for (int i = 0; i < DAYS_OF_WEEK.length; i++) { // fill the first line
            calendar[0][i] = DAYS_OF_WEEK[i];
        }
        int days = 1;
        for (int i = 1; i < calendar.length; i++) {
            for (int j = 0; j < calendar[0].length; j++){
                if (i == 1 && j < firstDate) { // before the day 1
                    calendar[i][j] = ".";
                } else if (days > getNumberOfDaysInMonth(month, year)) { // after the max day i.e. after 31
                    calendar[i][j] = ".";
                } else {
                    calendar[i][j] = "" + days;
                    days++;
                }
            }
        }
        return calendar;
    }

    public static void main(String[] args) {
//        System.out.println(getFirstDayOfWeekInMonth("September", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("August", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("October", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("November", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("December", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("January", "2019"));
//        System.out.println(getFirstDayOfWeekInMonth("March", "2019"));
        System.out.println(getFirstDayOfWeekInMonth("January", "2000")); // 0
        System.out.println(getFirstDayOfWeekInMonth("January", "2020")); // 4
        System.out.println(getFirstDayOfWeekInMonth("February", "2020")); // 0

//        String[][] output = generateCalendar("February", "2020");
//        for (int i = 0; i < output.length; i++) {
//            for (int j = 0; j < output[0].length; j++) {
//                System.out.print(output[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        String[][] output2 = generateCalendar("February", "2019");
//        for (int i = 0; i < output2.length; i++) {
//            for (int j = 0; j < output2[0].length; j++) {
//                System.out.print(output2[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        String[][] output3 = generateCalendar("September", "2019");
//        for (int i = 0; i < output3.length; i++) {
//            for (int j = 0; j < output3[0].length; j++) {
//                System.out.print(output3[i][j] + "  ");
//            }
//            System.out.println();
//        }
    }
}