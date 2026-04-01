public class MotoristaECarro {
    public static class Motorista {
        private String nome;

        public Motorista(String nome) {
            this.nome = nome;
        }

        public void dirigir(Carro carro) {
            carro.ligar();

            System.out.printf("%s está dirigindo %s%n", nome, carro.getMarca());
        }

        public String getNome() {
            return nome;
        }
    }

    public static class Carro {
        private String marca;

        public Carro(String marca) {
            this.marca = marca;
        }

        public void ligar() {
            System.out.printf("%s está ligando...%n", marca);
        }

        public String getMarca() {
            return marca;
        }
    }

    public static void main(String[] args) {
        Motorista m = new Motorista("João");
        Carro c = new Carro("Honda");

        m.dirigir(c);
    }
}