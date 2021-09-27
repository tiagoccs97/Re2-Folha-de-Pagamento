package fpg.command;

import java.util.Scanner;

public class Select9_Command extends Command{
	public Select9_Command(Roll f) {
		super(f);
	}
	
	public void execute() {	
		backup();
		Selector9.modify_agenda(f.HT, new Scanner(System.in));
	}
}
