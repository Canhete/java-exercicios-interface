import java.util.ArrayList;
import java.util.List;

public class CriarCasa {
    public static class Casa {
        private String endereco;
        private List<Quarto> quartos;

        public Casa(String endereco, List<String> nomesQuartos) {
            this.endereco = endereco;
            quartos = new ArrayList<>();
            for (String nome : nomesQuartos) {
                quartos.add(new Quarto(nome));
            }
        }

        public void info() {
            System.out.printf("Endereço: %s%n", endereco);
            System.out.println("--- Cômodos ---");
            for (Quarto q : quartos) {
                System.out.printf("%s%n", q.getNome());
            }
        }

        public List<Quarto> getQuartos() {
            return quartos;
        }
    }

    public static class Quarto {
        private String nome;

        public Quarto(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public static void main(String[] args) {
        Casa casa = new Casa(
                "Rua Maria Augusta",
                List.of("Quarto", "Cozinha", "Banheiro", "Sala", "Garagem")
        );

        casa.info();
    }
}