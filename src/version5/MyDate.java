package version5;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private String monthName;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2026;

        monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    public MyDate(int day, int month, int year) {
        //
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date inputted");
        }
        this.day = day;
        this.month = month;
        this.year = year;

        monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    public void setFullDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date inputted");
        }

        this.day = day;
        this.month = month;
        this.year = year;

        monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

    public int getDay() {return day;}
    public void setDay(int day) {
        //validate day input
        if (isValidDate(day, this.month, this.year)) {
            this.day = day;
        }
        else System.out.println("Invalid day inputted");

    }

    public int getMonth() {return month;}
    public void setMonth(int month) {
        if (isValidDate(this.day, month, this.year)) {
            this.month = month;
            this.monthName = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        }
        else System.out.println("Invalid Month Inputted");

    }

    public int getYear() {return year;}
    public void setYear(int year) {
        if (isValidDate(this.day, this.month, year)) {
            this.year = year;
        }
        else System.out.println("Invalid Year Inputted");
    }

    public String getMonthName() {return monthName;}

    private boolean isValidDay(int day) {return 1 <= day && day <= 31;}
    private boolean isValidMonth(int month) {return 1 <= month && month <= 12;}
    private boolean isValidYear(int year) {return year >= 1;}

    private boolean isValidDate(int day, int month, int year) {
        if (!isValidDay(day) || !isValidMonth(month) || !isValidYear(year)) {
            return false;
        }
        return day <= Month.of(month).length(java.time.Year.isLeap(year));
    }

    public void display() {

        System.out.printf("%02d %s %d\n", day, monthName , year);
    }

    @Override
    public String toString() {return String.format("%02d %s %d", day, monthName, year);}

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;

        // Null & Type check: Guard against null and ensure exact class match
        else if (preTest == null || getClass() != preTest.getClass()) {
            return false;
        }

        // 4. Typecast the object after successful type check
        MyDate other = (MyDate) preTest;

        // 5. Compare other fields
        if  ( this.day == other.day &&
                this.month == other.month &&
                this.year == other.year
            )
            {return true;}

        else return false;
    }

    // 6. ALWAYS override hashCode when you override equals
   @Override
   public int hashCode() {return Objects.hash(day, month, year);}

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }
}
