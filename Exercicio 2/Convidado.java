import java.util.ArrayList;

public class Convidado extends Frequentador {
    private ArrayList<Convite> convites;

    public Convidado(String nome) {
        super(nome);
        this.convites = new ArrayList<>();
    }

    public boolean pesquisarConvite(Data data, String nome) {
        for (Convite convite : convites) {
            Socio socio = convite.getSocio(); 
            if (socio.getNome().equals(nome) && convite.getData().equals(data)) {
                return true; // O convite com a data e o nome especificados foi encontrado
            }
        }
        return false; // Nenhum convite correspondente foi encontrado
    }
    

    @Override
    public boolean isSocio() {
        return false;
    }
}
