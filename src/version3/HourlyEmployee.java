package version3;

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
        
        System.out.printf("ID: %-3s",this.empID);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | DOB: " + this.birthDate); 
        System.out.print(" | Hired: " + this.hireDate); 
        System.out.print(" | Hours: " + this.totalHoursWorked);
        System.out.print(" | Rate/Hour: ₱" +  this.ratePerHour);
        System.out.print(" | Computed Salary: " + this.computeSalary() );
        System.out.println(" | BirthMonth Salary: " + this.computeSalary(this.birthDate.getMonth()) );
            
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
    public String toString() {
        return String.format("HourlyEmployee: %s, Hours: %.2f, Rate/hour: %.2f", displayEmployee();, totalHoursWorked, ratePerHour);
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
