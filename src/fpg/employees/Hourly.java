package fpg.employees;

import java.util.HashMap;
import java.util.Map;

import fpg.payment.*;
import java.util.ArrayList;
import fpg.agenda.*;

public class Hourly extends Employee{
	private int arrival_time;
	private int exit_time;
	private double daily_payment;
	private int check_setofday;
	private ArrayList<Hourly> Payment_Daily = new ArrayList<Hourly>();
	
	public Hourly(int arrival_time,int exit_time,double daily_payment,int check_setofday, String name, String adress, char type, int payment_method, AgendaStrategy agenda,int id, double salary,boolean syndicate,double syndicate_tax) {
		super(name, adress, type, payment_method, agenda, id, salary, syndicate, syndicate_tax);
		this.arrival_time = arrival_time;
		this.exit_time = exit_time;
		this.daily_payment = daily_payment;
		this.check_setofday = check_setofday;
	}
	public Hourly() {
		super();
		this.arrival_time = 0;
		this.exit_time = 0;
		this.daily_payment = 0;
		this.check_setofday = 0;
	}
	//Gets
	
	public int get_arrival_time() {
		return arrival_time;
	}
	public int get_exittime() {
		return exit_time;
	}
	public double get_daily_payment() {
		return daily_payment;
	}
	public ArrayList<Hourly> get_PaymentDaily() {
		return Payment_Daily;
	}
	public int get_check_setofday() {
		return check_setofday;
	}
	
	//Sets

	public void set_arrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}
	public void set_exittime(int exit_time) {
		this.exit_time = exit_time;
	}
	public void set_daily_payment(double daily_payment) {
		this.daily_payment = daily_payment;
	}
	public void set_PaymentDaily(ArrayList<Hourly> payment_daily) {
		this.Payment_Daily = payment_daily;
	}
	public void set_check_setofday(int check_setofday) {
		this.check_setofday = check_setofday;
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

}
