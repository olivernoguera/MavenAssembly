package es.onoguera.zopa.test.lenders;

import com.opencsv.bean.CsvBindByName;


public class CSVLender {

    @CsvBindByName
    private String lender;
    @CsvBindByName
    private Double rate;
    @CsvBindByName
    private Integer available;


    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "CSVLender{" +
                "name='" + lender + '\'' +
                ", rate=" + rate +
                ", available=" + available +
                '}';
    }
}
