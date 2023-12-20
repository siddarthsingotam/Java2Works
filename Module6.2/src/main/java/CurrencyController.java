import javafx.application.Application;
import javafx.stage.Stage;

public class CurrencyController extends Application {

    private CurrencyModel model;
    private CurrencyView view;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        model = new CurrencyModel();
        view = new CurrencyView();

        // Initialize choice boxes with currencies
        view.getSourceCurrencyChoiceBox().getItems().addAll(model.getConversionRates().keySet());
        view.getTargetCurrencyChoiceBox().getItems().addAll(model.getConversionRates().keySet());

        // Set event handler for the convert button
        view.getConvertButton().setOnAction(e -> handleConvertButton());

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }

    private void handleConvertButton() {
        try {
            double amount = Double.parseDouble(view.getAmountTextField().getText());
            String sourceCurrency = view.getSourceCurrencyChoiceBox().getValue();
            String targetCurrency = view.getTargetCurrencyChoiceBox().getValue();

            double result = model.convert(amount, sourceCurrency, targetCurrency);

            view.getResultTextField().setText(String.format("%.2f %s", result, targetCurrency));
        } catch (NumberFormatException | NullPointerException ex) {
            // Handle invalid input
            view.getResultTextField().setText("Invalid input");
        }
    }
}