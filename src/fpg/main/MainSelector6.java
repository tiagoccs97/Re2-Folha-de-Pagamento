package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import fpg.employees.Employee;

public class MainSelector6 {
	public static void change_employee(Map<Integer, Employee> HT, Scanner S){
		int aux=0;
		boolean acceptInput = false;
		Main.show_employee_list(HT);
		while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario desejado: ");
				aux = S.nextInt();
				acceptInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!!!");
			} 
			if(aux<0) {
				acceptInput = false;
				System.out.println("Digite um valor inteiro positivo!!!");
			} 
		}		
		 HT.get(aux).change_employee_data(HT.get(aux), S);		 
	}
}
