public class Convite {
    private Socio socio;
    private Convidado convidado;
    private Data data;

    public Convite(Socio socio, Convidado convidado, Data data) {
        this.socio = socio;
        this.convidado = convidado;
        this.data = data;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
