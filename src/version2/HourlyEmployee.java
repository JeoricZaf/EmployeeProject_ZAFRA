/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 * 
 * 
 *
 * @author User
 */

/*

Version 2 should show Composition - instantiating classes within other classes


if current month is birthmonth, add 5000 salary (Changes computeSalary function)
    add vars
        dateHired
        birthDate;

name should be a class instead of a string
    firstname
    lastname
    middle

myDate should be a class
    int date
    int month
    int year


//apply to all employee types


 */

public class HourlyEmployee {
    
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    private float totalHoursWorked;
    private double ratePerHour;

    

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name("No_Name");
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();
        
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;

    }

    public HourlyEmployee(int empID, String fName, String lName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(fName, lName); ;
        this.hireDate = new MyDate(day, month, year);


    }
    
      public HourlyEmployee(int empID, String fName, String lName, String mName, float totalHoursWorked, double ratePerHour, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear) {
        this.empID = empID;
        this.empName = new Name(fName, mName, lName );
        this.birthDate = new MyDate(bday, bmonth, byear);
        this.hireDate = new MyDate(Hireday, Hiremonth, Hireyear);
        
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }



    public int getEmpID() {return empID;}
    public void setEmpID(int empID) {this.empID = empID;}

    public Name getEmpName() {return empName;}
    public void setEmpName(String firstName, String middleName, String lastName) {
        this.empName.setFirstName(firstName);
        this.empName.setMiddleName(middleName);
        this.empName.setLastName(lastName);
    }

    public MyDate getBirthDate() {return this.birthDate;}
    public void setBirthDate(int day, int month, int year) {
        this.birthDate.setDay(day) ; 
        this.birthDate.setMonth(month); 
        this.birthDate.setYear(year); 
    }

    public MyDate getHireDate() {return this.hireDate;}
    public void setHireDate(int day, int month, int year) {
        this.hireDate.setDay(day) ; 
        this.hireDate.setMonth(month); 
        this.hireDate.setYear(year);  
        
    }

    public float getTotalHoursWorked() {return totalHoursWorked;}
    public void setTotalHoursWorked(float totalHoursWorked) {this.totalHoursWorked = totalHoursWorked;}

    public double getRatePerHour() {return ratePerHour;}
    public void setRatePerHour(double ratePerHour) {this.ratePerHour = ratePerHour; }

    


    
    public double computeSalary() {
//        Standard working threshold: 5 days * 8 hours/day = 40 regular hours.
//        Hours <= 40: Salary = totalHoursWorked * ratePerHour.
//        Hours > 40: Regular Pay = 40 * ratePerHour; 
//        Overtime Pay = (totalHoursWorked - 40) * (ratePerHour * 1.5).
//        Total Salary = Regular Pay + Overtime Pay.
                
        double salary = 0;
        double OvertimeRate = this.ratePerHour * 1.5;
        
        if (this.totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        }
        else if (this.totalHoursWorked > 40) { //40 hours pay + overtime pay
            double OverTimeHours = this.totalHoursWorked - 40;

            salary = (40 * this.ratePerHour) + ( OverTimeHours * OvertimeRate);
        }
        
        else {System.out.println("Something went wrong");return -1;} 
                
        return salary;
        
    }

    //all employees will now have 2 compute salary functions thru overloading. 2nd one is bday bonus pay
    public double computeSalary(int currentMonth) {

        double new_salary = this.computeSalary();

        //if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            new_salary += 5000;
        }

    return new_salary;
    }


    
    public void displayHourlyEmployee(){
        
        System.out.printf("%-3s","Employee Type: HourlyEmployee");
        System.out.printf(" | ID: %-3s",this.empID);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | Birthday: " + this.birthDate); 
        System.out.print(" | Hours Worked: " + this.totalHoursWorked);
        System.out.print(" | Rate per Hour: " +  this.ratePerHour);
        System.out.println(" | Computed Salary: " + this.computeSalary() );
        System.out.println(" | BirthMonth Salary: " + this.computeSalary(this.birthDate.getMonth()) );
                
        
    }
    
    @Override
    public String toString() {
        return   
                String.format("%-44s", "Employee Type: HourlyEmployee") +
                String.format(" | ID: %-3s", this.empID) +
                " | Name: " +                       this.empName +
                " | Hours Worked: " +       this.totalHoursWorked +
                " | Rate per Hour: " +          this.ratePerHour +
                " | Computed Salary: " +        this.computeSalary();
    }
    
}

