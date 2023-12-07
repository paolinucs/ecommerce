package it.paolone.ecommerce.dto;

public class OrderDetailsDTO {

    private OrderDTO orderDtoData;
    private CustomerDTO customerDtoData;
    private ShippingDTO shippingDtoData;
    private TransactionDTO transactionDtoData;

    public OrderDTO getOrderDtoData() {
        return orderDtoData;
    }

    public CustomerDTO getCustomerDtoData() {
        return customerDtoData;
    }

    public TransactionDTO getTransactionDtoData() {
        return transactionDtoData;
    }

    public void setOrderDtoData(OrderDTO orderDtoData) {
        this.orderDtoData = orderDtoData;
    }

    public void setCustomerDtoData(CustomerDTO customerDtoData) {
        this.customerDtoData = customerDtoData;
    }

    public void setTransactionDtoData(TransactionDTO transactionDtoData) {
        this.transactionDtoData = transactionDtoData;
    }

    public ShippingDTO getShippingDtoData() {
        return shippingDtoData;
    }

    public void setShippingDtoData(ShippingDTO shippingDtoData) {
        this.shippingDtoData = shippingDtoData;
    }
}
