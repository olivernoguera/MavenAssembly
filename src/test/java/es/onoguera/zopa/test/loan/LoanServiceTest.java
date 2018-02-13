package es.onoguera.zopa.test.loan;

import es.onoguera.zopa.test.lenders.CSVLenders;
import es.onoguera.zopa.test.utils.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LoanServiceTest {

    private LoanService loanService = new LoanService();

    @Test(expected = IllegalArgumentException.class)
    public void calculateNullLoan() throws IOException {
        loanService.calculateLoan(new CSVLenders(getRelativePath("market.csv")), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateNullCSVLenders() throws IOException {
        loanService.calculateLoan(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithoutRequestAmount() throws IOException {
        loanService.calculateLoan(new CSVLenders(getRelativePath("market.csv")), new Loan());
    }

    @Test
    public void calculateWithPreconditions() throws IOException {
        Loan loan = new Loan();
        loan.setRequestAmount(1000);
        loanService.calculateLoan(new CSVLenders(getRelativePath("market.csv")), loan);
        Assert.assertEquals("calculateWithPreconditions::Estimated rate ",
                NumberUtils.round(0.07, 2),
                NumberUtils.round(loan.getRate(), 2));
    }

    private String getRelativePath(String file) {
        return "src/test/resources/" + file;
    }

    @Test(expected = IllegalArgumentException.class)
    public void printeNullLoan() {
        loanService.printLoan(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printNullRate() {
        Loan loan = new Loan(1000, null, 20.0, 100.5);
        loanService.printLoan(loan);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printNullMonthlyRepayment() {
        Loan loan = new Loan(1000, 1.0, null, 100.5);
        loanService.printLoan(loan);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printNullTotalRepayment() {
        Loan loan = new Loan(1000, 1.0, 20.0, null);
        loanService.printLoan(loan);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printNullRequestAmount() {
        Loan loan = new Loan(null, 1.0, 20.0, 100.5);
        loanService.printLoan(loan);
    }

    @Test
    public void printGoodLoan() {
        Loan loan = new Loan(1000, 1.0, 20.0, 100.5);
        loanService.printLoan(loan);
    }
}
