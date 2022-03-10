

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;


public class MenuController {


    final ObservableList<String> THEMES = FXCollections.observableArrayList("Dark","Light");
    @FXML
    private ComboBox<String> themeList;
    @FXML
    private AnchorPane background;
    @FXML
    private TabPane fullBackground;
    @FXML
    private Label welcomeMsg;
    @FXML
    private Label instrcText;



    @FXML
    public void initialize() {
        System.out.println(instrcText);
        themeList.setItems(THEMES);
        themeList.setValue("Light");
        if (!Controller.guestLogin){
            welcomeMsg.setText("Welcome back, "+Controller.currentUser+"!");
        }else{
            welcomeMsg.setText("Welcome back!");
        }
    
        
    }



    public void changeTheme(){
        String theme = themeList.getValue();
         switch (theme){
            case "Dark":
                fullBackground.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                //Can't really figure out how to make an array of all the labels and iterate through all of them and change colour through a for loop...
                //Maybe fix this later?
                welcomeMsg.setTextFill(Color.WHITE);
                instrcText.setTextFill(Color.WHITE);
                break;
            case "Light":
                fullBackground.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                //Can't really figure out how to make an array of all the labels and iterate through all of them and change colour through a for loop...
                //Maybe fix this later?
                welcomeMsg.setTextFill(Color.BLACK);
                instrcText.setTextFill(Color.BLACK);

                break;
            }
    }

}
