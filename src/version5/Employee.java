package version5;

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

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();
    }

    public Employee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
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
    public void setEmpName(Name empName) {this.empName = empName;} //assumes a complete class? its vague, can intake a partial name

    public MyDate getBirthDate() { return birthDate;}
    public void setBirthDate(MyDate birthDate) {this.birthDate = birthDate;}

    public MyDate getHireDate() { return hireDate;    }
    public void setHireDate(MyDate hireDate) {  this.hireDate = hireDate;    }

    public void displayEmployee() {

        System.out.printf("%s [ID: %-3s", "Employee", empID);
        System.out.print(" | Name " + empName);
        System.out.print(" | DOB " + birthDate);
        System.out.print(" | Hired " + hireDate);
        System.out.println("]");

    }

    public void display(){displayEmployee();System.out.println();}

    public double computeSalary(int currentMonth) {return 0.0;}

    public double computeSalary() {return computeSalary(-1);}

//    Prints employee ID, name, birth date, and hire date.
    @Override
    public String toString() {return String.format("ID: %-3s | Name: %s | DOB: %s | Hired: %s", empID, empName, birthDate, hireDate);}

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
            Objects.equals(this.hireDate, other.hireDate);
    }

    // 6. ALWAYS override hashCode when you override equals
   @Override
   public int hashCode() {return Objects.hash(empID, empName, birthDate, hireDate);}

    @Override
    public Employee clone() {
        try {
            Employee clonedEmployee = (Employee) super.clone();
            clonedEmployee.empName = (empName == null) ? null : empName.clone();
            clonedEmployee.birthDate = (birthDate == null) ? null : birthDate.clone();
            clonedEmployee.hireDate = (hireDate == null) ? null : hireDate.clone();
            return clonedEmployee;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }
}
