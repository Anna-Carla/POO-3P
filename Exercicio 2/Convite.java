public class Convite {
    private Convidado convidado;
    private Data data;
    private String idSocio;

    public Convite(String idSocio, Convidado convidado, Data data) {
        this.idSocio = idSocio;
        this.convidado = convidado;
        this.data = data;
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


    public String getIdSocio() {
        return idSocio;
    }


    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

}
