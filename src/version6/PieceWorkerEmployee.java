
package version6;

import java.util.Objects;

/**
 * This class represents a piece worker employee.
 *
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
        validateValues(totalPiecesFinished, ratePerPiece);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {return totalPiecesFinished;}
    public void setTotalPiecesFinished(int totalPiecesFinished) {validateValues(totalPiecesFinished, ratePerPiece); this.totalPiecesFinished = totalPiecesFinished;}

    public double getRatePerPiece() {return ratePerPiece;}
    public void setRatePerPiece(double ratePerPiece) {validateValues(totalPiecesFinished, ratePerPiece); this.ratePerPiece = ratePerPiece;}

    public double computeSalary(int currentMonth) {

        double BdayBonus = getBirthdayBonus(currentMonth);

//        Base pay: totalPiecesFinished * ratePerPiece.
    //Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to 10 * ratePerPiece.
    //Bonus pieces factor: floor(totalPiecesFinished / 100) * (10 * ratePerPiece).
    //Total Salary = Base Pay + Bonus Pay.

        double BasePay = this.totalPiecesFinished * this.ratePerPiece;

        double bonusPay = (totalPiecesFinished / 100) * 10 * ratePerPiece;
        return BasePay + bonusPay + BdayBonus;

    }

    public double computeSalary() {return computeSalary(-1);}

    public void displayPieceWorkerEmployee() {
        System.out.printf("[Piece Worker] ID: %d | Name: %s | Salary: ₱%.2f%n",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public void displayEmployee() {displayPieceWorkerEmployee();}

    @Override
    public void display(){displayPieceWorkerEmployee(); System.out.println();}

    @Override
        public String toString() {
                return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                    getEmpID(), getEmpName(), computeSalary());

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
   public int hashCode() {return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);}

   @Override
   public PieceWorkerEmployee clone() {return (PieceWorkerEmployee) super.clone();}

    private void validateValues(int pieces, double rate) {
        if (pieces < 0) throw new IllegalArgumentException("Total pieces finished cannot be negative");
        if (rate < 0) throw new IllegalArgumentException("Rate per piece cannot be negative");
    }

}
