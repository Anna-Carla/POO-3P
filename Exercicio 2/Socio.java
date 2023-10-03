import java.util.ArrayList;
import java.util.List;

public class Socio extends Frequentador {
    private List<Convite> convidadosDoSocio;
    private boolean presenca = false;

    public Socio(String nome) {
        super(nome);
        this.convidadosDoSocio = new ArrayList<>();
    }

    public Convite emitirConvite(Convidado convidado, Data data) {
        if (convidadosDoSocio.size() < 4) { // Verifica se o sócio pode emitir até 4 convites
            Convite convite = new Convite(id, convidado, data);
            convidadosDoSocio.add(convite);
            return convite;
        } else {
            System.out.println("Limite de convites mensais atingido para este sócio.");
            return null;
        }
    }

    public boolean estaPresente() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public void setConvitesFeitos(List<Convite> convidadosDoSocio) {
        this.convidadosDoSocio = convidadosDoSocio;
    }

    public List<Convite> getConvitesFeitos() {
        return convidadosDoSocio;
    }

    public int getQuantidadeConvitesEmitidos() {
        return convidadosDoSocio.size();
    }

    @Override
    public boolean isSocio() {
        return true;
    }

}
