package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage ps;
    public static Show headS = null;


    //Displays the main menu of booking app
    @Override
    public void start(Stage ps1) throws Exception{
        ps=ps1;
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
        ps.show();
    }

    //Creates a list which allows the user to add shows
    public static void addShow(Show s){
        s.nextS = headS;
        headS = s;
    }

    //Displays the added shows on a ListView
    public static void listViewShows(ListView lv){
        Show temp=headS;
        lv.getItems().clear();
        while(temp!=null){
            lv.getItems().add(temp.getTitle() + " from " +
                    temp.getStartDate() + " to " +
                    temp.getEndDate() + " for " +
                    temp.getRunTime() + " minutes " + ", Price: (S): " +
                    temp.getStallPrice() + ", (C): " +
                    temp.getCirclePrice() + ", (B): " +
                    temp.getBalconyPrice());
            temp=temp.nextS;
        }
    }

    //Populates the ChoiceBox with the show titles stored in show list
    public static void popShowChoiceBox(ChoiceBox cb) {
        if (headS == null) {
            cb.getItems().add("No Shows Available");
        } else {
            cb.getItems().clear();
            Show temp = headS;

            while (temp != null) {
                cb.getItems().add(temp.getTitle());
                temp = temp.nextS;
            }
        }
    }

    //Used to associate the title with the correct show in performance controller
    public static Show getShowFromTitle(String title) {
        Show temp = headS;
        while (temp != null) {
            if (!title.equalsIgnoreCase(temp.getTitle()))
                temp = temp.nextS;
            else
                return temp;
        }
        return null;
    }

    //Deletes a particular entry in the list of shows
    //Searched using the index
    public static void cancelShows(int index){
        Show temp = headS;
        int i = 0;
        while(i<index && temp!=null) {
            temp = temp.nextS;
            i++;
        }
        if(temp!=null && temp.nextS!=null) {
            temp.nextS = temp.nextS.nextS;
        }
    }

    //Deletes all shows from list
    //If head is null it cant point to the next show
    //If all shows are deleted then all shows and performances are also deleted
    public static void deleteAllShows() {
        headS = null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
