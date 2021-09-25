package fpg.payment;
import fpg.employees.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PaymentDay {
	String schedule;
	Character employee_type;
	
	//Gets
	public String get_schedule() {
		return schedule;
	}
	public int get_employee_type() {
		return employee_type;
	}
	//Sets
	public void set_schedule(String schedule) {
		this.schedule = schedule;
	}
	public void set_employee_type(Character employee_type) {
		this.employee_type = employee_type;
	}	
	
	public static void check_payments(Map<Integer,Employee> HT,int day,int month,int year,int week_day,int totalsize) {
		System.out.println("Hoje: " + day + "/" + month + "/" + year + " Dia da Semana: " + week_day);
		int has_employees = 0;
		System.out.println("\nFOLHA DE PAGAMENTO:");
		for(int i = 0;i <= totalsize;i++) {
			if(HT.containsKey(i)) {
				if((HT.get(i).get_payment_day() == day) && (HT.get(i).get_payment_month() == month) && (HT.get(i).get_payment_year() == year) && (HT.get(i).get_payment_week_day() == week_day)) {
					has_employees++;
					System.out.println("Nome: " + HT.get(i).get_name());
					System.out.println("Endereco: " + HT.get(i).get_adress());
					System.out.println("Tipo: " + HT.get(i).get_type());
					System.out.println("Tipo de Pagamento: " + HT.get(i).get_payment_method());
					if(HT.get(i).get_syndicate() == true) {
						if(HT.get(i) instanceof Employee) {
							System.out.println("Faz parte do Sindicato");
							System.out.println("ID do Sindicato: " + HT.get(i).get_id_s());
							Employee.calculate_syndicate(HT, i);
							System.out.println("Taxa de Sindicato: " + HT.get(i).get_syndicate_tax());
							if(HT.get(i).get_service_tax() != 0) {
								System.out.println("Taxa de Servico do Sindicato: " + HT.get(i).get_service_tax());
								HT.get(i).set_service_tax(0);
							}
							else System.out.println("Nao ha Taxas de Servico do Sindicato");
						}
						else System.out.println("Nao foi possivel associar empregado.");
					}
					else System.out.println("Nao faz parte de Sindicato");
					System.out.println("Pagamento: " + HT.get(i).get_payment());
					System.out.println("---------------------------------------");
					HT.get(i).set_first_day(day);
					HT.get(i).set_first_month(month);
					HT.get(i).set_first_year(year);
					HT.get(i).set_first_week_day(week_day);
					PaymentDay.set_payment_schedule(HT,i);
					if(HT.get(i).get_type() == 'H') {
						if(HT.get(i) instanceof Employee) {
							Hourly aux_employee = (Hourly) HT.get(i);
							aux_employee.get_PaymentDaily().clear();
						}
						else System.out.println("Funcionario nao associado, operacao nao realizada!");
					}
					else if(HT.get(i).get_type() ==  'C') {
						if(HT.get(i) instanceof Employee) {
							Commissioned aux_employee = (Commissioned) HT.get(i);
							double aux_sells = aux_employee.get_sells();
							aux_sells = aux_sells * -1;
							aux_employee.set_sells(aux_sells);
						}
						else System.out.println("Funcionario nao associado, operacao nao realizada!");	
					}
					HT.get(i).set_payment(0);
				}
			}
		}	
		if(has_employees == 0) {
			System.out.println("Nao ha nenhum funcionario a ser pago hoje");
		}
		System.out.println();
	}
	
	public static void set_payment_schedule(Map<Integer,Employee> HT,int aux) {
		if(HT.get(aux).get_type() == 'H') {
			String current_schedule = HT.get(aux).get_agenda();
			int DayIWant = 0;
			if(current_schedule.equals("Segunda Semanal")) DayIWant = 2;
			else if(current_schedule.equals("Terca Semanal")) DayIWant = 3;
			else if(current_schedule.equals("Quarta Semanal")) DayIWant = 4;
			else if(current_schedule.equals("Quinta Semanal"))  DayIWant = 5;
			else if(current_schedule.equals("Sexta Semanal") || current_schedule.equals("Semanalmente")) DayIWant = 6;
				
			int dayp,monthp,yearp,week_dayp;
			dayp = HT.get(aux).get_first_payment_day();
			monthp = HT.get(aux).get_first_payment_month();
			yearp = HT.get(aux).get_first_payment_year();
			week_dayp = HT.get(aux).get_first_week_day(); 
				
			pass_Ndays(7, dayp, monthp, yearp, week_dayp, DayIWant, -1);
			
			HT.get(aux).set_payment_day(dayp);
			HT.get(aux).set_payment_month(monthp);
			HT.get(aux).set_payment_year(yearp);
			HT.get(aux).set_payment_week_day(week_dayp);
		}
		else if(HT.get(aux).get_type() == 'A'){
			if(HT.get(aux).get_agenda() == "Mensalmente") {
				int dayp,monthp,yearp,week_dayp;
				dayp = HT.get(aux).get_first_payment_day();
				monthp = HT.get(aux).get_first_payment_month();
				yearp = HT.get(aux).get_first_payment_year();
				week_dayp = HT.get(aux).get_first_week_day(); 
				
				pass_Ndays(30, dayp, monthp, yearp, week_dayp, -1, -1);
				
				if(week_dayp == 7) {
					dayp += 2;
				} 
				else if(week_dayp == 1) {
					dayp += 1;
				}
				HT.get(aux).set_payment_day(dayp);
				HT.get(aux).set_payment_month(monthp);
				HT.get(aux).set_payment_year(yearp);
				HT.get(aux).set_payment_week_day(week_dayp);
			}
			else {
				String current_schedule = HT.get(aux).get_agenda();
				String now = null;
				int DayOFMonth = 0;
				now = current_schedule;
				DayOFMonth = Integer.parseInt(now);
				
				int dayp,monthp,yearp,week_dayp;
				dayp = HT.get(aux).get_first_payment_day();
				monthp = HT.get(aux).get_first_payment_month();
				yearp = HT.get(aux).get_first_payment_year();
				week_dayp = HT.get(aux).get_first_week_day();
				
				
				
				for(int i = 0;i < 31;i++) {
					if(DayOFMonth == 31 && (monthp == 4 || monthp == 6 || monthp == 9 || monthp == 11)) DayOFMonth = 30;
					else if(DayOFMonth == 31 && monthp == 2) DayOFMonth = 28;
					dayp++;
					week_dayp++;
					if(dayp == DayOFMonth) break;
					if(week_dayp == 8) week_dayp = 1;
					else if(dayp == 29 && monthp == 2) {
						dayp = 1;
						monthp++;
					}
					if(dayp == 31 && (monthp == 4 || monthp == 6 || monthp == 9 || monthp == 11)) {
						dayp = 1;
						monthp++;
					}
					else if(dayp == 32) {
						dayp = 1;
						monthp++;
					}
					if(monthp == 13) {
						monthp = 1;
						yearp++;
					}
				}
				HT.get(aux).set_payment_day(dayp);
				HT.get(aux).set_payment_month(monthp);
				HT.get(aux).set_payment_year(yearp);
				HT.get(aux).set_payment_week_day(week_dayp);
			}
		}
		else if(HT.get(aux).get_type() == 'C') {
			
			String current_schedule = HT.get(aux).get_agenda();
			int DayIWant = 0;
			if(current_schedule == "Segunda Semanal") DayIWant = 2;
			else if(current_schedule == "Terca Semanal") DayIWant = 3;
			else if(current_schedule == "Quarta Semanal") DayIWant = 4;
			else if(current_schedule == "Quinta Semanal")  DayIWant = 5;
			else if(current_schedule == "Sexta Semanal" || current_schedule == "Bi-Semanalmente") DayIWant = 6;
			
			int dayp,monthp,yearp,week_dayp;
			dayp = HT.get(aux).get_first_payment_day();
			monthp = HT.get(aux).get_first_payment_month();
			yearp = HT.get(aux).get_first_payment_year();
			week_dayp = HT.get(aux).get_first_week_day(); 
			
			pass_Ndays(15, dayp, monthp, yearp, week_dayp, DayIWant, 2);
			
			HT.get(aux).set_payment_day(dayp);
			HT.get(aux).set_payment_month(monthp);
			HT.get(aux).set_payment_year(yearp);
			HT.get(aux).set_payment_week_day(week_dayp);
		}
	}
	public static void modify_schedule(Map<Integer, Employee> HT, int y, Scanner S, ArrayList<PaymentDay> Payment_Schedules,
			int day, int aux) throws NumberFormatException {
		String entry;
		System.out.println("Agenda de Pagamento atual - O Empregado e pago: " + HT.get(y).get_agenda());
		System.out.println("Deseja modificar a Agenda de Pagamento? Se sim, pressione 1. Se nao, pressione enter");
		entry = S.nextLine();
		if (entry.equals("1")) {
			boolean acceptindex = true;
			System.out.println("Informe uma das opcoes abaixo: ");
			for (int i = 0; i < Payment_Schedules.size(); i++) {
				try {
					Payment_Schedules.get(i);
				} catch (IndexOutOfBoundsException e) {
					acceptindex = false;
				}
				if (acceptindex) {
					if (HT.get(y).get_type() == Payment_Schedules.get(i).get_employee_type()) {
						System.out.println(Payment_Schedules.get(i).get_schedule());
					}
					acceptindex = true;
				}
			}
			acceptindex = true;
			boolean validateschedule = false;
			String schedule;
			schedule = S.nextLine();
			for (int i = 0; i < Payment_Schedules.size(); i++) {
				try {
					Payment_Schedules.get(i);
				} catch (IndexOutOfBoundsException e) {
					acceptindex = false;
				}
				if (acceptindex) {
					if (schedule.equals(Payment_Schedules.get(i).get_schedule())) {
						validateschedule = true;
						break;
					}
					acceptindex = true;
				}
			}
			if (validateschedule) {
				if (HT.get(y).get_type() == 'A' && (!(schedule.equals("Mensalmente")) && (!(schedule.equals("Mensal"))))) {
					String now = null;
					int DayOFMonth = 0;
					now = schedule;
					DayOFMonth = Integer.parseInt(now);
					if (DayOFMonth > day) {
						HT.get(y).set_agenda(schedule);
						PaymentDay.set_payment_schedule(HT, y);
					} else
						System.out.println("Nao foi possivel atualizar, data invalida");
				} else {
					HT.get(y).set_agenda(schedule);
					PaymentDay.set_payment_schedule(HT, aux);
				}
			} else
				System.out.println("Agenda nao existe.");
		}
	}
	public static void pass_Ndays(int N, int dayp, int monthp, int yearp, int week_dayp, int DayIWant, int freq) {
		int totaldays=0;
		for(int i = 0;i < N+1;i++) {
			dayp++;
			week_dayp++;
			if(week_dayp == 8) week_dayp = 1;
			if(week_dayp == DayIWant) {
				totaldays++;
			}
			if(week_dayp == DayIWant && totaldays == freq) {
				break;
			}
			if(dayp == 29 && monthp == 2) {
				dayp = 1;
				monthp++;
			}
			if(dayp == 31 && (monthp == 4 || monthp == 6 || monthp == 9 || monthp == 11)) {
				dayp = 1;
				monthp++;
			}
			else if(dayp == 32) {
				dayp = 1;
				monthp++;
			}
			if(monthp == 13) {
				monthp = 1;
				yearp++;
			}
		}
		
	}
}