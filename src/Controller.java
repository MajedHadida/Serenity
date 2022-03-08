
import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Controller {

    final ObservableList<String> THEMES = FXCollections.observableArrayList("Dark","Light");
    
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


    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void switchToMainMenu(ActionEvent event) throws IOException{
        if (checkLogin()){
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            incorrectLogin.setOpacity(1f);
        }
        
    }


    @FXML
    public void initialize() {

    }

    public boolean checkLogin(){
        if  (username.getCharacters().toString().equals("username") && password.getCharacters().toString().equals("password")){
            return true;
        }
        return false;
    }

    public void playAudio(){
         String musicFile = "calm.mp3";     // For example
         Media sound = new Media(new File(musicFile).toURI().toString());
         MediaPlayer mediaPlayer = new MediaPlayer(sound);
         mediaPlayer.play();
     }


}
