package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroDoQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	
	public Reserva(Integer numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) {
		if (checkIn.isBefore(LocalDate.now())) {
			throw new DomainException("A data de check-in deve ser posterior a data atual.");
		}
		
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
		if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
			throw new DomainException("A reserva deve ser feita para datas futuras");
		}
		if (checkOut.isBefore(checkIn)) {
			throw new DomainException("O check-out deve ser feito após o check-in");
		}
		
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