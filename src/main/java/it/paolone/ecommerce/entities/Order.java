package it.paolone.ecommerce.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long orderId;
    /**@Column(name = "customer_id")
    private Long customerId;**/
    @Column(name = "order_date")
    private String orderDate;
   /** @Column(name = "shipping_id")
    private Long shippingId;
    @Column(name = "transaction_id")
    private Long transactionId;**/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer joinedCustomer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private Shipping joinedShipping;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transaction joinedTransaction;

    //getters and setters

   /** public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }**/

    public Long getOrderId() {
        return orderId;
    }

   /** public Long getShippingId() {
        return shippingId;
    }

    public Long getTransactionId() {
        return transactionId;
    }**/

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }**/

    public Customer getJoinedCustomer() {
        return joinedCustomer;
    }

    public Shipping getJoinedShipping() {
        return joinedShipping;
    }

    public Transaction getJoinedTransaction() {
        return joinedTransaction;
    }

    public void setJoinedCustomer(Customer joinedCustomer) {
        this.joinedCustomer = joinedCustomer;
    }

    public void setJoinedShipping(Shipping joinedShipping) {
        this.joinedShipping = joinedShipping;
    }

    public void setJoinedTransaction(Transaction joinedTransaction) {
        this.joinedTransaction = joinedTransaction;
    }
}
