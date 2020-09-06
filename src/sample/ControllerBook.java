package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static sample.Main.ps;

public class ControllerBook {

    @FXML
    TextField customerName;
    @FXML
    ChoiceBox<String> showSelect;
    @FXML
    ChoiceBox<String> perfSelect;
    @FXML
    TextField genID;
    @FXML
    ListView<String> bookList;
    @FXML
    GridPane gridBalcony;
    @FXML
    GridPane gridCircle;
    @FXML
    GridPane gridStalls;

    //Theatre Map
    //Creating Array of buttons to populate into gridpanes
    //Resource:
    //https://teamtreehouse.com/community/javafx-dynamically-adding-buttons-and-calling-setonaction-on-it
   /* private Seat[] buttons = new Seat[94];

    Button button = new Button();

    public void popGrid(Performance pObj){
        for(int i = 0; i < 24; i++){
            Seat[] theBal = pObj.perfSeatPlan.getBalcony();
            gridBalcony.add (new Button(theBal[i].getSeatNumber()), i%8, i/8);
        }

        for(int i = 0; i < 30; i++){
            Seat[] theCir = pObj.perfSeatPlan.getCircle();
           // gridCircle.add (new Button(theCir[i].getSeatNumber()),);
        }

        for(int i = 0; i < 40; i++){
            Seat[] theStl = pObj.perfSeatPlan.getStalls();
           // gridStalls.add (new Button(theStl[i].getSeatNumber()),);
        }

        //button.setOnAction()
    }
    */

    //Redirects to mainMenu
    @FXML
    public void mainMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
    }

    //Stores these into the Booking list and also lists the booking in a ListView
    @FXML
    public void addBook(ActionEvent e){
        Booking nb = new Booking();

        nb.setCustomerName(customerName.getText());
        nb.setShowSelect(showSelect.getValue());
        nb.setPerfSelect(perfSelect.getValue());

        Show s = Main.getShowFromTitle(showSelect.getValue());
        Performance temp = s.getPeformanceFromShow(perfSelect.getValue());
        temp.addBook(nb);
        temp.listViewBooks(bookList);
    }

    @FXML
    public void viewBooks(ActionEvent e) {
        bookList.getItems().clear();
        Show s = Main.getShowFromTitle(showSelect.getValue());
        Performance p = s.getPeformanceFromShow(perfSelect.getValue());
        Booking temp = p.headB;
        while (temp != null) {
            p.listViewBooks(bookList);
            temp = temp.nextB;
        }
    }

    //Uses DELETE key to delete selected list objects
    @FXML
    public void cancelBook(KeyEvent e) {
        if (e.getCode() == KeyCode.DELETE && bookList.getSelectionModel().getSelectedIndex() >= 0)
            bookList.getItems().remove(bookList.getSelectionModel().getSelectedIndex());

            Show s = Main.getShowFromTitle(showSelect.getValue());


            Performance temp = s.getPeformanceFromShow(perfSelect.getValue());
            temp.cancelBooks(bookList.getSelectionModel().getSelectedIndex());
    }

    //Clears the booking list and ListView
    @FXML
    public void resetBooks(ActionEvent e){
        bookList.getItems().clear();
        Show s = Main.getShowFromTitle(showSelect.getValue());
        Performance temp = s.getPeformanceFromShow(perfSelect.getValue());
        temp.deleteAllBooks();
    }

    //Identifying show from title then populating box with the performances of that show
    @FXML
    public void showSelected(ActionEvent e){
        Show s = Main.getShowFromTitle(showSelect.getValue());
        Performance temp = s.headP;
        perfSelect.getItems().clear();
        while(temp != null){
            perfSelect.getItems().add(temp.getPerfInfo());
            temp = temp.nextP;
        }
    }

    //Linking the right seat plan to its corresponding performance
    @FXML
    public void perfSelected(ActionEvent e){
        Show s = Main.getShowFromTitle(showSelect.getValue());
        Performance temp = s.headP;
        while (temp != null){
            if(temp.getPerfInfo().equals(perfSelect.getSelectionModel().getSelectedItem()))
                break;
            temp = temp.nextP;
        }
        //Populates the grid for the theatre map
       /* if (temp !=null){
            popGrid(temp);
        }*/
    }

    //Populates the boxes with content
    public void initialize() {
        Main.popShowChoiceBox(showSelect);
        //The "" masks the int into a string
        genID.setText("" + Booking.totalBook + 1);
    }
}
