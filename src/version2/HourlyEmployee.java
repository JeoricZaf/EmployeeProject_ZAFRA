/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */

/*

if current month is birthmonth, add 5000 salary

name should be a class instead of a string
    firstname
    lastname
    middle

myDate
    int date
    int month
    int year

dateHired
birthDate;

//apply to all employee types
 */

public class HourlyEmployee {
    
    private int empID;
    private Name empName;
        //change this to a class
    private float totalHoursWorked;
    private double ratePerHour;

    private MyDate birthDate;
    private MyDate dateHired;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;

        this.birthDate = new MyDate();
        this.dateHired = new MyDate();

    }

    public HourlyEmployee(int empID, String fName, String lName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(fName, lName); ;

        this.dateHired = new MyDate(day, month, year);

    }
    
      public HourlyEmployee(int empID, String fName, String lName, String mName, float totalHoursWorked, double ratePerHour, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear) {
        this.empID = empID;
        this.empName = new Name(fName, lName, mName);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;

        this.birthDate = new MyDate(bday, bmonth, byear);
          this.dateHired = new MyDate(Hireday, Hiremonth, Hireyear);
    }

    public int getEmpID() {return empID;}
    public void setEmpID(int empID) {this.empID = empID;}

    public Name getEmpName() {return empName;}
    public void setEmpName(Name empName) {this.empName = empName;}

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
    //all should have 2 compute salary functions. 2nd one is bday bonus pay
    public double ComputeSalary(int currentMonth) {

        double base_salary = this.ComputeSalary();


//        if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            base_salary += 5000;

        }

    return base_salary;
    }


    
    public void displayHourlyEmployee(){
        
        System.out.printf("%-44s","Employee Type: HourlyEmployee");
        System.out.print(" | ID: " + this.empID);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | Hours Worked: " + this.totalHoursWorked);
        System.out.print(" | Rate per Hour: " +  this.ratePerHour);
        System.out.println(" | Computed Salary: " + this.ComputeSalary() );
                
        
    }
    
    @Override
    public String toString() {
        return
                "Employee Type: HourlyEmployee " +
                " | ID: "+                this.empID + 
                " | Name: " +            this.empName +
                " | Hours Worked: " +    this.totalHoursWorked +
                " | Rate per Hour: " +     this.ratePerHour +
                " | Computed Salary: " +    this.ComputeSalary();
    }
    
}

