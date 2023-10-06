import java.util.ArrayList;
import java.util.List;

/**
 * Representa um frequentador do tipo Convidado em um clube.
 */
public class Convidado extends Frequentador {
    private List<Convite> convites;
    protected int quantidadeVisitas;

    public Convidado(String nome) {
        super(nome);
        this.convites = new ArrayList<>();
        this.quantidadeVisitas = 0;
    }

    /**
     * Registra a visita do Convidado ao clube, se houver um convite válido
     * disponível para a data.
     *
     * @param data        A data da visita.
     * @param horaEntrada A hora de entrada do Convidado.
     */
    @Override
    public void registrarVisita(Data data, Hora horaEntrada) {
        if (pesquisarConvite(data)) {
            Visita visita = new Visita(this, data, horaEntrada);
            visitas.add(visita);
            quantidadeVisitas++;
        }
    }

    /**
     * Verifica se existe um convite válido para a data especificada, fazendo uma
     * pesquisa.
     *
     * @param data A data para a qual deseja-se verificar a disponibilidade de
     *             convite.
     * @return True se houver um convite válido, false caso contrário.
     */
    private boolean pesquisarConvite(Data data) {
        if (convites.isEmpty()) {
            return false;
        }
        for (Convite convite : convites) {
            if (convite.getData().equals(data) && convite.getSocio().isPresenca(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um convite à lista de convites disponíveis para o Convidado.
     *
     * @param convite O convite a ser adicionado.
     */
    public void adicionarConvite(Convite convite) {
        convites.add(convite);
    }

    /**
     * Verifica se o frequentador é um sócio.
     *
     * @return False, já que um Convidado não é um sócio.
     */
    @Override
    public boolean isSocio() {
        return false;
    }

    //GET DA CLASSE
    public int getQuantidadeVisitas() {
        return quantidadeVisitas;
    }

}
