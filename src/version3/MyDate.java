package version3;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private String monthName;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2026;
    }

    public MyDate(int day, int month, int year) {
        //
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




    public void display() {

        System.out.printf("%s %d, %d\n", this.monthName, this.day, this.year);
    }




    @Override
    public String toString() {
        return "Date: " + this.day + " " + this.monthName + " " + this.year;
    }

}

//for version 3 override equals, hashCode, and clone.
