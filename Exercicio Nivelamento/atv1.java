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

}