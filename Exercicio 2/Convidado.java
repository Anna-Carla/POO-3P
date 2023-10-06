import java.util.ArrayList;

public class Convidado extends Frequentador {
    private ArrayList<Convite> convites;
    protected int quantidadeVisitas;

    public Convidado(String nome) {
        super(nome);
        this.convites = new ArrayList<>();
        this.quantidadeVisitas = 0;
    }

    @Override
    public void registrarVisita(Data data, Hora horaEntrada) {
        if (pesquisarConvite(data)) {
            Visita visita = new Visita(this, data, horaEntrada);
            visitas.add(visita);
            quantidadeVisitas++;
            System.out.println("O Convidado Entrou");
        }
    }

    private boolean pesquisarConvite(Data data) {
        if (convites.isEmpty()) {
            System.out.println("Convidado não possui convite");
            return false;
        }
        for (Convite convite : convites) {
            if (convite.getData().equals(data) && convite.getSocio().isPresenca(data)) {
                System.out.println("Convite existente");
                return true;
            }
        }
        return false;
    }

    public void adicionarConvite(Convite convite) {
        convites.add(convite);
    }
    
    public int getQuantidadeVisitas() {
        return quantidadeVisitas;
    }

    @Override
    public boolean isSocio() {
        return false;
    }
}
