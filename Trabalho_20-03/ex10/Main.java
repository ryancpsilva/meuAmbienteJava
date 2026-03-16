package ex10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaClientes listaCli = new ListaClientes();
        ListaItens listaIte = new ListaItens();

        Scanner scnr = new Scanner(System.in);
        int res = -1;

        System.out.println("=".repeat(28));
        System.out.println("Sistema de Gestão de Pedido");
        System.out.println("=".repeat(28));
        while (res != 0) {
            
            System.out.println("Digite sua opção: ");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Adicionar item");
            System.out.println("3 - Exibir dados cadastrados");
            System.out.println("0 - Sair");
            
            res = scnr.nextInt();
            scnr.nextLine(); // limpa o buffer
            switch (res) {
                case 1:
                    Cliente c = new Cliente();
                    System.out.println("=".repeat(37));
                    System.out.println("Digite o nome do cliente: ");
                    c.nome = scnr.nextLine();
                    System.out.println("Digite o CPF do cliente: ");
                    c.CPF = scnr.nextLine();
                    System.out.println("Digite o endereço do cliente: ");
                    c.endereco = scnr.nextLine();
                    System.out.println("=".repeat(37));
                    listaCli.cadastrarCliente(c);
                    break;
                case 2:
                    Item i = new Item();
                    System.out.println("=".repeat(37));
                    System.out.println("Digite o nome do item: ");
                    i.nomeProduto = scnr.nextLine();
                    System.out.println("Digite a quantidade do item: ");
                    i.quantidade = scnr.nextInt();
                    System.out.println("Digite o valor unitário do item: ");
                    i.valorUnitario = scnr.nextDouble();
                    System.out.println("=".repeat(37));
                    scnr.nextLine();
                    listaIte.cadastrarItem(i);
                    break;
                case 3:
                    System.out.println("=".repeat(37));
                    System.out.println("-".repeat(25));
                    System.out.println("Clientes: ");
                    System.out.println("-".repeat(25));
                    listaCli.listarClientes();
                    System.out.println("=".repeat(37));
                    System.out.println("-".repeat(25));
                    System.out.println("Itens: ");
                    System.out.println("-".repeat(25));
                    listaIte.listarItens();
                    System.out.println("=".repeat(37));
                    break;
                case 0:
                    System.out.println("=".repeat(37));
                    System.out.println("Obrigado por utilizar nosso sistema! :)");
                    System.out.println("=".repeat(37));
                    break;

                default:
                    System.out.println("=".repeat(37));
                    System.out.println("Entrada inválida! Escolha outra opção");
                    System.out.println("=".repeat(37));
                    break;
            }

        }
        scnr.close();
    }
}