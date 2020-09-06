package sample;

public class Seat {
    private String seatNumber;
    private boolean seatBooked;

    //CONSTRUCTOR
    public Seat(String seatNumber, boolean seatBooked) {
        this.seatNumber = seatNumber;
        this.seatBooked = seatBooked;
    }

    //GETTERS
    public String getSeatNumber() {
        return seatNumber;
    }

    public Boolean getSeatBooked() {
        return seatBooked;
    }

    //SETTERS
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatBooked(Boolean seatBooked) {
        this.seatBooked = seatBooked;
    }
}
