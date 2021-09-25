package fpg.undo_redo;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;
import fpg.employees.*;
import fpg.main.*;
import fpg.payment.*;



public class Undo_Redo {
	private static Stack<Undo_Redo> Undo = new Stack<Undo_Redo>();
	private static Stack<Undo_Redo> Redo = new Stack<Undo_Redo>();
	private int old_sel,old_day,old_month,old_year,old_week_day,old_total_size,old_array_position;
	private Hashtable<Integer,Employee> old_HT =  new Hashtable<Integer,Employee>();
	
	
	public Undo_Redo(int sel,int day,int month,int year,int week_day,int total_size,int array_position,Map<Integer,Employee> employee) {
		set_old_sel(sel);
		set_old_day(day);
		set_old_month(month);
		set_old_year(year);
		set_old_week_day(week_day);
		set_oldMap(employee,total_size);
		set_old_array_position(array_position);
	}
	
	public static void Save(int sel,int day,int month,int year,int week_day,int total_size,int array_position,Map<Integer,Employee> employee) {
		Undo_Redo undo_redo = new Undo_Redo(sel,day,month,year,week_day,total_size,array_position,employee);
		Undo.push(undo_redo);
	}
	
	public static void SaveRedo(int sel,int day,int month,int year,int week_day,int total_size,int array_position,Map<Integer,Employee> employee) {
		Undo_Redo undo_redo = new Undo_Redo(sel,day,month,year,week_day,total_size,array_position,employee);
		Redo.push(undo_redo);
	}

	public static Undo_Redo undo() {
		Undo_Redo current = null;
		if(Undo.size() != 0) {
			current = Undo.pop();
			if(Undo.size() != 0) current = Undo.pop();
			Redo.push(current);
		}
		return current;
	}

	public static Undo_Redo redo() {
		Undo_Redo current = null;
		if(Redo.size() != 0) {
			current = Redo.pop();
			Undo.push(current);
		}
		return current;
	}
	//Gets
	public int get_old_sel() {
		return old_sel;
	}

	public int get_old_month() {
		return old_month;
	}
	public int get_old_year() {
		return old_year;
	}
	public int get_old_day() {
		return old_day;
	}
	public int get_old_week_day() {
		return old_week_day;
	}
	public int get_old_array_position() {
		return old_array_position;
	}
	public int get_old_total_size() {
		return old_total_size;
	}
	public Map<Integer,Employee> get_oldMap() {
		return old_HT;
	}
	//Sets
	public void set_old_sel(int old_sel) {
		this.old_sel = old_sel;
	}
	public void set_old_month(int old_month) {
		this.old_month = old_month;
	}
	public void set_old_year(int old_year) {
		this.old_year = old_year;
	}
	public void set_old_day(int old_day) {
		this.old_day = old_day;
	}
	public void set_old_week_day(int old_week_day) {
		this.old_week_day = old_week_day;
	}
	public void set_old_array_position(int old_array_position) {
		this.old_array_position = old_array_position;
	}
	public void set_old_total_size(int old_total_size) {
		this.old_total_size = old_total_size;
	}
	public void set_oldMap(Map<Integer,Employee> HT,int total_size) {
		//Set the save state
		double commission = 0;
		for(int currentid = 0;currentid <= total_size;currentid++) {
			if(HT.containsKey(currentid)) {
				if(HT.get(currentid) instanceof Employee) {
					if(HT.get(currentid).get_type() == 'C') {
						Commissioned current = (Commissioned) HT.get(currentid);
						commission = current.get_commission_percentage();
					}
					Employee.add_employee(this.old_HT, HT.get(currentid).get_name(), HT.get(currentid).get_adress(), HT.get(currentid).get_type(), HT.get(currentid).get_payment_method(), HT.get(currentid).get_agenda(), currentid, HT.get(currentid).get_salary(), HT.get(currentid).get_first_payment_day(), HT.get(currentid).get_first_payment_month(), HT.get(currentid).get_first_payment_year(), HT.get(currentid).get_first_week_day(), HT.get(currentid).get_syndicate(), HT.get(currentid).get_service_tax(),commission);
				}
			}
		}
	}
}