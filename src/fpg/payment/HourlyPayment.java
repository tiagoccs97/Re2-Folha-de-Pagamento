package fpg.payment;
import fpg.employees.*;

public class HourlyPayment implements CalculatePaymentStrategy{


	public void calculate(Employee employee) {
				int verifypayment = 0;
				boolean acceptindex = true;
				Hourly currentemployee = (Hourly) employee;
				for(int i = 0;i < currentemployee.get_PaymentDaily().size();i++) {
					//Try
					try {
						currentemployee.get_PaymentDaily().get(i).get_arrival_time();
						currentemployee.get_PaymentDaily().get(i).get_exittime();
					}
					catch(IndexOutOfBoundsException e){
						acceptindex = false;
					}
					if(acceptindex) {
						if((currentemployee.get_PaymentDaily().get(i).get_arrival_time() != -1) && (currentemployee.get_PaymentDaily().get(i).get_exittime() != -1)) {
							verifypayment++;
							int begin = currentemployee.get_PaymentDaily().get(i).get_arrival_time();
							int end = currentemployee.get_PaymentDaily().get(i).get_exittime();
							int totaltime = end-begin;
							if(totaltime <= 0) currentemployee.get_PaymentDaily().get(i).set_daily_payment(0);
							else if(totaltime <= 8) currentemployee.get_PaymentDaily().get(i).set_daily_payment(totaltime * (currentemployee.get_salary()));
							else {
								double currentpayment = 8 * (currentemployee.get_salary());
								int extrahours = totaltime - 8;
								double finalpayment = (extrahours*((currentemployee.get_salary())*1.5)) + currentpayment;
								currentemployee.get_PaymentDaily().get(i).set_daily_payment(finalpayment);
							}
						}
						else currentemployee.get_PaymentDaily().get(i).set_daily_payment(0);
						acceptindex = true;
					}
				}
				acceptindex = true;
				double finalpaymentsum = 0;
				if(verifypayment == 0) currentemployee.set_payment(0.0);
				else {
					for(int i = 0; i < currentemployee.get_PaymentDaily().size();i++) {
						//Try
						try {
							currentemployee.get_PaymentDaily().get(i).get_daily_payment();
						}
						catch(IndexOutOfBoundsException e){
							acceptindex = false;
						}
						if(acceptindex){
							finalpaymentsum += currentemployee.get_PaymentDaily().get(i).get_daily_payment();
							acceptindex = true;
						}
					}
					currentemployee.set_payment(finalpaymentsum);
					System.out.println("Pagamento concluido!!");
					System.out.println();
				}
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

