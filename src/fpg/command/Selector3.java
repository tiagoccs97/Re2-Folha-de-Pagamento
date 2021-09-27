package fpg.command;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import fpg.employees.Employee;
import fpg.employees.Hourly;
import fpg.main.Main;


public class Selector3 {
	public static void card(Map<Integer, Employee> HT, Scanner S) {
		int id = 0;
		int arrive=0;
		int exit=0;
		double aux=0;
		boolean acceptInput = false;
		Roll.show_employee_list(HT);
		//Try
		while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario desejado: ");
				id = S.nextInt();
				acceptInput = false;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!!!");
			} 	
			if(id<0) {
			acceptInput = true;
			System.out.println("Digite um valor inteiro positivo!!!");
			} 
		}
		acceptInput = false;
		if(HT.get(id) instanceof Hourly) {
			while (!acceptInput) {
				try {					
					System.out.println("Informe a hora de chegada(inteiro): ");
					arrive = S.nextInt();
					System.out.println("Informe a hora de saida(inteiro): ");
					exit = S.nextInt();
					acceptInput = true;
				} catch (NumberFormatException e) {
					System.out.println("Digite um valor inteiro!!!");
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor inteiro!!!");
				} 
				if(exit<arrive) {
					System.out.println("Hora de saida precisa ser maior que a de chegada, digite novamente!!!");
					acceptInput = false;
				}
			}  
			aux = HT.get(id).get_payment() + (exit-arrive)*HT.get(id).get_salary();
			HT.get(id).set_payment(aux);		  	
		} else System.out.println("Operacao nao realizada, este funcionario nao e horista!!!");
		
	}
}		
							
  

