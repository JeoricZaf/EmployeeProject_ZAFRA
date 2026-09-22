/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 * Base Version
 * 
 * Learn the basics of java, tostring, override
 *
 * @author User
 */
public class HourlyEmployee {
    
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
        
    }
    
    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }
    
      public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {return empID;}
    public void setEmpID(int empID) {this.empID = empID;}

    public String getEmpName() {return empName;}
    public void setEmpName(String empName) {this.empName = empName;}

    public float getTotalHoursWorked() {return totalHoursWorked;}
    public void setTotalHoursWorked(float totalHoursWorked) {this.totalHoursWorked = totalHoursWorked;}

    public double getRatePerHour() {return ratePerHour;}
    public void setRatePerHour(double ratePerHour) {this.ratePerHour = ratePerHour; }
     
    
    public double ComputeSalary() {
//        Standard working threshold: 5 days * 8 hours/day = 40 regular hours.
//        Hours <= 40: Salary = totalHoursWorked * ratePerHour.
//        Hours > 40: Regular Pay = 40 * ratePerHour; 
//        Overtime Pay = (totalHoursWorked - 40) * (ratePerHour * 1.5).
//        Total Salary = Regular Pay + Overtime Pay.
                
        double salary = 0;
        
        if (this.totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        }
        else if (this.totalHoursWorked > 40) { //40 hours pay + overtime pay
            salary = (40 * this.ratePerHour) +  ( (this.totalHoursWorked - 40) * (this.ratePerHour * 1.5) );
        }
        
        else {System.out.println("Something went wrong");}
                
         return salary;
        
    }
    
    public void displayHourlyEmployee(){
        
        System.out.printf("ID: %-3s",this.empID);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | Hours: " + this.totalHoursWorked);
        System.out.print(" | Rate/Hour: ₱" +  this.ratePerHour);
        System.out.println(" | Computed Salary: " + this.ComputeSalary() );
                
        
    }
    
    @Override
    public String toString() {
        return   
                String.format("%-28s", "HourlyEmployee") +
                String.format(" [ID: %-3s", this.empID) +
                ", Name: " +                       this.empName +
                ", Hours: " +       this.totalHoursWorked +
                ", Rate: " +          this.ratePerHour +
                ", Total Salary: " +        this.ComputeSalary() +
                " ]"
                ;
    }
    
}

