import java.util.Scanner;

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
