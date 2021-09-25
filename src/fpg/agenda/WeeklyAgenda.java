package fpg.agenda;
import fpg.employees.*;

public class WeeklyAgenda implements AgendaStrategy{
	
	private int payment_day;
	private int payment_month;
	private int payment_year;
	private int payment_week_day;
	private int first_day;
	private int first_month;
	private int first_year;
	private int first_week_day;
	
	//Sets
	public void set_first_date(Calendar_Save date) {
		this.first_day = date.get_day();
		this.first_month = date.get_month();
		this.first_year = date.get_year();
		this.first_week_day = date.get_week_day();
	}
	public void set_payment_week_day(int payment_week_day){
		this.payment_week_day = payment_week_day;
	}
	public void set_payment_day(int payment_day){
		this.payment_day = payment_day;		
	}
	public void set_payment_month(int payment_month) {
		this.payment_month = payment_month;		
	}
	public void set_payment_year(int payment_year){
		this.payment_year = payment_year;		
	}	
	public void set_first_week_day(int first_week_day){
		this.first_week_day = first_week_day;
	}
	public void set_first_day(int first_day){
		this.first_day = first_day;		
	}
	public void set_first_month(int first_month) {
		this.first_month = first_month;		
	}
	public void set_first_year(int first_year){
		this.first_year = first_year;
	}
	//Gets
	public void get_payment_date(Calendar_Save Date, Employee E) {
		
	}
	public int get_payment_week_day(){
		return payment_week_day;
	}
	public int get_payment_day(){
		return payment_day;
	}
	public int get_payment_month(){
		return payment_month;
	}
	public int get_payment_year(){
		return payment_year;
	}
	public int get_first_week_day(){
		return first_week_day;
	}
	public int get_first_payment_day(){
		return first_day;
	}
	public int get_first_payment_month(){
		return first_month;
	}
	public int get_first_payment_year(){
		return first_year;
	}
	//Methods
	public void set_payment_date(Calendar_Save Date) {
		Calendar_Save aux_date = new Calendar_Save(Date.get_day(), Date.get_month(), Date.get_year(), Date.get_week_day());
		aux_date.pass_Ndays(7);
		this.payment_day = aux_date.get_day();
		this.payment_month = aux_date.get_month();
		this.payment_year = aux_date.get_year();
		this.payment_week_day = aux_date.get_week_day();
	}
	public void get_payment_date(Calendar_Save Date) {
		String WD = null;
		if(this.payment_week_day == 1) WD = "Domingo";
		else if(this.payment_week_day == 2) WD = "Segunda-Feira";
		else if(this.payment_week_day == 3) WD = "Terça-Feira";
		else if(this.payment_week_day == 4) WD = "Quarta-Feira";
		else if(this.payment_week_day == 5) WD = "Quinta-Feira";
		else if(this.payment_week_day == 6) WD = "Sexta-Feira";
		else if(this.payment_week_day == 7) WD = "Sabado";
		
		System.out.println("Este funcionario sera pago em uma " + WD + " na data: " + this.payment_day + "/" + this.payment_month + "/" + this.first_year);
	}
	public String show_agenda_type() {
		return "Semanalmente";
	}
	

}
