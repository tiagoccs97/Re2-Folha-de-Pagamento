package fpg.main;
import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import fpg.employees.*;
import fpg.payment.*;
import fpg.agenda.*;

public class Main {	
	public static void main(String[] args) {		
		int sel = -1;
		int array_position=-1;		
		Count count = new Count(0, 0);		
		Scanner S = new Scanner(System.in);
		Map<Integer, Employee> HT = new HashMap<Integer, Employee>();	
		ArrayList<PaymentDay> Payment_Schedules = new ArrayList<PaymentDay>();
		Employee A = new Employee();	
		//Calendario
		Calendar newCalendar = Calendar.getInstance();
		Calendar_Save Date = new Calendar_Save(newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.MONTH)+1, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.DAY_OF_WEEK));
		PaymentDay SetDefault0 = new PaymentDay();
		SetDefault0.set_schedule("Semanalmente");
		SetDefault0.set_employee_type('H');
		Payment_Schedules.add(SetDefault0);
		
		PaymentDay SetDefault1 = new PaymentDay();
		SetDefault1.set_schedule("Mensalmente");
		SetDefault1.set_employee_type('A');
		Payment_Schedules.add(SetDefault1);
		
		PaymentDay SetDefault2 = new PaymentDay();
		SetDefault2.set_schedule("Bi-semanalmente");
		SetDefault2.set_employee_type('C');
		Payment_Schedules.add(SetDefault2);
		//Done
				
		while  (sel != 0) { //Comeca a rodar a folha e mostra as opcoes					
			System.out.println("Selecione uma das opcoes:");
			System.out.println();
			System.out.println("0 - Sair");
			System.out.println("1 - Adicionar um empregado");
			System.out.println("2 - Remover um empregado");
			System.out.println("3 - Lançar um cartão de ponto");
			System.out.println("4 - Lançar um resultado de venda");
			System.out.println("5 - Lançar uma taxa de servico");
			System.out.println("6 - Alterar detalhes de um empregado");
			System.out.println("7 - Rodar a folha de pagamento para hoje");
			System.out.println("8 - Undo/Redo:");
			System.out.println("9 - Agenda de pagamento");	
			System.out.println("10 - Mostrar funcionarios cadastrados");
			System.out.println();			
			
				sel = S.nextInt();
				S.nextLine();
			
			
		
			//Baseado no numero recebido pelo sistema, o mesmo ira para a operacao desejada. Obs.: sel = selector
			if(sel == 1) { // Adicionar funcionario				
				MainSelector1.add_employee(A, HT, S, count, Date);	
			}
			if(sel == 2) { // Remover funcionario
				show_employee_list(HT);
				MainSelector2.remove(HT, S);
			}
			if(sel == 3) { // lancar cartao de ponto
				show_employee_list(HT);
				array_position = MainSelector3.card(HT, S, array_position);
			}
			if(sel == 4) { // lancar resultado de venda
				show_employee_list(HT);
				MainSelector4.sell_result(HT, S);
			}
			if(sel == 5){ // lancar taxa de servico
				show_employee_list(HT);
				MainSelector5.service_tax(HT, S);
			}
			if(sel == 6){ // Alterar detalhes de um funcionario
				show_employee_list(HT);
				MainSelector6.change_employee(HT, S);
			}
			if(sel == 7){ // rodar folha para hoje
				System.out.println("Digite quantos dias deseja rodar:");
				
			}
			if(sel == 8){ // Undo/Redo
				
			}
				
			
			if(sel == 9) {// modificar agenda de pagamento
				show_employee_list(HT);
				MainSelector9.modify_agenda(HT, S);
			}
			if(sel == 10) { //Mostrar funcionarios cadastrados
				show_employee_list(HT);
			}
		//S.close();
		}
	}
	public static void show_employee_list(Map<Integer, Employee> HT) {
		System.out.println("Lista de funcionários cadastrados:");
		System.out.println();
		for(Integer X : HT.keySet()) { HT.get(X).show_employee_data(); }
		System.out.println();
	}

}
	
//Character.toString

