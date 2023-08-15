import java.util.*;

public class atv8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a data no formato DD/MM/AAAA: ");
        String data = sc.nextLine();

        if (verificarData(data)) {
            System.out.println("A data é válida.");
        } else {
            System.out.println("A data é inválida ou está em formato incorreto.");
        }

        sc.close();
    }

    // Função para verificar se uma data é válida
    public static boolean verificarData(String data) {
        // Dividir a entrada em partes: dia, mês e ano
        String[] partesData = data.split("/");

        // Verificar se a entrada possui três partes (dia, mês e ano)
        if (partesData.length != 3) {
            return false;
        }

        // Converter partes para inteiros
        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        // Verificar se o mês está dentro do intervalo válido
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Verificar se o dia está dentro do intervalo válido para o mês e ano
        if (dia < 1 || dia > diasNoMes(mes, ano)) {
            return false;
        }

        return true; // Se todas as verificações passaram, a data é válida
    }

    // Função para obter o número de dias em um mês, considerando anos bissextos
    public static int diasNoMes(int mes, int ano) {
        if (mes == 2) {
            if (verificarAnoBissexto(ano)) {
                return 29; // Fevereiro em ano bissexto tem 29 dias
            } else {
                return 28; // Fevereiro em anos não bissextos tem 28 dias
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30; // Meses com 30 dias
        } else {
            return 31; // Meses com 31 dias
        }
    }

    // Função para verificar se um ano é bissexto
    public static boolean verificarAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }
}
