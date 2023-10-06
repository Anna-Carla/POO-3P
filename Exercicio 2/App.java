import java.util.Scanner;

/**
 * Classe principal que contém o método main para executar o programa do clube.
 */
public class App {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Clube clube = new Clube(10);

        int opcao = 0;
        while (opcao != 7) {
            menu1();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFrequentador(clube);
                    break;
                case 2:
                    registrarEntrada(clube);
                    break;
                case 3:
                    registrarSaida(clube);
                    break;
                case 4:
                    emitirConvite(clube);
                    break;
                case 5:
                    Data data = registrarData();
                    System.out.println(clube.relatorioVisitasData(data));
                    break;
                case 6:
                    String idFreq = leitura("Digite o Id do Frequentador: ");
                    System.out.println(clube.relatorioVisitasFreq(idFreq));
                    break;
                case 7:
                    String idSocio = leitura("Digite o Id do Socio");
                    System.out.println(clube.relatorioVisitasConvidados(idSocio));
                    break;
                case 8:
                    System.out.println("Saindo do programa.");
                    sc.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Exibe o menu principal do programa na saída padrão.
     */
    public static void menu1() {
        System.out.println();
        System.out.println("----- Menu -----");
        System.out.println("1. Cadastrar Frequentador");
        System.out.println("2. Registrar Entrada");
        System.out.println("3. Registrar Saída");
        System.out.println("4. Emitir Convite");
        System.out.println("5. Gerar Relatório de Visitas por Data");
        System.out.println("6. Gerar Relatório de Visitas por Frequentador");
        System.out.println("7. Gerar Relatório de Visitas de Convidados de um Socio:");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Realiza o cadastro de um frequentador no clube.
     *
     * @param clube O clube onde o frequentador será cadastrado.
     */
    public static void cadastrarFrequentador(Clube clube) {
        int opcaoSocioConvidado = Integer.parseInt(leitura("(1) Socio \n(2) Convidado\nOpção"));
        String nome = leitura("\nNome");
        if (opcaoSocioConvidado == 1) {
            Socio novoSocio = new Socio(nome);
            clube.addFrequentador(novoSocio);
        } else if (opcaoSocioConvidado == 2) {
            Convidado novoConvidado = new Convidado(nome);
            clube.addFrequentador(novoConvidado);
        }
    }

    /**
     * Registra a entrada de um frequentador no clube.
     *
     * @param clube O clube onde a entrada será registrada.
     */
    public static void registrarEntrada(Clube clube) {
        String idFreq = leitura("Id do Frequentador");
        Frequentador freq = clube.buscarFrequentador(idFreq);
        Data data = registrarData();
        Hora horaSaida = registrarHora();
        clube.registrarVisita(idFreq, data, horaSaida);
    }

    /**
     * Emite um convite de um sócio para um convidado no clube.
     *
     * @param clube O clube onde o convite será emitido.
     */
    public static void emitirConvite(Clube clube) {
        String idSocio = leitura("Id Socio");
        String idConvidado = leitura("Id do Convidado");
        Frequentador freq1 = clube.buscarFrequentador(idSocio);
        Frequentador freq2 = clube.buscarFrequentador(idConvidado);
        Convidado convidado = (Convidado) freq2;
        Socio socio = (Socio) freq1;
        Data data = registrarData();
        socio.emitirConvite(socio, convidado, data, idConvidado);
    }

    /**
     * Registra a saída de um frequentador do clube.
     *
     * @param clube O clube onde a saída será registrada.
     */
    public static void registrarSaida(Clube clube) {
        String idFreq = leitura("Id do Frequentador");
        Frequentador freq = clube.buscarFrequentador(idFreq);
        Data data = registrarData();
        Hora horaSaida = registrarHora();
        clube.registrarSaida(idFreq, data, horaSaida);
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem
     * sempre é completada com ":". Retorna uma string
     * que pode ser posteriormente convertida.
     * 
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem) {
        System.out.print(mensagem + ": ");
        return sc.next();
    }

    /**
     * Registra uma data inserida pelo usuário.
     *
     * @return Um objeto Data representando a data inserida pelo usuário.
     */
    public static Data registrarData() {
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        return new Data(dia, mes, ano);
    }

    /**
     * Registra uma hora inserida pelo usuário.
     *
     * @return Um objeto Hora representando a hora inserida pelo usuário.
     */
    public static Hora registrarHora() {
        System.out.print("Hora: ");
        byte horas = sc.nextByte();
        System.out.print("Minuto: ");
        byte minutos = sc.nextByte();
        System.out.print("Segundo: ");
        byte segundos = sc.nextByte();
        return new Hora(horas, minutos, segundos);
    }
}
