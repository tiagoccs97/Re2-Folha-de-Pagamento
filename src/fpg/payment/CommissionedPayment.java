package fpg.payment;


import fpg.employees.*;

public class CommissionedPayment implements CalculatePaymentStrategy{

	
	public void calculate(Employee employee) {
		if(employee.get_type() == 'C') {
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
		else System.out.println("Operacao nao realizada, selecione um funcionario comissionado!!!");		
	}

	
	public void calculate_syndicate(Employee employee) {
		
		
	}
}
