import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um sócio em um clube, estendendo a classe Frequentador.
 */
public class Socio extends Frequentador {
    private List<Convite> convidadosDoSocio;
    protected boolean presenca;

    public Socio(String nome) {
        super(nome);
        this.convidadosDoSocio = new ArrayList<>();
        this.presenca = false;
    }

    /**
     * Emite um convite para um convidado, com uma limitação de emissões com base na
     * regra, ou seja 4 convites.
     *
     * @param socio       O sócio que está emitindo o convite.
     * @param convidado   O convidado que receberá o convite.
     * @param data        A data do convite.
     * @param idConvidado O ID do convidado.
     * @return O convite emitido ou null se o limite de convites for atingido.
     */
    public Convite emitirConvite(Socio socio, Convidado convidado, Data data, String idConvidado) {
        if (convidadosDoSocio.size() < 4) {
            Convite convite = new Convite(idConvidado, this, data);
            convidadosDoSocio.add(convite);
            convidado.adicionarConvite(convite);
            return convite;
        } else {
            return null;
        }
    }

    /**
     * Registra uma visita do sócio ao clube, criando uma nova instância de Visita e
     * adicionando-a à lista de visitas do sócio.
     * Atualiza o status de presença do sócio.
     *
     * @param data        A data da visita.
     * @param horaEntrada A hora de entrada da visita.
     */
    @Override
    public void registrarVisita(Data data, Hora horaEntrada) {
        Visita visita = new Visita(this, data, horaEntrada);
        visitas.add(visita);
        presenca = true;
    }

    /**
     * Gera um relatório de visitas dos convidados do sócio.
     *
     * @param clube O clube onde os convidados estão registrados.
     * @return Uma string contendo o relatório de visitas dos convidados do sócio.
     */
    public String relatorioVisitasConvidados(Clube clube) {
        StringBuilder relat = new StringBuilder("\nRelatório de Visitas dos Convidados de " + nome + "\n");
        int qnt = 0;
        for (Convite cv : convidadosDoSocio) {
            Convidado c = (Convidado) clube.buscarFrequentador(cv.getIdConvidado());
            String nomec = c.getNome();
            qnt = c.getQuantidadeVisitas();
            relat.append(nomec).append(" visitou ").append(qnt).append(" vezes\n");
        }
        return relat.toString();
    }

    /**
     * Verifica se o sócio está presente no clube em uma data específica.
     *
     * @param data A data para verificar a presença.
     * @return True se o sócio está presente na data especificada, false caso
     *         contrário.
     */
    public boolean isPresenca(Data data) {
        for (Visita visita : visitas) {
            if (visita.getDataEntrada().equals(data))
                if (visita.getDataSaida() == null)
                    return true;
        }
        return false;
    }

    @Override
    public boolean isSocio() {
        return true;
    }

    // GETTERS E SETTERS DA CLASSE
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

    public List<Convite> getConvidadosDoSocio() {
        return convidadosDoSocio;
    }

    public void setConvidadosDoSocio(List<Convite> convidadosDoSocio) {
        this.convidadosDoSocio = convidadosDoSocio;
    }
}
