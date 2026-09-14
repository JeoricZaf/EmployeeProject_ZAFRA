package version2;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2026;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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
        System.out.printf("%d-%d-%d\n", this.day, this.month, this.year);
    }

    @Override
    public String toString() {
        return "Date: " + this.day + " " + this.month + " " + this.year;
    }

}
