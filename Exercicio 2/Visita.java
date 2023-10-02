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
    }

    public Data getDataEntrada() {
        return dataEntrada;
    }

    public Hora getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Hora horaSaida) {
        this.horaSaida = horaSaida;
    }
}
