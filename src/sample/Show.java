package sample;

import javafx.scene.control.ListView;

import java.time.LocalDate;

public class Show {
    private String title;
    private String stallPrice;
    private String circlePrice;
    private String balconyPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private double runTime;

    Show nextS = null;
    Performance headP = null;

    //Creates a list which allows the user to add performances
    public void addPerf(Performance p) {
        p.nextP = headP;
        headP = p;
    }

    //Displays the added performances on a ListView
    public void listViewPerfs(ListView lv) {
        Performance temp = headP;
        lv.getItems().clear();
        while (temp != null) {
            lv.getItems().add(temp.getShowTitle() + " on " +
                    temp.getPerfDate() + ", Time: " +
                    temp.getTime());
            temp = temp.nextP;
        }
    }

    //Deletes a particular entry in the list of performances
    //Searched using the index
    public void cancelPerfs(int index) {
        Performance temp = headP;
        int i = 0;
        while (i < index && temp != null) {
            temp = temp.nextP;
            i++;
        }
        if (temp != null && temp.nextP != null) {
            temp.nextP = temp.nextP.nextP;
        }
    }

    //Deletes all performances from list
    //If head is null it cant point to the next performance
    public void deleteAllPerfs() {
        headP = null;
    }

    //Used to associate the date with the correct performance in booking controller
    //Compares properDate and and the string that gets passed through
    public Performance getPeformanceFromShow(String date) {
        Performance temp = headP;
        while (temp != null){
            String properDate = temp.getPerfDate().toString() + " - "+ temp.getTime();
        if (!date.equals(properDate))
            temp = temp.nextP;
        else
            return temp;
        }
        return null;
    }

    //GETTERS
    public String getTitle() {
        return title;
    }

    public String getStallPrice() {
        return stallPrice;
    }

    public String getCirclePrice() {
        return circlePrice;
    }

    public String getBalconyPrice() {
        return balconyPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getRunTime() {
        return runTime;
    }

    public Show getNextS() {
        return nextS;
    }

    public Performance getNextP() {
        return headP;
    }



    //SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStallPrice(String stallPrice) {
        this.stallPrice = stallPrice;
    }

    public void setCirclePrice(String circlePrice) {
        this.circlePrice = circlePrice;
    }

    public void setBalconyPrice(String balconyPrice) {
        this.balconyPrice = balconyPrice;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public void setNextS(Show nextS) {
        this.nextS = nextS;
    }

    public void setNextP(Performance nextP) {
        this.headP = nextP;
    }
}
