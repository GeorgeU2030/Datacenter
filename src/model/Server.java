package model;

public class Server {
  
    private int cache;
    private int numberProcessor;
    private String brand;
    private int amountM;
    private int amountD;
    private int diskCapacity;
    private int numberServers;
/**
 * Constructor of the Server class
 * @param numberServers int is the number of the servers
 * @param cache int is the capacity of the cache memory
 * @param numberProcessor int is the amount of the proccesors
 * @param brand string is the brand server
 * @param amountM int is the capacity of the RAM
 * @param amountD int is the amount the disks
 * @param diskCapacity int is the capacity of the disks
 */
public Server(int numberServers,int cache,int numberProcessor,String brand,int amountM,int amountD,int diskCapacity){
this.cache=cache;
this.numberProcessor=numberProcessor;
this.brand=brand;
this.amountM=amountM;
this.amountD=amountD;
this.diskCapacity=diskCapacity;
this.numberServers=numberServers;
}

public int getAmountM(){
    return amountM;
}
public int getDiskCapacity(){
    return diskCapacity;
}
public int getNumberServers(){
    return numberServers;
}
/**
 * Method toString of the Server class
 * Show of the information of the servers , without parameters
 * @return String is the information server
 */ 
public String toString() {
    return "\nDisk Amount: " + amountD + "\n" + "Amount Memory: " + amountM + "\n" + "Brand: " + brand + "\n"
            + "Cache Memory: " + cache + "\n" + "Disk Capacity: " + diskCapacity +"\n"+ "numberProcessor: " + numberProcessor
            + "\n";
}

}
