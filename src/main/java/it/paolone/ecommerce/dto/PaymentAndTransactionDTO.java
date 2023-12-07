package it.paolone.ecommerce.dto;

import it.paolone.ecommerce.entities.PaymentData;
import it.paolone.ecommerce.entities.PaymentType;

public class PaymentAndTransactionDTO {
    private PaymentDataDTO paymentDataData;
    private PaymentTypeDTO paymentTypeData;
    private TransactionDTO transactionData;

    public PaymentDataDTO getPaymentDataData() {
        return paymentDataData;
    }

    public PaymentTypeDTO getPaymentTypeData() {
        return paymentTypeData;
    }

    public TransactionDTO getTransactionData() {
        return transactionData;
    }

    public void setPaymentDataData(PaymentDataDTO paymentDataData) {
        this.paymentDataData = paymentDataData;
    }

    public void setPaymentTypeData(PaymentTypeDTO paymentTypeData) {
        this.paymentTypeData = paymentTypeData;
    }

    public void setTransactionData(TransactionDTO transactionData) {
        this.transactionData = transactionData;
    }
}
