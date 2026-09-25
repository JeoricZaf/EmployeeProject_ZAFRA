/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version3;

/**
 *
 * @author User
 */



public class BasePlusCommissionEmployee extends CommissionEmployee {
    
    
    private double baseSalary;

    BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }
    BasePlusCommissionEmployee(int empID, String firstName, String lastName) {
        super(empID, new Name(firstName, lastName));
        this.baseSalary = 0;
    }
    BasePlusCommissionEmployee(int empID, String firstName, String middleName, String lastName, MyDate birthDate, MyDate hireDate, double totalSale, double baseSalary) {
        super(empID, new Name(firstName, middleName, lastName), birthDate, hireDate, totalSale);
        this.baseSalary = baseSalary;
    }




    public int getEmpID() {
        return this.empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    

    public Name getEmpName() {
        return this.empName;
    }
    public void setEmpName(String firstName, String middleName, String lastName) {
        this.empName.setFirstName(firstName);
        this.empName.setMiddleName(middleName);
        this.empName.setLastName(lastName);
    }

    public double getTotalSale() {
        return totalSale;
    }
    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
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
    
    public void displayBasePlusCommissionEmployee() {
        
        System.out.printf("%-45s", "Employee Type: BasePlusCommissionEmployee ");
        System.out.print("| ID: "+ this.empID);
        System.out.print("| Name: "+ this.empName);
        System.out.print("| Total Sale: "+ this.totalSale);
        System.out.println("| Base Salary: "+ this.baseSalary);
    }
    
    
    @Override
        public String toString() {
            return "Employee Type: BasePlusCommissionEmployee " + 
                   "| ID: " + this.empID +
                   "| Name: " + this.empName +
                   "| Base Salary: " + this.baseSalary +
                   "| Total Sales: " + this.totalSale +
                   "| Commission Rate: " + this.commissionRate +
                   "| Total Base Plus Commission: " + this.computeSalary();
            
        }
    
}

