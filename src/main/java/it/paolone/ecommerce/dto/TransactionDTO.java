package it.paolone.ecommerce.dto;

import it.paolone.ecommerce.entities.PaymentData;
import it.paolone.ecommerce.entities.PaymentType;

public class TransactionDTO {

    private Long transactionId;
    private String transactionDate;
    private int transactionAmount;
    private PaymentType paymentType;
    private PaymentData paymentData;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }
}









