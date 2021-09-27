package fpg.command;

import java.util.Scanner;

public class Select2_Command extends Command {
	
	public Select2_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector2.remove(f.HT, new Scanner(System.in));
	}

}
