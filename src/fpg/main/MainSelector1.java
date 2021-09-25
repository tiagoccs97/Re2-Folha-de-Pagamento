package fpg.main;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fpg.agenda.Calendar_Save;
import fpg.agenda.MonthlyAgenda;
import fpg.employees.Commissioned;
import fpg.employees.Employee;
import fpg.employees.Hourly;
import fpg.agenda.*;

public class MainSelector1 {
	public static void add_employee(Employee A, Map<Integer,Employee> HT, Scanner S, Count count, Calendar_Save Date) {
		
		int payment_method=1;		
		char type='A';
		boolean syndicate=false;
		double salary=0;
		double syndicate_tax=0;
		double aux_d=0;
		String name;
		String adress;
		
		System.out.println("Digite o Nome do empregado:");
		name = S.nextLine();				
		System.out.println("Digite o Endereço do funcionario:");
		adress = S.nextLine();					
		try {
			System.out.println("Digite o Tipo de funcionario:");
			System.out.println("A - Assalariado");
			System.out.println("H - Horista");
			System.out.println("C - Comissionado");
			type = S.next().charAt(0);						
		}		
		catch(NullPointerException e) {
			System.out.println("Digite um caractere valido!!!");
		}
		catch(InputMismatchException e) {
			System.out.println("Digite um caractere valido!!!");
		}
		try{
			System.out.println("Digite o Metodo de Pagamento do funcionario:");
			System.out.println("1 - Cheque pelos correios");
			System.out.println("2 - Cheque em mãos");
			System.out.println("3 - Deposito em conta bancaria");
			payment_method = S.nextInt();
		}	
		catch(NullPointerException e) {
			System.out.println("Digite um numero valido!!!");
		}
		catch(InputMismatchException e) {
			System.out.println("Digite um numero valido!!!");
		}
		catch(NumberFormatException e) {
			System.out.println("Digite um numero valido!!!");
		}
		
		
		try{
			System.out.println("O empregado pertence a um sindicato? (true - sim; false - não)");
			syndicate = S.nextBoolean();
		}	
		catch(NullPointerException e) {
			System.out.println("Digite uma alternativa valida!!!");

		}
		catch(InputMismatchException e) {
			System.out.println("Digite uma alternativa valida!!!");
		}
		if(type == 'A') {
			try{
				System.out.println("Digite o salario mensal:");
				salary = S.nextDouble();
			}
			catch(NullPointerException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(InputMismatchException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(NumberFormatException e) {
				System.out.println("Digite um numero valido!!!");
			}
			
			if(syndicate == true) {
				System.out.println("Digite a taxa sindical deste funcionario");
				syndicate_tax = S.nextDouble();
				A.set_syndicate_tax(syndicate_tax);
				A.set_id_s(count.get_id_synd()+100);
				count.add_id_synd();
			}
			A = new Employee(name, adress, type, payment_method, new MonthlyAgenda(), count.get_id(), salary, syndicate, syndicate_tax);
			A.get_agenda().set_first_date(Date);	
			A.get_agenda().set_payment_date(Date);
			HT.put(count.get_id(), A);					
		}	
		else if(type == 'H') {
			try{						
				System.out.println("Digite o salario por hora trabalhada:");
				salary = S.nextDouble();
			}
			catch(NullPointerException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(InputMismatchException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(NumberFormatException e) {
				System.out.println("Digite um numero valido!!!");
			}
			
			A = new Hourly(-1, -1, 0, 0, name, adress, type, payment_method, new MonthlyAgenda(), count.get_id(), salary, syndicate, syndicate_tax);
			A.get_agenda().set_first_date(Date);	
			A.get_agenda().set_payment_date(Date);
			if(syndicate == true) {
				System.out.println("Digite a taxa sindical deste funcionario");
				syndicate_tax = S.nextDouble();
				A.set_syndicate_tax(syndicate_tax);
				A.set_id_s(count.get_id_synd()+100);
				count.add_id_synd();
			}
			HT.put(count.get_id(), A);							
		}	
		else if(type == 'C') {
			try{						
				System.out.println("Digite a porcentagem da commissao:");
				aux_d = S.nextDouble();
			}
			catch(NullPointerException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(InputMismatchException e) {
				System.out.println("Digite um numero valido!!!");
			}
			catch(NumberFormatException e) {
				System.out.println("Digite um numero valido!!!");
			}					
			A = new Commissioned(0 , 0, name, adress, type, payment_method, new MonthlyAgenda(), count.get_id(), salary, syndicate, syndicate_tax);
			A.get_agenda().set_first_date(Date);	
			A.get_agenda().set_payment_date(Date);
			
			if(syndicate == true) {
				System.out.println("Digite a taxa sindical deste funcionario:");
				syndicate_tax = S.nextDouble();
				A.set_syndicate_tax(syndicate_tax);
				A.set_id_s(count.get_id_synd()+100);
				count.add_id_synd();;
			}
			HT.put(count.get_id(), A);									
		}				
		System.out.println();
		System.out.println("Os dados de " + name + " foram adicionados com sucesso!");
		System.out.println();
		
	}

}
