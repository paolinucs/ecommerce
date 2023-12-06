package it.paolone.ecommerce.entities;

import jakarta.persistence.*;

@Table(name= "transaction")
@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column (name = "id")
  private Long id;

    @Column (name = "transaction_date")
    private String transactionDate;

    @Column(name = "transaction_amount")
    private int transactionAmount;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_data")
    private Long paymentData;

    public Long getId() {
        return id;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public String getPayamentType() {
        return paymentType;
    }

    public Long getPaymentData() {
        return paymentData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setPayamentType(String payamentType) {
        this.paymentType = payamentType;
    }

    public void setPaymentData(Long paymentData) {
        this.paymentData = paymentData;
    }
}
