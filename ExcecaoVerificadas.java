import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ExcecaoVerificadas {
    public static String lerPrimeiraLinha(String caminho) throws IOException {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            return leitor.readLine();
        }
    }

    public static void main(String[] args) {
        try {
            String linha = lerPrimeiraLinha("texto.txt");
            System.out.println("Primeira linha de 'texto.txt': " + linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}