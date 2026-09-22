package version2;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private String monthName;

    public MyDate() {
        this.day = 1; //default date if none given
        this.month = 1;
        this.year = 2026;

        monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }


    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


    public String getMonthName() {
        return monthName;
    }




    public void display() {

        System.out.printf("Date: %s %d, %d", this.monthName, this.day, this.year);
    }



    @Override
    public String toString() {
        return String.format("%s %d, %d", this.monthName, this.day, this.year);
    }

}
