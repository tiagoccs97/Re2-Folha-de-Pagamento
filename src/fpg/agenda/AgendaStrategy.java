package fpg.agenda;

public interface AgendaStrategy {	
		
		public void set_payment_date(Calendar_Save Date);
		public void get_payment_date(Calendar_Save Date);	
		public void set_first_date(Calendar_Save date);
		public int get_payment_week_day();		
		public int get_payment_day();		
		public int get_payment_month();		
		public int get_payment_year();		
		public int get_first_week_day();	
		public int get_first_day();			
		public int get_first_month();		
		public int get_first_year();
		public void set_payment_week_day(int week_day);		
		public void set_payment_day(int day);		
		public void set_payment_month(int month);		
		public void set_payment_year(int year);		
		public void set_first_week_day(int first_week_day);	
		public void set_first_day(int first_day);			
		public void set_first_month(int first_month);		
		public void set_first_year(int first_year);
		public String show_agenda_type();
}