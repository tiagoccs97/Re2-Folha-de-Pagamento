package fpg.payment;
import fpg.employees.*;

public class HourlyPayment implements CalculatePaymentStrategy{


	public void calculate(Employee employee) {
				
	}
	public void calculate_syndicate(Employee employee) {
		if(employee.get_syndicate() == true && employee.get_payment() != 0) {
			double salary = employee.get_payment();
			double tax =  employee.get_syndicate_tax();
			double servicetax = employee.get_service_tax();
			tax = salary * tax;
			salary = salary - tax;
			if(servicetax != 0) {
				servicetax = salary * servicetax;
				salary = salary - servicetax;
			}
			employee.set_payment(salary);
		}	
	}	
}

