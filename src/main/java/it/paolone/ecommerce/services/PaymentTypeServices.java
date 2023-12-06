package it.paolone.ecommerce.services;
import it.paolone.ecommerce.entities.PaymentData;
import it.paolone.ecommerce.entities.PaymentType;
import it.paolone.ecommerce.repositories.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PaymentTypeServices {

    private final PaymentTypeRepository paymentTypeRepository;
    @Autowired
    public PaymentTypeServices (PaymentTypeRepository paymentTypeRepository){
        this.paymentTypeRepository= paymentTypeRepository;
    }

    public  PaymentType getPaymentTypeById(String id){
        Optional<PaymentType> fetchedPaymentType = paymentTypeRepository.findById(id);
        return fetchedPaymentType.orElse(null);
    }

    public List<PaymentType> getAllPaymentType() {
        return paymentTypeRepository.findAll();
    }

    public PaymentType savePaymentType(PaymentType type) {
        return paymentTypeRepository.save(type);
    }
}
