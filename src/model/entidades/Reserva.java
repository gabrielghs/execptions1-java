package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout){
		if(!checkout.after(checkin)) {
			throw new DomainException("a data de Check-out deve ser superior a data de Check-in!");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();//Calcula a diferenca entre as 2 datas em miles segundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//Converte os mile segundos para dias.
		
	} 
	
	public void atualizaDatas(Date checkin, Date checkout){
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			//Exceçao usada quando os argumentos q passa para um metodo são invalidos
			throw new DomainException("as datas de reserva para atalização devem ser datas futuras");
		}
		if(!checkout.after(checkin)) {
			throw new DomainException("a data de Check-out deve ser superior a data de Check-in!");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+numeroQuarto
				+", check-in: "
				+sdf.format(checkin)
				+", check-out: "
				+sdf.format(checkout)
				+", "
				+duracao()
				+" noites";
				
	}
}
