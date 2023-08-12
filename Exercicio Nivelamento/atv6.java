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
