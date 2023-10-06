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
        this.horaSaida = null;
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

    @Override
    public String toString() {
        return "Dia: " + this.dataEntrada
                + "\nHora Entrada: " + this.horaEntrada
                + "\nHora Saída: " + this.horaSaida;
    }

}
