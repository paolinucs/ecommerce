package it.paolone.ecommerce.dto;

public class TransactionDTO {
    private String transactionDate;
    private int transactionAmount;
    private String paymentType;
    private Long paymentData;

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setPaymentData(Long paymentData) {
        this.paymentData = paymentData;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Long getPaymentData() {
        return paymentData;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }
}
