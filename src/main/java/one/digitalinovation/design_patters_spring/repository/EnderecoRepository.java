package one.digitalinovation.design_patters_spring.repository;

import one.digitalinovation.design_patters_spring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
