package customer.loan.accounts;

public class PrimaryMortgage extends LoanAccount{
    private double PMIMonthlyAmount;
    private Address Address;

    public PrimaryMortgage(double principal, double annualInterestRate, int months, double PMIMonthlyAmount, Address Address) {
        super(principal, annualInterestRate, months);
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        this.Address = Address;
    }
    
    @Override
    public String toString() {
        return String.format("%s%n%s $%.2f%n%s %.2f%%%n%s %d%n%s $%.2f%n%s $%.2f%n%s%n%n", "Primary Mortgage Loan with:", "Principal:", super.getPrinciple(),
                "Annual Interest Rate:", super.getAnnualInterestRate(), "Term of Loan in Months:", super.getMonths(),
                "Monthly Payment:", super.calculateMonthlyPayment(super.getMonths()), "PMI Monthly Amount:", this.PMIMonthlyAmount, this.Address.toString());
    }
}
