/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

import java.lang.Math;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    
    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    
    public double computeSalary() {
//        
//        Base pay: totalPiecesFinished * ratePerPiece.
    //Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to 10 * ratePerPiece.
    //Bonus pieces factor: floor(totalPiecesFinished / 100) * (10 * ratePerPiece).
    //Total Salary = Base Pay + Bonus Pay. 
        
        double BasePay = this.totalPiecesFinished * this.ratePerPiece;
        
        double BonusPay = Math.floor(this.totalPiecesFinished / 100) * (this.ratePerPiece * 10);
        
        return BasePay + BonusPay;

    }
    
    public void displayBasePlusCommissionEmployee() {
        
        System.out.printf("%-44s","Employee Type: PieceWorkerEmployee");
        System.out.printf(" | ID: %-3s",this.empID);
        System.out.print(" | Name: "+ this.empName);
        System.out.print(" | Total Sale: "+ this.totalPiecesFinished);
        System.out.println(" | Base Salary: "+ this.ratePerPiece);
    }
    
    
    @Override
        public String toString() {
            return 
                    String.format("%-44s", "Employee Type: PieceWorkerEmployee") +
                    String.format(" | ID: %-3s", this.empID) +
                   " | Name: " + this.empName +
                   " | Total Pieces Finished: " + this.totalPiecesFinished+
                   " | Rate Per Piece: " + this.ratePerPiece +
                   " | Total Salary: " + this.computeSalary();
            
        }
    
    
    
}
//
//Class 2: PieceWorkerEmployee
//Attributes (Private)
//    empID: int
//    empName: String
//    totalPiecesFinished: int
//    ratePerPiece: double
//Constructors
//    Default-like Constructor: PieceWorkerEmployee() — defaults numeric values to 0 and string to "N/A".
//    Partial Constructor: PieceWorkerEmployee(int empID, String empName) — initializes ID and name, leaves piece counts at 0.
//    Full Constructor: PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) — initializes all fields.
//Methods
//    Getters and Setters: Complete set for all 4 attributes.
//    computeSalary(): double
//        Base pay: $\text{totalPiecesFinished} \times \text{ratePerPiece}$.
//        Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to $10 \times \text{ratePerPiece}$.
//        Bonus pieces factor: $\lfloor \frac{\text{totalPiecesFinished}}{100} \rfloor \times (10 \times \text{ratePerPiece})$.
//        Total Salary = Base Pay + Bonus Pay.
//    displayPieceWorkerEmployee(): void
//        Prints empID, empName, totalPiecesFinished, and ratePerPiece.
//    toString(): String (Overridden) 
//        Returns formatted string of all details including computeSalary().
