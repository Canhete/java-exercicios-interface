public class Animais {
    public static class Animal {
        protected String nome; // Apenas subclasses acessam o atributo

        public Animal(String nome) {
            this.nome = nome;
        }

        // Método padrão da classe genérica
        public void emitirSom() {
            System.out.println("Som de animal");
        }
    }

    public static class Cachorro extends Animal {
       public Cachorro(String nome) {
           super(nome);
       }

       // Métodos
        @Override
        public void emitirSom() {
            super.emitirSom();

            System.out.println(nome + " diz au au!");
        }

        public void buscarBolinha() {
            System.out.println(nome + " foi buscar a bolinha!");
        }
    }

    public static class Gato extends Animal {
        public Gato(String nome) {
            super(nome);
        }

        @Override
        public void emitirSom() {
            super.emitirSom();

            System.out.println(nome + " diz miau!");
        }
    }

    public static class Veterinario {
        private String nome;

        public Veterinario(String nome) {
            this.nome = nome;
        }

        // Método
        public void examinar(Animal animal) {
            System.out.println(nome + " está examinando " + animal.nome + "...");

            animal.emitirSom();
        }
    }

    public static void main(String[] args) {
        // Instanciação de cada classe
        Animal animal = new Animal("Animal genérico");
        Cachorro cachorro = new Cachorro("Cachorro");
        Gato gato = new Gato("Gato");

        // Classe veterinário
        Veterinario joao = new Veterinario("João");

        // Som de todas classes
        animal.emitirSom();
        cachorro.emitirSom();
        gato.emitirSom();

        // O Veterinário examina uma dessas classes
        joao.examinar(gato);

        // Upcasting implícito
        Animal toby = new Cachorro("Toby");

        // toby.buscarBolinha(); --> Causa erro de compilação
        // Animal não reconhece o método buscarBolinha()

        // Down casting explícito
        if (toby instanceof Cachorro c) {
            c.buscarBolinha();
        }

        // Testando para Gato
        // Não funciona porque Gato não é Cachorro e não tem método específico buscarBolinha()
        Animal bolaNeve = new Gato("Bola de neve");
        if (bolaNeve instanceof Cachorro c) {
           c.buscarBolinha();
        } else {
           System.out.println(bolaNeve.nome + " não é um cachorro!");
        }
    }
}