package  busResv;

import java.sql.Time;

public class Bus{
private int busNo1;
private boolean ac;
private int capacity;
private int booking_Number;
private String driver_Name;
private Time duraction;



Bus(int busNo,boolean ac,int capacity,String driver_Name,int booking_Number){
    this.busNo1 = busNo;
    this.ac = ac;
    this.capacity = capacity;
    this.driver_Name = driver_Name;
     this.booking_Number = booking_Number;

    }

    public int getBusNo(){
        return busNo1;
    }
    public boolean getAc(){
        return ac;

    } 
    public void setAc(boolean val){
       ac = val;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int cap){
 capacity = cap;
    }
    public void displayBusInfo(){
System.err.println("BusNo" + busNo1 + " Ac:" + ac  + " Total capacity: " + capacity );

    }

    public String getDriver_Name() {
        return driver_Name;
    }

    public void setDriver_Name() {
        driver_Name = driver_Name;
    }

    public int getBooking_Number() {
        return booking_Number;
    }

    public void setBooking_Number(int booking_Number) {
       booking_Number = booking_Number;
    }

}