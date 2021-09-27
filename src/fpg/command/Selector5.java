package fpg.command;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fpg.employees.Employee;
import fpg.main.Main;


public class Selector5 {
	public static void service_tax(Map<Integer, Employee> HT, Scanner S) {
		int aux=0;
		double aux_d=0;
		boolean acceptInput = false;
		Roll.show_employee_list(HT);
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
		if(aux < 0){
			System.out.println("Digite um valor inteiro!!!");
			System.out.println("Operacao nao realizada, voltando ao menu...");
			S.next();					
		}
		else if(HT.get(aux).get_syndicate() == true) {
		
			if(HT.containsKey(aux)) {
				if(HT.get(aux)instanceof Employee) {
			
					System.out.println("Digite a porcentagem da taxa:");
					aux_d = S.nextDouble();		
					HT.get(aux).set_service_tax(aux_d);
				}
			}
		}
	}
	
	

}
