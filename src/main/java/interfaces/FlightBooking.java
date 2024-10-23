package interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightBooking implements IBooking {
    private String company;
    private String flightNumber;
    private String bookedSeat = "";
    private Date bookDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public FlightBooking(String company, String flightNumber) {
        this.company = company;
        this.flightNumber = flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(String bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public void book(Date bookDate, String... args) {
        if(bookedSeat.isEmpty() && args.length > 0){
            this.bookedSeat = args[0];
            this.bookDate = bookDate;
            System.out.println("Booked seaat on " + this.company + " " + this.flightNumber);
        }else{
            System.out.println("Cannot perform a flight reservation");
        }
    }

    @Override
    public void cancelBook() {
        this.bookedSeat = "";
        System.out.println("Booked succesfully cancelled.");

    }

    @Override
    public void getTicketDetail() {
        if (!this.bookedSeat.isEmpty()) {
            System.out.println("Flight " + this.flightNumber + "( " + this.company + "), for date " + this.sdf.format(this.bookDate) + " has a seat booked: " + this.bookedSeat);
        }else{
            System.out.println("This flight is not booked.");
        }

    }
}
