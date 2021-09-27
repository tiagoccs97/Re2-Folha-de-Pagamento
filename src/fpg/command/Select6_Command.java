package fpg.command;

import java.util.Scanner;

public class Select6_Command extends Command{
	
	public Select6_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector6.change_employee(f.HT, new Scanner(System.in));
	}
	
}
