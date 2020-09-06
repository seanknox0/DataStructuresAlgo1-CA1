package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

import static sample.Main.ps;

public class ControllerPerf {

    @FXML
    ChoiceBox<String> showTitle;
    @FXML
    DatePicker perfDate;
    @FXML
    RadioButton matinee;
    @FXML
    RadioButton evening;
    @FXML
    ListView<String> perfList;

    //Redirects to mainMenu
    @FXML
    public void mainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
    }

    //Stores these into the Performance list and also lists the performance in a ListView
    @FXML
    public void addPerf(ActionEvent e){
        Performance np = new Performance();
        Performance np2 = null ;
        //Creates two performances if both matinee & evening are selected
        if(matinee.selectedProperty().getValue() == true && evening.selectedProperty().getValue() == true){
            np2=new Performance();

            np2.setShowTitle(showTitle.getValue());
            np2.setPerfDate(perfDate.getValue());
            np2.setTime("Matinee");

            np.setShowTitle(showTitle.getValue());
            np.setPerfDate(perfDate.getValue());
            np.setTime("Evening");

                }
        else if (matinee.selectedProperty().getValue() == true)
        {
            np.setShowTitle(showTitle.getValue());
            np.setPerfDate(perfDate.getValue());
            np.setTime("Matinee");
        }
        else if (evening.selectedProperty().getValue() == true)
        {
            np.setShowTitle(showTitle.getValue());
            np.setPerfDate(perfDate.getValue());
            np.setTime("Evening");
        }
        //Running showTitle through method to get the corresponding show
        Show s = Main.getShowFromTitle(showTitle.getValue());
        //Adding a single performance to list
        s.addPerf(np);
        //Checks if a second performance was created and adds if it was
        if(np2 != null)
        {
            s.addPerf(np2);
        }
        //Adds the performances to a ListView
        s.listViewPerfs(perfList);
    }

    @FXML
    public void viewPerfs(ActionEvent e) {
        perfList.getItems().clear();
        Show s = Main.getShowFromTitle(showTitle.getValue());
        Performance temp = s.headP;
        while (temp != null) {
            s.listViewPerfs(perfList);
            temp = temp.nextP;
        }
    }

    //Uses DELETE key to delete selected list objects
    @FXML
    public void cancelPerf(KeyEvent e) {
        if (e.getCode() == KeyCode.DELETE && perfList.getSelectionModel().getSelectedIndex() >= 0)
            perfList.getItems().remove(perfList.getSelectionModel().getSelectedIndex());

            //Deletes from list by getting corresponding show to title then removing that performance
            Show s = Main.getShowFromTitle(showTitle.getValue());
            s.cancelPerfs(perfList.getSelectionModel().getSelectedIndex());
    }

    //Clears the performance list and ListView
    @FXML
    public void resetPerfs(ActionEvent e) {
        //removes from ListView
        perfList.getItems().clear();
        //removes from list
        Show s = Main.getShowFromTitle(showTitle.getValue());
        s.deleteAllPerfs();
    }

    @FXML
    public void displayPerf(ActionEvent e) {
        Show s = Main.getShowFromTitle(showTitle.getValue());
        s.listViewPerfs(perfList);
    }

    //Populates the boxes with content
    public void initialize(){
            Main.popShowChoiceBox(showTitle);
        }
}