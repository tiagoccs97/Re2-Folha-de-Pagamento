package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fpg.employees.Commissioned;
import fpg.employees.Employee;

public class MainSelector4 {
	
	public static void sell_result(Map<Integer, Employee> HT, Scanner S) {

		int aux=0;
		boolean acceptInput = false;
		double aux_d=0;
		String sell_date;
		Main.show_employee_list(HT);
		while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario desejado: ");
				aux = S.nextInt();
				S.nextLine();
				acceptInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor correto!!!");
			} 
			if(aux<0) {
				acceptInput = false;
				System.out.println("Digite um valor inteiro positivo!!!");
			} 
		}		
		 if(HT.get(aux).get_type() == 'C') {		
			Commissioned aux_commissioned = (Commissioned) HT.get(aux);
			System.out.println("Digite a data da venda");
			sell_date = S.nextLine();
			System.out.println("Digite o valor da venda:");
			aux_d = S.nextDouble();
			aux_commissioned.set_sells(aux_d);
			System.out.println("Venda lancada com sucesso, confira os dados da venda:");
			System.out.println("Data da venda: " + sell_date + " Valor da venda: " + aux_d);
			System.out.println();
		 }
		 else {
			 System.out.println("Operaçao nao realizada, escolha um funcionario comissionado!!!");
			 System.out.println();			 
		 }
	}	
}
