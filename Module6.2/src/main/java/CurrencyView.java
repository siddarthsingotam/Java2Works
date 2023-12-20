import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyView extends Application {

    private TextField amountTextField;
    private ChoiceBox<String> sourceCurrencyChoiceBox;
    private ChoiceBox<String> targetCurrencyChoiceBox;
    private TextField resultTextField;
    private Button convertButton;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        amountTextField = new TextField();
        Label amountLabel = new Label("Amount:");

        sourceCurrencyChoiceBox = new ChoiceBox<>();
        Label sourceCurrencyLabel = new Label("Source Currency:");

        targetCurrencyChoiceBox = new ChoiceBox<>();
        Label targetCurrencyLabel = new Label("Target Currency:");

        convertButton = new Button("Convert");
        resultTextField = new TextField();
        resultTextField.setEditable(false);
        Label resultLabel = new Label("Result:");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(
                amountLabel, amountTextField,
                sourceCurrencyLabel, sourceCurrencyChoiceBox,
                targetCurrencyLabel, targetCurrencyChoiceBox,
                convertButton,
                resultLabel, resultTextField
        );

        scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public TextField getAmountTextField() {
        return amountTextField;
    }

    public ChoiceBox<String> getSourceCurrencyChoiceBox() {
        return sourceCurrencyChoiceBox;
    }

    public ChoiceBox<String> getTargetCurrencyChoiceBox() {
        return targetCurrencyChoiceBox;
    }

    public TextField getResultTextField() {
        return resultTextField;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public Scene getScene() {
        return scene;
    }
}