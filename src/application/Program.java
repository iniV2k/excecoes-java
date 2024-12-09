package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int numeroDoQuarto = sc.nextInt();
			sc.nextLine();

			System.out.print("Data de check-in (dd/mm/aaaa): ");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);

			System.out.print("Data de check-out (dd/mm/aaaa): ");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);
			
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println("Digite os dados para atualizar a reserva: ");

			System.out.print("Data de check-in (dd/mm/aaaa): ");
			checkIn = LocalDate.parse(sc.nextLine(), fmt);

			System.out.print("Data de check-out (dd/mm/aaaa): ");
			checkOut = LocalDate.parse(sc.nextLine(), fmt);

			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}

		sc.close();
	}
}