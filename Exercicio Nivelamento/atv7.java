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
