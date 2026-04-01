public class PagamentoCompras {
    public static class CarrinhoDeCompras {
        private double total;

        public CarrinhoDeCompras() {
            total = 0;
        }

        public void adicionarItem(double valor) {
            total += valor;
        }

        public void realizarCheckout(FormaPagamento forma) {
            if (total <= 0) {
                throw new IllegalStateException("Carrinho vazio. Valor em carrinho: " + total);
            }

            forma.processarPagamento(total);
        }
    }

    public interface FormaPagamento {
        public abstract void processarPagamento(double valor);
    }

    public static class PagamentoCartao implements FormaPagamento {
        @Override
        public void processarPagamento(double valor) {
            System.out.printf("Pagamento de %.2f R$ processado via Cartão.%n", valor);
        }
    }

    public static class PagamentoPix implements FormaPagamento {
        @Override
        public void processarPagamento(double valor) {
            System.out.printf("Pagamento de %.2f R$ processado via Pix.%n", valor);
        }
    }

    public static void main(String[] args) {
        // Pagamento com cartão
        CarrinhoDeCompras carrinhoCartao = new CarrinhoDeCompras();
        carrinhoCartao.adicionarItem(10.00);
        carrinhoCartao.adicionarItem(20.00);
        carrinhoCartao.adicionarItem(14.59);
        carrinhoCartao.realizarCheckout(new PagamentoCartao());

        // Pagamento com pix
        CarrinhoDeCompras carrinhoPix = new CarrinhoDeCompras();
        carrinhoPix.adicionarItem(59.99);
        carrinhoPix.adicionarItem(20.49);
        carrinhoPix.realizarCheckout(new PagamentoPix());

    }
}