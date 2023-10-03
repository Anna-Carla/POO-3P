
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
		boolean resposta = false;
		if (quantFreq == frequentadores.length) {
			System.out.println("Limite de Frequentadores atingidos");
		} else {
			resposta = true;
			frequentadores[quantFreq] = novo;
			System.out.println("\nFrequentador Cadastrado\nID: " + frequentadores[quantFreq].getId() + "\nNome: "
					+ frequentadores[quantFreq].getNome() + "\n");
			quantFreq++;
		}
		return resposta;
	}

	public void imprimirFrequentadores() {
		System.out.println("\nLista de Frequentadores:");

		for (int i = 0; i < quantFreq; i++) {
			System.out.println("ID: " + frequentadores[i].getId());
			System.out.println("Nome: " + frequentadores[i].getNome());
			if (frequentadores[i].isSocio()) {
				System.out.println("Tipo: Socio");
			} else {
				System.out.println("Tipo: Convidado");
			}
			System.out.println();
		}
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

	public Frequentador buscarFrequentador(String idFrequentador) {
		for (int i = 0; i < frequentadores.length; i++) {
			if (idFrequentador.equals(frequentadores[i].getId())) {
				return (Frequentador) frequentadores[i];
			}
		}
		return null;
	}

	public Socio buscarSocio(String idFrequentador) {
		Frequentador frequentadorAtual = buscarFrequentador(idFrequentador);
		if (frequentadorAtual == null) {
			return null;
		}
		for (int i = 0; i < frequentadores.length; i++) {
			if (frequentadorAtual.isSocio()) {
				return (Socio) frequentadores[i];
			}
		}
		return null;
	}

	public Convidado buscarConvidado(String idFrequentador) {
		Frequentador frequentadorAtual = buscarFrequentador(idFrequentador);
		if (frequentadorAtual == null) {
			return null;
		}
		for (int i = 0; i < frequentadores.length; i++) {
			if (frequentadorAtual.isSocio()) {
				return (Convidado) frequentadores[i];
			}
		}
		return null;
	}

	public static boolean estaPresente() {
		return true;
	}
}
