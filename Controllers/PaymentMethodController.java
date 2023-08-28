package com.woderlust.controller;

import com.woderlust.NewPaymentMethodRequest;
import com.woderlust.entities.PaymentMethod;
import com.woderlust.services.PaymentMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/paymentMethod/")
    public List<PaymentMethod> getAllPaymentMethod() { return paymentMethodService.getDataPayments();}

    @PostMapping("/paymentMethod/")
    public void addPaymentMethod(@RequestBody NewPaymentMethodRequest request) { paymentMethodService.addPaymentMethod(request); }

    @PutMapping("/paymentMethod/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod, @PathVariable Long id) { return paymentMethodService.updatePaymentMethod(id, paymentMethod);}

    @DeleteMapping("/paymentMethod/{id}")
    public void deletePaymentMethod(@PathVariable Long id) { paymentMethodService.delete(id);}
}
