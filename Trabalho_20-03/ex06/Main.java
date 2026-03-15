package ex06;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int res = -1;
		String fruta = "";
		ArrayList<String> frutas = new ArrayList<>();

		frutas.add("Melancia");
		while (res != 0) {
			System.out.println("=".repeat(60));
			System.out.println("Digite 1 para adicionar fruta, 2 para ver lista ou 0 para sair");
			System.out.println("=".repeat(60));
			res = scnr.nextInt();
			System.out.println("=".repeat(60));
			if (res == 1) {
				scnr.nextLine();
				System.out.println("Digite a fruta: ");
				fruta = scnr.nextLine();
				frutas.add(fruta);
			} else if (res == 2) {
				for (int i = 0; i < frutas.size(); i++) {
					System.out.println("-".repeat(15));
					System.out.println((i + 1) + " - " + frutas.get(i));
					System.out.println("-".repeat(15));
				}
			}
		}
		System.out.println("=".repeat(60));
		System.out.println("Obrigado por usar o nosso sistema! :)");
		System.out.println("=".repeat(60));
		scnr.close();
	}
}
