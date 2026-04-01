import java.util.ArrayList;
import java.util.List;

public class OContador {
    public static class Visitante {
        private String nome;
        private int idade;
        private static int totalVisitantes = 0;

        // Constructor
        public Visitante(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
            totalVisitantes += 1;
        }

        // Getters
        public String getNome() {
            return nome;
        }
        public int getIdade() {
            return idade;
        }
        public static int getTotalVisitantes() {
            return totalVisitantes;
        }
    }

    public static void main(String[] args) {
        List<Visitante> visitantes = new ArrayList<>(List.of(
                new Visitante("Ana", 24),
                new Visitante("Beto", 25),
                new Visitante("Camelia", 31),
                new Visitante("Dante", 75),
                new Visitante("Edu", 18)
        ));

        for (Visitante v : visitantes) {
            System.out.printf("%s, %d anos%n", v.getNome(), v.getIdade());
        }

        System.out.printf("Total visitantes: %d%n", Visitante.getTotalVisitantes());
    }
}