import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class EdenMesozoico {
    // Exceptions
    public static class DinossauroMalTratadoException extends Exception {
        private final String nome;
        private final int saude;

        public DinossauroMalTratadoException(String nome, int saude) {
            super("[-]" + nome + " não foi tratado corretamente, ainda está doente! Saúde: " + saude);
            this.nome = nome;
            this.saude = saude;
        }

        public int getSaude() {
            return saude;
        }
        public String getNome() {
            return nome;
        }
    }

    public static class DinossauroDoenteException extends Exception {
        private final String nome;
        private final int saude;

        public DinossauroDoenteException(String nome, int saude) {
            super("[-] " + nome + " está doente! Saúde: " + saude);
            this.nome = nome;
            this.saude = saude;
        }

        public int getSaude() {
            return saude;
        }
    }

    public static class BrechaContencaoException extends Exception {
        private final String nomeDino;
        private final String nomeRecinto;

        public BrechaContencaoException(String nomeDino, String nomeRecinto) {
            super("[!!!] " + nomeDino + " escapou do recinto '" + nomeRecinto + "', Alerta de Brecha de Contenção!");
            this.nomeDino = nomeDino;
            this.nomeRecinto = nomeRecinto;
        }

        public String getNomeDino() {
            return nomeDino;
        }

        public String getNomeRecinto() {
            return nomeRecinto;
        }
    }

    public static class FalhaConterDinossauroException extends Exception {
        private final String nomeDino;
        private final String nomeRecinto;

        public FalhaConterDinossauroException(String nomeDino, String nomeRecinto) {
            super("[!] Falha ao conter " + nomeDino + " de volta para recinto '" + nomeRecinto + "', ainda está solto!");
            this.nomeDino = nomeDino;
            this.nomeRecinto = nomeRecinto;
        }

        public String getNomeDino() {
            return nomeDino;
        }

        public String getNomeRecinto() {
            return nomeRecinto;
        }
    }

    // Recinto
    public static class Recinto { // Recinto existe separadamente de Dinossauro então trata-se de Agregação
        private final String nome;
        private int nivelSegurança;
        private Dinossauro dinossauro;

        // Construtor padrão força a colocar um Dinossauro por Recinto
        public Recinto(String nome, Dinossauro dinossauro) {
            this.dinossauro = dinossauro;
            this.nome = nome;
            dinossauro.setRecinto(this);
            nivelSegurança = new Random().nextInt(5) + 1; // Nível de segurança varia de 1 a 5;
        }

        // Métodos
        public void checarSeguranca() throws BrechaContencaoException {
            System.out.printf("Checando a segurança do Recinto '%s'...%n%n", nome);

            int chanceEscapar = new Random().nextInt(100) + 1; // Chance de escapar é aleatória de 1 a 100
            int chanceConter = Math.min(new Random().nextInt(100) + 1 + nivelSegurança * 10, 100); // Chance de conter também é aleatória de 1 a 100, somando bônus de segurança

            if (nivelSegurança == 1) {
                System.out.printf("> Nível de segurança: %d - Hostil%n", nivelSegurança);
            } else if (nivelSegurança == 2) {
                System.out.printf("> Nível de segurança: %d - Inseguro%n", nivelSegurança);
            } else if (nivelSegurança == 3) {
                System.out.printf("> Nível de segurança: %d - Moderado%n", nivelSegurança);
            } else if (nivelSegurança == 4) {
                System.out.printf("> Nível de segurança: %d - Seguro%n", nivelSegurança);
            } else {
                System.out.printf("> Nível de segurança: %d - Máxima Segurança%n%n", nivelSegurança);
            }

            System.out.printf("> Chances de Brecha de Contenção: %d%%%n%n", chanceEscapar % chanceConter);

            int tentaFugir = new Random().nextInt(2); // Bem simples, o dinossauro pode ou não tentar fugir 50%

            if (tentaFugir == 1) {
                System.out.printf("[!] %s está tentando fugir!%n", dinossauro.nome);

                if (chanceEscapar >= chanceConter) { // Chance de escapar é comparada com o nível de segurança
                    throw new BrechaContencaoException(dinossauro.nome, nome); // Dinossauro escapou!
                }

                System.out.printf("[!] %s falhou em fugir.%n%n", dinossauro.nome); // Falha em fugir
            } else {
                System.out.printf("[OK] Todos os portões do recinto '%s' estão seguros!%n%n", nome);
            }
        }

        public void tentarConter() throws FalhaConterDinossauroException {
            System.out.printf("Tentando conter %s...%n", dinossauro.nome);

            int chanceConter = Math.min(new Random().nextInt(20) + 1 + nivelSegurança, 20); // Um valor aleatório de 1 a 20 somado ao valor de nivelSegurança (quanto mais seguro, maiores as chances de conseguir conter de volta);

            if (chanceConter >= dinossauro.vontadeFugir) {
                throw new FalhaConterDinossauroException(dinossauro.nome, nome);
            }

            System.out.printf("[OK] %s contido com sucesso!%n", dinossauro.nome);
        }

        // Getters
        public String getNome() {
            return nome;
        }
    }

    // Interfaces
    public interface Tratavel {
        public abstract void realizarExame() throws DinossauroDoenteException;
        public abstract void tratar() throws DinossauroMalTratadoException;
    }

    // Classe pai
    public static abstract class Dinossauro implements Tratavel {
        protected final String nome;
        private int saude;
        private final int saudavel; // Parâmetro para determinar o limite saudável de saúde
        private Recinto recinto; // Cada dinossauro mora num recinto
        private int vontadeFugir; // Parâmetro usado para determinar o quão inclinado o dinossauro está a fugir do recinto

        public Dinossauro(String nome) {
            this.nome = nome;
            saudavel = new Random().nextInt(6) + 6; // Valor saudável aleatório entre 6 e 12;
            saude = new Random().nextInt(20) + 1; // Gera um número aleatório de 1 a 20 para determinar o valor da saúde do dinossauro;
            vontadeFugir = new Random().nextInt(20) + 1; // Valor aleatório de 1 a 20 para determinar o quanto o dinossauro quer fugir;
        }

        @Override
        public void realizarExame() throws DinossauroDoenteException {
            System.out.printf("Realizando exame em %s...%n%n", nome);

            if (saude <= saudavel) { // Se a saúde for menor que 8, o dinossauro está doente
                throw new DinossauroDoenteException(nome, saude);
            }

            System.out.printf("> %s está saudável! Saúde: %d%n", nome, saude);
        }

        @Override
        public void tratar() throws DinossauroMalTratadoException{
            System.out.printf("Tratando %s...%n", nome);

            saude = Math.min(saude + new Random().nextInt(20) + 1, 20); // Trata o dinossauro somando um número aleatório de 1 a 20, no máximo sendo 20;

            if (saude <= saudavel) {
                throw new DinossauroMalTratadoException(nome, saude);
            }

            System.out.printf("[+] %s tratado com sucesso! Saúde: %d%n%n", nome, saude);
        }

        // Métodos da classe
        public void alimentar() {
            System.out.println("Alimentando dinossauro...");
        }

        // Setters
        private void setRecinto(Recinto recinto) {
            this.recinto = recinto;
        }

        // Getters
        public String getNome() {
            return nome;
        }

        public int getSaude() {
            return saude;
        }

        public int getSaudavel() {
            return saudavel;
        }

        public Recinto getRecinto() {
            return recinto;
        }
    }

    public static class Carnivoro extends Dinossauro {
        private final String dieta;

        public Carnivoro(String nome, String dieta) {
            super(nome);
            this.dieta = dieta;
        }

        @Override
        public void realizarExame() throws DinossauroDoenteException {
            super.realizarExame();
            System.out.printf("> %s é carnívoro, se alimenta de %s.%n%n", getNome(), dieta);
        }

        @Override
        public void alimentar() {
            super.alimentar();

            System.out.printf("%s está devorando %s.%n%n", nome, dieta);
        }
    }

    public static class Herbivoro extends Dinossauro {
        private final String dieta;

        public Herbivoro(String nome, String dieta) {
            super(nome);
            this.dieta = dieta;
        }

        @Override
        public void realizarExame() throws DinossauroDoenteException {
            super.realizarExame();
            System.out.printf("> %s é herbívoro, se alimenta de %s.%n%n", getNome(), dieta);
        }

        @Override
        public void alimentar() {
            super.alimentar();

            System.out.printf("%s está mastigando %s.%n%n", nome, dieta);
        }
    }

    // Função utilitaria
    public static String centralizar(String texto, int largura) {
        int padding = (largura - texto.length()) / 2;
        return String.format("%" + (padding + texto.length()) + "s", texto);
    }

    public static void main(String[] args) {
        // Lista de dinossauros no Zoologico
        List<Dinossauro> dinossauros = new ArrayList<>(List.of(
                // Carnivoros
                new Carnivoro("Tyrannosaurus Rex", "Carne"),
                new Carnivoro("Velociraptor", "Carne"),
                new Carnivoro("Spinosaurus", "Carne e Peixe"),
                new Carnivoro("Allosaurus", "Carne"),
                new Carnivoro("Dilophosaurus", "Carne"),

                // Herbivoros
                new Herbivoro("Triceratops", "Plantas e Folhas"),
                new Herbivoro("Brachiosaurus", "Folhas de Árvores"),
                new Herbivoro("Stegosaurus", "Plantas Rasteiras"),
                new Herbivoro("Ankylosaurus", "Vegetação Baixa"),
                new Herbivoro("Parasaurolophus", "Folhas e Galhos")
        ));

        // Lista de recintos
        List<Recinto> recintos = new ArrayList<>(List.of(
                // Carnivoros
                new Recinto("Setor do Rei", dinossauros.get(0)),           // T-Rex
                new Recinto("Jaula das Garras", dinossauros.get(1)),       // Velociraptor
                new Recinto("Arena do Espinho", dinossauros.get(2)),       // Spinosaurus
                new Recinto("Covil do Predador", dinossauros.get(3)),      // Allosaurus
                new Recinto("Recinto do Escupidor", dinossauros.get(4)),   // Dilophosaurus

                // Herbivoros
                new Recinto("Prado dos Chifres", dinossauros.get(5)),      // Triceratops
                new Recinto("Vale dos Gigantes", dinossauros.get(6)),      // Brachiosaurus
                new Recinto("Clareira das Placas", dinossauros.get(7)),    // Stegosaurus
                new Recinto("Fortaleza Blindada", dinossauros.get(8)),     // Ankylosaurus
                new Recinto("Jardim dos Cristas", dinossauros.get(9))      // Parasaurolophus
        ));

        // Para cada dinossauro
        for (Dinossauro d : dinossauros) {
            // Tenta realizar exame em cada dinossauro
            try {
                System.out.printf("=============================[ %-20s ]=================================%n", centralizar(d.getNome(), 20));
                d.realizarExame();

            } catch (DinossauroDoenteException e) { // Pegou dinossauro doente
               System.out.println(e.getMessage());
                System.out.println();

               // Tenta tratar dinossauro doente, até 5 vezes para evitar loop infinito, porque são valores de tratamento são aleatórios
                int tentativas = 0;
                boolean tratado = false;
               while (!tratado && tentativas < 5) { // Enquanto não for tratado e tentativas não ultrapassarem 5
                   try { // Tenta tratar dinossauro
                       d.tratar();
                       tratado = true;
                   } catch (DinossauroMalTratadoException ex) { // Tratamento deu errado, tenta novamente
                       System.out.println(ex.getMessage());
                       System.out.println("Tentando novamente...");
                       tentativas++;
                   }
               }

               // Falhou as 5 tentativas
               if (!tratado) {
                   System.out.printf("%n%s não respondeu ao tratamento após 5 tentativas.%n%n", d.getNome());
               }
            }

            d.alimentar();

            System.out.println("--------------------------------------------------------------------------------------");

            // Depois de verificar a saúde checa a segurança
            try {
                d.getRecinto().checarSeguranca();

            } catch (BrechaContencaoException e) { // Pegou dinossauro tentando fugir
                System.out.println(e.getMessage());
                System.out.println();

                // Tenta conter Dinossauro, até 3 tentativas de contenção para evitar loop infinito;
                int tentativas = 0;
                boolean contido = false;
                while (!contido && tentativas < 3) {
                    try {
                        d.getRecinto().tentarConter();
                        contido = true;
                    } catch (FalhaConterDinossauroException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("Tentando novamente...");
                        tentativas++;
                    }
                }

                if (!contido) {
                    System.out.printf("%n%s não foi contido de volta ao recinto '%s' após 3 tentativas.%n", d.getNome(), d.getRecinto().getNome());
                    System.out.printf("[!!!] %s está solto no parque, Alerta de Evacuação!%n%n", d.getNome());
                }
            }
        }

        System.out.println("======================================================================================");
    }
}