

import java.io.File;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;


public class MenuController {


    final ObservableList<String> THEMES = FXCollections.observableArrayList("Dark","Light");
    final ObservableList<Integer> BREATHINGTIMES = FXCollections.observableArrayList(1,2,5);
    Timer timer = new Timer();
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
    private Button submitQ;
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
    //Question 6 ----------------------
    @FXML
    private Label question6;
    @FXML
    private RadioButton q6o1;
    @FXML
    private RadioButton q6o2;
    @FXML
    private RadioButton q6o3;
    //Toggle groups ------------------
    @FXML
    private ToggleGroup question1group;
    @FXML
    private ToggleGroup question2group;
    @FXML
    private ToggleGroup question3group;
    @FXML
    private ToggleGroup question4group;
    @FXML
    private ToggleGroup question5group;
    //Array of objects (buttons, labels, togglegroups, etc...)
    public ToggleGroup[] questionGroups;
    public Button[] allButtons;
    public RadioButton[] allRadioButtons;
    //Breathe Menu Objects
    @FXML
    private Button breatheButton;
    @FXML
    private Label breatheInstrc;
    @FXML
    private Button stopBreathing;

    MediaPlayer mediaPlayer;




    @FXML
    public void initialize() {
        themeList.setItems(THEMES);
        themeList.setValue("Light");
        if (!Controller.guestLogin){
            welcomeMsg.setText("Welcome back, "+Controller.currentUser+"! You have logged in x times.");
        }else{
            welcomeMsg.setText("Welcome back!");
        }
        
        initializeGroups();
        initializeRadioButtons();
        
        
    }

    //Inits groups of radio buttons and allocates into an array, so we can search this array later when the user attempts to answer all/some/none
    public void initializeGroups(){
        questionGroups = new ToggleGroup[5]; 
        questionGroups[0] = question1group;
        questionGroups[1] = question2group;
        questionGroups[2] = question3group;
        questionGroups[3] = question4group;
        questionGroups[4] = question5group;
    }
    public void initializeButtons(){
        allButtons = new Button[1];
        allButtons[0] = submitQ;
    }
    public void initializeRadioButtons(){
        allRadioButtons = new RadioButton[18];
        allRadioButtons[0] = q1o1;
        allRadioButtons[1] = q1o2;
        allRadioButtons[2] = q1o3;
        allRadioButtons[3] = q2o1;
        allRadioButtons[4] = q2o2;
        allRadioButtons[5] = q2o3;
        allRadioButtons[6] = q3o1;
        allRadioButtons[7] = q3o2;
        allRadioButtons[8] = q3o3;
        allRadioButtons[9] = q4o1;
        allRadioButtons[10] = q4o2;
        allRadioButtons[11] = q4o3;
        allRadioButtons[12] = q5o1;
        allRadioButtons[13] = q5o2;
        allRadioButtons[14] = q5o3;
        allRadioButtons[15] = q6o1;
        allRadioButtons[16] = q6o2;
        allRadioButtons[17] = q6o3;

    }

    //Disables the button once the user has entered answers to all the questions
    public void submitButton(){
        boolean allAnswered = false;
        for (int i = 0; i < questionGroups.length; i++) {
            if (questionGroups[i].getSelectedToggle() != null){
                allAnswered = true;
            }else{
                allAnswered = false;
            }
        }

        if (allAnswered){
            submitQ.setDisable(true);
        }else{
            System.out.println("User hasn't put an answer!");
        }
        
    }


    public void changeTheme(){
        String theme = themeList.getValue();
         switch (theme){
            case "Dark":
                fullBackground.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                //Can't really figure out how to make an array of all the labels and iterate through all of them and change colour through a for loop...
                //Maybe fix this later?
                for (int i = 0; i < allRadioButtons.length; i++) {
                    allRadioButtons[i].setTextFill(Color.WHITE);
                }
                welcomeMsg.setTextFill(Color.WHITE);
                instrcText.setTextFill(Color.WHITE);
                question1.setTextFill(Color.WHITE);
                question2.setTextFill(Color.WHITE);
                question3.setTextFill(Color.WHITE);
                question4.setTextFill(Color.WHITE);
                question5.setTextFill(Color.WHITE);
                question6.setTextFill(Color.WHITE);
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
                question6.setTextFill(Color.BLACK);

                break;
            }
    }

    public void playAudio(){
        String musicFile = "music/";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void getTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.toString());
    }

    public void timeBreathe() throws InterruptedException{
        String musicFile = "music/breathe.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);

        breatheButton.setVisible(false);
        breatheInstrc.setVisible(true);
        stopBreathing.setVisible(true);
        TimerTask task = new TimerTask(){
            int phase = 1;
            @Override
            public void run() {
                Platform.runLater(() -> {
                switch (phase){
                    case 1:
                        breatheInstrc.setText("Breathe in...");
                        break;
                    case 2:
                        breatheInstrc.setText("Hold...");
                        break;
                    case 3:
                        breatheInstrc.setText("Breathe out...");
                        break;
                }
                phase++;
                if (phase > 3){
                    phase = 1;
                }
                
                
            });
            }
        };
        //Makes timer run every 4 seconds to constantly cycle through the 3 stages of breathing until user presses "Stop"
        timer.scheduleAtFixedRate(task, 0, 4000);
            
        
    }

    public void stopBreathing(){
        mediaPlayer.setAutoPlay(false);
        mediaPlayer.stop();
        breatheButton.setVisible(true);
        breatheInstrc.setVisible(false);
        stopBreathing.setVisible(false);
        
        timer.cancel();
    }

}
