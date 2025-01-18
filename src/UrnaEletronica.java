import java.util.ArrayList;
import java.util.List;

public class UrnaEletronica {
    private List<Candidato> candidatos;
    private int votosNulos;

    public UrnaEletronica() {
        candidatos = new ArrayList<>();
        votosNulos = 0;

        candidatos.add(new Candidato("Ada Lovelace", 1));
        candidatos.add(new Candidato("Alan Turing", 2));
        candidatos.add(new Candidato("Marie Curie", 3));
        candidatos.add(new Candidato("Albert Einstein", 4));
        candidatos.add(new Candidato("Ludwig van Beethoven", 5));
    }

    public void receberVoto(int numero) {
        boolean votoValido = false;
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numero) {
                candidato.incrementarVotos();
                votoValido = true;
                break;
            }
        }
        if (!votoValido) {
            votosNulos++;
        }
    }

    public void apurarResultados() {
        int totalVotosValidos = 0;
        for (Candidato candidato : candidatos) {
            totalVotosValidos += candidato.getVotos();
        }

        System.out.println("\nResultado da Votação: ");
        Candidato vencedor = null;
        boolean empate = false;

        for (Candidato candidato : candidatos) {
            double percentual = totalVotosValidos > 0 ? (candidato.getVotos() * 100.0) / totalVotosValidos : 0;
            System.out.printf("%s: %d votos (%.2f%%)\n", candidato.getNome(), candidato.getVotos(), percentual);

            if (vencedor == null || candidato.getVotos() > vencedor.getVotos()) {
                vencedor = candidato;
                empate = false;
            } else if (candidato.getVotos() == vencedor.getVotos()) {
                empate = true;
            }
        }

        System.out.println("Quantidade de votos Nulos: " + votosNulos);
        if (empate) {
            System.out.println("Resultado: Houve empate entre os candidatos com maior número de votos.");
        } else if (vencedor != null) {
            System.out.println("Vencedor: " + vencedor.getNome());
        }
    }
}
