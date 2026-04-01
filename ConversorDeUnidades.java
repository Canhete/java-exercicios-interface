public final class ConversorDeUnidades {
    public static double converterCelsiusFahrenheit(double tempCelsius) {
        return (tempCelsius * 9/5) + 32;
    }

    public static double converterFahrenheitCelsius(double tempFahrenheit) {
        return (tempFahrenheit - 32) * 5/9;
    }

    public static double converterKmMilhas(double km) {
        return km * 0.621371;
    }

    public static double converterMilhasKm(double milhas) {
        return milhas / 0.621371;
    }

    public static void main(String[] args) {
        double tempC = 32.75;
        double tempF = 133.77;
        double km = 32.5;
        double milhas = 120;

        double tempCConvertido = ConversorDeUnidades.converterCelsiusFahrenheit(tempC);
        double tempFConvertido = ConversorDeUnidades.converterFahrenheitCelsius(tempF);
        double kmConvertido = ConversorDeUnidades.converterKmMilhas(km);
        double milhasConvertido = ConversorDeUnidades.converterMilhasKm(milhas);

        System.out.printf("%.2f C = %.2f F%n", tempC, tempCConvertido);
        System.out.printf("%.2f F = %.2f C%n", tempF, tempFConvertido);
        System.out.printf("%.2f Km = %.2f Milhas%n", km, kmConvertido);
        System.out.printf("%.2f Milhas = %.2f Km%n", milhas, milhasConvertido);
    }
}