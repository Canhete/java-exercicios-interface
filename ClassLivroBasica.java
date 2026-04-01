public class ClassLivroBasica {
    public static class Livro {
        private String titulo;
        private String autor;
        private int anoPublicacao;

        // Setters
        public Livro(String titulo, String autor, int anoPublicacao) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
        }

        // Getters
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        public int getAnoPublicacao() { return anoPublicacao; }

        // Setters
        public void setTitulo(String titulo) { this.titulo = titulo; }
        public void setAutor(String autor) { this.autor = autor; }
        public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    }

    public static void main(String[] args) {
        Livro meu_pe_laranja = new Livro("Meu Pé de Laranja Lima", "José Mauro", 1968);
        Livro os_setoes = new Livro("Os Sertões", "Euclides da Cunha", 1902);

        System.out.printf("%s, %s, %d%n", meu_pe_laranja.getTitulo(), meu_pe_laranja.getAutor(), meu_pe_laranja.getAnoPublicacao());
        System.out.printf("%s, %s, %d%n", os_setoes.getTitulo(), os_setoes.getAutor(), os_setoes.getAnoPublicacao());
    }
}