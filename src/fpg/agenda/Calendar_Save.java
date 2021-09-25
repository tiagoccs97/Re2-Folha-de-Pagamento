package fpg.agenda;

public class Calendar_Save {
	private int current_day;
	private int current_month;
	private int current_year;
	private int current_week_day;	
	//Constructor
	public Calendar_Save(int cday, int cmonth, int cyear, int cweek_day) {
		this.current_day = cday;
		this.current_month = cmonth;
		this.current_year = cyear;
		this.current_week_day = cweek_day;
	}		
	//Sets
	public void set_day (int cday) {
		this.current_day = cday;
	}
	public void set_month(int month) {
		this.current_month = month;
	}
	public void set_year(int year) {
		this.current_year = year;
	}
	public void set_year1(int year) {
		this.current_year = year;
	}
	//Gets
	public int get_day() {
		return this.current_day;
	}
	public int get_month() {
		return this.current_month;
	}
	public int get_year() {
		return this.current_year;
	}
	public int get_week_day() {
		return this.current_week_day;
	}
	//Methods
	public void pass_day() {			
			this.current_day += 1;	
			update_date();
	}
	public void pass_Ndays(int  N) {
		for(int x = 0; x<N; x++) {
			this.pass_day();
		}
	}
	public void update_date(){
		if(this.current_week_day == 8) this.current_week_day = 1;
		
		if(this.current_day == 29 && this.current_month == 2) {
			this.current_day = 1;
			this.current_month++;
		}
		if(this.current_day == 31 && (this.current_month == 4 || this.current_month == 6 || this.current_month == 9 || this.current_month == 11)) {
			this.current_day = 1;
			this.current_month++;
		}
		else if(this.current_day == 32) {
			this.current_day = 1;
			this.current_month++;
		}
		if(this.current_month == 13) {
			this.current_month = 1;
			this.current_year++;
		}
	}
}

