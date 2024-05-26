package  busResv;

public class Bus{
private int busNo1;
private boolean ac;
private int capacity;


Bus(int busNo,boolean ac,int capacity){
    this.busNo1 = busNo;
    this.ac = ac;
    this.capacity = capacity ;
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
System.err.println("Bus No" + busNo1 + " Ac:" + ac  + " Total capacity: " + capacity );

    }

}