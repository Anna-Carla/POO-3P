import java.util.ArrayList;
import java.util.List;

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

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void registrarVisita(Data data, Hora horaEntrada) {
        Visita visita = new Visita(this, data, horaEntrada);
        visitas.add(visita);
        System.out.println("Visita Registrada");
    }

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

    public boolean visitouClubeEm(Data data) {
        for (Visita visita : visitas) {
            if (visita.getDataEntrada().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public String relatorioVisitas() {
        StringBuilder relat = new StringBuilder("Relatório de Visitas de " + nome + " (ID: " + id + ")\n");
        for (Visita visita : visitas) {
            relat.append(visita).append("\n");
        }
        return relat.toString();
    }

    public abstract boolean isSocio(); // Método para verificar se é sócio ou convidado

    private static String gerarId() {
        return String.valueOf(ultimoId++);
    }
}
