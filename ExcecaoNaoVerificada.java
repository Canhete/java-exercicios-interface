public class ExcecaoNaoVerificada {
    public static void main(String[] args) {
        int[] array = new int[3];

        array[0] = 1;
        array[1] = 5;
        array[2] = 9;

        try {
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Não foi possível acessar o indice 5 do array.Ex Tamanho do array: " + array.length);
        }
    }
}