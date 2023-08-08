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
}

/*
 * Elabore um programa que leia uma frase e mostre-a invertida na tela. Após
 * mostrar a primeira frase, o programa
 * deve ler e imprimir outra, assim fazendo até que o usuário digite a palavra
 * “fim”.
 */