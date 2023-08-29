/*
//ATIVIDADE 1

import java.util.*;

public class atv1 {
    public static void main(String[] args) {
        int[] vet = new int[6];

        preencher(vet);
        inverter(vet);
    }

    public static void preencher(int[] vet) {
        System.out.println("Preencha o vetor:");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < vet.length; i++) {
            vet[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void inverter(int[] vet) {

        int[] vetInvertido = new int[6];
        int num = 0;

        for (int i = 5; i >= 0; i--) {
            vetInvertido[i] = vet[num];
            num++;
        }

        for (int i = 0; i < vetInvertido.length; i++) {
            System.out.print(vetInvertido[i] + " - ");
        }
    }

} */

/* 
//ATIVIDADE 2

import java.util.*;

public class atv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam;
        System.out.println("Tamanho do Vetor");
        tam = sc.nextInt();
        int[] vet = new int[tam];
        preencher(vet);
        exibirVetor(vet, tam);
        somarVizinho(vet, tam);
        sc.close();
    }

    public static void somarVizinho(int[] vet, int tam) {
        int atual = 0;
        int proximo = 1;
        int tamVetor = tam / 2;

        if (tam % 2 != 0) { // se for impar aumenta 1
            tamVetor += 1;
        }

        int[] vetSoma = new int[tamVetor];
        for (int i = 0; i < vetSoma.length; i++) {

            vetSoma[i] = vet[atual] + vet[proximo];
            atual += 2;
            if (tam % 2 != 0 && atual == vet.length-1) { //se o atual tiver na ultima posição
                proximo++; //o proximo aponta para o ultimo
            } else {
            proximo += 2;
            }
        }
        System.out.println("\nVetor somado");
        exibirVetor(vetSoma, tamVetor);
    }

    public static void preencher(int[] vet) {
        System.out.println("Preencha o vetor");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < vet.length; i++) {
            vet[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void exibirVetor(int[] vet, int tam) {
        for (int i = 0; i < tam; i++) {
            System.out.print(vet[i] + " ");
        }
    }
}
*/

/* 
//ATIVIDADE 3

import java.util.*;

public class atv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura, largura;
        System.out.println("Informe altura e largura do retangulo");
        altura = sc.nextInt();
        largura= sc.nextInt();
        retangulo(altura, largura);
        sc.close();
    }

    public static void retangulo(int altura, int largura) {
        linhaCheia(altura, largura);
        for (int i = 1; i <= altura-2; i++) {
            linhaVazia(altura, largura);
        }
        linhaCheia(altura, largura);
    }

    public static void linhaCheia(int altura, int largura) {
        for (int i = 1; i <= largura; i++) {
            System.out.print("x");
        }
        System.out.println();
    }

    public static void linhaVazia(int altura, int largura) {
        for (int i = 1; i <= largura; i++) {
            if(i==1 || i==largura) {
                System.out.printf("x");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}*/

/* 
//ATIVIDADE 4

import java.util.*;

public class atv4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        System.out.println("Digite uma frase: ");
        frase = sc.nextLine();
        inversor(frase);
        sc.close();
    }

    public static void inversor(String frase) {
        String[] inverte = frase.split("");
        for (int i = inverte.length - 1; i >= 0; i--) {
            System.out.print(inverte[i]);
        }
    }
}*/

/* 
//ATIVIDADE 5
import java.util.*;

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
}*/

/*
//ATIVIDADE 6

import java.util.*;

public class atv6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bilhete1, bilhete2;

        System.out.print("Bilhete 1: ");
        bilhete1 = sc.nextLine();
        System.out.print("Bilhete 2: ");
        bilhete2 = sc.nextLine();

        System.out.println("BILHETE PREMIADO: "+bilhete2.substring(0, 3)+bilhete1.substring(2, 5));
        sc.close();
    }
}
 */

 /*
//ATIVIDADE 7

import java.util.*;

public class atv7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Digite um número: ");
        numero = sc.nextInt();

        int digito1 = numero / 10;
        int digito2 = numero % 10;
        int somaDigitos = digito1 + digito2;

        if (somaDigitos > 9) {
            int novoDigito = (digito1 * 10) + somaDigitos;
            System.out.println(novoDigito + "" + digito2);
        } else {
            System.out.println(digito1 + "" + somaDigitos + "" + digito2);
        }
        sc.close();
    }
}
  */

/*
//ATIVIDADE 8

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
 */

/*
//ATIVIDADE 9

import java.util.*;
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
 */