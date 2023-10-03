import java.util.ArrayList;

public class Convidado extends Frequentador {
    private ArrayList<Convite> convites;

    public Convidado(String nome) {
        super(nome);
        this.convites = new ArrayList<>();
    }

    public boolean pesquisarConvite(Data data, String idSocio) {
        for (Convite convite : convites) {
            if (convite.getIdSocio().equals(idSocio) && convite.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSocio() {
        return false;
    }
}
