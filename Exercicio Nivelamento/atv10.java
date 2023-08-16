import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class atv10 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        String nomeArquivo;
        System.out.print("Digite o nome do arquivo: ");
        nomeArquivo = sc.nextLine();

        File arquivo = new File(nomeArquivo + ".txt");

        if (arquivo.exists()) {
            lerArquivo(arquivo);
        } else {
            System.out.println("Arquivo inexistente");
        }
        sc.close();
    }

    public static void lerArquivo(File arquivo) throws Exception {
        String linha;
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            while ((linha = bufferedReader.readLine()) != null) {
                String[] vetorArquivo = linha.split(";");
                int[] vetorInt = new int[vetorArquivo.length];

                for (int x = 0; x < vetorArquivo.length; x++) { //cria um vetor Int para receber os numero (String)
                    vetorInt[x] = Integer.parseInt(vetorArquivo[x]);
                }

                exibirVetor(vetorInt, vetorArquivo.length);
                somarVizinho(vetorInt, vetorArquivo.length);
                System.out.println("\n\n");
            }
            leitor.close();
            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
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
            if (tam % 2 != 0 && atual == vet.length - 1) { // se o atual tiver na ultima posição
                proximo++; // o proximo aponta para o ultimo
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

/*
 * Refaça o exercício 02, sendo que os dados serão lidos de um arquivo texto. O
 * arquivo texto pode ter várias linhas
 * e cada linha representa um vetor a ser utilizado pelo método. O separador
 * usado é ponto e vírgula. Por exemplo:
 * 4;8;15;4;15;16;23;42
 * 7;11;13;17;29;23;29;31
 * 6;5;4;3;2;1
 */