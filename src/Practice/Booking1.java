package Practice;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Booking1 {
    String passangerName;
    int busNo1;
    Date date;

Booking1(){

Scanner scanner= new Scanner(System.in);
    System.out.println("Enter the passanger Name: ");
    passangerName = scanner.next();
    System.out.println("Enter Bus No: ");
   busNo1=scanner.nextInt();
    System.out.println("Enter date dd/MM/yyyy");
    String dateInput = scanner.next();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
           date = dateFormat.parse(dateInput);
        } catch (ParseException ex) {
        }
}


public boolean isAvailable(ArrayList<Booking1> bookings1, ArrayList<Bus1> buses1){
    int capacity = 0;
    for(Bus1 bus:buses1){
if(bus.getBusNo()== busNo1)
capacity = bus.getCapacity();
    }
    int booked=0;
    for(Booking1 bs:bookings1){
        if(bs.busNo1 == busNo1 && bs.date.equals(date)){
            booked++;
        }
    }
    return booked<capacity?true:false;

}
}
