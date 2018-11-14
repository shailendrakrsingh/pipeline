package springbootApp.Shailendra.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PizzaEntity {
	@Id
	private Integer pizzaid;
	private String pizzaname;
	private Double bill;
	private Date billdate;
	public PizzaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPizzaid() {
		return pizzaid;
	}
	public void setPizzaid(Integer pizzaid) {
		this.pizzaid = pizzaid;
	}
	public String getPizzaname() {
		return pizzaname;
	}
	public void setPizzaname(String pizzaname) {
		this.pizzaname = pizzaname;
	}
	
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}
}
