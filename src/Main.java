import java.text.ParseException;
import java.util.Scanner; //nested package/ hierarchical package
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {


        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,3));
        buses.add(new Bus(3,true,5));

        int userOpt = 1;
        Scanner scanner = new Scanner(System.in);

        for(Bus b:buses) {
            b.displayBusInfo();
        }

        while(userOpt==1) {
            System.out.println("Enter 1 to Book and 2 to exit");
            userOpt = scanner.nextInt();
            if(userOpt == 1) {
                Booking booking = new Booking();
                if(booking.isAvailable(bookings,buses)) {
                    bookings.add(booking);
                    System.out.println("Booking confirmed");
                }
                else
                    System.out.println("Sorry...");
            }
        }
    }

}
