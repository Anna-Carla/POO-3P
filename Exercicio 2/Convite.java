/**
 * Representa um convite emitido por um Socio para um Convidado em um clube.
 */
public class Convite {
    protected Socio socio;
    protected String idConvidado;
    private Data data;

    /**
     * Cria uma instância da classe Convite com as informações especificadas.
     *
     * @param idConvidado O ID do Convidado para o qual o convite é emitido.
     * @param socio       O Socio que emitiu o convite.
     * @param data        A data para a qual o convite é válido.
     */
    public Convite(String idConvidado, Socio socio, Data data) {
        this.idConvidado = idConvidado;
        this.socio = socio;
        this.data = data;
    }

    /**
     * Obtém a data de validade do convite.
     *
     * @return A data de validade do convite.
     */
    public Data getData() {
        return data;
    }

    /**
     * Define a data de validade do convite.
     *
     * @param data A data de validade a ser definida.
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Obtém o ID do Convidado para o qual o convite é emitido.
     *
     * @return O ID do Convidado.
     */
    public String getIdConvidado() {
        return idConvidado;
    }

    /**
     * Define o ID do Convidado para o qual o convite é emitido.
     *
     * @param idConvidado O ID do Convidado a ser definido.
     */
    public void setIdConvidado(String idConvidado) {
        this.idConvidado = idConvidado;
    }

    /**
     * Obtém o Socio que emitiu o convite.
     *
     * @return O Socio que emitiu o convite.
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Define o Socio que emitiu o convite.
     *
     * @param socio O Socio a ser definido como emissor do convite.
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
