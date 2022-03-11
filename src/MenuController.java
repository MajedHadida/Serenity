

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
    //Question 1 ---------------------
    @FXML
    private Label question1;
    @FXML
    private RadioButton q1o1;
    @FXML
    private RadioButton q1o2;
    @FXML
    private RadioButton q1o3;
    //Question 2 ----------------------
    @FXML
    private Label question2;
    @FXML
    private RadioButton q2o1;
    @FXML
    private RadioButton q2o2;
    @FXML
    private RadioButton q2o3;
    //Question 3 ----------------------
    @FXML
    private Label question3;
    @FXML
    private RadioButton q3o1;
    @FXML
    private RadioButton q3o2;
    @FXML
    private RadioButton q3o3;
    //Question 4 ----------------------
    @FXML
    private Label question4;
    @FXML
    private RadioButton q4o1;
    @FXML
    private RadioButton q4o2;
    @FXML
    private RadioButton q4o3;
    //Question 5 ----------------------
    @FXML
    private Label question5;
    @FXML
    private RadioButton q5o1;
    @FXML
    private RadioButton q5o2;
    @FXML
    private RadioButton q5o3;


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
                question1.setTextFill(Color.WHITE);
                q1o1.setTextFill(Color.WHITE);
                q1o2.setTextFill(Color.WHITE);
                q1o3.setTextFill(Color.WHITE);
                question2.setTextFill(Color.WHITE);
                q2o1.setTextFill(Color.WHITE);
                q2o2.setTextFill(Color.WHITE);
                q2o3.setTextFill(Color.WHITE);
                question3.setTextFill(Color.WHITE);
                q3o1.setTextFill(Color.WHITE);
                q3o2.setTextFill(Color.WHITE);
                q3o3.setTextFill(Color.WHITE);
                question4.setTextFill(Color.WHITE);
                q4o1.setTextFill(Color.WHITE);
                q4o2.setTextFill(Color.WHITE);
                q4o3.setTextFill(Color.WHITE);
                question5.setTextFill(Color.WHITE);
                q5o1.setTextFill(Color.WHITE);
                q5o2.setTextFill(Color.WHITE);
                q5o3.setTextFill(Color.WHITE);
                break;
            case "Light":
                fullBackground.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                //Can't really figure out how to make an array of all the labels and iterate through all of them and change colour through a for loop...
                //Maybe fix this later?
                welcomeMsg.setTextFill(Color.BLACK);
                instrcText.setTextFill(Color.BLACK);
                question1.setTextFill(Color.BLACK);
                q1o1.setTextFill(Color.BLACK);
                q1o2.setTextFill(Color.BLACK);
                q1o3.setTextFill(Color.BLACK);
                question2.setTextFill(Color.BLACK);
                q2o1.setTextFill(Color.BLACK);
                q2o2.setTextFill(Color.BLACK);
                q2o3.setTextFill(Color.BLACK);
                question3.setTextFill(Color.BLACK);
                q3o1.setTextFill(Color.BLACK);
                q3o2.setTextFill(Color.BLACK);
                q3o3.setTextFill(Color.BLACK);
                question4.setTextFill(Color.BLACK);
                q4o1.setTextFill(Color.BLACK);
                q4o2.setTextFill(Color.BLACK);
                q4o3.setTextFill(Color.BLACK);
                question5.setTextFill(Color.BLACK);
                q5o1.setTextFill(Color.BLACK);
                q5o2.setTextFill(Color.BLACK);
                q5o3.setTextFill(Color.BLACK);

                break;
            }
    }

}
