package ui;
import java.util.Scanner;
import model.Datacenter;

/**
 * Main class of the Datacenter project
 * Developed by 
 * @author George Michael Trujillo
 * @version 1.0
 * @since November-December 2021
 */
public class Main {

    /**
	 * data is the connection to the Datacenter class in the model package
	 */
private Datacenter data;
    /**
	 * sc is the object that allows to read information entered by the user
	 */
private Scanner sc;
    /**
	 * Constructor of the class, does not receive parameters 
	 * The method initializes the reader object,and Datacenter
	 */
public Main() {
    sc= new Scanner(System.in);
    data= new Datacenter();
    data.createMiniroom();
}

public static void main (String[] a){
    
    Main obj = new Main();
    int option =0;
    
    //cycle to execute the menu while the user does not enter 0
    do {
        option =obj.showMenu();
        obj.answerOption(option);
    }while (option !=0);
    if (option <0 && option>9){
    System.out.println ("Enter a valid number");
    }
}

/**
	 * Method that shows the application menu
	 * @return input, int is the option entered by the user
	 */
public int showMenu() {
    int input;
    System.out.println("Welcome Datacenter App\n\n\n"+ 
                        "(1) Carry Out Project\n"+
                        "(2) Show List Rooms Available\n"+
                        "(3) Add Server\n"+
                        "(4) Show Price the a Room\n"+
                        "(5) Show Information the a Room\n"+
                        "(6) Cancel Room Rental\n"+
                        "(7) Show the rooms turned on\n"+
                        "(8) Simulate all rooms turned on\n"+
                        "(9) Simulate turn off Rooms\n"
    );
    input = sc.nextInt();
    return input;
}
/**
	 *Method that is in charge of calling the methods that solve each of the
	 * application requirements
	 * @param option, int is the number entered by the user 
	 */
public void answerOption(int option){
    switch(option) {
    case 0: 
        System.out.println("The App has been closed");
        break;
    case 1:
        enterProject();
        break;
    case 2:
        data.showRoomsAvailable();
        break;
    case 3:
        addServer();
        break;
    case 4:
        showPrice();
        break;
    case 5:
        showInformationRoom();
        break;
    case 6:
        cancelRoom();
        break;
    case 7:
        System.out.println("The servers turned on are \n");
        System.out.println(data.roomTurnedOn());
        break;
    case 8:
    System.out.println("The servers turned on are \n");
    System.out.println(data.allTurnedRoom());
    case 9:
       simulationsRooms();
}
}
/**
 * Method to show a kind project, investigation or the company
 * without parameters
 */
public void enterProject(){
System.out.println("TYPE PROJECT");
System.out.println("(1) Investigation Project");
System.out.println("(2) Company Project");
int option = sc.nextInt();
switch(option){
case 1:
   projectInvestigation();
   break;
case 2:
   companyProject();
   break;
}
}
/**
 * Method to register a investigation Project
 * without parameters
 */
public void projectInvestigation(){
System.out.println("Enter the name Project");
String nameProject= sc.next();
String company = "ICESI";
String nit="NIT 890.316.745-5";
System.out.println(data.showDisponible());
System.out.println("Enter the number of the Miniroom");
int numberR=sc.nextInt();
System.out.println("Enter the day");
int day=sc.nextInt();
System.out.println("Enter the month");
int month =sc.nextInt();
System.out.println("Enter the year");
int year=sc.nextInt();
data.reserveMiniRoom(nameProject, company, nit, numberR,day,month,year);


}
/**
 * Method to register a company Project
 * without parameters
 */
public void companyProject(){
System.out.println("Enter the name of the Project");
String nameProject = sc.next();
System.out.println("Enter the name of the Company");
String company= sc.next();
System.out.println("Enter the NIT of the Company");
String nit = sc.next();
System.out.println("Enter the number of the Miniroom");
int numberR=sc.nextInt();
System.out.println("Enter the day");
int day=sc.nextInt();
System.out.println("Enter the month");
int month =sc.nextInt();
System.out.println("Enter the year");
int year=sc.nextInt();
data.reserveMiniRoom(nameProject, company, nit, numberR,day,month,year);
}

/**
 * Method to add a Server to a Room
 * without parameters
 */
public void addServer(){
String brand="";
System.out.println("Enter the number of the rented room");
int numberRoom=sc.nextInt();
System.out.println("Enter the number of the servers to add");
int numberServers=sc.nextInt();
System.out.println("Amount of cache memory");
int cache=sc.nextInt();
System.out.println("Number of processors");
int numberP=sc.nextInt();
System.out.println("Processor brand, (1)INTEL, (2) AMD");
int optionP=sc.nextInt();
if(optionP==1){
    brand="INTEL";
}
else {
    brand="AMD";
}
System.out.println("Amount of RAM");
int ram = sc.nextInt();
System.out.println("Disk quantity");
int diskQuantity=sc.nextInt();
System.out.println("Disc capacity");
int diskCapacity=sc.nextInt();
data.searchRoomforAddServer(numberRoom,numberServers,cache,numberP,brand,ram,diskQuantity,diskCapacity);
}

/**
 * Method that show the price the a room
 * without parameters
 */
public void showPrice(){
    System.out.println("Enter the number of the Room that you want know the Price");
    int numberRoom=sc.nextInt();
    data.showPrice(numberRoom);
}
/**
 * Method that the information the a Room
 * without parameters
 */
public void showInformationRoom(){
    System.out.println("Enter the number of the Room that you want know the Information");
    int numberRoom=sc.nextInt();
    data.showInformationRoom(numberRoom);
}

/**
 * Method that cancel the rent a Room
 * without parameters
 */
public void cancelRoom(){
    System.out.println("Enter the Room that you want cancel");
    int numberRoom=sc.nextInt();
    data.cancelRoom(numberRoom);
}
/**
 * Method that simulates the turn off the rooms
 * without parameters
 */
public void simulationsRooms(){
    System.out.println("Enter a Letter for Simulate Turn Off Rooms");
    System.out.println("(L) turns off the first minirooms of all corridors, along with the minirooms of the first corridor");
    System.out.println("(Z) turn off the minirooms of the first and last runner, along with the minirooms of the reverse diagonal");
    System.out.println("(H) turn off the minirooms located in the odd-numbered corridors");
    System.out.println("(O) turn off the minirooms located in the windows");
    System.out.println("(M) turn off all minirooms in column that you want");
    System.out.println("(P) turn off the minirooms of a corridor");
    String option = sc.next();
    simulationOptions(option);
}
/**
 * Method that show the information according to the option entered
 * @param option String is the letter entered for the user
 */
public void simulationOptions(String option){
    switch(option){
        case "L":
        System.out.println("The rooms turn off are\n");
        data.turnoffoptionL();
        break;
        case "Z":
        System.out.println("The rooms turn off are\n");
        data.turnoffOptionZ();
        break;
        case "H":
        System.out.println("The rooms turn off are\n");
        data.turnoffOptionH();
        break;
        case "O":
        System.out.println("The rooms turn off are\n");
        data.turnoffOptionO();
        break;
        case "M":
        System.out.println("Enter the number of the column");
        int column = sc.nextInt();
        data.turnoffOptionM(column);
        break;
        case "P":
        System.out.println("Enter the number of the corridor");
        int corridor =sc.nextInt();
        data.turnoffOptionP(corridor);
        break;
    }
}
}
