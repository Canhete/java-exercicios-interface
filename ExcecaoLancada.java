public class ExcecaoLancada {
    public static class Funcionario {
        private String nome;
        private int idade;

        public Funcionario(String nome, int idade) {
            if (idade < 16) { // Verifica também no constructor
                throw new IllegalArgumentException("A idade mínima para contratação é 16 anos");
            }

            this.nome = nome;
            this.idade = idade;
        }

        public void setIdade(int idade) {
            if (idade < 16) { // Impede funcionarios menor de 16
                throw new IllegalArgumentException("A idade mínima para contratação é 16 anos");
            }

            this.idade = idade;
        }
    }

    public static void main(String[] args) {
        Funcionario enzo = new Funcionario("Enzo", 15);
    }
}