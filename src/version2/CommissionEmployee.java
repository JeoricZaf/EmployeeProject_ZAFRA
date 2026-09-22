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
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;

    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
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
    
    public double computeSalary() {
//        Below PHP 50,000: 5% commission (0.05 * totalSale)
//        PHP 50,000 to below PHP 100,000: 10% commission (0.10 * totalSale)
//        PHP 100,000 to below PHP 500,000: 15% commission (0.15 * totalSale)
//        PHP 500,000 and above: 20% commission (0.20 * totalSale)

        
        double Commission = 0;
        
        if (this.totalSale < 50_000) {
            //5% commission
            Commission = 0.05 * this.totalSale;
        }
        else if (this.totalSale >= 50_000 && this.totalSale < 100_000) {
            //10% commission
            Commission = 0.10 * this.totalSale;
        }
        else if (this.totalSale >= 100_000 && this.totalSale < 500_000) {
            //15% commission
            Commission = 0.15 * this.totalSale;
        }
        else if (this.totalSale >= 500_000) {
            //20% commission
            Commission = 0.20 * this.totalSale;
        }
        else {System.out.println("Something went wrong");}
            
         
        return Commission;
        
    }
    
    public void displayCommissionEmployee() {
        
        System.out.printf("%-44s","Employee Type: CommissionEmployee");
        System.out.printf(" | ID: %-3s",this.empID);
        System.out.print(" | Name: "+ this.empName);
        System.out.println(" | Total Sale: "+ this.totalSale);
    }
    
    
    @Override
        public String toString() {
            return 
                    String.format("%-44s", "Employee Type: CommissionEmployee") +
                    String.format(" | ID: %-3s", this.empID) +
                   " | Name: " + this.empName +
                   " | Commission Pay: " + this.computeSalary();
            
        }
    


}
