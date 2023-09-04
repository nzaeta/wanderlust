package Models.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoz.NZWanderlust.Entities.PaymentMethod;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}