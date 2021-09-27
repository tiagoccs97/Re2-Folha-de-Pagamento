package fpg.payment;
import fpg.employees.*;

public class CommissionedPayment implements CalculatePaymentStrategy{
	
	public void calculate(Employee employee) {
		
		if(employee instanceof Employee) {
			Commissioned currentemployee = (Commissioned) employee;
			double total = currentemployee.get_sells();
			if(total > 0) {
				total = total * (currentemployee.get_commission_percentage());
			}
			double finalsalary = total + (currentemployee.get_salary());
			currentemployee.set_payment(finalsalary);
			System.out.println("Pagamento concluido!!");
			System.out.println();
		}
		else System.out.println("Funcionario nao associado, operacao nao realizada!");				
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
