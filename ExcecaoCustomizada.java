public class ExcecaoCustomizada {
    public static class EstoqueInsuficienteException extends Exception {
        private final int estoqueDisponivel;
        private final int quantidadeSolicitada;

        public EstoqueInsuficienteException(int estoqueDisponivel, int quantidadeSolicitada) {
            super("Estoque insuficiente. Disponível: " + estoqueDisponivel + ", Solicitado: " + quantidadeSolicitada);
            this.estoqueDisponivel = estoqueDisponivel;
            this.quantidadeSolicitada = quantidadeSolicitada;
        }

        public int getEstoqueDisponivel() {
            return estoqueDisponivel;
        }
        public int getQuantidadeSolicitada() {
            return quantidadeSolicitada;
        }
    }

    public static class Produto {
        private String nome;
        private int estoque;

        public Produto(String nome, int estoque) {
            this.nome = nome;
            this.estoque = estoque;
        }

        public void reduzirEstoque(int quantidade) throws EstoqueInsuficienteException {
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser positiva.");
            }
            if (quantidade > estoque) {
                throw new EstoqueInsuficienteException(estoque, quantidade);
            }

            estoque -= quantidade;
            System.out.println("Compra feita com sucesso. Estoque restante: " + estoque);
        }
    }

    public static void main(String[] args) {
        Produto produto = new Produto("Televisão", 10);

        try {
            produto.reduzirEstoque(3);
            produto.reduzirEstoque(10);
        } catch (EstoqueInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}