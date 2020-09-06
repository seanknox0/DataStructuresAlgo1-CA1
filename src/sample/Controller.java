package sample;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static sample.Main.ps;

public class Controller {

    //Directs to the add show window
   @FXML
    public void addShow(ActionEvent e) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("AddShow.fxml"));
       ps.setTitle("West End Theatre");
       ps.setScene(new Scene(root));
    }

    //Directs to the add performance window
    @FXML
    public void addPerf(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddPerformance.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
    }

    //Directs to the book performance window
    @FXML
    public void bookPerf(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BookPerformance.fxml"));
        ps.setTitle("West End Theatre");
        ps.setScene(new Scene(root));
    }

    //Deletes every Show, Performance and Booking
    @FXML
    public void resetEverything(ActionEvent e) {
       Main.deleteAllShows();
    }

    //Loads a XML file which has previously saved shows, performances and bookings
    @SuppressWarnings("unchecked")
    public void loadTheatre(ActionEvent e) throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Theatre.xml"));
        Main.headS = (Show) is.readObject();
        Main.headS.headP = (Performance) is.readObject();
        Main.headS.headP.headB = (Booking) is.readObject();
        is.close();
    }

    //Saves the shows, performances and bookings to an XML file which can be loaded next use of app
    public void saveTheatre(ActionEvent e) throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Theatre.xml"));
        out.writeObject(Main.headS);
        out.writeObject(Main.headS.headP);
        out.writeObject(Main.headS.headP.headB);
        out.close();
    }
}
