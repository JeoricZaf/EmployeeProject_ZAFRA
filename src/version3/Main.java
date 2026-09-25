package version3;

public class Main {

    public static void main(String[] args) {
        Employee Em = new Employee();
        HourlyEmployee Em2 = new HourlyEmployee();
        PieceWorkerEmployee Em3 = new PieceWorkerEmployee();
        CommissionEmployee Em4 = new CommissionEmployee();
        BasePlusCommissionEmployee Em5 = new BasePlusCommissionEmployee();


        Em.displayEmployee();
        Em2.displayHourlyEmployee();
        Em3.displayPieceWorkerEmployee();
        Em4.displayCommissionEmployee();
        Em5.displayBasePlusCommissionEmployee();

    }

}
