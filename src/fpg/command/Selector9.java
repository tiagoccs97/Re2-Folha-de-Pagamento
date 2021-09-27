package fpg.command;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import fpg.employees.Employee;
import fpg.agenda.*;

public class Selector9 {
	public static void modify_agenda(Map<Integer, Employee> HT, Scanner S){
		
		int id=0;
		int aux=0;
		boolean acceptInput = false;
		Roll.show_employee_list(HT);
		while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario desejado: ");
				id = S.nextInt();
				acceptInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!!!");
			} 
			if(id<0) {
				acceptInput = false;
				System.out.println("Digite um valor inteiro positivo!!!");
			} 
		}
		System.out.println("Este funcionario tem a agenda: " + HT.get(id).get_agenda().show_agenda_type());
		System.out.println();
		acceptInput = false;
		while (!acceptInput) {
			try {				
				System.out.println("Deseja mudar a agenda? (1 - Sim, 2 - Nao)");
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
		acceptInput = false;
		if(aux ==  1) {
			while (!acceptInput) {
				try {
					System.out.println("Digite o numero da nova agenda: (Ex: 1 - Semanal, 2 - Bi-Semanal, 3 - Mensal) ");
					aux = S.nextInt();
					acceptInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Digite um numero correto!!!");
				} 		
				if(aux < 1 || aux > 3) {
					acceptInput = false;
					System.out.println("Digite um numero com algum valor do exemplo!!!");
				}
			} 
			if(aux == 1) {
				WeeklyAgenda newAgenda = new WeeklyAgenda();
				copyAgenda(HT, id, newAgenda);
				HT.get(id).set_agenda(newAgenda);
			}
			else if(aux == 2) {
				BiWeeklyAgenda newAgenda = new BiWeeklyAgenda();
				copyAgenda(HT, id, newAgenda);
				HT.get(id).set_agenda(newAgenda);
			}
			else if(aux == 3) {
				MonthlyAgenda newAgenda = new MonthlyAgenda();
				copyAgenda(HT, id, newAgenda);
				HT.get(id).set_agenda(newAgenda);
			}
			System.out.println("Agenda atualizada com sucesso!!!");
			System.out.println();
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
