package fpg.payment;
import fpg.employees.*;


public interface CalculatePaymentStrategy {	
	
	public void calculate(Employee employee);
	public void calculate_syndicate(Employee employee);	
}
