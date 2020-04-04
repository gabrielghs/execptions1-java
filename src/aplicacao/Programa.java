package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numeroQuarto= sc.nextInt();
			System.out.print("Check-in data (dd/mm/aaaa): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/mm/aaaa): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Check-in data (dd/mm/aaaa): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/mm/aaaa): ");
			checkout = sdf.parse(sc.next());
			Date agora = new Date();
			
			reserva.atualizaDatas(checkin, checkout);
			System.out.println("Reserva: "+reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato da data invalido.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		sc.close();
	}
}
