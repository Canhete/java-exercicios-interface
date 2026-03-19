public class MinhaClasseLivro {
    public static class Livro {
        private String titulo;
        private String autor;
        private int anoPublicacao;

        // Constructor
        public Livro(String titulo, String autor, int anoPublicacao) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
        }
        
        // Getters
        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        // Setters
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
        }
    }

    public static class Impressora {
        public void imprimir(Livro l) {
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + l.getAutor());
            System.out.println("Ano de publicação: " + l.getAnoPublicacao());
        }
    }

    public static void main(String[] args) {
        Livro meuLivro = new Livro("Meu Pé de Laranja Lima", "José Mauro", 1968);
        Livro outroLivro = new Livro("Os Lusíadas", "Luís Vaz de Camões", 1572);

        Impressora i = new Impressora();

        i.imprimir(meuLivro);
        i.imprimir(outroLivro);
    }
}