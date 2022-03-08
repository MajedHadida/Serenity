import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class MenuController {
    //testing change
    final ObservableList<String> THEMES = FXCollections.observableArrayList("Dark","Light");
    @FXML
    private ComboBox<String> themeList;
    @FXML
    private AnchorPane background;


    @FXML
    public void initialize() {
        themeList.setItems(THEMES);
        themeList.setValue("Light");
    }

    public void changeTheme(){
        String theme = themeList.getValue();
         switch (theme){
            case "Dark":
                background.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                break;
            case "Light":
                background.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                break;
            }
    }

}
