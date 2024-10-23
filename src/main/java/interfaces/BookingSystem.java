package interfaces;

import java.util.Date;

public class BookingSystem {
    public static void main(String[] args) {
        CarBooking cb = new CarBooking("00000BBB");
        cb.book(new Date());
        cb.getTicketDetail();
        cb.cancelBook();
        cb.getTicketDetail();
        cb.book(new Date());
        cb.getTicketDetail();
        FlightBooking fb = new FlightBooking ("Iberia", "IBE1234");
        fb.book(new Date(), "V72");
        fb.getTicketDetail();



    }
}
