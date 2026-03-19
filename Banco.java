public class Banco {
    public static class ContaBancaria {
        private String titular;
        private double saldo;

        // Constructor
        public ContaBancaria(String titular) {
            this.titular = titular;
            saldo = 0.0f;
        }

        // Métodos
        public void depositar(double valor) {
            if (valor <= 0) {
                throw new Exception("Valor de depósito negativo");
            }
            this.saldo += valor;
        }

        public void sacar(double valor) {

        }

        // Getters
        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }
    }
}