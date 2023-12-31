/**
 * Representa um convite emitido por um Socio para um Convidado em um clube.
 */
public class Convite {
    protected Socio socio;
    protected String idConvidado;
    private Data data;

    public Convite(String idConvidado, Socio socio, Data data) {
        this.idConvidado = idConvidado;
        this.socio = socio;
        this.data = data;
    }

    //GETTERS E SETTERS DA CLASSE
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(String idConvidado) {
        this.idConvidado = idConvidado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
