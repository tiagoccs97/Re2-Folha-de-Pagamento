package fpg.command;
import fpg.main.*;
import java.util.Scanner;

public class Select1_Command extends Command{	
	
	public Select1_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector1.add_employee(f.HT, new Scanner(System.in), f.count, f.Date);
	}
	
}
