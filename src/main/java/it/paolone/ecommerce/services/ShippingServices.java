package it.paolone.ecommerce.services;
import it.paolone.ecommerce.dto.ShippingDTO;
import it.paolone.ecommerce.entities.PaymentData;
import it.paolone.ecommerce.entities.Shipping;
import it.paolone.ecommerce.repositories.ShippingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShippingServices {

    private final ShippingRepository shippingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShippingServices(ShippingRepository shippingRepository, ModelMapper modelMapper) {
        this.shippingRepository = shippingRepository;
        this.modelMapper = modelMapper;
    }

    public Shipping getShippingById(Long id) {
        Optional<Shipping> fetchedShipping = shippingRepository.findById(id);
        return fetchedShipping.orElse(null);
    }

    public List<Shipping> getAllPaymentData() {
        return shippingRepository.findAll();
    }

    public Shipping saveShippping(Shipping data ) {
        return shippingRepository.save(data);
    }

    public ShippingDTO convertToShippingDTO(Shipping data){
       return modelMapper.map(data,ShippingDTO.class);
    }
}
