/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    private double totalSale;
    private double baseSalary;
    private double commissionRate;
    
    BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name("No_Name");
        this.totalSale = 0;
        this.baseSalary = 0;

        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();
    }
    BasePlusCommissionEmployee(int empID, String firstName, String lastName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(firstName, lastName);

        this.hireDate = new MyDate(day, month, year);
    }
    BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, double totalSale, double baseSalary, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear) {
        this.empID = empID;
        this.empName = new Name(firstName, middleName, lastName);
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;

        this.birthDate = new MyDate(bday, bmonth, byear);
        this.hireDate = new MyDate(Hireday, Hiremonth, Hireyear);
    }






    public int getEmpID() {return this.empID;}
    public void setEmpID(int empID) {this.empID = empID;}
    
    public Name getEmpName() {return this.empName;}
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


    public double getTotalSale() {return totalSale;}
    public void setTotalSale(double totalSale) {this.totalSale = totalSale;
    }

    public double getBaseSalary() {return baseSalary;}
    public void setBaseSalary(double baseSalary) {this.baseSalary = baseSalary;}
    





    public double computeSalary() {
        
        double Commission = 0;
        
        if (this.totalSale < 50_000) {
            //5% commission
            commissionRate = 0.5;
            Commission = commissionRate * this.totalSale;
        }
        else if (this.totalSale >= 50_000 && this.totalSale < 100_000) {
            //10% commission
            commissionRate = 0.10;
            Commission = commissionRate * this.totalSale;
        }
        else if (this.totalSale >= 100_000 && this.totalSale < 500_000) {
            //15% commission
            commissionRate = 0.15;
            Commission = commissionRate * this.totalSale;
        }
        else if (this.totalSale >= 500_000) {
            //20% commission
            commissionRate = 0.20;
            Commission = commissionRate * this.totalSale;
        }
        else {System.out.println("Something went wrong");}
            
         
        double Salary = this.baseSalary + Commission;
        
        return Salary;
    }

    public double computeSalary(int currentMonth) {

        double new_salary = this.computeSalary();

        //if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            new_salary += 5000;
        }

        return new_salary;
    }

    
    public void displayBasePlusCommissionEmployee() {
        
        System.out.printf("ID: %-3s",this.empID);
        System.out.print(" | Name: "+ this.empName);
        System.out.print(" | Total Sale: "+ this.totalSale);
        System.out.println(" | Base Salary: "+ this.baseSalary);
        System.out.print(" | Commission Rate: "+ this.commissionRate);
        System.out.println(" | Total Salary: "+ this.computeSalary() );
    }


    @Override
    public String toString() {
        return 
                String.format("%-28s", "BasePlusCommissionEmployee") +
                String.format(" [ID: %-3s", this.empID) +
                ", Name: " + this.empName +
                ", Total Sales: " + this.totalSale +
                ", Commission Rate: " + this.commissionRate +
                ", Base Salary: " + this.baseSalary +
                ", Total Base Plus Commission: " + this.computeSalary() +
                " ]";
        
    }

        
    
    
    
    
}

