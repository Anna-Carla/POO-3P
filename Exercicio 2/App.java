import java.util.Scanner;

public class App {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Clube clube = new Clube(10); // Especifique o tamanho máximo de frequentadores
        int opcao = 0;
        while (opcao != 7) {
            menu1();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFrequentador(clube);
                    break;
                case 2:
                    registrarEntradaFrequentador(clube);
                    break;
                case 3:
                    registrarSaida(clube);
                    break;
                case 4:
                    emitirConvite(clube);
                    break;
                case 5:
                    relatorioVisitasData(clube);
                    break;
                case 6:
                    String idFreq = leitura("Digite o Id do Frequentador: ");
                    clube.relatorioVisitasFreq(idFreq);
                    break;
                case 7:

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

    public static void menu1() {
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

    public static void cadastrarSocio(Clube clube) {
        String nome = leitura("Nome do Socio: ");
        Socio criarSocio = new Socio(nome);
        clube.addFrequentador(criarSocio);
    }

    public static void cadastrarConvidado(Clube clube) {
        String nome = leitura("Nome do Convidado: ");
        Convidado criarConvidado = new Convidado(nome);
        clube.addFrequentador(criarConvidado);
    }

    public static void cadastrarFrequentador(Clube clube) {
        System.out.println("Deseja cadastrar Socio ou Convidado? ");
        char resposta = sc.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
            cadastrarSocio(clube);
        } else if (resposta == 'c' || resposta == 'C') {
            cadastrarConvidado(clube);
        }
    }

    public static void registrarEntradaFrequentador(Clube clube) {
        System.out.println("Você é Socio ou Convidado? ");
        char resposta = sc.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
            registrarEntradaSocio(clube);

        } else if (resposta == 'c' || resposta == 'C') {
            registrarEntradaConvidado(clube);
        }
    }

    public static void registrarEntradaSocio(Clube clube) {
        String idSocio = leitura("Id do Socio: ");
        Socio socio = clube.buscarSocio(idSocio);
        socio.setPresenca(true);
        Data data = registrarData();
        Hora hora = registrarHora();
        clube.registrarVisita(idSocio, data, hora);

    }

    public static void registrarEntradaConvidado(Clube clube) {
        System.out.println("Id do Convidado: ");
        String idConvidado = sc.nextLine();
        Convidado convidado = clube.buscarConvidado(idConvidado);
        System.out.println("Id do Socio: ");
        String idSocio = sc.nextLine();
        Socio socio = clube.buscarSocio(idSocio);
        Data data = registrarData();
        Hora hora = registrarHora();

        if (socio != null && convidado != null) {
            if (socio.estaPresente()) {
                boolean conviteValido = clube.verificarConvite(convidado, data, idSocio);

                if (conviteValido) {
                    clube.registrarVisita(idConvidado, data, hora);
                    System.out.println("Entrada registrada com sucesso!");
                } else {
                    System.out.println("Convite inválido. A entrada não pode ser registrada.");
                }
            } else {
                System.out.println("O sócio não está presente");
            }

        } else {
            System.out.println("Convidado não encontrado.");
        }
    }

    public static void registrarSaida(Clube clube) {
        String idFreq = leitura("Digite seu Id: ");
        Data data = registrarData();
        Hora hora = registrarHora();
        clube.registrarSaida(idFreq, data, hora);
    }

    public static boolean convidadoExiste(Clube clube) {
        System.out.println("Id do Convidado: ");
        String idConvidado = sc.nextLine();
        Convidado convidado = clube.buscarConvidado(idConvidado);

        if (convidado == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean socioExiste(Clube clube) {
        System.out.println("Id do Socio: ");
        String idSocio = sc.nextLine();
        Socio socio = clube.buscarSocio(idSocio);
        if (socio == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void emitirConvite(Clube clube) {
        System.out.println("Você é Socio ou Convidado? ");
        char resposta = sc.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
            String idSocio = sc.nextLine();
            Socio socio = clube.buscarSocio(idSocio);
            if (socioExiste(clube)) {
                System.out.println("O convidado possui cadastro? ");
                char resposta2 = sc.next().charAt(0);
                if (resposta == 's' || resposta == 'S') {
                    String idConvidado = sc.nextLine();
                    Convidado convidado = clube.buscarConvidado(idConvidado);
                    if (convidadoExiste(clube)) {
                        Data data = registrarData();
                        socio.emitirConvite(convidado, data);
                    }

                } else if (resposta2 == 'n' || resposta2 == 'N') {
                    cadastrarConvidado(clube);
                }
            }

        } else if (resposta == 'c' || resposta == 'C') {
            System.out.println("Não é possível gerar um convite");
        }
    }

    public static void relatorioVisitasData(Clube clube) {
        Data dataRelatorio = registrarData();
        clube.relatorioVisitasData(dataRelatorio);
    }

    public static String leitura(String mensagem) {
        System.out.print(mensagem + ": ");
        return sc.nextLine();
    }

    public static Data registrarData() {
        Data data = new Data();
        int dia, mes, ano;
        System.out.print("Dia: ");
        sc.nextInt();
        System.out.print("Mês: ");
        sc.nextInt();
        System.out.print("Ano: ");
        sc.nextInt();
        return data;
    }

    public static Hora registrarHora() {
        Hora hora = new Hora();
        System.out.print("Hora: ");
        byte horas = sc.nextByte();
        System.out.print("Minuto: ");
        byte minutos = sc.nextByte();
        System.out.print("Segundo: ");
        byte segundos = sc.nextByte();
        return hora;
    }
}
