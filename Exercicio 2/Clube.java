/**
 * Representa um clube que mantém o registro de frequentadores e suas atividades.
 */
public class Clube {
    private Frequentador[] frequentadores;
    private int quantFreq;

    /**
     * Cria uma instância da classe Clube com um número mínimo de vagas para frequentadores.
     *
     * @param n O número mínimo de vagas disponíveis no clube (deve ser maior ou igual a 2).
     */
    public Clube(int n) {
        if (n <= 2) {
            n = 2;
        }
        frequentadores = new Frequentador[n];
        quantFreq = 0;
    }

    /**
     * Adiciona um novo frequentador ao clube.
     *
     * @param novo O frequentador a ser adicionado.
     * @return True se o frequentador foi adicionado com sucesso, false se o limite de vagas foi atingido.
     */
    public boolean addFrequentador(Frequentador novo) {
        boolean resposta = false;
        if (quantFreq == frequentadores.length) {
            // Limite de vagas atingido.
        } else {
            resposta = true;
            frequentadores[quantFreq] = novo;
            System.out.println("\nFrequentador Cadastrado\nID: " + frequentadores[quantFreq].getId() + "\nNome: "
                    + frequentadores[quantFreq].getNome() + "\n");
            quantFreq++;
        }
        return resposta;
    }

    /**
     * Registra a visita de um frequentador ao clube.
     *
     * @param idFreq      O ID do frequentador.
     * @param data        A data da visita.
     * @param horaEntrada A hora de entrada do frequentador.
     */
    public void registrarVisita(String idFreq, Data data, Hora horaEntrada) {
        buscarFrequentador(idFreq).registrarVisita(data, horaEntrada);
    }

    /**
     * Registra a saída de um frequentador do clube.
     *
     * @param idFreq     O ID do frequentador.
     * @param data       A data da saída.
     * @param horaSaida  A hora de saída do frequentador.
     */
    public void registrarSaida(String idFreq, Data data, Hora horaSaida) {
        buscarFrequentador(idFreq).registrarSaida(data, horaSaida);
    }

    /**
     * Gera um relatório de visitas no clube em uma data específica.
     *
     * @param data A data para a qual deseja-se gerar o relatório.
     * @return Uma string com o relatório de visitas na data especificada.
     */
    public String relatorioVisitasData(Data data) {
        StringBuilder relat = new StringBuilder("Visitas em " + data + "\n");
        for (int i = 0; i < quantFreq; i++) {
            if (frequentadores[i].visitouClubeEm(data)) {
                relat.append(frequentadores[i].relatorioVisitas()).append("\n");
            }
        }
        return relat.toString();
    }

    /**
     * Gera um relatório de visitas de um frequentador específico.
     *
     * @param idFreq O ID do frequentador para o qual deseja-se gerar o relatório.
     * @return Uma string com o relatório de visitas do frequentador especificado.
     */
    public String relatorioVisitasFreq(String idFreq) {
        return buscarFrequentador(idFreq).relatorioVisitas();
    }

    /**
     * Gera um relatório de visitas de convidados de um sócio específico.
     *
     * @param idFreq O ID do sócio para o qual deseja-se gerar o relatório de visitas de convidados.
     * @return Uma string com o relatório de visitas de convidados do sócio especificado.
     */
    public String relatorioVisitasConvidados(String idFreq) {
        Socio socio = (Socio) buscarFrequentador(idFreq);
        return (socio.relatorioVisitasConvidados(this));
    }

    /**
     * Busca um frequentador pelo seu ID.
     *
     * @param idFrequentador O ID do frequentador a ser buscado.
     * @return O frequentador correspondente ao ID especificado, ou null se o ID não for encontrado.
     */
    public Frequentador buscarFrequentador(String idFrequentador) {
        for (int i = 0; i < frequentadores.length; i++) {
            if (idFrequentador.equals(frequentadores[i].getId())) {
                return frequentadores[i];
            }
        }
        System.out.println("ID de frequentador inexistente.");
        return null;
    }

    /**
     * Verifica se o clube está atualmente em funcionamento.
     *
     * @return True se o clube está em funcionamento, false caso contrário.
     */
    public static boolean estaPresente() {
        return true; // Esta implementação sempre retorna true, você pode personalizá-la conforme necessário.
    }
}

