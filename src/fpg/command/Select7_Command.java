package fpg.command;

import java.util.Scanner;

public class Select7_Command extends Command{
	public Select7_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector7.runPayRoll(f.HT, new Scanner(System.in), f.Date);
	}

}
