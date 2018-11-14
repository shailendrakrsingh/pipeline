package springbootApp.Shailendra.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import springbootApp.Shailendra.entity.PizzaEntity;


public interface PizzaDao extends JpaRepository<PizzaEntity, Integer>{

	Collection<PizzaEntity> getPizzaDetailsByName(String name);
	@Query("select k from PizzaEntity k where k.bill>=?1 and k.bill<=")
	List<PizzaEntity> getAllPizzasByBill(Double bill,Double bil2);




}
