package sample;

public class SeatPlan {

    //Declaring size of arrays
    private Seat[] balcony = new Seat[24];
    private Seat[] circle = new Seat[30];
    private Seat[] stalls = new Seat[40];

    //When called it gives values to the seats by naming and declaring whether or not its booked
    //Also sets the max seats each can hold in the for loop
    public void SeatPlan() {
        for(int i = 0; i < 24; i++){
            balcony[i] = new Seat("B" + i+1, false);
        }

        for(int i = 0; i < 30; i++){
            circle[i] = new Seat("C" + i+1, false);
        }

        for(int i = 0; i < 40; i++){
            stalls[i] = new Seat("S" + i+1, false);
        }
    }

    //GETTERS
    public Seat[] getBalcony() {
        return balcony;
    }

    public Seat[] getCircle() {
        return circle;
    }

    public Seat[] getStalls() {
        return stalls;
    }

    //SETTERS
    public void setBalcony(Seat[] balcony) {
        this.balcony = balcony;
    }

    public void setCircle(Seat[] circle) {
        this.circle = circle;
    }

    public void setStalls(Seat[] stalls) {
        this.stalls = stalls;
    }
}
