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
}

/*
 * 3 – Escreva um ou mais métodos para imprimir no console retângulos usando
 * caracteres, como, por exemplo:
 * XXXXX
 * X   X
 * X   X
 * X   X
 * XXXXX
 */