package fpg.command;

import java.util.Scanner;

public class Select4_Command extends Command{
	
	public Select4_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector4.sell_result(f.HT, new Scanner(System.in));
	}

}
