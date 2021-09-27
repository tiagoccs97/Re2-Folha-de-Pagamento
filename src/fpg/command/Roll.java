package fpg.command;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import count.Count;
import fpg.agenda.Calendar_Save;
import fpg.employees.Employee;

public class Roll {
	
	public Map<Integer,Employee> HT;
	public Count count;
	public Calendar_Save Date;
	private CommandHistory history = new CommandHistory();
	
	public void Run(){
		int sel = -1;	
		count = new Count(0, 0);		
		Scanner S = new Scanner(System.in);
		HT = new HashMap<Integer, Employee>();		
		//Calendario
		Calendar newCalendar = Calendar.getInstance();
		Date = new Calendar_Save(newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.MONTH)+1, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.DAY_OF_WEEK));	
		Roll roll = this;
		Command x;
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
					
			//Baseado no numero recebido pelo sistema, o mesmo ira para a operacao desejada. Obs.: sel = selector
			if(sel == 1) { // Adicionar funcionario				
				executeCommand(new Select1_Command(this));
				//x = new Select1_Command(this);
			    //x.execute();
			    //save(roll.HT, roll.count, roll.Date);			    
			}
			if(sel == 2) { // Remover funcionario
				Selector2.remove(HT, S);
			}
			if(sel == 3) { // lancar cartao de ponto				
				Selector3.card(HT, S);
			}
			if(sel == 4) { // lancar resultado de venda				
				Selector4.sell_result(HT, S);
			}
			if(sel == 5){ // lancar taxa de servico			
				Selector5.service_tax(HT, S);
			}
			if(sel == 6){ // Alterar detalhes de um funcionario				
				Selector6.change_employee(HT, S);
			}
			if(sel == 7){ // rodar folha para hoje
				Selector7.runPayRoll(HT, S, Date);
			}
			if(sel == 8){ // Undo/Redo
				int n=0;
				System.out.println("Digite a opcao desejada: 1 - Undo, 2 - Redo");
				n = S.nextInt();
				if(n==1) {
					undo();
				}
				else if(n==2) {
					redo();
				}
			}			
			if(sel == 9) {// modificar agenda de pagamento
				Selector9.modify_agenda(HT, S);
			}
			if(sel == 10) { //Mostrar funcionarios cadastrados
				show_employee_list(HT);
			}
		}
	}
	public static void show_employee_list(Map<Integer, Employee> HT) {
		System.out.println("Lista de funcionários cadastrados:");
		System.out.println();
		for(Integer X : HT.keySet()) { HT.get(X).show_employee_data(); }
		System.out.println();
	}
	private void executeCommand(Command command) {       
		history.pushUndo(command);
		command.execute();
    }

    private void undo() {
        if (history.isEmptyUndo()) {
        	System.out.println("Pilha Undo vazia");
        	return;
        }
        Command command = history.popUndo();
        if (command != null) {
        	history.pushRedo(command);
            command.restore();
        }
    }
    private void redo() {
    	if (history.isEmptyRedo()) {
    		System.out.println("Pilha Redo vazia");
    		return;
    	}
    	Command command = history.popRedo();
        if (command != null) {
        	history.pushUndo(command);
            command.restore();
        }
    }
    public void save(Map<Integer,Employee> HT, Count count, Calendar_Save Date) {
    	this.HT = HT;
    	this.count = count;
    	this.Date = Date;    	
    }
}
