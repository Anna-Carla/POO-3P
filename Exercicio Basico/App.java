import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nomes das Equipes\nEquipe 1: ");
        String equipe1 = sc.nextLine();

        System.out.print("Equipe 2: ");
        String equipe2 = sc.nextLine();

        Partida partida = new Partida(equipe1, equipe2);

        while (!partida.verificarEmpate()) {
            for (int i = 1; i <= 4; i++) {
                System.out.print("Pontos do Periodo\n");
                System.out.print(equipe1+": ");
                int pontosEquipe1 = sc.nextInt();
                System.out.print(equipe2+": ");
                int pontosEquipe2 = sc.nextInt();

                partida.pontuacaoPeriodo(pontosEquipe1, pontosEquipe2);
            }

            System.out.println(partida.placar());
        }

        System.out.println("Equipe vencedora: " + partida.verificarVencedor());

        sc.close();
    }
}
