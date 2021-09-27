package fpg.command;

import java.util.Map;
import java.util.Scanner;
import fpg.payment.*;
import fpg.employees.Employee;
import fpg.agenda.*;

public class Selector7 {
	public static void runPayRoll(Map<Integer, Employee> HT, Scanner S, Calendar_Save date){		
		int N=0;
		System.out.println("Digite o numero de dias a serem passados");		
		N = S.nextInt();
		PayRoll.verify_days(HT, date, N);
		System.out.println("Finalizado");
		System.out.println();
	}
}
