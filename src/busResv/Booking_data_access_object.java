package busResv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Booking_data_access_object {
    public int getBookedCount(int busNo,java.util.Date date ) throws SQLException{
        String query = "select count(passangerName) from booking where bus_No=? and travel_date=?";
        Connection con = DbConnection.getConnection();
       PreparedStatement pst=  con.prepareStatement(query);
       java.sql.Date sqlDate = new  java.sql.Date(date.getTime());
       pst.setInt(1, busNo);
       pst.setDate(2, sqlDate);
       ResultSet rs=pst.executeQuery();
       rs.next();
       return rs.getInt(1);
    }


   public  void  addBooking(Booking booking) throws SQLException{
    String query = "Insert into booking values(?,?,?)";
    java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
Connection con = DbConnection.getConnection();
PreparedStatement pst = con.prepareStatement(query);
pst.setString(1, booking.passengerName);
pst.setInt(2, booking.busNo);
pst.setDate(3, sqldate);

pst.executeUpdate();
   }














}
