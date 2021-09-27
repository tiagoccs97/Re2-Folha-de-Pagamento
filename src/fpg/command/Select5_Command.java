package fpg.command;

import java.util.Scanner;

public class Select5_Command extends Command{
	
	public Select5_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector5.service_tax(f.HT, new Scanner(System.in));
	}

}
