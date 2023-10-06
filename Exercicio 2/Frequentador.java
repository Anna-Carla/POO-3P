import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa um frequentador em um clube.
 */
public abstract class Frequentador {
    private static int ultimoId = 1;
    protected String id;
    protected String nome;
    protected List<Visita> visitas;

    public Frequentador(String nome) {
        this.id = gerarId();
        this.nome = nome;
        this.visitas = new ArrayList<>();
    }



    /**
     * Registra a entrada do frequentador no clube, recebendo a data e a hora.
     *
     * @param data        A data da entrada.
     * @param horaEntrada A hora de entrada.
     */
    public void registrarVisita(Data data, Hora horaEntrada) {
        Visita visita = new Visita(this, data, horaEntrada);
        visitas.add(visita);
    }

    /**
     * Registra a saída do frequentador do clube, percorrendo todas as visitas até encontrar com base na data.
     *
     * @param data       A data da saída.
     * @param horaSaida  A hora de saída.
     */
    public void registrarSaida(Data data, Hora horaSaida) {
        for (Visita visita : visitas) {
            if (visita.getHoraSaida() == null) {
                if (visita.getDataEntrada().equals(data)) {
                    visita.setHoraSaida(horaSaida);
                    break;
                }
            }
        }
    }

    /**
     * Verifica se o frequentador visitou o clube em uma data específica.
     *
     * @param data A data para verificar a visita.
     * @return True se o frequentador visitou o clube na data especificada, false caso contrário.
     */
    public boolean visitouClubeEm(Data data) {
        for (Visita visita : visitas) {
            if (visita.getDataEntrada().equals(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gera um relatório de visitas do frequentador.
     *
     * @return Uma string contendo o relatório de visitas do frequentador.
     */
    public String relatorioVisitas() {
        StringBuilder relat = new StringBuilder("Relatório de Visitas de " + nome + " (ID: " + id + ")\n");
        for (Visita visita : visitas) {
            relat.append(visita).append("\n");
        }
        return relat.toString();
    }

    /**
     * Verifica se o frequentador é um sócio.
     *
     * @return True se o frequentador é um sócio, false caso contrário.
     */
    public abstract boolean isSocio();

    /**
     * Gera um ID único para o frequentador.
     *
     * @return O ID gerado.
     */
    private static String gerarId() {
        return String.valueOf(ultimoId++);
    }

    //GETS DA CLASSE
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
