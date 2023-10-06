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

    public Visita(Frequentador frequentador, Data dataEntrada, Hora horaEntrada) {
        this.frequentador = frequentador;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.horaSaida = null; // Inicialmente, a hora de saída é nula.
    }


    public Frequentador getFrequentador() {
        return frequentador;
    }

    public void setFrequentador(Frequentador frequentador) {
        this.frequentador = frequentador;
    }

    public Data getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Hora getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Hora horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Data getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Data dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Hora getHoraSaida() {
        return horaSaida;
    }

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
