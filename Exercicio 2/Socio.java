import java.util.ArrayList;
import java.util.List;

public class Socio extends Frequentador {
    private List<Convite> convitesFeitos;
    private List<Convidado> convidadosCadastrados; // Lista de convidados cadastrados
    private boolean presenca = false;

    public Socio(String nome) {
        super(nome);
        this.convitesFeitos = new ArrayList<>();
        this.convidadosCadastrados = new ArrayList<>();
    }

    public Convite emitirConvite(Convidado convidado, Data data) {
        if (convitesFeitos.size() < 4) { // Verifica se o sócio pode emitir até 4 convites
            Convite convite = new Convite(this, convidado, data);
            convitesFeitos.add(convite);
            return convite;
        } else {
            System.out.println("Limite de convites mensais atingido para este sócio.");
            return null;
        }
    }

    public void setConvitesFeitos(List<Convite> convitesFeitos) {
        this.convitesFeitos = convitesFeitos;
    }

    public List<Convite> getConvitesFeitos() {
        return convitesFeitos;
    }

    public List<Convidado> getConvidadosCadastrados() {
        return convidadosCadastrados;
    }

    public void setConvidadosCadastrados(List<Convidado> convidadosCadastrados) {
        this.convidadosCadastrados = convidadosCadastrados;
    }

    public int getQuantidadeConvitesEmitidos() {
        return convitesFeitos.size();
    }

    public boolean estaPresente() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    @Override
    public boolean isSocio() {
        return true;
    }

}
