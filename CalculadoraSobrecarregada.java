public class CalculadoraSobrecarregada {
    public class Calculadora {
        public static int somar(int a, int b) {
            return a + b;
        }
        public static int somar(int a, int b, int c) {
            return a + b + c;
        }
        public static double somar(double a, double b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        int a = 1337;
        int b = 66;
        int c = 250039;
        double pi = 3.145926;
        double e = 2.71828;

        System.out.printf("%d + %d = %d%n", a, b, Calculadora.somar(a,b));
        System.out.printf("%d + %d + %d = %d%n", a, b, c, Calculadora.somar(a,b,c));
        System.out.printf("%f + %f = %f%n", pi, e, Calculadora.somar(pi,e));
    }
}