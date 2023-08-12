import java.util.Scanner;

public class atv5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o número de disciplinas: ");
        int disciplinas = sc.nextInt();

        System.out.print("Informe o total semanal de horas: ");
        int horas = sc.nextInt();

        System.out.print("Informe o total semanal de minutos: ");
        int minutosSemanais = sc.nextInt();

        sc.close();

        planoDeEstudos(disciplinas, horas, minutosSemanais);
    }

    public static void planoDeEstudos(int disciplinas, int horas, int minutosSemanais) {
        int totalMinutosSemanais = ((horas * 60) + minutosSemanais) / 7;
        int minutosDeDescanso = totalMinutosSemanais / 10;
        int minutosPorDisciplina = (totalMinutosSemanais / disciplinas) - minutosDeDescanso;

        System.out.println("\nTempo de estudo por disciplina por dia: " + minutosPorDisciplina + " minutos");
        System.out.println("Tempo de descanso por dia: " + minutosDeDescanso + " minutos");
    }
}
