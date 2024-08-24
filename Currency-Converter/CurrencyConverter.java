import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter {

    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {

        exchangeRates.put("USD", 1.0);  //BASE 
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("GBP", 0.75);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        System.out.println("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Currency not supported.");
            return;
        }

        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);

        scanner.close();
        
    }

    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        return amount * (targetRate / baseRate);
    }
}