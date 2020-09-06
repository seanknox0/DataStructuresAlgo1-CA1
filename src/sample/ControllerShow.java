package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

import static sample.Main.ps;

public class ControllerShow {
    @FXML
    ComboBox<String> title;
    @FXML
    ComboBox<String> stallPrice;
    @FXML
    ComboBox<String> circlePrice;
    @FXML
    ComboBox<String> balconyPrice;
    @FXML
    DatePicker startDate;
    @FXML
    DatePicker endDate;
    @FXML
    Slider runTime;
    @FXML
    ListView<String> showList;

    //Redirects to mainMenu
    @FXML
    public void mainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
    }

    //Stores these into the Show list and also lists the show in a ListView
    @FXML
    public void addShow(ActionEvent e){
        Show ns = new Show();

        ns.setTitle(title.getValue());
        ns.setStallPrice(stallPrice.getValue());
        ns.setCirclePrice(circlePrice.getValue());
        ns.setBalconyPrice(balconyPrice.getValue());
        ns.setStartDate(startDate.getValue());
        ns.setEndDate(endDate.getValue());
        ns.setRunTime(runTime.getValue());

        Main.addShow(ns);
        Main.listViewShows(showList);
    }

    @FXML
    public void viewShows(ActionEvent e) {
        showList.getItems().clear();
        Show temp = Main.headS;
        while (temp != null) {
            Main.listViewShows(showList);
            temp = temp.nextS;
        }
    }

    //Uses DELETE key to delete selected list objects
    @FXML
    public void cancelShow(KeyEvent e){
        if(e.getCode()== KeyCode.DELETE && showList.getSelectionModel().getSelectedIndex()>=0)
                showList.getItems().remove(showList.getSelectionModel().getSelectedIndex());
                //Deletes from the list
                Main.cancelShows(showList.getSelectionModel().getSelectedIndex());
    }

    //Clears the show list and ListView
    @FXML
    public void resetShows(ActionEvent e) {
        showList.getItems().clear();
        Main.deleteAllShows();
    }

    //Populates the boxes with content
    public void initialize(){
        stallPrice.getItems().addAll("€2", "€4", "€6", "€8", "€10", "€12", "€14");
        circlePrice.getItems().addAll("€4", "€8", "€12", "€16", "€20", "€24", "€28");
        balconyPrice.getItems().addAll("€30", "€40", "€50", "€60", "€70");
    }
}
