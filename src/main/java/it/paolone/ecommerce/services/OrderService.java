package it.paolone.ecommerce.services;
import it.paolone.ecommerce.entities.Order;
import it.paolone.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long id){
        Optional<Order> fetchedOrder = orderRepository.findById(id);
        return fetchedOrder.orElse(null);
    }

    public List<Order> getAllOrders(){
        List<Order> fetchedOrders = orderRepository.findAll();
        return fetchedOrders;
    }

    public Order saveOrder(Order data){
        return orderRepository.save(data);
    }

}
