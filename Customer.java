package customer.loan.accounts;
import java.util.ArrayList;

public class Customer{
    private String firstName;
    private String lastName;
    private String SSN;
    
    ArrayList<LoanAccount> loanAccounts = new ArrayList<>();

    public Customer(String firstName, String lastName, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
    
    public void addLoanAccount(LoanAccount account) {
        loanAccounts.add(account);
    }
    
    public void printMonthlyReport() {
        System.out.printf("%s: %s %s %s%s%n%n", "Account Report for Customer", 
                this.firstName, this.lastName, "with SSN ", this.SSN);
        
        
        for (LoanAccount loan:loanAccounts) {
            System.out.println(loan);
        }
    } 
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }
}
