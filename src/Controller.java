
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {

    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ComboBox<String> themeList;
    @FXML
    private BorderPane background;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrectLogin;
    @FXML
    private Button registerButton;
    @FXML
    private CheckBox guest;
    public static boolean guestLogin;
    public static String currentUser;


    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //This function is called when register account button is pressed.
    public void registerAccount(){
        // DO SOMETHING
        System.out.println("test");
    }


    public void switchToMainMenu(ActionEvent event) throws IOException{
        if (checkLogin() || guestLogin){
            currentUser = username.getCharacters().toString();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            incorrectLogin.setOpacity(1f);
        }
        
    }


    public boolean checkLogin(){
        if  (username.getCharacters().toString().equals("username") && password.getCharacters().toString().equals("password")){
            return true;
        }
        return false;
    }

    public boolean enableGuest(){
        if (guest.isSelected()){
            username.setText("");
            username.setEditable(false);
            password.setText("");
            password.setEditable(false);
            registerButton.setDisable(true);
            return guestLogin = true;
        }
        registerButton.setDisable(false);
        username.setEditable(true);
        password.setEditable(true);
        return guestLogin = false;
    }


}
