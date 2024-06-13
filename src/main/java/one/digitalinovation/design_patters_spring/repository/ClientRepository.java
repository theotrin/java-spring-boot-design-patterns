package one.digitalinovation.design_patters_spring.repository;

import one.digitalinovation.design_patters_spring.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // -> não precisa
public interface ClientRepository extends CrudRepository<Client, Long> {

}
