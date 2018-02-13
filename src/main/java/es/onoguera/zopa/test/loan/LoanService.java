package es.onoguera.zopa.test.loan;

import es.onoguera.zopa.test.lenders.CSVLender;
import es.onoguera.zopa.test.lenders.CSVLenders;

import java.util.Objects;

public class LoanService {

    private final static Integer INTEREST_RATE = 36;


    /**
     * calculate Loan fields with result
     *
     * @param csvLenders with markets
     * @param loan       with requestAmount
     * @return
     * @throws IllegalArgumentException if not applies preconditions
     */
    public Loan calculateLoan(CSVLenders csvLenders, Loan loan) throws IllegalArgumentException {

        if (Objects.isNull(csvLenders)) {
            throw new IllegalArgumentException("CSVLenders must not be null");
        }
        checkLoan(loan);
        checkRequestAmount(loan);
        int requestAmount = loan.getRequestAmount();
        double acummulatedAmout = 0;
        double acummulateRate = 0;
        double totalAmountWithRate = 0;
        boolean finished = false;
        for (int i = 0; i < csvLenders.getCSVLenders().size() && !finished; i++) {
            CSVLender csvLender = csvLenders.getCSVLenders().get(i);
            Double currentAmount = csvLender.getAvailable().doubleValue();
            if (acummulatedAmout + currentAmount >= requestAmount) {
                currentAmount = requestAmount - acummulatedAmout;
                finished = true;
            }
            Double currentAmountWithRate = currentAmount * csvLender.getRate();
            totalAmountWithRate += currentAmountWithRate;
            acummulatedAmout += currentAmount;
            acummulateRate += calculateMonthPayment(csvLender.getAvailable(), csvLender.getRate() / 12);
        }
        loan.setRate(totalAmountWithRate / requestAmount);
        loan.setMonthlyPayment(acummulateRate);
        loan.setTotalPayment(acummulateRate * INTEREST_RATE);
        return loan;
    }

    /**
     * Calculate the fixed-rate payment for a loan with the given principal, rate and term.
     * This is using A = (R/(1-(1+R)^-n))*P, where R is the rate, n is the term and P is the principal.
     *
     * @param P The money borrowed initially
     * @param R The interest rate per period
     * @return The amount due each term
     */
    private static double calculateMonthPayment(double P, double R) {
        if (R == 0) { // prevent division by zero
            return P / INTEREST_RATE;
        }
        double proportion = R / (1 - (Math.pow(1 + R, -INTEREST_RATE)));
        return proportion * P;
    }

    /**
     * Outputs loan with de demand format
     *
     * @param loan The loan to print
     */
    public static void printLoan(Loan loan) throws IllegalArgumentException {
        checkAllLoan(loan);
        System.out.println("Requested amount: £" + (int) loan.getRequestAmount());
        System.out.format("Rate: %.1f%%%n", loan.getRate() * 100);
        System.out.format("Monthly repayment: £%.2f%n", loan.getMonthlyPayment());
        System.out.format("Total repayment: £%.2f%n", loan.getTotalPayment());
    }

    private static void checkLoan(Loan loan) {
        if (Objects.isNull(loan)) {
            throw new IllegalArgumentException("Must not be null");
        }

    }

    private static void checkAllLoan(Loan loan) throws IllegalArgumentException {
        checkLoan(loan);
        checkRequestAmount(loan);
        checkRequestRate(loan);
        checkRequestMonthlyRepayment(loan);
        checkRequestTotalRepayment(loan);
    }

    private static void checkRequestAmount(Loan loan) {
        if (loan.getRequestAmount() == null) {
            throw new IllegalArgumentException("Request amount is mandatory");
        }
    }

    private static void checkRequestRate(Loan loan) {
        if (loan.getRate() == null) {
            throw new IllegalArgumentException("Request rate is mandatory");
        }
    }

    private static void checkRequestMonthlyRepayment(Loan loan) {
        if (loan.getMonthlyPayment() == null) {
            throw new IllegalArgumentException("Monthly repayment is mandatory");
        }
    }

    private static void checkRequestTotalRepayment(Loan loan) {
        if (loan.getTotalPayment() == null) {
            throw new IllegalArgumentException("Total repayment is mandatory");
        }
    }

}
