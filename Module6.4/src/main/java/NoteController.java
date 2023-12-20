// NoteController.java
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    private Notebook notebook;

    public NoteController() {
        this.notebook = new Notebook();
    }

    @FXML
    private void initialize() {
        // Set up event handling, if needed
    }

    @FXML
    private void handleAddButton() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note("My list", "1. Milk\n2. Eggs\n3. Bread");
            note.setTitle(title);
            note.setContent(content);

            notebook.addNote(note);

            // Update the view (you can add code to display notes in the GUI)
            System.out.println("Note added: " + note);

            // Optional: Clear input fields after adding a note
            titleField.clear();
            contentArea.clear();
        }
    }

    // Optional: Implement additional methods for editing or deleting notes
}

