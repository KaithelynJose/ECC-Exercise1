import java.util.Scanner;
import java.util.Random;

public class App {  
    static String [][] table;

    public static String getRandValues() {
        String values = " !#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~␡";
        StringBuilder SB = new StringBuilder();  
        Random random = new Random();     
        while(SB.length() < 3){
            int i = (int) (random.nextFloat() * values.length());
            SB.append(values.charAt(i));
        }
        String valStr = SB.toString();    
        return valStr;
    }

    public static String[][] initializeArray(String[][] table){
        for(int i=0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = getRandValues(); 
            }         
        }
        return table;
    }

    private static void searchString(String[][]table, int rowNum, int colNum){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        
        System.out.print("Enter a string to search: ");  
        String search= sc.nextLine();             

        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(table[i][j].contains(search)){
                    count++;
                    System.out.println("Search String \""+ search+"\" found at " + "("+Integer.toString(i)+","+Integer.toString(j)+")");
                }
            }
        }
        System.out.println("Returned "  +count + " matches.");
        showMenu(table, rowNum, colNum);
        sc.close();
    }

    private static String editValue(String[][]table, int rowNum, int colNum){
        Scanner sc = new Scanner(System.in);
        int inputCol = 0;
        int inputRow = 0;
        String newValue = " ";
        
        System.out.print("Enter Row: ");
        inputRow = sc.nextInt();
        System.out.print("Enter Cols:");
        inputCol = sc.nextInt();
        System.out.print("Enter New Values: ");
        newValue = sc.next();

        table[inputRow][inputCol] = newValue;
        System.out.println(table[inputRow][inputCol]);
        showMenu(table, rowNum, colNum);
        
        return newValue; 
            
    }

    private static void printTable(String[][]table, int rowNum, int colNum){
        for(int i=0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                System.out.print("[" + table [i][j] + "] ");                        
            }
            System.out.println();           
        }
        showMenu(table, rowNum, colNum);
    }
    
    public static String[][] resetTable(String [][]table){
        Scanner sc = new Scanner(System.in);
        int rowNum, colNum;

        System.out.print("Enter a number for row dimension: ");
        rowNum = sc.nextInt();
        System.out.print("Enter a number for column dimension: ");
        colNum = sc.nextInt(); 
        System.out.println("-------------------");

        table = new String [rowNum][colNum];
        for(int i=0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                table[i][j] = getRandValues();
 
                System.out.print("[" + table [i][j] + "] ");                        
            }
            System.out.println();           
        }
        return table;
    }

    public static int showMenu(String[][]table, int rowNum, int colNum){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tMENU");
        System.out.println("-------------------");
        System.out.println("[1]- SEARCH");
        System.out.println("[2] - EDIT");
        System.out.println("[3] - PRINT");
        System.out.println("[4] - RESET");
        System.out.println("[5] - EXIT");
        System.out.println("-------------------");
        System.out.print("Enter your choice: ");
        
        choice = sc.nextInt();

        switch(choice) {
            case 1: System.out.println("-------------------");
                    System.out.println("SEARCH\n");
                    searchString(table, rowNum, colNum);
                    break;
            case 2: System.out.println("-------------------");
                    System.out.println("EDIT\n");
                    editValue(table, rowNum, colNum);
                    break;
            case 3: System.out.println("-------------------");
                    System.out.println("PRINT\n");
                    printTable(table, rowNum, colNum);
                    break;
            case 4: System.out.println("-------------------");
                    System.out.println("RESET\n");
                    resetTable(table);
                    showMenu(table, rowNum, colNum);
                    break;
            case 5: System.out.println("-------------------");
                    System.out.println("EXIT\n");
                    System.exit(0);
                    break;
            default : System.out.println("Invalid choice");
		      System.out.print("Enter your choice: ");
		      choice = sc.nextInt();

        }
        return choice;  
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int rowNum, colNum; 
        
        System.out.println("JAVA EXERCISE 1");

        System.out.print("\nEnter a number for row dimension: ");
        rowNum = sc.nextInt();
        System.out.print("Enter a number for column dimension: ");
        colNum = sc.nextInt(); 
        System.out.println("-------------------");
        
        String [][] table = new String [rowNum][colNum];
                     
        for(int i=0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                table[i][j] = getRandValues();

                System.out.print("[" + table [i][j] + "] ");                          
            }
            System.out.println();           
        }
        showMenu(table, rowNum, colNum);
        sc.close();
    }     
}