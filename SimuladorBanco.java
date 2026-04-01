public class SimuladorBanco {
    public static class ContaBancaria {
        private final String titular;
        private double saldo;

        // Construtor
        public ContaBancaria(String titular) {
            this.titular = titular;
            saldo = 0.0f;
        }

        public void depositar(double valor) {
            if (valor <= 0) { // Impede valores negativos e zero como depósito
                throw new IllegalArgumentException("Valor de depósito deve ser positivo. Recebido: " + valor);
            }

            saldo += valor;
            System.out.printf("Sacado %.2f R$%n", valor);
        }

        public void sacar(double valor) {
            if (valor <= 0) {
                throw new IllegalArgumentException("Valor deve ser positivo. Recebido: " + valor);
            }
            if (valor > saldo) {
                throw new IllegalStateException("Saldo insuficiente. Saldo: " + saldo + ", Solicitado: " + valor);
            }

            saldo -= valor;
            System.out.printf("Depositado %.2f R$%n", valor);
        }

        public void verSaldo() {
            System.out.printf("Saldo: %.2f R$%n", saldo);
        }
    }

    public static void main(String[] args) {
        ContaBancaria c = new ContaBancaria("João da Silva");

        c.verSaldo();
        c.depositar(100.00);
        c.sacar(33.58);
        c.verSaldo();
    }
}