import java.util.HashMap;
import java.util.Map;

public class CurrencyModel {
    private Map<String, Double> conversionRates;

    public CurrencyModel() {
        // Initialize with some hardcoded conversion rates
        conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.73);
        // Add more currencies as needed
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = conversionRates.get(sourceCurrency);
        double targetRate = conversionRates.get(targetCurrency);

        return amount * (1 / sourceRate) * targetRate;
    }
}
