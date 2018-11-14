package springbootApp.Shailendra.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootApp.Shailendra.bussiness.been.Pizza;
import springbootApp.Shailendra.dao.PizzaDao;
import springbootApp.Shailendra.entity.PizzaEntity;

@Service
public class PizzaSerivces {
	
	@Autowired
	private PizzaDao pizzaDAO;

	public Collection<Pizza> getPizzaDetailsByName(String name){
		Collection<PizzaEntity> collec =pizzaDAO.getPizzaDetailsByName(name);
		List<Pizza> listpizza = new ArrayList<Pizza> ();
		for (PizzaEntity pizzaEntity : collec) {
			Pizza Pizza=new Pizza();
			BeanUtils.copyProperties(pizzaEntity, Pizza);
			listpizza.add(Pizza);
		}
		return listpizza;
	}
	public Collection<Pizza> getAllPizzasByBill(Double bill,Double bil2){
		Collection<PizzaEntity> collec =pizzaDAO.getAllPizzasByBill(bill,bil2);
		List<Pizza> listpizza = new ArrayList<Pizza> ();
		for (PizzaEntity pizzaEntity : collec) {
			Pizza Pizza=new Pizza();
			BeanUtils.copyProperties(pizzaEntity, Pizza);
			listpizza.add(Pizza);
		}
		return listpizza;
	}
	@Autowired
	private PizzaDao employeeDAO;

	public int addPizza(Pizza employee) {

	PizzaEntity employeeEntity = new PizzaEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		PizzaEntity emp= (PizzaEntity)employeeDAO.save(employeeEntity);
		return emp.getPizzaid();
	}

	public Collection<Pizza> getPizzaDetails(){
		Collection<PizzaEntity> collec =employeeDAO.findAll();
		List<Pizza> listEmployee = new ArrayList<Pizza> ();
		for (PizzaEntity employeeEntity : collec) {
			Pizza employee=new Pizza();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
	}
	public Pizza getPizzaDetailByName(int employeeId){
		Pizza employee =null;
		PizzaEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employee= new Pizza();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
}
	public Pizza deletePizza(int employeeId){
		Pizza employee =null;
		PizzaEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employeeDAO.delete(employeeEntity);
			employee= new Pizza();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	}
