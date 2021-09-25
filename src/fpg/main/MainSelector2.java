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
		System.out.println("Digite o ID do funcionario a ser removido:");
		while (!acceptInput) {
			try {
				aux = S.nextInt();
				acceptInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
				System.out.println("Operacao nao realizada, voltando ao menu...");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!!!");
				System.out.println("Operacao nao realizada, voltando ao menu...");
			} 
		}
		if (acceptInput) {
			HT.remove(aux);
			System.out.println("Operaçao realizada com sucesso");
		}
	}
}
