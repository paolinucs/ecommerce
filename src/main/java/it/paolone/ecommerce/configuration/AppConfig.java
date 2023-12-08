package it.paolone.ecommerce.configuration;

import it.paolone.ecommerce.dto.*;
import it.paolone.ecommerce.dto.OrderDetailsDTO;
import it.paolone.ecommerce.entities.*;
import it.paolone.ecommerce.repositories.ShippingRepository;
import it.paolone.ecommerce.repositories.TransactionRepository;
import it.paolone.ecommerce.services.ShippingServices;
import it.paolone.ecommerce.services.TransactionServices;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                        .setAmbiguityIgnored(true);

      /*  modelMapper.typeMap(OrderDTO.class, Order.class).addMappings(mapper -> {
            mapper.map(src -> src.getOrderId(), Order::setOrderId);
            mapper.map(src -> src.getOrderDate(), Order::setOrderDate);
            mapper.map(src -> src.getTransactionData(), Order::setJoinedTransaction);
            mapper.map(src -> src.getShippingData(), Order::setJoinedShipping);
            mapper.map(src -> src.getCustomerData(), Order::setJoinedCustomer);
        });

        modelMapper.typeMap(CustomerDTO.class, Customer.class).addMappings(mapper -> {
            mapper.map(src -> src.getCustomerId(), Customer::setCustomerId);
            mapper.map(src -> src.getEmail(), Customer::setEmail);
            mapper.map(src -> src.getNominative(), Customer::setNominative);
            mapper.map(src -> src.getPhoneNumber(), Customer:: setPhoneNumber);
        });

        modelMapper.typeMap(ShippingDTO.class, Shipping.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), Shipping::setId);
            mapper.map(src -> src.getShippingAddress(), Shipping::setShippingAddress);
            mapper.map(src -> src.getShippingCompany(), Shipping::setShippingCompany);
            mapper.map(src -> src.getShippingDate(), Shipping::setShippingDate);
            mapper.map(src -> src.getTrackingCode(), Shipping::setTrackingCode);
        });

        modelMapper.typeMap(TransactionDTO.class, Transaction.class).addMappings(mapper -> {
            mapper.map(src -> src.getTransactionId(), Transaction::setId);
            mapper.map(src -> src.getPaymentData(), Transaction::setFetchedPaymentData);
            mapper.map(src -> src.getPaymentType(), Transaction::setFetchedPaymentType);
        });

        modelMapper.typeMap(OrderDetailsDTO.class, OrderDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getOrderDtoData().getOrderId(), OrderDTO::setOrderId);
            mapper.map(src -> src.getOrderDtoData().getOrderDate(), OrderDTO::setOrderDate);
            mapper.map(src -> src.getOrderDtoData().getCustomerId(), OrderDTO::setShippingData());
            mapper.map(src -> src.getOrderDtoData().getTransactionData(), OrderDTO::setTransactionData);
            mapper.map(src -> src.getOrderDtoData().getShippingData(), OrderDTO::setShippingData);
        });

        modelMapper.typeMap(OrderDetailsDTO.class, ShippingDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getShippingDtoData().getId(), ShippingDTO::setId);
            mapper.map(src -> src.getShippingDtoData().getShippingCompany(), ShippingDTO::setShippingCompany);
            mapper.map(src -> src.getShippingDtoData().getTrackingCode(), ShippingDTO::setTrackingCode);
            mapper.map(src -> src.getShippingDtoData().getShippingDate(), ShippingDTO::setShippingDate);
            mapper.map(src -> src.getShippingDtoData().getShippingAddress(), ShippingDTO::setShippingAddress);
        });

        modelMapper.typeMap(OrderDetailsDTO.class, TransactionDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getTransactionDtoData().getTransactionId(), TransactionDTO::setTransactionId);
            mapper.map(src -> src.getTransactionDtoData().getTransactionAmount(), TransactionDTO::setTransactionAmount);
            mapper.map(src -> src.getTransactionDtoData().getPaymentData(), TransactionDTO::setPaymentData);
            mapper.map(src -> src.getTransactionDtoData().getPaymentType(), TransactionDTO::setPaymentType);
            mapper.map(src -> src.getTransactionDtoData().getTransactionDate(), TransactionDTO::setTransactionDate);
        });

        modelMapper.typeMap(OrderDetailsDTO.class, CustomerDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getCustomerDtoData().getCustomerId(), CustomerDTO::setCustomerId);
            mapper.map(src -> src.getCustomerDtoData().getPhoneNumber(), CustomerDTO::setPhoneNumber);
            mapper.map(src -> src.getCustomerDtoData().getNominative(), CustomerDTO::setNominative);
            mapper.map(src -> src.getCustomerDtoData().getEmail(), CustomerDTO::setEmail);
        });
        */



        return modelMapper;

    }

    @Bean
    public ShippingServices shippingServices(ShippingRepository shippingRepository, ModelMapper modelMapper) {
        return new ShippingServices(shippingRepository, modelMapper);
    }
    
    @Bean
    public TransactionServices transactionServices(TransactionRepository transactionRepository, ModelMapper modelMapper){
        return new TransactionServices(transactionRepository,modelMapper);
    }
}
