import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Urna Eletrônica!");
        System.out.println("Candidatos:");
        System.out.println("01 - Ada Lovelace");
        System.out.println("02 - Alan Turing");
        System.out.println("03 - Marie Curie");
        System.out.println("04 - Albert Einstein");
        System.out.println("05 - Ludwig van Beethoven");

        int votosRecebidos = 0;
        while (votosRecebidos < 10) {
            System.out.print("Digite o número do seu candidato: ");
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                urna.receberVoto(numero);
                votosRecebidos++;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
            }
        }

        urna.apurarResultados();
        scanner.close();
    }
}
