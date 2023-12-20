package Task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;
    private TextField wordTextField;
    private TextArea meaningTextArea;

    @Override
    public void start(Stage stage) {
        // Initialize model and controller
        Dictionary dictionary = new Dictionary();
        controller = new DictionaryController(dictionary);

        // Initialize UI components
        wordTextField = new TextField();
        Button searchButton = new Button("Search");
        meaningTextArea = new TextArea();
        meaningTextArea.setEditable(false);

        // Set up layout
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);

        // Add components to the layout
        pane.getChildren().addAll(wordTextField, searchButton, meaningTextArea);

        // Set up event handling
        searchButton.setOnAction(e -> searchWord());

        // Set up scene
        Scene scene = new Scene(pane, 400, 200);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    private void searchWord() {
        String word = wordTextField.getText().trim();
        if (!word.isEmpty()) {
            String meaning = controller.searchWord(word);
            meaningTextArea.setText(meaning);
        } else {
            // Handle empty word input
            meaningTextArea.setText("Please enter a word.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

