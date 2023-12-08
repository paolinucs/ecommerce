package it.paolone.ecommerce.services;
import it.paolone.ecommerce.dto.*;
import it.paolone.ecommerce.repositories.CustomerRepository;
import it.paolone.ecommerce.repositories.OrderRepository;
import it.paolone.ecommerce.entities.*;
import it.paolone.ecommerce.repositories.ShippingRepository;
import it.paolone.ecommerce.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.print.attribute.standard.Destination;
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
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final ShippingRepository shippingRepository;
    @Autowired
    public OrderDetailsService(ShippingRepository shippingRepository, TransactionRepository transactionRepository, CustomerRepository customerRepository,
                               OrderService orderService, OrderRepository orderRepository, ModelMapper modelMapper, CustomerService customerService,
                               ShippingServices shippingService, TransactionServices transactionService){
        this.modelMapper = modelMapper;
        this.customerService = customerService;
        this.shippingService = shippingService;
        this.transactionService = transactionService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.shippingRepository = shippingRepository;
    }

    public OrderDetailsDTO convertToOrderDetailsDto(Order order){
        CustomerDTO customerDtoData = customerService.convertToCustomerDTO(order.getJoinedCustomer());
        ShippingDTO shippingDtoData = shippingService.convertToShippingDTO(order.getJoinedShipping());
        //TransactionDTO transactionDtoData = transactionService.convertToTransactionDTO(order.getJoinedTransaction());

        OrderDetailsDTO returnData = modelMapper.map(order, OrderDetailsDTO.class);
        returnData.setCustomerDtoData(customerDtoData);
        //returnData.setTransactionDtoData(transactionDtoData);
        returnData.setShippingDtoData(shippingDtoData);

        return returnData;

    }

    public Order convertToOrder(OrderDetailsDTO orderDetailsDTO){
        Order orderData = orderService.convertToOrder(orderDetailsDTO.getOrderDtoData());
        Customer customerData = customerService.convertToCustomer(orderDetailsDTO.getCustomerDtoData());
        //Transaction transactionData = transactionService.convertToTransaction(orderDetailsDTO.getTransactionDtoData());
        Shipping shippingData = shippingService.convertToShipping(orderDetailsDTO.getShippingDtoData());

        orderData.setJoinedCustomer(customerData);
        orderData.setJoinedShipping(shippingData);
        //orderData.setJoinedTransaction(transactionData);

        return orderData;
    }


    public List<OrderDetailsDTO> getAllOrdersDetails(){
        List<Order> ordersData = orderRepository.findAll();
        List<OrderDetailsDTO> orderDetailsDTOList = new ArrayList<>();

        for (Order order: ordersData){
            CustomerDTO customerDtoData = customerService.convertToCustomerDTO(order.getJoinedCustomer());
            ShippingDTO shippingDtoData = shippingService.convertToShippingDTO(order.getJoinedShipping());
          //  TransactionDTO transactionDtoData = transactionService.convertToTransactionDTO(order.getJoinedTransaction());

            OrderDetailsDTO returnData = modelMapper.map(order, OrderDetailsDTO.class);
            returnData.setCustomerDtoData(customerDtoData);
            returnData.setShippingDtoData(shippingDtoData);
          //  returnData.setTransactionDtoData(transactionDtoData);
        }

        return orderDetailsDTOList;
    }

    public OrderDetailsDTO saveNewOrder(OrderDetailsDTO dataInput){
        if(dataInput != null){

            Order orderData = modelMapper.map(orderRepository.findById(dataInput.getOrderDtoData().getOrderId()), Order.class);
            Shipping shippingData = modelMapper.map(shippingRepository.findById(dataInput.getShippingDtoData().getId()), Shipping.class);
          //  Transaction transactionData = modelMapper.map(transactionRepository.findById(dataInput.getTransactionDtoData().getTransactionId()), Transaction.class);
            Customer customerData = modelMapper.map(customerRepository.findById(dataInput.getCustomerDtoData().getCustomerId()), Customer.class);

            //saving Data
            Order savedOrder = orderRepository.save(orderData);
            Shipping savedShipping = shippingRepository.save(shippingData);
           // Transaction savedTransaction = transactionRepository.save(transactionData);
            Customer savedCustomer = customerRepository.save(customerData);

          /*  OrderDetailsDTO returningOrderDetailsDTO = new OrderDetailsDTO();
            returningOrderDetailsDTO.setOrderDtoData(modelMapper.map(savedOrder,OrderDTO.class));
            returningOrderDetailsDTO.setShippingDtoData(modelMapper.map(savedShipping,ShippingDTO.class));
            returningOrderDetailsDTO.setTransactionDtoData(modelMapper.map(savedTransaction,TransactionDTO.class));
            returningOrderDetailsDTO.setCustomerDtoData(modelMapper.map(savedCustomer, CustomerDTO.class));

            return returningOrderDetailsDTO;*/

            return dataInput;

        }else throw new IllegalArgumentException("!!! saveNewOrder in OrderDetailsService cannot be null !!!");
    }




}
