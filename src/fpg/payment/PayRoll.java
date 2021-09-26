package fpg.payment;
import fpg.agenda.*;
import fpg.employees.*;
import java.util.HashMap;
import java.util.Map;

public class PayRoll {

	public static void verify_day(Map<Integer, Employee> HT, Calendar_Save date) {		
		
		if (!HT.isEmpty()) {
			
			System.out.println("-------------FOLHA DE PAGAMENTO-------------");
			System.out.println();
			System.out.println("Data de hoje: " + date.get_week_day() + " - " +  date.get_day() + "/" + date.get_month() + "/" + date.get_year());
			System.out.println();
			System.out.println("Lista de funcionarios a serem pagos: ");
			System.out.println();
			
			for (Integer X : HT.keySet()) {
				if (HT.get(X).get_agenda().get_payment_day() == date.get_day()
						&& HT.get(X).get_agenda().get_payment_month() == date.get_month()
						&& HT.get(X).get_agenda().get_payment_year() == date.get_year()) {
					HT.get(X).show_employee_data();
					if (HT.get(X).get_syndicate() == true) {
						Employee.calculate_payment(HT, X);
						Employee.calculate_syndicate(HT, X);
						System.out.println("Valor pago(contando as taxas do sindicato): " + HT.get(X).get_payment());
						Employee.resetPay(HT, X);
						HT.get(X).get_agenda().set_payment_date(date);
					} else {
						Employee.calculate_payment(HT, X);
						System.out.println("Valor pago: " + HT.get(X).get_payment());
						Employee.resetPay(HT, X);
						HT.get(X).get_agenda().set_payment_date(date);
					}
				}
			} 
			date.pass_day();
		} else System.out.println("Adicione funcionarios para poder rodar a folha");
	}
	public static void verify_days(Map<Integer, Employee> HT, Calendar_Save date, int N){
		for(Integer X = 0; X<N; X++) {
			verify_day(HT, date);
		}
	}
}
