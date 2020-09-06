package sample;

import javafx.scene.control.ListView;

import java.time.LocalDate;

public class Performance {
    private String showTitle;
    private LocalDate perfDate;
    private String time;

    SeatPlan perfSeatPlan = new SeatPlan();

    Performance nextP = null;
    Booking headB = null;


    //Creates a list which allows the user to add bookings
    public void addBook(Booking b){
        b.nextB = headB;
        headB = b;
    }

    //Displays the added bookings on a ListView
    public void listViewBooks(ListView lv){
        Booking temp = headB;
        lv.getItems().clear();
        while(temp != null){
            lv.getItems().add(temp.getCustomerName() + " for: " +
                    temp.getShowSelect() + ", " +
                    temp.getPerfSelect() + ", ID: " +
                    temp.getBookingID() + ", Seat(s): " +
                    temp.getSeatNum());
            temp = temp.nextB;
        }
    }

    //Deletes a particular entry in the list of bookings
    //Searched using the index
    public void cancelBooks(int index){
        Booking temp = headB;
        int i = 0;
        while(i<index && temp!=null) {
            temp = temp.nextB;
            i++;
        }
        if(temp!=null && temp.nextB!=null) {
            temp.nextB = temp.nextB.nextB;
        }
    }

    //Deletes all bookings from list
    //If head is null it cant point to the next Booking
    public void deleteAllBooks(){
        headB = null;
    }

    //GETTERS
    public String getPerfInfo() {
        return getPerfDate() + " - " + getTime();
    }

    public String getTime() {
        return time;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public LocalDate getPerfDate() {
        return perfDate;
    }

    public Performance getNextP() {
        return nextP;
    }

    public Booking getHeadB() {
        return headB;
    }

    //SETTERS
    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public void setPerfDate(LocalDate perfDate) {
        this.perfDate = perfDate;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHeadB(Booking nextB) {
        this.headB = nextB;
    }

    public void setNextP(Performance nextP) {
        this.nextP = nextP;
    }
}
