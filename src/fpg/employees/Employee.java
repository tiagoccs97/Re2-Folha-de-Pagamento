package fpg.employees;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import fpg.payment.*;
import fpg.undo_redo.*;
import fpg.agenda.*;
import java.util.Scanner;

public class Employee {
	
	private String name;
	private String adress;
	private int id;
	private int id_s;
	private int payment_method;
	private char type;
	private boolean syndicate;
	private double syndicate_tax;
	private double service_tax;
	private double salary;
	private double payment;
	private AgendaStrategy agenda;

	//Gets
	
	public String get_name(){
		return name;
	}
	public String get_adress(){
		return adress;
	}
	public int get_id(){
		return id;
	}
	public int get_id_s(){
		return id_s;
	}
	public int get_payment_method(){
		return payment_method;
	}
	public char get_type(){
		return type;
	}
	public boolean get_syndicate(){
		return syndicate;
	}
	public double get_syndicate_tax(){
		return syndicate_tax;
	}
	public double get_service_tax(){
		return service_tax;
	}
	public double get_salary(){
		return salary;
	}
	public AgendaStrategy get_agenda(){
		return agenda;
	}
	public double get_payment(){
		return payment;
	}
	//Sets
	
	public void set_name(String name) {
		this.name = name;		
	}
	public void set_adress(String adress) {
		this.adress = adress;		
	}
	public void set_id(int id) {
		this.id = id;
	}
	public void set_id_s(int id_s) {
		this.id_s = id_s;
	}	
	
	public void set_first_payment_method(int payment_method){
		this.payment_method = payment_method;		
	}
	public void set_type(char type){
		this.type = type;		
	}
	public void set_syndicate(boolean syndicate){
		this.syndicate = syndicate;
	}
	public void set_syndicate_tax(double syndicate_tax){
		this.syndicate_tax = syndicate_tax;
	}
	public void set_service_tax(double service_tax){
		this.service_tax += service_tax;
	}
	public void set_salary(double salary){
		this.salary = salary;
	}
	public void set_agenda(MonthlyAgenda agenda){
		this.agenda = agenda;
	}
	public void set_payment(double payment){
		this.payment = payment;
	}
	
	//Constructor
	
