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
		int numeroQuarto= sc.nextInt();
		System.out.print("Check-in data (dd/mm/aaaa): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/mm/aaaa): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {//Se não checkout for depois de checkin ou seja se ñ é maior
			System.out.println("Erro a data de Check-out deve ser superior a data de Check-in!");
			
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println("Reserva: "+reserva);
		
			System.out.println("Entre co os dados para atualizar a reserva:");
			System.out.print("Check-in data (dd/mm/aaaa): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/mm/aaaa): ");
			checkout = sdf.parse(sc.next());
			Date agora = new Date();
			
			String erro = reserva.atualizaDatas(checkin, checkout);
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {
				System.out.println("Reserva: "+reserva);
			}
			
		}
	}
}
