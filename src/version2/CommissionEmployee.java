/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    private double totalSale;
    private double CommissionRate;


    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name("No_Name");
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();

        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String fName, String lName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(fName, lName); ;
        this.hireDate = new MyDate(day, month, year);

    }

    public CommissionEmployee(int empID, String fName, String lName, String mName, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear, double totalSale) {
        this.empID = empID;
        this.empName = new Name(fName, mName, lName);
        this.birthDate = new MyDate(bday, bmonth, byear);
        this.hireDate = new MyDate(Hireday, Hiremonth, Hireyear);
        
        this.totalSale = totalSale;
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


    public double getTotalSale() {return totalSale; }
    public void setTotalSale(double totalSale) {this.totalSale = totalSale;}




    
    public double computeSalary() {
//        Below PHP 50,000: 5% commission (0.05 * totalSale)
//        PHP 50,000 to below PHP 100,000: 10% commission (0.10 * totalSale)
//        PHP 100,000 to below PHP 500,000: 15% commission (0.15 * totalSale)
//        PHP 500,000 and above: 20% commission (0.20 * totalSale)

        double Salary = 0;
        
        if (this.totalSale < 50_000) {
            //5% commission
            this.CommissionRate = 0.05;
        }
        else if (this.totalSale >= 50_000 && this.totalSale < 100_000) {
            //10% commission
            this.CommissionRate = 0.10;
        }
        else if (this.totalSale >= 100_000 && this.totalSale < 500_000) {
            //15% commission
            this.CommissionRate = 0.15;
        }
        else if (this.totalSale >= 500_000) {
            //20% commission
            this.CommissionRate = 0.20;
            
        }
        else {System.out.println("Something went wrong"); return -1;}
            
        Salary = this.CommissionRate * this.totalSale;
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

    
    public void displayCommissionEmployee() {
        
        System.out.printf("ID: %-3s",this.empID);
        System.out.print(" | Name: "+ this.empName);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | Birthday: "); this.birthDate.display();
        System.out.print(" | Total Sale: "+ this.totalSale);
        System.out.print(" | Computed Salary: " + this.computeSalary() );
        System.out.print(" | BirthMonth Salary: " + this.computeSalary(this.birthDate.getMonth()) );
    }
    
    
    @Override
        public String toString() {
            return 
                    String.format("%-28s", "CommissionEmployee") +
                    String.format(" [ID: %-3s", this.empID) +
                   ", Name: " + this.empName +
                   ", Total Sale: " + this.totalSale +
                   ", Commission Pay: " + this.computeSalary()+
                    "]";
            
        }
    


}
