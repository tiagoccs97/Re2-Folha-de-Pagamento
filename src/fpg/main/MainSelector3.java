package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import fpg.employees.Employee;
import fpg.employees.Hourly;
import fpg.undo_redo.Undo_Redo;

public class MainSelector3 {
  public static int card(Map<Integer, Employee> HT, Scanner S, int array_position) {
	  int current_employee_id = 0;
	  boolean acceptInput = false;
		//Try
	  while (!acceptInput) {
			try {
				System.out.println("Digite o ID do funcionario desejado: ");
				current_employee_id = S.nextInt();
				acceptInput = false;
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor inteiro!!!");
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!!!");
			} 
			if(current_employee_id<0) {
				acceptInput = true;
				System.out.println("Digite um valor inteiro positivo!!!");
			} 
		}
		S.nextLine();
		
		
		if(HT.containsKey(current_employee_id)) {
			if(HT.get(current_employee_id).get_type() == 'H') {
				int arrival = -1,exit = -1;
				if(HT.get(current_employee_id) instanceof Employee) {
					boolean acceptindex = true;
					Hourly current_employee = (Hourly) HT.get(current_employee_id);
					if(current_employee.get_check_setofday() == 0) {
						Hourly aux_hourly = new Hourly(-1,-1,0,0,current_employee.get_name(),current_employee.get_adress(),current_employee.get_type(),current_employee.get_payment_method(),current_employee.get_agenda(),current_employee.get_id(),current_employee.get_salary(),current_employee.get_syndicate(),current_employee.get_syndicate_tax());
						aux_hourly.set_arrival_time(-1);
						aux_hourly.set_exittime(-1);
						aux_hourly.set_daily_payment(0);
						current_employee.get_PaymentDaily().add(aux_hourly);
						current_employee.set_check_setofday(1);
						array_position = current_employee.get_PaymentDaily().size()-1;
					}
					if(current_employee.get_check_setofday() == 1){
						//Try
						try {
							current_employee.get_PaymentDaily().get(array_position).get_arrival_time();
						}
						catch(IndexOutOfBoundsException e) {
							System.out.println("Nao foi possivel acessar.Necessario informar hora de chegada novamente.Selecione a opcao novamente.");
							array_position--;
							acceptindex = false;
						}
						if(acceptindex)
						{
							if((current_employee.get_PaymentDaily().get(array_position).get_arrival_time() == -1)) {
								System.out.println("Informe a hora de chegada do empregado: ");
								//Try
								
								try{
									arrival = S.nextInt();
									
								}
								catch(NumberFormatException e){
									System.out.println("Valor no formato incorreto. Digite novamente:");
								}
								catch(InputMismatchException e) {
									System.out.println("Valor no formato incorreto. Digite novamente:");
								}
								S.nextLine();
								
								
								current_employee.get_PaymentDaily().get(array_position).set_arrival_time(arrival);
							}
							else if(current_employee.get_PaymentDaily().get(array_position).get_exittime() == -1) {
									System.out.println("Informe a hora de saida do empregado: ");
									//Try
									
									try{
										exit = S.nextInt();
											
									}
									catch(NumberFormatException e){
										System.out.println("Valor no formato incorreto. Digite novamente:");
									}
									catch(InputMismatchException e) {
										System.out.println("Valor no formato incorreto. Digite novamente:");
									}
									S.nextLine();
									
									
									current_employee.get_PaymentDaily().get(array_position).set_exittime(exit);
							}
						}
					}
				}
				else System.out.println("Nao foi possivel associar empregado.");
			}
			else System.out.println("Empregado nao e horista.");
		}
		else System.out.println("Nao foi possivel encontrar o empregado.");
		
		System.out.println("Pressione enter para continuar.");
		S.nextLine();
		return array_position;
  	}
  
}
