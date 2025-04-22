package customer.loan.accounts;

public class UnsecuredLoan extends LoanAccount{
    
    public UnsecuredLoan(double principal, double annualInterestRate, int months) {
        super(principal, annualInterestRate, months);
    }
    
    @Override
    public String toString() {
        return String.format("%s%n%s $%.2f%n%s %.2f%%%n%s %d%n%s $%.2f%n%n", "Unsecured Loan with:", "Principal:", super.getPrinciple(), 
            "Annual Interest Rate:", super.getAnnualInterestRate(), "Term of Loan in Months:", super.getMonths(),
            "Monthly Payment:", super.calculateMonthlyPayment(super.getMonths()));
    }
}
