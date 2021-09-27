package fpg.command;

import java.util.Map;
import java.util.HashMap;
import count.Count;
import fpg.agenda.Calendar_Save;
import fpg.employees.Employee;

public abstract class Command {
	public Roll f;
	private Map<Integer,Employee> backup_HT;
	private Count backup_count;
	private Calendar_Save backup_Date;
	
	Command(Roll f){
		this.f = f;
	}
	void backup() {
		backup_HT =  new HashMap<Integer, Employee>();
		for(Integer X : f.HT.keySet()) {
			backup_HT.put(X, f.HT.get(X));
		}
		backup_count = new Count(0, 0);
		backup_Date = new Calendar_Save(0, 0, 0, 0);
		backup_count.set_id(f.count.get_id());
		backup_count.set_id_synd(f.count.get_id_synd());
		backup_Date.set_day(f.Date.get_day());
		backup_Date.set_month(f.Date.get_month());
		backup_Date.set_year(f.Date.get_day());
		backup_Date.set_week_day(f.Date.get_week_day());
		
	}
	public void restore() {
		f.HT =  new HashMap<Integer, Employee>();
		for(Integer X : backup_HT.keySet()) {
			f.HT.put(X, backup_HT.get(X));
		}
		f.count = new Count(0, 0);
		f.Date = new Calendar_Save(0, 0, 0, 0);
		f.count.set_id(backup_count.get_id());
		f.count.set_id_synd(backup_count.get_id_synd());
		f.Date.set_day(backup_Date.get_day());
		f.Date.set_month(backup_Date.get_month());
		f.Date.set_year(backup_Date.get_day());
		f.Date.set_week_day(backup_Date.get_week_day());
	}
	public abstract void execute();
}
