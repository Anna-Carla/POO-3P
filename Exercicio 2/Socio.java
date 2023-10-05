import java.util.ArrayList;
import java.util.List;

public class Socio extends Frequentador {
    private List<Convite> convidadosDoSocio;
    protected boolean presenca = false;

    public Socio(String nome) {
        super(nome);
        this.convidadosDoSocio = new ArrayList<>();
    }

    public Convite emitirConvite(Socio socio, String idConvidado, Data data) {
        if (convidadosDoSocio.size() < 4) { // Verifica se o sócio pode emitir até 4 convites
            Convite convite = new Convite(idConvidado, this, data);
            convidadosDoSocio.add(convite);
            System.out.println("Convite emitido!");
            return convite;
        } else {
            System.out.println("Limite de convites mensais atingido para este sócio.");
            return null;
        }
    }

    @Override
    public void registrarVisita(Data data, Hora horaEntrada) {
        Visita visita = new Visita(this, data, horaEntrada);
        visitas.add(visita);
        presenca = true;
        System.out.println("O Socio Entrou");
    }


    public boolean isPresenca() {
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

    public List<Convite> getConvidadosDoSocio() {
        return convidadosDoSocio;
    }

    public void setConvidadosDoSocio(List<Convite> convidadosDoSocio) {
        this.convidadosDoSocio = convidadosDoSocio;
    }

}
