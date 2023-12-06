package it.paolone.ecommerce.controllers;

import it.paolone.ecommerce.dto.OrderDetailsDTO;
import it.paolone.ecommerce.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderDetailsController {

    public final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService){
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<OrderDetailsDTO>> getOrderDetails(){
        List<OrderDetailsDTO> fetchedData = orderDetailsService.getAllOrdersDetails();
        if(!fetchedData.isEmpty()){
            return ResponseEntity.ok(fetchedData);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
