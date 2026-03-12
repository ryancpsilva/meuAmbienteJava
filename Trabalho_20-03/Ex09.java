import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int res = -1;

        System.out.println("============================");
        System.out.println("Sistema de Gestão de Pedido");
        System.out.println("============================");
        while (res != 0) {
            
            System.out.println("Digite sua opção: ");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Adicionar pedido");
            System.out.println("3 - Exibir dados cadastrados");
            System.out.println("0 - Sair");
            
            res = scnr.nextInt();
            switch (res) {
                case 1:
                    System.out.println("=====================================");
                    System.out.println("Opção 1 selecionada");
                    System.out.println("=====================================");
                    break;
                    case 2:
                    System.out.println("=====================================");
                    System.out.println("Opção 2 selecionada");
                    System.out.println("=====================================");
                    break;
                    case 3:
                    System.out.println("=====================================");
                    System.out.println("Opção 3 selecionada");
                    System.out.println("=====================================");
                    break;
                    case 0:
                    System.out.println("=====================================");
                    System.out.println("Opção 0 selecionada");
                    System.out.println("=====================================");
                    break;
            
                    default:
                    System.out.println("=====================================");
                    System.out.println("Entrada inválida! Escolha outra opção");
                    System.out.println("=====================================");
                    break;
            }
            
        }
        scnr.close();
    }
}