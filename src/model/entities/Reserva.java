package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {

	private Integer numeroDoQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	public Reserva(Integer numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}

	
	public long duracao() {
		return ChronoUnit.DAYS.between(LocalDate.parse(checkIn.toString()), LocalDate.parse(checkOut.toString()));
	}
	
	public void atualizarDatas(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero do quarto: " + numeroDoQuarto
				+ ", check-in: " + FMT.format(checkIn)
				+ ", check-out: " + FMT.format(checkOut)
				+ ", " + duracao() + " noites\n");
		
		return sb.toString();
	}
}