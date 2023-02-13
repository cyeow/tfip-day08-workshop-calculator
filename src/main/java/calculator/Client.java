package calculator;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        if(args.length <= 0) {
            System.out.println("Usage: java add/Client <hostname>:<portno>");
            System.exit(0);
        }

        String hostname = args[0].split(":")[0];
        Integer portNo = Integer.parseInt(args[0].split(":")[1]);

        Socket socket = new Socket(hostname, portNo); 
        NetworkIO netIO = new NetworkIO(socket);
        
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String serverResponse = "";

        System.out.println("Welcome to basic math calculator!");
        displayMenu();

        while(!input.equalsIgnoreCase("quit")) {
            System.out.printf("> ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("help")) {
                displayMenu();
                continue;
            }

            if(!input.equalsIgnoreCase("quit")) {
                String numbers = input;//.replace("add", "").trim();
                netIO.write(numbers);

                serverResponse = netIO.read();
                System.out.println(serverResponse);    
            }
        }

        scanner.close();
        netIO.write("quit"); // erm so this is a cybersecurity issue, clients should not be able to end the server process
        netIO.close();
        
    }

    private static void displayMenu() {
        System.out.println("==============================");
        System.out.println("Available commands:");
        System.out.println("\"add <integer array>\"\t\tAdds the numbers in the integer array.");
        System.out.println("\"subtract <integer array>\"\tSubtracts the numbers in the integer array from the integer in the first element of the array.");
        System.out.println("\"multiply <integer array>\"\tMultiplies the numbers in the integer array.");
        System.out.println("\"divide <integer array>\"\tDivides the numbers in the integer array from the integer in the first element of the array.");
        System.out.println("\"help\"\t\t\t\tDisplays the list of available commands.");
        System.out.println("\"quit\"\t\t\t\tEnds the connection with the server.");
        System.out.println("\nNote on <integer array>");
        System.out.println("Integer array input should be delimited by spaces, e.g. \"add 1 2 3 4\"");
        System.out.println("==============================");
    }
}
