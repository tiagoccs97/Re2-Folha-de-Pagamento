package fpg.employees;

import java.util.HashMap;
import java.util.Map;

import fpg.agenda.AgendaStrategy;
import fpg.payment.*;

public class Commissioned extends Employee{
		private double commission_percentage;
		private double sells;
		
		public Commissioned(double commission_percentage, double sells, String name, String adress, char type, int payment_method, AgendaStrategy agenda,int id, double salary,boolean syndicate,double syndicate_tax) {
			super(name, adress, type, payment_method, agenda, id, salary, syndicate, syndicate_tax);
			this.commission_percentage = commission_percentage;		
			this.sells = 0;
		}
		public Commissioned() {
			
		}
		//Gets
		public double get_commission_percentage(){
			return commission_percentage;
		}
		public double get_sells(){
				return sells;
		}
		
		//Sets
		public void set_commission_percentage(double commission_percentage) {
			this.commission_percentage = commission_percentage;
		}
		public void set_sells(double sells) {
			this.sells += sells;
		}
		
		public static void calculate_syndicate(Map<Integer,Employee> HT,int aux) {
			CalculatePaymentStrategy C = new HourlyPayment();
			Calculate_payment calc = new Calculate_payment(C);
			calc.begin_syndicate(HT.get(aux));
		}
		
		
		public static void calculate_payment(Map<Integer,Employee> HT,int aux) {
			CalculatePaymentStrategy C = new CommissionedPayment();
			Calculate_payment calc = new Calculate_payment(C);
			calc.begin_salary(HT.get(aux));
		}
}
