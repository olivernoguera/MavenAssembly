package es.onoguera.zopa.test.loan;

public class Loan {

    private Integer requestAmount;
    private Double rate;
    private Double monthlyPayment;
    private Double totalPayment;


    public Loan() {
    }

    public Loan(Integer requestAmount, Double rate, Double monthlyPayment, Double totalPayment) {
        this.requestAmount = requestAmount;
        this.rate = rate;
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
    }

    public Integer getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Integer requestAmount) {
        this.requestAmount = requestAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }


}
