package calculator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            System.out.println("Usage: java add/App <portNo>");
            System.exit(0);
        }

        Integer portNo = Integer.parseInt(args[0]);

        ServerSocket server = new ServerSocket(portNo);
        System.out.println("Server started; listening on port " + portNo);

        Socket socket = server.accept();
        System.out.println("Client connected to " + socket.getLocalSocketAddress().toString());

        NetworkIO netIO = new NetworkIO(socket);

        String msgRecv = "";

        // below line is specific to this program
        MathFn mathfn = new MathFn();

        while(!msgRecv.equalsIgnoreCase("quit")) {
            msgRecv = netIO.read();
            
            // if{} is specific to this program
            if(!msgRecv.equalsIgnoreCase("quit")) {
                if(msgRecv.toLowerCase().startsWith("add")) {
                    netIO.write("Sum result: " + mathfn.add(msgRecv));

                } else if(msgRecv.toLowerCase().startsWith("subtract")) {
                    netIO.write("Subtraction result: " + mathfn.minus(msgRecv));

                } else if(msgRecv.toLowerCase().startsWith("multiply")) {
                    netIO.write("Multiplication result: " + mathfn.multiply(msgRecv));

                } else if(msgRecv.toLowerCase().startsWith("divide")) {
                    netIO.write("Division result: " + mathfn.divide(msgRecv));

                }
            }   
        }
        netIO.close();
        server.close();
    }
}