	public Employee(String name, String adress, char type, int payment_method, AgendaStrategy agenda,int id, double salary,boolean syndicate,double syndicate_tax) {
		
		this.name = name;
		this.adress = adress;
		this.type = type;
		this.payment_method = payment_method;
		this.agenda = agenda;		
		this.id = id;
		this.salary = salary;
		this.syndicate = syndicate;
		this.syndicate_tax = syndicate_tax;
		this.id_s = id + 100;
		this.service_tax = 0;
	}
	public Employee() {
		this.id = -1;
		this.id_s = -1;
		this.name = "0";
		this.adress = "0";
		this.type = 'A';
		this.payment_method = -1;
		this.syndicate = false;
		this.syndicate_tax = 0;
		this.service_tax = 0;
		this.agenda = new MonthlyAgenda();
		this.salary=0;
	}
	// Funções adicionais
	public void show_employee_data() {
		
		String aux_type = "0";
		String aux_syndicate = "0";
		String aux_pmethod= "0";
		if(this.syndicate == true)  {aux_syndicate = "true";}
		if(this.syndicate == false)  {aux_syndicate = "false";}
		
		if(this.type == 'A') {aux_type = "Assalaried";}
		else if(this.type == 'H') {aux_type = "Hourly";}
		else if(this.type == 'C') {aux_type = "Commissioned";}	
		
		if(this.payment_method == 1) {aux_pmethod = "Cheque pelos correios";}
		else if(this.payment_method == 2) {aux_pmethod = "Cheque em mãos";}
		else if(this.payment_method == 3) {aux_pmethod = "Deposito em conta bancaria";}	
		
		if(syndicate == true) System.out.print("ID: " + this.id + "\n" + "ID do Sindicato: " + this.id_s + "\n" + "Nome: " + this.name + "\n" + "Endereco: " + this.adress + "\n" + "Tipo de funcionario: " + aux_type + "\n" + "Metodo de pagamento: " + aux_pmethod + "\n" + "Pertente ao sindicato: " + aux_syndicate + "\n" + "Primeiro dia da semana: " + this.agenda.get_first_week_day() + "\n" + "Primeiro dia de cadastro: " + this.agenda.get_first_payment_day() + "\n" + "Primeiro mes de cadastro: " + this.agenda.get_first_payment_month() + "\n" + "Primeiro ano de cadastro: " + this.agenda.get_first_payment_year() + "\n" + "Agenda de pagamento: " + this.agenda.show_agenda_type() + "\n");
		else System.out.print("ID: " + this.id + "\n" + "Nome: " + this.name + "\n" + "Endereco: " + this.adress + "\n" + "Tipo de funcionario: " + aux_type + "\n" + "Metodo de pagamento: " + aux_pmethod + "\n" + "Pertente ao sindicato: " + aux_syndicate + "\n" + "Primeiro dia da semana: " + this.agenda.get_first_week_day() + "\n" + "Primeiro dia de cadastro: " + this.agenda.get_first_payment_day() + "\n" + "Primeiro mes de cadastro: " + this.agenda.get_first_payment_month() + "\n" + "Primeiro ano de cadastro: " + this.agenda.get_first_payment_year() + "\n" + "Agenda de pagamento: " + this.agenda.show_agenda_type() + "\n");
		System.out.println("--------------------------------------------------------");
	}
	public void change_employee_data(Employee aux) {
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
			int aux_int = -1;
			String aux_n;
			double aux_d=0;
			int aux_i;
			boolean aux_b;
			System.out.println("Deseja alterar o Nome? (1 = Sim / 2 = Nao)");
			aux_int = read.nextInt();
			read.nextLine();
			if(aux_int == 1) {
				System.out.println("Digite o novo nome:");
				aux_n = read.nextLine();
				this.name = aux_n;
				aux_int = -1;
			}
			System.out.println("Deseja alterar o Endereco? (1 = Sim / 2 = Nao)");
			aux_int = read.nextInt();
			read.nextLine();
			if(aux_int == 1) {
				System.out.println("Digite o novo endereco:");
				aux_n = read.nextLine();
				this.adress = aux_n;
				aux_int = -1;
			}
			System.out.println("Deseja alterar o tipo de funcionario? (1 = Sim / 2 = Nao)");
			aux_int = read.nextInt();
			read.nextLine();
			if(this.type == 'A') {
				try{
					System.out.println("Digite o salario mensal:");
					aux_d = read.nextDouble();
				}
				catch(InputMismatchException e) {
					System.out.println("Digite um numero valido!!!");
				}
				catch(NumberFormatException e) {
					System.out.println("Digite um numero valido!!!");
				}				
				aux.set_salary(aux_d);											
			}	
			else if(this.type == 'H') {
				try {						
					System.out.println("Digite o salario por hora trabalhada:");
					aux_d = read.nextDouble();
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
					Hourly aux1 = (Hourly) aux;
					aux1.set_salary(aux_d);
										
			}	
			else if(this.type == 'C') {
				try{						
					System.out.println("Digite a porcentagem da commissao:");
					aux_d = read.nextDouble();
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
				Commissioned aux2 = (Commissioned) aux;
				aux2.set_commission_percentage(aux_d);									
			}	
			System.out.println("Deseja alterar o metodo de pagamento do funcionario? (1 = Sim / 2 = Nao)");
			aux_int = read.nextInt();
			if(aux_int == 1) {
				System.out.println("Digite um dos numeros seguintes:");
				System.out.println("1 - Cheque pelos correios");
				System.out.println("2 - Cheque em mãos");
				System.out.println("3 - Depósito em conta bancaria");
				aux_i = read.nextInt();
				this.payment_method = aux_i;
				aux_int = -1;
			}
			System.out.println("Deseja alterar se o funcionario pertence a um sindicato? (1 = Sim / 2 = Nao)");
			aux_int = read.nextInt();
			if(aux_int == 1) {
				System.out.println("Digite: true = sim / false = nao");
				aux_b = read.nextBoolean();
				this.syndicate = aux_b;
				aux_int = -1;
				if(aux_b == true) {
					System.out.println("Deseja alterar a taxa sindical? (1 = Sim / 2 = Nao)");
					aux_int = read.nextInt();
					if(aux_int == 1) {
						System.out.println("Digite o novo valor da taxa sindical para este funcionario:");
						aux_d = read.nextDouble();
						this.syndicate_tax = aux_d;
						aux_int = -1;
					}
					System.out.println("Deseja alterar a taxa de servico? (1 = Sim / 2 = Nao)");
					aux_int = read.nextInt();
					if(aux_int == 1) {
						System.out.println("Digite o novo valor da taxa de serviço:");
						aux_d = read.nextDouble();
						this.service_tax = aux_d;
						aux_int = -1;
					}
				}
			}
			
		
		System.out.println("Dados alterados com sucesso!");
		System.out.println();
		
	}
	public static int add_employee(Employee A, Map<Integer,Employee> HT, Scanner S, int count_id, int count_s, Calendar_Save Date) {
		
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
				A.set_id_s(count_s+100);
				count_s++;
			}
			A = new Employee(name, adress, type, payment_method, new MonthlyAgenda(), count_id, salary, syndicate, syndicate_tax);
			A.agenda.set_first_date(Date);	
			A.agenda.set_payment_date(Date);
			HT.put(count_id, A);					
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
			
			A = new Hourly(-1, -1, 0, 0, name, adress, type, payment_method, new MonthlyAgenda(), count_id, salary, syndicate, syndicate_tax);
			A.agenda.set_first_date(Date);	
			A.agenda.set_payment_date(Date);
			if(syndicate == true) {
				System.out.println("Digite a taxa sindical deste funcionario");
				syndicate_tax = S.nextDouble();
				A.set_syndicate_tax(syndicate_tax);
				A.set_id_s(count_s+100);
				count_s++;
			}
			HT.put(count_id, A);							
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
			A = new Commissioned(0 , 0, name, adress, type, payment_method, new MonthlyAgenda(), count_id, salary, syndicate, syndicate_tax);
			A.agenda.set_first_date(Date);	
			A.agenda.set_payment_date(Date);
			if(syndicate == true) {
				System.out.println("Digite a taxa sindical deste funcionario:");
				syndicate_tax = S.nextDouble();
				A.set_syndicate_tax(syndicate_tax);
				A.set_id_s(count_s+100);
				count_s++;
			}
			HT.put(count_id, A);									
		}				
		System.out.println();
		System.out.println("Os dados de " + name + " foram adicionados com sucesso!");
		System.out.println();
		
		return count_s;
	}
	public static void calculate_syndicate(Map<Integer,Employee> HT,int aux) {
		CalculatePaymentStrategy A = new AssalariedPayment();
		Calculate_payment calc = new Calculate_payment(A);
		calc.begin_syndicate(HT.get(aux));
	}
	
	
	public static void calculate_payment(Map<Integer,Employee> HT,int aux) {
		CalculatePaymentStrategy A = new AssalariedPayment();
		Calculate_payment calc = new Calculate_payment(A);
		calc.begin_salary(HT.get(aux));
	}

}


