

public class Bus1{
    private int busNo;
    private boolean ac;
   private int capacity;

Bus1(int busNo ,boolean ac ,int capacity){
    this.busNo =  busNo;
    this.ac = ac;
    this.capacity =capacity;

}

public int getBusNo(){
    return busNo;
}
public boolean  getAc(){
    return ac;
}
public void setAc(boolean  val){
    ac=val;
}
public int getCapacity(){
    return capacity;
}
public void setCapacity(int cap){
    capacity = cap;
   
}

public void displayBusInfo(){
    System.out.println("BesNo : "+busNo+ " Ac: " +ac+ " Total capacity: "+capacity);
}

}