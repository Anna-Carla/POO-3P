/**
 * Classe que representa uma visita de um frequentador ao clube, incluindo
 * informações de entrada e saída.
 */
public class Visita {
    private Frequentador frequentador;
    private Data dataEntrada;
    private Hora horaEntrada;
    private Data dataSaida;
    private Hora horaSaida;

    /**
     * Cria uma instância da classe Visita com os detalhes da entrada.
     *
     * @param frequentador O frequentador que está fazendo a visita.
     * @param dataEntrada  A data de entrada da visita.
     * @param horaEntrada  A hora de entrada da visita.
     */
    public Visita(Frequentador frequentador, Data dataEntrada, Hora horaEntrada) {
        this.frequentador = frequentador;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.horaSaida = null; // Inicialmente, a hora de saída é nula.
    }

    /**
     * Obtém o frequentador associado a esta visita.
     *
     * @return O frequentador associado a esta visita.
     */
    public Frequentador getFrequentador() {
        return frequentador;
    }

    /**
     * Define o frequentador associado a esta visita.
     *
     * @param frequentador O frequentador a ser associado a esta visita.
     */
    public void setFrequentador(Frequentador frequentador) {
        this.frequentador = frequentador;
    }

    /**
     * Obtém a data de entrada da visita.
     *
     * @return A data de entrada da visita.
     */
    public Data getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Define a data de entrada da visita.
     *
     * @param dataEntrada A data de entrada a ser definida.
     */
    public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * Obtém a hora de entrada da visita.
     *
     * @return A hora de entrada da visita.
     */
    public Hora getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Define a hora de entrada da visita.
     *
     * @param horaEntrada A hora de entrada a ser definida.
     */
    public void setHoraEntrada(Hora horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Obtém a data de saída da visita, se aplicável.
     *
     * @return A data de saída da visita ou null se a saída não foi registrada.
     */
    public Data getDataSaida() {
        return dataSaida;
    }

    /**
     * Define a data de saída da visita, se aplicável.
     *
     * @param dataSaida A data de saída a ser definida.
     */
    public void setDataSaida(Data dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * Obtém a hora de saída da visita, se aplicável.
     *
     * @return A hora de saída da visita ou null se a saída não foi registrada.
     */
    public Hora getHoraSaida() {
        return horaSaida;
    }

    /**
     * Define a hora de saída da visita, se aplicável.
     *
     * @param horaSaida A hora de saída a ser definida.
     */
    public void setHoraSaida(Hora horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * Retorna uma representação em formato de string da visita, incluindo a data e
     * horários de entrada e saída.
     *
     * @return Uma string representando a visita.
     */
    @Override
    public String toString() {
        return "Dia: " + this.dataEntrada
                + "\nHora Entrada: " + this.horaEntrada
                + "\nHora Saída: " + this.horaSaida;
    }
}
