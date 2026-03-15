package ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        System.out.print("Por favor, digite o seu nome: ");

        String nomeCliente = leitor.nextLine();
        System.out.println("Olá, " + nomeCliente + "! Seja muito bem-vindo(a)!");

        leitor.close();
    }
}