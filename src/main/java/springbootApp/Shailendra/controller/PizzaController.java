package springbootApp.Shailendra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import springbootApp.Shailendra.bussiness.been.Pizza;
import springbootApp.Shailendra.services.PizzaSerivces;


@RestController
public class PizzaController {
	@Autowired
	private PizzaSerivces pizzaSerivces;
	
	
	@RequestMapping(value="pizza/getDetailsByName/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pizza>> getPizzaDetailByName(@PathVariable("name") String myId){
	Collection<Pizza> pizza = pizzaSerivces.getPizzaDetailsByName(myId);
	if(pizza!=null)
	{
		
	return new ResponseEntity<Collection<Pizza>>(pizza, HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Collection<Pizza>>(HttpStatus.NOT_FOUND);
		
	}
	}
	@RequestMapping(value="pizza/controller/getAllPizzaOrdersByBill/{sal3}/{sal4}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Collection<Pizza>> getAllPizzaOrdersByBill(@PathVariable("sal3") Double var1,@PathVariable("sal4") Double var2){
			Collection <Pizza> listPizza = pizzaSerivces.getAllPizzasByBill(var1, var2);
			System.out.println(listPizza);
			return new ResponseEntity<Collection<Pizza>>(listPizza, HttpStatus.OK);
			}


	
	@RequestMapping(value="/pizza/controller/addPizza",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addPizza(@RequestBody Pizza employee){
		int id= pizzaSerivces.addPizza(employee);
		System.out.println("[id]:"+id);
		return new ResponseEntity<String>("Pizza added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/pizza/controller/deletePizza/{id}",method=RequestMethod.DELETE,
			//consumes=MediaType.TEXT_PLAIN_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pizza> deletePizza(@PathVariable("id") int myId){
		Pizza employee= pizzaSerivces.deletePizza(myId);
		if(employee==null){
			return new ResponseEntity<Pizza>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Removed: "+employee);
		return new ResponseEntity<Pizza>(employee,HttpStatus.OK);
	}
	

}
