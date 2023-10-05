import java.util.ArrayList;

public class Convidado extends Frequentador {
    private ArrayList<Convite> convites;
    protected boolean presenca = false;


    public Convidado(String nome) {
        super(nome);
        this.convites = new ArrayList<>();
    }

    @Override
    public void registrarVisita(Data data, Hora horaEntrada) {
        if(pesquisarConvite(data)) {
        Visita visita = new Visita(this, data, horaEntrada);
        presenca = true;
        visitas.add(visita);
        System.out.println("O Convidado Entrou");
        }
    }

    private boolean pesquisarConvite(Data data) {
        for (Convite convite : convites) {
            if (convite.getData().equals(data) && convite.getSocio().isPresenca()==true) {
                System.out.println("Convite existente");
                return true;
            }
        }
        return false;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    @Override
    public boolean isSocio() {
        return false;
    }
}
