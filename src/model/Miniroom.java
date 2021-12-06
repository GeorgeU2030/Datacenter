package model;

public class Miniroom {

private String project;
private String company;
private String nit;
private boolean window;
private double price;
private int numberRoom;
private int registerNum;
private Date dateRegister=new Date();
private Server[][]servers=new Server[8][50];
/**
     * Constructor of the Miniroom Class, empty 
     */
public Miniroom(){}
/**
 * Constructor of the Miniroom Class
 * @param project string is the name of the project
 * @param company string is the company of the project
 * @param nit string is the nit of the company
 * @param window boolean is if the miniroom has window
 * @param price double is the price of the miniroom
 * @param numberRoom int is the number of the room
 * @param day int is the day that you rent the miniroom
 * @param month int is the month that you rent the miniroom
 * @param year int is the year that you rent the miniroom
 * @param registerNum int is the number of the register
 */
public Miniroom(String project,String company,String nit,boolean window,
                double price,int numberRoom,int day,int month,int year,int registerNum){
    this.project=project;
    this.company=company;
    this.nit=nit;
    this.window=window;
    this.price=price;
    this.numberRoom=numberRoom; 
    dateRegister = new Date(day,year,month);
    this.registerNum=registerNum;
    }
/**
 * Method that add a Server
 * @param posR int is the number of the row to add a server
 * @param posC int is the number of the column to add a server
 * @param numberServers int is the numbers of the servers to contain
 * @param cache int is the capacity of the cache memory
 * @param numberP int is the number of proccesors of the server
 * @param brand string is the brand server
 * @param ram int is the capacity of the RAM
 * @param diskQuantity int is the disk quantity
 * @param diskCapacity int is the disk capacity
 */
public void addServer(int posR,int posC,int numberServers,int cache, int numberP,String brand,int ram,int diskQuantity,int diskCapacity){
    servers[posR][posC]=new Server(numberServers,cache,numberP,brand,ram,diskQuantity,diskCapacity);
}

public String getProject(){
    return project;
}
public int getNumberRoom(){
    return numberRoom;
}
public boolean getWindow(){
    return window;
}
public double getPrice(){
    return price;
}
public void setProject(String project){
    this.project = project;
}
public void setCompany(String company){
    this.company=company;
}
public void setNit(String nit){
    this.nit =nit;
}
public void setWindow(boolean window){
    this.window=window;
}
public void setPrice(double price){
    this.price=price;
}
/**
 * Method that show the server
 * @param posR int is the row that server to show
 * @param posC int is the column that server to show
 * @return out string is the information of the server
 */
public String showServer(int posR,int posC){
    String out="";
    if(servers[posR][posC]!=null){
    out += servers[posR][posC].toString();
    }
    else {
    out += "The Room hasn't servers";
    }
    return out;
}
/**
 * Method that cancel of the server in a room
 * @param posR int is the row of the server to cancel
 * @param posC int is the column of the server to cancel
 */
public void warningServer(int posR,int posC){
    if(servers[posR][posC]!=null){
    System.out.println("the amount memory is " + servers[posR][posC].getAmountM()+ "\n");
    System.out.println( "the capacity the disk is " + servers[posR][posC].getDiskCapacity()+ "\n"); 
    servers[posR][posC]=null;
    }
}
/**
 * Method that search the amount the severs that contain a miniroom
 * @param posR int is the row to search 
 * @param posC int is the colum to search
 * @return exist boolean is if the miniroom contain more the 4 servers
 */
public boolean serverMinus(int posR,int posC){
    boolean exist =false;
    if (servers[posR][posC]!=null){
        if(servers[posR][posC].getNumberServers()<4){
            exist = true;
        }
    }
    return exist;
}
/**
 * Method toString of the Miniroom class
 * Show of the Miniroom , without parameters
 * @return String is the information miniroom
 */ 
public String toString() {
    String out="";
    out+= "project " + project+ "\n";
    out+= "company " + company+ "\n";
    out+= "nit " + nit+ "\n";
    out+= "window " + window+ "\n";
    out+= "price " + price+ "\n";
    out+= "numberRoom " + numberRoom+ "\n";
    out+= dateRegister.toString();
    return out;
}
}