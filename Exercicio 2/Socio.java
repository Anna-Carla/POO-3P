import java.util.ArrayList;
import java.util.List;

public class Socio extends Frequentador {
    private List<Convite> convidadosDoSocio;
    protected boolean presenca = false;

    public Socio(String nome) {
        super(nome);
        this.convidadosDoSocio = new ArrayList<>();
    }

    public Convite emitirConvite(Socio socio, Convidado convidado, Data data, String idConvidado) {
        if (convidadosDoSocio.size() < 4) { // Verifica se o sócio pode emitir até 4 convites
            Convite convite = new Convite(idConvidado, this, data);
            convidadosDoSocio.add(convite);
            convidado.adicionarConvite(convite);
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


    public String relatorioVisitasConvidados(Clube clube) {
        StringBuilder relat = new StringBuilder("\nRelatório de Visitas dos Convidados de " + nome+"\n");
        int qnt=0;
        for (Convite cv : convidadosDoSocio) {
            Convidado c = (Convidado) clube.buscarFrequentador(cv.getIdConvidado());
            String nomec=c.getNome();
            qnt = c.getQuantidadeVisitas();
            relat.append(nomec+"visitou "+qnt+"vezes\n");
        }
        return relat.toString();
    }


    public boolean isPresenca(Data data) {
        for (Visita visita : visitas) {
            if (visita.getDataEntrada().equals(data))
                if (visita.getDataSaida() == null)
                    return true;
        }
        return false;
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
