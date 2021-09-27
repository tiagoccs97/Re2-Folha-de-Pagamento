package fpg.employees;
import java.util.Map;
import fpg.payment.*;
import fpg.agenda.*;

public class Hourly extends Employee{
	
	public Hourly(String name, String adress, char type, int payment_method, AgendaStrategy agenda,int id, double salary,boolean syndicate,double syndicate_tax) {
		super(name, adress, type, payment_method, agenda, id, salary, syndicate, syndicate_tax);
		
	}
	public Hourly() {
		super();
	}
	public static void calculate_syndicate(Map<Integer,Employee> HT,int aux) {
		CalculatePaymentStrategy H = new HourlyPayment();
		Calculate_payment calc = new Calculate_payment(H);
		calc.begin_syndicate(HT.get(aux));
	}	
	
	public static void calculate_payment(Map<Integer,Employee> HT,int aux) {
		CalculatePaymentStrategy H = new HourlyPayment();
		Calculate_payment calc = new Calculate_payment(H);
		calc.begin_salary(HT.get(aux));
	}
	public static void resetPay(Map<Integer,Employee> HT,int aux) {
		Hourly employee = (Hourly) HT.get(aux);
		employee.set_service_tax(0);
		employee.set_payment(0);		
	}
}
