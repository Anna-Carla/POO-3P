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
                    clube.imprimirFrequentadores();
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

    public static boolean socioOuConvidado() {
        String op = leitura("\nSócio ou Convidado?\n(1) Sócio\n(2) Convidado\nOpção");
        if (op.equals("1")) {
            return true;
        } else if (op.equals("2")) {
            return false;
        } else {
            System.out.println("Opção Inválida");
            return socioOuConvidado();
        }
    }

    // INICIO DA PARTE DO CADASTRO
    public static void cadastrarSocio(Clube clube) {
        String nome = leitura("Nome do Sócio: ");
        Socio novoSocio = new Socio(nome);
        clube.addFrequentador(novoSocio);
    }

    public static void cadastrarConvidado(Clube clube) {
        String nome = leitura("Nome do Convidado: ");
        Convidado novoConvidado = new Convidado(nome);
        clube.addFrequentador(novoConvidado);
    }

    public static void cadastrarFrequentador(Clube clube) {
        if (socioOuConvidado()) {
            cadastrarSocio(clube);
        } else {
            cadastrarConvidado(clube);
        }
    }
    // FIM DA PARTE DO CADASTRO

    public static void registrarEntradaFrequentador(Clube clube) {
        if (socioOuConvidado()) {
            registrarEntradaSocio(clube);
        } else {
            registrarEntradaConvidado(clube);
        }
    }

    public static void registrarEntradaSocio(Clube clube) {
        String idSocio = leitura("Id do Socio: ");
        Socio socio = clube.buscarSocio(idSocio);
        if (socio != null) {
            socio.setPresenca(true);
            Data data = registrarData();
            Hora hora = registrarHora();
            clube.registrarVisita(idSocio, data, hora);
        } else {
            System.out.println("Socio não existe");
        }
    }

    // Verificar o id do Conv, tem convite, id socio, socio está dentro, data do
    // convite com a data que quer entrar
    public static void registrarEntradaConvidado(Clube clube) {
        System.out.println("Id do Convidado: ");
        String idConvidado = leitura("Id do Convidado: ");
        Convidado convidado = clube.buscarConvidado(idConvidado);
        if(convidado!= null){ 
        System.out.println("Possui convite? ");
        char resposta = sc.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
        System.out.println("Data da entrada: ");
            Data data = registrarData();
            System.out.println("Id do Socio: ");
            String idSocio = sc.nextLine();
            Socio socio = clube.buscarSocio(idSocio);
            if(convidado.pesquisarConvite(data, idSocio)) {
                if(socio.estaPresente()) {
                    System.out.println("Informe o horário da entrada");
                    Hora hora = registrarHora();
                    clube.registrarVisita(idConvidado, data, hora);
                    System.out.println("Entrada registrada com sucesso!");
                } else {
                    System.out.println("Socio não está presente");
                }
            } else {
                System.out.println("Convite inválido");
            }
            
        } else if(resposta == 'n' || resposta == 'N') {
            System.out.println("Entrada não é permitida");
        }
    } else {
        System.out.println("Convidado não existe");
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
        return sc.next();
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
