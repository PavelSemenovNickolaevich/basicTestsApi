package booking;

public class BookingId {


    private int bookingid;

    public BookingId(int bookingid) {
        this.bookingid = bookingid;
    }

    @Override
    public String toString() {
        return "booking.BookingId{" +
                "id=" + bookingid +
                '}';
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

}
