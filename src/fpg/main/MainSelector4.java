package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fpg.employees.Commissioned;
import fpg.employees.Employee;

public class MainSelector4 {
	
	public static void sell_result(Map<Integer, Employee> HT, Scanner S)
	{
		int aux=0;
		boolean acceptInput = false;
		double aux_d;
		String sell_date;
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
		S.nextLine();
		
			System.out.println("Digite um valor inteiro!!!");
			System.out.println("Operacao nao realizada, voltando ao menu...");
			S.next();					
		
		 if(HT.get(aux).get_type() != 'C') {
			System.out.println("Escolha um funcionario Comissionado!!!");
			System.out.println("Operacao nao realizada, voltando ao menu...");
			S.next();
		
		
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
	}
	
}
