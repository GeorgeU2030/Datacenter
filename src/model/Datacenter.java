package model;

public class Datacenter {
/**
 * rooms is the association with the Miniroom class
 */
private Miniroom rooms;
private Miniroom [][] matrix;
private int [][] matrixRoom;
private int [][] matrixTurned;
private int [][] allTurned;
private int registerNum=0;
/**
 * Constructor of the Datacenter class, does not receive paramters
 * the method initializes the matrixes
 */
public Datacenter() {
    matrix = new Miniroom [8][50];
    matrixRoom = new int [8][50];
    rooms =new Miniroom();
    matrixTurned=new int[8][50];
    allTurned= new int [8][50];
} 

/**
 * method that creates the minirooms
 * without parameters
 */
public void createMiniroom(){
int value=1;
double price=0;
for (int i =0; i < matrix.length;i++){
    for (int j =0;j < matrix[0].length;j++){
        matrix[i][j] = new Miniroom("","","",false,price,value++,0,0,0,0);
    }
}
for (int i =0; i < matrix.length;i++){
    for (int j =0;j < matrix[0].length;j++){
        matrix[0][j].setWindow(true);
        matrix[i][0].setWindow(true);
        matrix[7][j].setWindow(true);
        matrix[i][49].setWindow(true);
        price=1000;
        if(matrix[i][j].getWindow()==true){
            price = price-(price*0.1);
            matrix[i][j].setPrice(price);
        }
        if (i==6){
            price = price-(price*0.15);
            matrix[6][j].setPrice(price);
        }
        if (i >0 && i <6){
            price = price+(price*0.25);
            matrix[i][j].setPrice(price);
        }
    }
}    

}
/**
 * Method that show the rooms available
 * @return out String is the matrix shown of the rooms available 
 */
public String showAvailable(){
String n="";
String out=" ";
int value =0;
for (int i =0; i < matrixRoom.length;i++){
    for (int j =0;j < matrixRoom[0].length;j++){
                if (matrix[i][j].getProject().equals(n)){
                matrixRoom[i][j] = matrix[i][j].getNumberRoom();
                }
                else {
                matrixRoom[i][j] =00;
                }
        }
    }
    for (int i =0; i < matrixRoom.length;i++){
        for (int j =0;j < matrixRoom[0].length;j++){
            out+= matrixRoom[i][j] + " ";
            if (matrixRoom[i][j]%25==0 && matrixRoom[i][j]!=0){
            out+= "\n";
            }
            if (matrixRoom[i][j]<99&&matrixRoom[i][j]>9){
            out += " ";
            }
            if (matrixRoom[i][j]<10){
            out += "  ";
            }
            if (matrixRoom[i][j]==0){
            if(matrixRoom[i][j-1]%25==24){
            if(matrixRoom[i][j-1]<100){
            out += "\n ";
            }
            if(matrixRoom[i][j-1]>100){
            out += "\n";
            }
            }
            }
        }
    }
return out;
}
/**
 * Method that reserve a Miniroom
 * @param project String is the name of the project
 * @param company String is the name of the company
 * @param nit String is the nit of the company
 * @param numberR int is the number of the room rented
 * @param day int is the day of the rent
 * @param month int is the month of the rent
 * @param year int is the year of the rent
 */
public void reserveMiniRoom(String project,String company,String nit,int numberR,int day,int month,int year){
    double price=0;
    int value=0;
    boolean window=false;
    registerNum++;
    for (int i =0; i < matrix.length;i++){
        for (int j =0;j < matrix[0].length;j++){
                if (matrix[i][j].getNumberRoom()==numberR){
                price=matrix[i][j].getPrice();
                value=matrix[i][j].getNumberRoom();
                window=matrix[i][j].getWindow();
                matrix[i][j]= new Miniroom(project,company,nit,window,price,value,day,month,year,registerNum);
                
                } 
        }
    }
}
/**
 * Method that show the rooms available
 * without parameters
 */
public void showRoomsAvailable(){
    double corridor =0;
    String window="";
    double number=0;
    double value=50;
    for (int i =0; i < matrixRoom.length;i++){
        for (int j =0;j < matrixRoom[0].length;j++){
            if(matrixRoom[i][j]!=0){
            number = (double) matrixRoom[i][j];
            corridor = number/value;
            System.out.println("Corridor: " + (int)Math.ceil(corridor));
            if(matrix[i][j].getWindow()==true){
            window = "With Window";
            }
            else {
                window= "Without Window";
            }
            System.out.println("Ubication: " + window );
            System.out.println("Column " + (j+1));
            System.out.println("Price "+ matrix[i][j].getPrice()+"\n");
            }
        }
    }
}
/**
 * Method that search the room for add Server
 * @param numberRoom int is the number of the room to add a Server
 * @param numberServers int is the numbers of the servers that you want add
 * @param cache int is the capacity of the cache memory
 * @param numberP int is the number of the proccesors
 * @param brand string is the proccesor brand
 * @param ram int is the RAM capacity
 * @param diskQuantity int is the disk Quantity
 * @param diskCapacity int is the disk Capacity
 */
public void searchRoomforAddServer(int numberRoom,int numberServers,int cache,int numberP,String brand,
                                   int ram,int diskQuantity,int diskCapacity){
    double price=0;
    int posR=0;  
    int posC=0; 
    boolean flag=false;                               
    for (int i =0; i < matrix.length ;i++){
        for (int j =0;j < matrix[0].length ;j++){
        if (matrix[i][j].getNumberRoom()==numberRoom){
        posR=i;
        posC=j;
        flag =true;
        if(numberServers<4){
        price = matrix[i][j].getPrice();
        price = price + (price*0.15);
        matrix[i][j].setPrice(price);
        }
        }
    }
}
if (flag=true){
    rooms.addServer(posR,posC,numberServers,cache,numberP,brand,ram,diskQuantity,diskCapacity);
}
}
/**
 * Method that show Price of a Room
 * @param numberRoom int is the number of the room to know the price
 */
public void showPrice(int numberRoom){
    for (int i =0; i < matrix.length;i++){
        for (int j =0;j < matrix[0].length;j++){
            if(numberRoom== matrix[i][j].getNumberRoom()){
                System.out.println("The price of the Room is " + matrix[i][j].getPrice());
            }
        }
    }
}
/**
 * Method that show information a Miniroom
 * @param numberRoom int is the number of the miniroom that you want know the information
 */
public void showInformationRoom(int numberRoom){
    int posR=0;
    int posC=0;
    for (int i =0; i < matrix.length ;i++){
        for (int j =0;j < matrix[0].length ;j++){
        if (matrix[i][j].getNumberRoom()==numberRoom){
        posR=i;
        posC=j;
        System.out.println(matrix[i][j].toString());
        System.out.println("register Number: "+ registerNum);
        System.out.println(rooms.showServer(posR, posC));
        }
    }
}
}
/**
 * Mathod that cancel the rent a Minirrom
 * @param numberRoom int is the number of the miniroom that you want cancel the rent
 */
public void cancelRoom(int numberRoom){
    int posR=0;
    int posC=0;
    double price=0;
    for (int i =0; i < matrix.length ;i++){
        for (int j =0;j < matrix[0].length ;j++){
        if (matrix[i][j].getNumberRoom()==numberRoom){
           posR=i;
           posC=j;
           rooms.warningServer(posR, posC);
           matrix[i][j].setCompany("");
           matrix[i][j].setNit("");
           matrix[i][j].setProject("");
           matrixRoom[i][j]=matrix[i][j].getNumberRoom();
           registerNum=0;
           if(rooms.serverMinus(posR, posC)==true){
               price= matrix[i][j].getPrice();
               price= (price / 1.15);
               matrix[i][j].setPrice(price);
           }
        }
    }
}
}
/**
 * Method that show the minirooms rented turn on 
 * @return out string is the matrix shown, the minirooms rent and turn on
 */
public String roomTurnedOn(){
    String out="";
    for (int i =0; i < matrixTurned.length ;i++){
        for (int j =0;j < matrixTurned[0].length ;j++){
        if(matrixRoom[i][j]==0){
            matrixTurned[i][j]=matrix[i][j].getNumberRoom();
        }
        else {
            matrixTurned[i][j]=0;
        }
        }
    }
    for (int i =0; i < matrixTurned.length;i++){
        for (int j =0;j < matrixTurned[0].length;j++){
            out+= matrixTurned[i][j] + " ";
            if (matrixRoom[i][j]%25==0 && matrixRoom[i][j]!=0){
            out+= "\n ";
            }
            if (matrixRoom[i][j]<100&&matrixRoom[i][j]>9){
            out += "  ";
            }
            if (matrixRoom[i][j]<10){
            out += "  ";
            }
            if (matrixRoom[i][j]==0){
            if(matrixRoom[i][j-1]%25==24){
            if(matrixRoom[i][j-1]<100){
            out += "\n";
            }
            if(matrixRoom[i][j-1]>100){
            out += "\n";
            }
            }
            }
            if(matrixRoom[i][j]==100){
            out += "  ";
            }
            if(matrixRoom[i][j]>100){
            out+= "  ";
            }
        }
    }
    return out;
}
/**
 * Method that simulate all the rooms turn on
 * @return out String is the matrix shown with all the rooms turn on
 */
public String allTurnedRoom(){
    String out="";
    for (int i =0; i < allTurned.length ;i++){
        for (int j =0;j < allTurned[0].length ;j++){
            allTurned[i][j]=matrix[i][j].getNumberRoom();
        }
        }
    for (int i =0; i < allTurned.length;i++){
        for (int j =0;j < allTurned[0].length;j++){
            out+= allTurned[i][j] + " ";
            if (allTurned[i][j]%25==0){
                out+= "\n";
                }
                if (matrixRoom[i][j]<99&&matrixRoom[i][j]>9){
                out += " ";
                }
                if (matrixRoom[i][j]<10){
                out += "  ";
                }
                

            }
    }
    return out;
}
/**
 * Method that do the function to simulate turn off with the letter L
 * without parameters
 */
public void turnoffoptionL(){
   for (int i =0; i < matrixTurned.length ;i++){
    for (int j =0;j < matrixTurned[0].length ;j++){
        matrixTurned[i][j]=0;
        matrixTurned[i][0]=matrix[i][0].getNumberRoom();
        matrixTurned[0][j]=matrix[0][j].getNumberRoom();
    }
}
  System.out.println(returnMatrix(matrixTurned));
}
/**
 * Method that do the function to simulate turn off with the letter Z
 * without parameters
 */
public void turnoffOptionZ(){
   for (int i =0; i < matrixTurned.length ;i++){
    for (int j =0;j < matrixTurned[0].length ;j++){
        matrixTurned[i][j]=0;
        matrixTurned[0][j]=matrix[0][j].getNumberRoom();
        matrixTurned[7][j]=matrix[7][j].getNumberRoom();
        matrixTurned[1][7]=matrix[1][7].getNumberRoom();
        matrixTurned[2][14]=matrix[2][14].getNumberRoom();
        matrixTurned[3][21]=matrix[3][21].getNumberRoom();
        matrixTurned[4][28]=matrix[4][28].getNumberRoom();
        matrixTurned[5][35]=matrix[5][35].getNumberRoom();
        matrixTurned[6][42]=matrix[6][42].getNumberRoom();
    }
}
  System.out.println(returnMatrix(matrixTurned));
}
/**
 * Method that do the function to simulate turn off with the letter H
 * without parameters
 */
public void turnoffOptionH(){
    double corridor=0;
    int ncorridor=0;
    double number=0;
    for (int i =0; i < matrixTurned.length ;i++){
        for (int j =0;j < matrixTurned[0].length ;j++){
            matrixTurned[i][j]=0;
            number = (double) matrix[i][j].getNumberRoom();
            corridor = number/50;
            ncorridor = (int)Math.ceil(corridor);
            if(ncorridor%2!=0){
                matrixTurned[i][j]= matrix[i][j].getNumberRoom();
            }
        }
    }
    System.out.println(returnMatrix(matrixTurned));
} 
/**
 * Method that do the function to simulate turn off with the letter O
 * without parameters
 */
public void turnoffOptionO(){
    for (int i =0; i < matrixTurned.length ;i++){
        for (int j =0;j < matrixTurned[0].length ;j++){
            matrixTurned[i][j]=0;
            if(matrix[i][j].getWindow()==true){
                matrixTurned[i][j]= matrix[i][j].getNumberRoom();
            }
        }
    }
    System.out.println(returnMatrix(matrixTurned));
}
/**
 * Method that do the function to simulate turn off with the letter M
 * without parameters
 */
public void turnoffOptionM(int column){
    for (int i =0; i < matrixTurned.length ;i++){
        for (int j =0;j < matrixTurned[0].length ;j++){
            matrixTurned[i][j]=0;
            matrixTurned[i][column]= matrix[i][column].getNumberRoom();
    }
    }
    System.out.println(returnMatrix(matrixTurned));
}
/**
 * Method that do the function to simulate turn off with the letter P
 * without parameters
 */
public void turnoffOptionP(int corridorEnter){
    double corridor=0;
    int ncorridor=0;
    double number=0;
    for (int i =0; i < matrixTurned.length ;i++){
        for (int j =0;j < matrixTurned[0].length ;j++){
            matrixTurned[i][j]=0;
            number = (double) matrix[i][j].getNumberRoom();
            corridor = number/50;
            ncorridor = (int)Math.ceil(corridor);
            if(ncorridor==corridorEnter){
            matrixTurned[i][j]=matrix[i][j].getNumberRoom();
            }
           
    }
}
   System.out.println(returnMatrix(matrixTurned));
}
/**
 * Method that show the Matrix with the rooms turn off
 * @param returnMatrix int[][] is the matrix that you want show
 * @return out is the matrix shown with the rooms turn off
 */
public String returnMatrix(int returnMatrix[][]){
    String out="";
    int value =0;
    for (int i =0; i < matrixTurned.length;i++){
        for (int j =0;j < matrixTurned[0].length;j++){
            out+= matrixTurned[i][j] + " ";
            value = matrix[i][j].getNumberRoom();
            if (value%25==0){
                out+= "\n";
                }
                if (value<100&&value>9){
                out += " ";
                }
                if (value<10){
                out += "  ";
                }
                if(value >100){
                out += " ";
                }
        }
    }
    return out;
}
}



