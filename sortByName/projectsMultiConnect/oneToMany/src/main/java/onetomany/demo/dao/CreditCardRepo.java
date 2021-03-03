package onetomany.demo.dao;

import onetomany.demo.model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends CrudRepository<CreditCard,Long> {
}
