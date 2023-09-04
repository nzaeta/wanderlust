package Models.Services;

import com.nicoz.NZWanderlust.NewDataPaymentRequest;
import com.nicoz.NZWanderlust.NewPaymentMethodRequest;
import com.nicoz.NZWanderlust.Entities.DataPayment;
import com.nicoz.NZWanderlust.Entities.PaymentMethod;
import com.nicoz.NZWanderlust.Repositories.PaymentMethodRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }
    
	@Autowired
	private DataPaymentService dataPaymentService;
	
	@Autowired
	private UserService userService;
    

    public List<PaymentMethod> getPaymentMethods(){ return paymentMethodRepository.findAll(); }

    public PaymentMethod get(Long id){ return paymentMethodRepository.findById(id).get(); }

    public void addPaymentMethod(NewDataPaymentRequest dataPaymentRequest){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setUser(userService.getUser(dataPaymentRequest.getUserId()));
        
        DataPayment dataPayment = dataPaymentService.addDataPayment(dataPaymentRequest);
        
        paymentMethod.setDataPayment(dataPayment);
        paymentMethodRepository.save(paymentMethod);
    }

//    public ResponseEntity<PaymentMethod> updatePaymentMethod(Long id, PaymentMethod paymentMethodDetails){
//        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
//        if(!optionalPaymentMethod.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        PaymentMethod paymentMethod = optionalPaymentMethod.get();
//        paymentMethod.setDataPaymentId(paymentMethodDetails.getDataPaymentId());
//        PaymentMethod updatePaymentmethod = paymentMethodRepository.save(paymentMethod);
//        return new ResponseEntity<>(updatePaymentmethod, HttpStatus.OK);
//    }

    public void delete(Long id){ 
    	PaymentMethod paymentMethod = paymentMethodRepository.findById(id).get();

    	
    	paymentMethodRepository.deleteById(id);
		dataPaymentService.delete(paymentMethod.getDataPayment().getId());
    }
    
}
