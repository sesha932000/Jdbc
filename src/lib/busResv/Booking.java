package busResv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking{
 String passengerName;
 int busNo;
Date date;

Booking(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter name of passanger: ");
passengerName = scanner.next();
System.out.println("Enter bus No : ");
busNo = scanner.nextInt();
System.out.println("Enter date dd/mm/yyyy");
String dateInput = scanner.next();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     try {
        date = dateFormat.parse(dateInput);
     } catch (ParseException ex) {
     }
}




 public boolean isAvailable(ArrayList<Booking>bookings,ArrayList<Bus>buses){
int capacity =0;
for(Bus bus:buses){
if(bus.getBusNo()== busNo)
  capacity =bus.getCapacity();
}
int booked = 0;
for(Booking b:bookings){
if( b.busNo == busNo && b.date.equals(date)){
    booked++;

}
}
return booked<capacity?true:false;
 }

 

}