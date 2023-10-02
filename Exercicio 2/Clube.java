
public class Clube {
	private Frequentador[] frequentadores;
	private int quantFreq;

	public Clube(int n) {
		if (n <= 2)
			n = 2;
		frequentadores = new Frequentador[n];
		quantFreq = 0;
	}

	public boolean addFrequentador(Frequentador novo) {
		boolean resposta = true;
		if (quantFreq == frequentadores.length)
			resposta = false;
		else {
			for (int i = 0; i < quantFreq && resposta; i++) {
				if (frequentadores[i].getId().equals(novo.getId()))
					resposta = false;
			}
			if (resposta) {
				frequentadores[quantFreq] = novo;
				quantFreq++;
			}
		}
		return resposta;
	}

	

	public void registrarVisita(String idFreq, Data data, Hora horaEntrada) {
		for (int i = 0; i < quantFreq; i++) {
			if (idFreq.equals(frequentadores[i].getId())) {
				frequentadores[i].registrarVisita(data, horaEntrada);
			}
		}
	}

	public void registrarSaida(String idFreq, Data data, Hora horaSaida) {
		for (int i = 0; i < quantFreq; i++) {
			if (idFreq.equals(frequentadores[i].getId())) {
				frequentadores[i].registrarSaida(data, horaSaida);
			}
		}
	}

	public String relatorioVisitasData(Data data) {
		
		StringBuilder relat = new StringBuilder("Visitas em " + data + "\n");
		for (int i = 0; i < quantFreq; i++) {
			if (frequentadores[i].visitouClubeEm(data)) {
				relat.append(frequentadores[i].relatorioVisitas()).append("\n");
			}
		}
		return relat.toString();
	}

	public String relatorioVisitasFreq(String idFreq) {
		for (int i = 0; i < quantFreq; i++) {
			if (idFreq.equals(frequentadores[i].getId())) {
				return frequentadores[i].relatorioVisitas();
			}
		}
		return "Não existe este sócio";
	}

	public Socio buscarSocio(String idFrequentador) {
		for (int i = 0; i < frequentadores.length; i++) {
			if (idFrequentador.equals(frequentadores[i].getId())) {
				return (Socio) frequentadores[i];
			}
		}
		return null;
	}

	public Frequentador buscarFrequentador(String idFrequentador) {
		for (int i = 0; i < frequentadores.length; i++) {
			if (idFrequentador.equals(frequentadores[i].getId())) {
				return (Frequentador) frequentadores[i];
			}
		}
		return null;
	}

	public Convidado buscarConvidado(String idFrequentador) {
		for (int i = 0; i < frequentadores.length; i++) {
			if (idFrequentador.equals(frequentadores[i].getId())) {
				return (Convidado) frequentadores[i];
			}
		}
		return null;
	}

	public boolean verificarConvite(Convidado convidado, Data data, String idSocio) {
		if (convidado.pesquisarConvite(data, idSocio)) {
			return true; // O convite foi encontrado para o convidado com a data e o nome do sócio
							// especificados
		} else {
			return false; // O convite não foi encontrado
		}
	}

	public static boolean estaPresente() {
		return true;
	}
}
