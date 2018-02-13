package es.onoguera.zopa.test;

import es.onoguera.zopa.test.lenders.CSVLender;
import es.onoguera.zopa.test.lenders.CSVLenders;
import es.onoguera.zopa.test.loan.Loan;
import es.onoguera.zopa.test.loan.LoanService;
import es.onoguera.zopa.test.utils.NumberUtils;

import java.io.IOException;

import static java.lang.System.exit;

public class ZopaTest {

    private final static Integer ARGS_SIZE = 2;
    private static final Integer MAX_AMOUNT = 15000;
    private static final Integer MIN_AMOUNT = 1000;
    private static final Integer AMOUNT_PIECE = 100;

    public static void main(String[] args) throws IOException {
        if (args.length != ARGS_SIZE) {
            System.out.println("Usage [application] [market_file] [loan_amount]");
            exit(-1);
        }
        Loan loan = new Loan();
        loan.setRequestAmount(parseAmount(args[1]));
        String path = args[0];
        CSVLenders csvLenders = new CSVLenders(path);
        LoanService loanService = new LoanService();
        loanService.calculateLoan(csvLenders,loan);
        loanService.printLoan(loan);
        exit(0);
    }

    private static Integer parseAmount(String argAmount){
        Integer amount = null;
        if (NumberUtils.isPositiveInteger(argAmount)) {
            amount = Integer.parseInt(argAmount);
        }else{
            System.out.println("Amount must be positive integer");
            exit(1);
        }
        if( amount > MAX_AMOUNT || amount < MIN_AMOUNT){
            System.out.println(String.format("Amount must be between %d and %d",MIN_AMOUNT,MAX_AMOUNT));
            exit(1);
        }
        if( amount % AMOUNT_PIECE != 0){
            System.out.println(String.format("Amount must be multiple of %d",AMOUNT_PIECE));
            exit(1);
        }
        return amount;
    }
}