package it.paolone.ecommerce.services;
import it.paolone.ecommerce.dto.*;
import it.paolone.ecommerce.repositories.OrderRepository;
import it.paolone.ecommerce.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsService {

    private final ModelMapper modelMapper;
    private final CustomerService customerService;
    private final ShippingServices shippingService;
    private final TransactionServices transactionService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    @Autowired
    public OrderDetailsService(OrderService orderService, OrderRepository orderRepository, ModelMapper modelMapper, CustomerService customerService, ShippingServices shippingService, TransactionServices transactionService){
        this.modelMapper = modelMapper;
        this.customerService = customerService;
        this.shippingService = shippingService;
        this.transactionService = transactionService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    public OrderDetailsDTO convertToOrderDetailsDto(Order order){
        CustomerDTO customerDtoData = customerService.convertToCustomerDTO(order.getJoinedCustomer());
        ShippingDTO shippingDtoData = shippingService.convertToShippingDTO(order.getJoinedShipping());
        TransactionDTO transactionDtoData = transactionService.convertToTransactionDTO(order.getJoinedTransaction());

        OrderDetailsDTO returnData = modelMapper.map(order, OrderDetailsDTO.class);
        returnData.setCustomerDtoData(customerDtoData);
        returnData.setTransactionDtoData(transactionDtoData);
        returnData.setShippingDtoData(shippingDtoData);

        return returnData;

    }

    public Order convertToOrder(OrderDetailsDTO orderDetailsDTO){
        Order orderData = orderService.convertToOrder(orderDetailsDTO.getOrderDtoData());
        Customer customerData = customerService.convertToCustomer(orderDetailsDTO.getCustomerDtoData());
        Transaction transactionData = transactionService.convertToTransaction(orderDetailsDTO.getTransactionDtoData());
        Shipping shippingData = shippingService.convertToShipping(orderDetailsDTO.getShippingDtoData());

        orderData.setJoinedCustomer(customerData);
        orderData.setJoinedShipping(shippingData);
        orderData.setJoinedTransaction(transactionData);

        return orderData;
    }


    public List<OrderDetailsDTO> getAllOrdersDetails(){
        List<Order> ordersData = orderRepository.findAll();
        List<OrderDetailsDTO> orderDetailsDTOList = new ArrayList<>();

        for (Order order: ordersData){
            CustomerDTO customerDtoData = customerService.convertToCustomerDTO(order.getJoinedCustomer());
            ShippingDTO shippingDtoData = shippingService.convertToShippingDTO(order.getJoinedShipping());
            TransactionDTO transactionDtoData = transactionService.convertToTransactionDTO(order.getJoinedTransaction());

            OrderDetailsDTO returnData = modelMapper.map(order, OrderDetailsDTO.class);
            returnData.setCustomerDtoData(customerDtoData);
            returnData.setShippingDtoData(shippingDtoData);
            returnData.setTransactionDtoData(transactionDtoData);
        }

        return orderDetailsDTOList;
    }



}
