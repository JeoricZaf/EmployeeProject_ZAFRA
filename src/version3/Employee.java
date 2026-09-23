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

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }


    @Override
    public String toString() {
        return String.format("a");
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

    HourlyEmployee()


    @Override
    public String toSTring() {
        return String.format();
    }

}
