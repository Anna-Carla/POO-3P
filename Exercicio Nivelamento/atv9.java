import java.util.Scanner;

public class atv9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a data no formato DD/MM: ");
        String data = sc.nextLine();

        // Dividir a entrada em partes: dia e mês
        String[] partesData = data.split("/");
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);

        // Calcular o dia da semana correspondente à data em 2024
        int diaDaSemana2024 = calcularDiaDaSemana2024(dia, mes);
        
        // Exibir o dia da semana correspondente em 2024
        System.out.println("Em 2024, essa data cairá em: " + nomeDiaSemana(diaDaSemana2024));

        sc.close();
    }

    // Função para calcular o dia da semana correspondente à data em 2024
    public static int calcularDiaDaSemana2024(int dia, int mes) {
        int diasTotais = contarDias(dia, mes);
        int diaDaSemana2024 = (diasTotais + 1) % 7; // Adicionando +1 para ajustar o 1º de janeiro de 2024
        return diaDaSemana2024;
    }

    // Função para contar o número total de dias até o mês fornecido
    public static int contarDias(int dia, int mes) {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDias = 0;
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += dia;

        return totalDias;
    }

    // Função para obter o nome do dia da semana a partir do índice
    public static String nomeDiaSemana(int diaSemana) {
        String[] nomesDias = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
        return nomesDias[diaSemana];
    }
}
