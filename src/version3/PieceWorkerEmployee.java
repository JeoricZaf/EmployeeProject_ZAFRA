
package version3;

import java.util.Objects;

/**
 * This class represents a piece worker employee.
 *
 * @author User
 */
public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    
    public PieceWorkerEmployee(int empID, Name empName) {
        super(empID, empName, new MyDate(), new MyDate());

        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    public PieceWorkerEmployee(int empID, Name empName, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, new MyDate(), new MyDate());

        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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
    
    @Override
    public double computeSalary(int currentMonth) {
       
        double BdayBonus = (currentMonth == this.getBirthDate().getMonth()) ? 5000 : 0;


//        Base pay: totalPiecesFinished * ratePerPiece.
    //Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to 10 * ratePerPiece.
    //Bonus pieces factor: floor(totalPiecesFinished / 100) * (10 * ratePerPiece).
    //Total Salary = Base Pay + Bonus Pay. 
        
        double BasePay = this.totalPiecesFinished * this.ratePerPiece;
        
        double BonusPay = Math.floor(this.totalPiecesFinished / 100) * (this.ratePerPiece * 10);
        
        return BasePay + BonusPay + BdayBonus;

    }
    
    public void displayPieceWorkerEmployee() {
        System.out.printf("%-28s [", "PieceWorkerEmployee");
        System.out.printf("%s",super.toString());
        System.out.printf(" | Pieces Finished: %d", this.totalPiecesFinished);
        System.out.printf(" | Rate/Piece: ₱%.2f", this.ratePerPiece);
        System.out.printf(" | Total Salary: ₱%.2f", this.computeSalary());
        System.out.printf(" | BirthMonth Salary: %.2f", this.computeSalary(getBirthDate().getMonth()) );
        System.out.println("]");
    }   
    
    
    @Override
        public String toString() {
            return 
                    String.format("%s", super.toString() ) +
                   " | Pieces Finished: " + this.totalPiecesFinished +
                   " | Rate/Piece: ₱" + this.ratePerPiece;
            
        }
    
     @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;

        // Null & Type check: Guard against null and ensure exact class match
        else if (preTest == null || getClass() != preTest.getClass()) {
            return false;
        }

        // 4. Typecast the object after successful type check
        PieceWorkerEmployee other = (PieceWorkerEmployee) preTest;

        // 5. Compare other fields
        if  ( super.equals(other) &&
              this.totalPiecesFinished == other.totalPiecesFinished &&
                this.ratePerPiece == other.ratePerPiece
                    //can implement full comparison later
            ) 
            {return true;}

        else return false;
    }

   @Override
   public int hashCode() {
       return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
   }

   
   @Override
   public PieceWorkerEmployee clone() {
    
            return (PieceWorkerEmployee) super.clone();
        
        
   }
    
}
