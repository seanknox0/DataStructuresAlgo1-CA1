package sample;

public class Booking {

    private String customerName;
    private int bookingID;
    private String showSelect;
    private String perfSelect;
    private Seat[] seatNum;

    Booking nextB = null;

    public static int totalBook = 0;

    //incrementing before, plus 1 to previous to count for unique ID
    public Booking() {
        bookingID = ++totalBook;
    }

    //GETTERS
    public String getCustomerName() {
        return customerName;
    }

    public String getShowSelect() {
        return showSelect;
    }

    public String getPerfSelect() {
        return perfSelect;
    }

    public int getBookingID() {
        return bookingID;
    }

    public Booking getNextB() {
        return nextB;
    }

    public Seat[] getSeatNum() {
        return seatNum;
    }

    public static int getTotalBook() {
        return totalBook;
    }

    //SETTERS
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setShowSelect(String showSelect) {
        this.showSelect = showSelect;
    }

    public void setPerfSelect(String perfSelect) {
        this.perfSelect = perfSelect;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setNextB(Booking nextB) {
        this.nextB = nextB;
    }

    public void setSeatNum(Seat[] seatNum) {
        this.seatNum = seatNum;
    }

    public static void setTotalBook(int totalBook) {
        Booking.totalBook = totalBook;
    }
}
