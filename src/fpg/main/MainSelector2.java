package fpg.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import fpg.employees.*;
import java.util.Map;
import java.util.HashMap;

public class MainSelector2 {
	
	public static void remove(Map<Integer, Employee> HT, Scanner S) {
		int aux=0;
		boolean acceptInput = false;
		while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario a ser removido:");
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
		if (acceptInput) {
			HT.remove(aux);
			System.out.println("Opera�ao realizada com sucesso");
		}
	}
}
