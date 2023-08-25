package com.woderlust.services;

import com.woderlust.NewPaymentMethodRequest;
import com.woderlust.entities.PaymentMethod;
import com.woderlust.repository.IPaymentMethodRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(IPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getDataPayments(){ return paymentMethodRepository.findAll(); }

    public PaymentMethod get(Long id){ return paymentMethodRepository.findById(id).get(); }

    public void addPaymentMethod(NewPaymentMethodRequest paymentMethodRequest){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setDataPaymentId(paymentMethodRequest.getDataPaymentId());
        paymentMethodRepository.save(paymentMethod);
    }

    public ResponseEntity<PaymentMethod> updatePaymentMethod(Long id, PaymentMethod paymentMethodDetails){
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
        if(!optionalPaymentMethod.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PaymentMethod paymentMethod = optionalPaymentMethod.get();
        paymentMethod.setDataPaymentId(paymentMethodDetails.getDataPaymentId());
        PaymentMethod updatePaymentmethod = paymentMethodRepository.save(paymentMethod);
        return new ResponseEntity<>(updatePaymentmethod, HttpStatus.OK);
    }

    public void delete(Long id){ paymentMethodRepository.deleteById(id);}
}
