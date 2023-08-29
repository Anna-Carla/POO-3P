import java.util.ArrayList;

public class Partida {

    private String equipe1;
    private String equipe2;
    private int periodo;
    private ArrayList<Integer> ptEquipe1 = new ArrayList<>();
    private ArrayList<Integer> ptEquipe2 = new ArrayList<>();

    public Partida(String equipe1, String equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.periodo = 0;
    }

    public void pontuacaoPeriodo(int pontosEquipe1, int pontosEquipe2) {
        if (!verificarEmpate()) {
            ptEquipe1.add(pontosEquipe1);
            ptEquipe2.add(pontosEquipe2);
            periodo++;
        }
    }

        private int somarPontuacao(ArrayList<Integer> pontos) {
        int somaPontos = 0;
        for (int i = 0; i < pontos.size(); i++) {
            somaPontos += pontos.get(i);
        }
        return somaPontos;
    }

    public boolean verificarEmpate() {
        int empate = somarPontuacao(ptEquipe1) - somarPontuacao(ptEquipe2);
        return periodo >= 4 && empate != 0;
    }

    public String verificarVencedor() {
        if (somarPontuacao(ptEquipe1) > somarPontuacao(ptEquipe2)) {
            return equipe1;
        } else {
            return equipe2;
        }
    }

    public String placar() {
        String result = "\t\t1Q\t2Q\t3Q\t4Q\t";

        for (int i = 1; i <= periodo - 4; i++) {
            result += "PR" + i + "\t";
        }

        result += "FINAL\n" + equipe1 + tabEquipe(equipe1);
        result += pontuacaoString(ptEquipe1) + "\n";
        result += equipe2 + tabEquipe(equipe2);
        result += pontuacaoString(ptEquipe2) + "\n";
        return result;
    }

    private String tabEquipe(String equipe) {
        return (equipe.length() / 8 > 0) ? "\t" : "\t\t";
    }

    private String pontuacaoString(ArrayList<Integer> pontos) {
        String result = "";
        for (int i = 0; i < pontos.size(); i++) {
            result += pontos.get(i) + "\t";
        }
        result += somarPontuacao(pontos) + "\n";
        return result;
    }

}