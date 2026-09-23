package version3;

import java.util.Objects;

/*
Now implements inheritanace, super() constructor chaining,

all 4 employee subclasses should inherit properties from employee superclass
employee superclass should include name and mydate classes

format all monetary values to %.2f

 */

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;
    private double Salary;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }
    public Employee(int empID, Name empName, MyDate birthDate, MyDate hireDate) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    public int getEmpID() {return empID;}
    public void setEmpID(int empID) { this.empID = empID;}

    public Name getEmpName() {return empName;  }
    public void setEmpName(Name empName) {this.empName = empName;}

    public MyDate getBirthDate() { return birthDate;}
    public void setBirthDate(MyDate birthDate) {this.birthDate = birthDate;}

    public MyDate getHireDate() { return hireDate;    }
    public void setHireDate(MyDate hireDate) {  this.hireDate = hireDate;    }


    public double ComputeSalary(int currentMonth) {

        //        Standard working threshold: 5 days * 8 hours/day = 40 regular hours.
//        Hours <= 40: Salary = totalHoursWorked * ratePerHour.
//        Hours > 40: Regular Pay = 40 * ratePerHour;
//        Overtime Pay = (totalHoursWorked - 40) * (ratePerHour * 1.5).
//        Total Salary = Regular Pay + Overtime Pay.

        double salary = 500;


        // if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            salary += 5000;

        }

        return salary;

    }

    public double ComputeSalary() {//Overloaded version without bday
        return this.ComputeSalary(-1);
    }








//    Prints employee ID, name, birth date, and hire date.
    @Override
    public String toString() {
        return String.format("Employee: [") +
                "ID: " + this.empID +
                "ID: " + this.empID +
                "ID: " + this.empID +
                "ID: " + this.empID +




                ;
    }

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;

        // Null & Type check: Guard against null and ensure exact class match
        else if (preTest == null || getClass() != preTest.getClass()) {
            return false;
        }

        // 4. Typecast the object after successful type check
        Employee other = (Employee) preTest;

        // 5. Compare significant fields (use Objects.equals for objects to avoid NullPointerExceptions)
        if  (   this.empID == other.empID &&
                this.empName.getFullName() == other.empName.getFullName() &&
                this.empID == other.empID &&
                this.empID == other.empID

        ) {

        }
    }

    // 6. ALWAYS override hashCode when you override equals
//    @Override
//    public int hashCode() {
//        return super.hash(name, age);
//    }


    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }
}


public class HourlyEmployee extends Employee {

    public HourlyEmployee() {

    }


    @Override
    public String toString() {
        return String.format("");
    }

}
