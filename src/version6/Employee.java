package version6;

import java.util.Objects;

/*
Now implements inheritanace, super() constructor chaining,

all 4 employee subclasses should inherit properties from employee superclass
employee superclass should include name and mydate classes

format all monetary values to %.2f

 */

public abstract class Employee implements Cloneable {

    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName) {
        this.empID = empID;
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate hireDate) {
        this.empID = empID;
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (hireDate == null) throw new NullPointerException("Hire date cannot be null");
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = hireDate.clone();
    }

    public final int getEmpID() {return empID;}

    public Name getEmpName() {return empName.clone();  }
    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() { return birthDate.clone();}
    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() { return dateHired.clone(); }
    public MyDate getHireDate() { return getDateHired(); }
    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Hire date cannot be null");
        this.dateHired = dateHired.clone();
    }
    public void setHireDate(MyDate hireDate) { setDateHired(hireDate); }

    public void display(){displayEmployee();System.out.println();}

    public final double getBirthdayBonus(int currentMonth) {
        return birthDate.getMonth() == currentMonth ? 5000 : 0;
    }

    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

//    Prints employee ID, name, birth date, and hire date.
    @Override
    public String toString() {return String.format("ID: %-3s | Name: %s | DOB: %s | Hired: %s", empID, empName, birthDate, dateHired);}

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;

        // Null & Type check: Guard against null and ensure exact class match
        else if (preTest == null || getClass() != preTest.getClass()) {
            return false;
        }

        // 4. Typecast the object after successful type check
        Employee other = (Employee) preTest;

        // 5. Compare other fields
        return this.empID == other.empID &&
            Objects.equals(this.empName, other.empName) &&
            Objects.equals(this.birthDate, other.birthDate) &&
            Objects.equals(this.dateHired, other.dateHired);
    }

    // 6. ALWAYS override hashCode when you override equals
   @Override
    public int hashCode() {return Objects.hash(empID, empName, birthDate, dateHired);}

    @Override
    public Employee clone() {
        try {
            Employee clonedEmployee = (Employee) super.clone();
            clonedEmployee.empName = (empName == null) ? null : empName.clone();
            clonedEmployee.birthDate = (birthDate == null) ? null : birthDate.clone();
            clonedEmployee.dateHired = (dateHired == null) ? null : dateHired.clone();
            return clonedEmployee;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }
}
