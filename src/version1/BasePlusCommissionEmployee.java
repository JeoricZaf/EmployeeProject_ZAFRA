/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;
    private double commissionRate;
    
    BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
        this.baseSalary = 0;
    }
    BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
    }
    BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }
    //asdasd
    public int getEmpID() {
        return this.empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    

    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
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

