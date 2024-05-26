import java.util.ArrayList;
import java.util.Scanner;

public class busDemo1{
    public static void main(String[] args) {
            ArrayList<Bus1> buses1 = new ArrayList<Bus1>();
            ArrayList<Booking1> bookings1 = new ArrayList<Booking1>();
 buses1.add(new Bus1(1,true,2));
 buses1.add(new Bus1(2,true,65));
 buses1.add(new Bus1(3,true,75));
          
for(Bus1 b:buses1){
    b.displayBusInfo();
} 

     int user =1;
        Scanner scanner =new Scanner(System.in);
        while(user==1){
System.out.println("Enter 1 to book enter 2 to Exit");
user=scanner.nextInt();
if (user ==1) {
    Booking1 booking = new Booking1();
    if(booking.isAvailable(bookings1,buses1)){
        bookings1.add(booking);
        System.out.println("Your Booking is confirmed");
    }else
System.out.println("Oops sorry, bus is full Booking some other bus or date");


}
        }
    }
}