package fpg.command;

import java.util.Scanner;

public class Select3_Command extends Command{
	
	public Select3_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector3.card(f.HT, new Scanner(System.in));
	}

}
