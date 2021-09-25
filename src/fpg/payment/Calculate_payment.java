package fpg.payment;
import fpg.employees.*;

public class Calculate_payment {
	
	private CalculatePaymentStrategy calculate;
	
	public Calculate_payment(CalculatePaymentStrategy C) {
		this.calculate = C;
	}
	public Calculate_payment() {
		
	}
	public void begin_salary(Employee employee) {
		this.calculate.calculate(employee);
	}
	public void begin_syndicate(Employee employee) {
	this.calculate.calculate_syndicate(employee);
	}
}
