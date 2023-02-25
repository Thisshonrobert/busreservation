import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            date = dateFormat.parse(dateInput);


    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for(Bus bus:buses) {
            if(bus.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }

        int booked = 0;
        for(Booking b:bookings) {
            if(b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }

        return booked<capacity?true:false;

    }
}
