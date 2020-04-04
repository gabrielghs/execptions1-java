package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuart= sc.nextInt();
		System.out.print("Check-in data (dd/mm/aaaa): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/mm/aaaa): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {//Se não checkout for depois de checkin ou seja se ñ é maior
			System.out.println("Erro a data de Check-out deve ser superior a data de Check-in!");
			
		}
		else {
			
		}

	}

}
