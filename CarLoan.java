package customer.loan.accounts;

public class CarLoan extends LoanAccount {
    private String vehicleVIN;

    public CarLoan(double principal, double annualInterestRate, int months, String vehicleVIN) {
        super(principal, annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;
    }
    
    @Override
    public String toString(){
        return String.format("%s%n%s $%.2f%n%s %.2f%%%n%s %d%n%s $%.2f%n%s %s%n%n", "Car Loan with:", "Principal:", super.getPrinciple(),
                "Annual Interest Rate:", super.getAnnualInterestRate(), "Term of Loan in Months:", super.getMonths(),
                "Monthly Payment:", super.calculateMonthlyPayment(super.getMonths()), "Vehicle VIN:", this.vehicleVIN);
    }
}
