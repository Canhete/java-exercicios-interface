import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

public class EquipeJogadores {
    public static class Equipe {
        private String nome;
        private List<Jogador> jogadores;

        public Equipe(String nome) {
            this.nome = nome;
            jogadores = new ArrayList<>();
        }

        public void adicionarJogador(Jogador j) {
             jogadores.add(j);
        }

        public void exibirJogadores() {
            System.out.printf("--- Equipe %s ---%n", nome);
            for (Jogador j : jogadores) {
                System.out.println(j.getNome());
            }
        }
    }

    public static class Jogador {
        private String nome;

        public Jogador(String nome) {
            if (nome == null || nome.isBlank()) {
                throw new IllegalArgumentException("Nome não pode ser nulo ou vazio. Nome: " + nome);
            }

            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public static void main(String[] args) {
        Equipe rocket = new Equipe("Equipe Rocket");

        Jogador jesse = new Jogador("Jesse");
        Jogador james = new Jogador("James");
        Jogador meowth = new Jogador("Meowth");

        rocket.adicionarJogador(jesse);
        rocket.adicionarJogador(james);
        rocket.adicionarJogador(meowth);

        rocket.exibirJogadores();
    }
}