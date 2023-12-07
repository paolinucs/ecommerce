package it.paolone.ecommerce.configuration;

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
        return new ModelMapper();
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
