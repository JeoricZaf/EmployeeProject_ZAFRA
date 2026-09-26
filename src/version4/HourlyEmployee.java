package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked; 
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;

    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, hireDate);

        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;

    }


    public float getTotalHoursWorked() {return totalHoursWorked;}
    public void setTotalHoursWorked(float totalHoursWorked) {this.totalHoursWorked = totalHoursWorked;}

    public double getRatePerHour() {return ratePerHour;}
    public void setRatePerHour(double ratePerHour) {this.ratePerHour = ratePerHour; }

    
    public void displayHourlyEmployee() {
        
        System.out.printf("%s","HourlyEmployee");
        System.out.printf(" [%s: ", super.toString());
        System.out.print(" | Hours: " + getTotalHoursWorked());
        System.out.print(" | Rate/Hour: ₱" +  getRatePerHour());
        System.out.print(" | Computed Salary: ₱" + this.computeSalary() );
        System.out.print(" | BirthMonth Salary: ₱" + this.computeSalary(getBirthDate().getMonth()) );
        System.out.println(" ]");
    }

    @Override 
    public void display(){displayHourlyEmployee();System.out.println();}

    @Override
    public String toString() {
        return
                String.format(" [ID: %-3s", getEmpID()) +
                " | Name: " +  getEmpName() +
                " | DOB: " +   getBirthDate() +
                " | Hired: " + getHireDate() +
                " | Hours: " + getTotalHoursWorked() +
                " |  Rate: ₱" + getRatePerHour()
               
                ;
    }

    @Override 
    public double computeSalary(int currentMonth) {
        double salary = 0  ;
        double bonus = (this.getBirthDate().getMonth() == currentMonth) ? 5000 : 0;

        
        if (this.totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        }
        else if (this.totalHoursWorked > 40) { //40 hours pay + overtime pay
            salary = (40 * this.ratePerHour) +  ( (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5) );
        }
        
        else {System.out.println("Something went wrong");}
                
        return salary + bonus;

    }

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;
        if (preTest == null || getClass() != preTest.getClass()) return false;

        HourlyEmployee other = (HourlyEmployee) preTest;
        return super.equals(other)
                && Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }

}
