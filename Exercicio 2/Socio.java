import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um sócio em um clube, estendendo a classe Frequentador.
 */
public class Socio extends Frequentador {
    private List<Convite> convidadosDoSocio;
    protected boolean presenca = false;

    /**
     * Cria uma instância da classe Socio com o nome especificado.
     *
     * @param nome O nome do sócio.
     */
    public Socio(String nome) {
        super(nome);
        this.convidadosDoSocio = new ArrayList<>();
    }

    /**
     * Emite um convite para um convidado.
     *
     * @param socio       O sócio que está emitindo o convite.
     * @param convidado   O convidado que receberá o convite.
     * @param data        A data do convite.
     * @param idConvidado O ID do convidado.
     * @return O convite emitido ou null se o limite de convites for atingido.
     */
    public Convite emitirConvite(Socio socio, Convidado convidado, Data data, String idConvidado) {
        if (convidadosDoSocio.size() < 4) { // Verifica se o sócio pode emitir até 4 convites
            Convite convite = new Convite(idConvidado, this, data);
            convidadosDoSocio.add(convite);
            convidado.adicionarConvite(convite);
            return convite;
        } else {
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
     * @return True se o sócio está presente na data especificada, false caso contrário.
     */
    public boolean isPresenca(Data data) {
        for (Visita visita : visitas) {
            if (visita.getDataEntrada().equals(data))
                if (visita.getDataSaida() == null)
                    return true;
        }
        return false;
    }

    /**
     * Define a presença do sócio no clube.
     *
     * @param presenca True se o sócio está presente, false caso contrário.
     */
    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    /**
     * Define a lista de convites feitos pelo sócio.
     *
     * @param convidadosDoSocio A lista de convites feitos pelo sócio.
     */
    public void setConvitesFeitos(List<Convite> convidadosDoSocio) {
        this.convidadosDoSocio = convidadosDoSocio;
    }

    /**
     * Obtém a lista de convites feitos pelo sócio.
     *
     * @return A lista de convites feitos pelo sócio.
     */
    public List<Convite> getConvitesFeitos() {
        return convidadosDoSocio;
    }

    /**
     * Obtém a quantidade de convites emitidos pelo sócio.
     *
     * @return A quantidade de convites emitidos pelo sócio.
     */
    public int getQuantidadeConvitesEmitidos() {
        return convidadosDoSocio.size();
    }

    @Override
    public boolean isSocio() {
        return true;
    }

    /**
     * Obtém a lista de convidados do sócio.
     *
     * @return A lista de convidados do sócio.
     */
    public List<Convite> getConvidadosDoSocio() {
        return convidadosDoSocio;
    }

    /**
     * Define a lista de convidados do sócio.
     *
     * @param convidadosDoSocio A lista de convidados do sócio.
     */
    public void setConvidadosDoSocio(List<Convite> convidadosDoSocio) {
        this.convidadosDoSocio = convidadosDoSocio;
    }
}
