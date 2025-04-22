package customer.loan.accounts;


public class LoanAccount {
    private double principal;
    private double annualInterestRate;
    private int months;

    public LoanAccount(double principal, double annualInterestRate, int months) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
    public double calculateMonthlyPayment(int numberOfPayments) {
        double monthlyInterest = this.annualInterestRate / 12 / 100;
        double monthlyPayment = this.principal * ( monthlyInterest / (1 - Math.pow(1 + monthlyInterest, - numberOfPayments)));
        return monthlyPayment;
    }
    
    @Override
    public String toString() {
        return String.format("%s $%.2f%n%s %.2f%n%s %d", "Principal:", this.principal, "Annual Interest Rate:", this.annualInterestRate,
                "Term of Loan in Months:", this.months);
    }
    
    public double getPrinciple() {
        return principal;
    }

    public int getMonths() {
        return months;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}