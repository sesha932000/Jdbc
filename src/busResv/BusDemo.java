package busResv;
import java.sql.SQLException;
import java.util.Scanner;

public class BusDemo{
public static void main(String [] args) {

// ArrayList<Bus> buses = new ArrayList<Bus>();
// ArrayList<Booking> Bookinges = new ArrayList<Booking>();

// buses.add(new Bus(1,true,2));   
// buses.add(new Bus(2,false,65));
// buses.add(new Bus(3,true,34));

// for(Bus b:buses){
// b.displayBusInfo();
// }

//////DataBasee 
Bus_Data_Access_Object busDAO = new Bus_Data_Access_Object();
try {
    busDAO.displayBusInfo();
    int user = 1; 
    Scanner scanner = new Scanner(System.in);
    while(user == 1){
        System.out.println("Enter 1 to Book and Enter 2 to Exit");
        user = scanner.nextInt();
        if(user == 1 ){
            Booking booking =new Booking(); 
            if(booking.isAvailable()){
                Booking_data_access_object bookingDao =new Booking_data_access_object();
                bookingDao.addBooking(booking);
                // Bookinges.add(booking);
    System.out.println("Your Booking is confirmed");
            }else
            System.out.println("Oops sorry, BUs is full, Try another Bus or Date.");
        }
    
    }
    scanner.close();




} catch (SQLException e) {
    // TODO Auto-generated catch block
   System.out.println(e);
}






}

}