package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fpg.employees.Employee;
import fpg.payment.PaymentDay;
import fpg.agenda.*;

public class MainSelector9 {
	public static void modify_agenda(Map<Integer, Employee> HT, Scanner S){
		int aux=0;
		String aux_S = null;
		boolean acceptInput = false;
		System.out.println("Digite o ID do funcionario desejado:");
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
		System.out.println("Este funcionario tem a agenda: " + HT.get(aux).get_agenda().show_agenda_type());
		System.out.println();
		acceptInput = false;
		while (!acceptInput) {
			try {				
				System.out.println("Deseja mudar a agenda? (1 - Sim, 2 - Nao");
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
		if(aux ==  1) {
			while (!acceptInput) {
				try {
					System.out.println("Digite o nome da nova agenda: (Ex: Semanal, Bi-Semanal, Mensal) ");
					aux_S = S.nextLine();
					acceptInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Digite um nome correto!!!");
				} 
				if(aux_S != "Semanal" && aux_S != "Mensal" && aux_S != "Semanal") {
					acceptInput = false;
					System.out.println("Digite um nome correto!!!");
				}
			} 
			if(aux_S == "Semanal") {
				WeeklyAgenda newAgenda = new WeeklyAgenda();
				copyAgenda(HT, aux, newAgenda);
				HT.get(aux).set_agenda(newAgenda);
			}
			else if(aux_S == "Mensal") {
				MonthlyAgenda newAgenda = new MonthlyAgenda();
				copyAgenda(HT, aux, newAgenda);
				HT.get(aux).set_agenda(newAgenda);
			}
			else if(aux_S == "Bi-Semanal") {
				BiWeeklyAgenda newAgenda = new BiWeeklyAgenda();
				copyAgenda(HT, aux, newAgenda);
				HT.get(aux).set_agenda(newAgenda);
			}
		}
		
	}
	public static void copyAgenda(Map<Integer, Employee> HT, int aux, AgendaStrategy newAgenda) {
		newAgenda.set_first_day(HT.get(aux).get_agenda().get_first_day());
		newAgenda.set_first_month(HT.get(aux).get_agenda().get_first_month());
		newAgenda.set_first_year(HT.get(aux).get_agenda().get_first_year());
		newAgenda.set_first_week_day(HT.get(aux).get_agenda().get_first_week_day());
		newAgenda.set_payment_day(HT.get(aux).get_agenda().get_first_day());
		newAgenda.set_payment_month(HT.get(aux).get_agenda().get_first_day());
		newAgenda.set_payment_year(HT.get(aux).get_agenda().get_first_day());
		newAgenda.set_payment_week_day(HT.get(aux).get_agenda().get_first_day());
	}

}
