package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroDoQuarto = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Data de check-in (dd/mm/aaaa): ");
		LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
		
		System.out.print("Data de check-out (dd/mm/aaaa): ");
		LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);
		
		if (checkOut.isBefore(checkIn)) {
			System.out.println("Erro na reserva: O check-out deve ser feito após o check-in");
		} else {
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("Digite os dados para atualizar a reserva: ");
			
			System.out.print("Data de check-in (dd/mm/aaaa): ");
			checkIn = LocalDate.parse(sc.nextLine(), fmt);
			
			System.out.print("Data de check-out (dd/mm/aaaa): ");
			checkOut = LocalDate.parse(sc.nextLine(), fmt);
			
			String erro = reserva.atualizarDatas(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);				
			} else {
				System.out.println("Reserva: " + reserva);
			}
		}
		
		sc.close();
	}
}