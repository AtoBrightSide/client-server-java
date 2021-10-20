import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 5566;

        Socket connection;
        ServerSocket listenSocket;

        InputStream inStream;
        DataInputStream inputDataStream;

        OutputStream outStream;
        DataOutputStream outputDataStream;

        String client;
        int first, second, sum;
        boolean connected;

        while (true) {
            try {
                listenSocket = new ServerSocket(PORT);
                System.out.println("Listening in port " + PORT);
                connection = listenSocket.accept();
                connected = true;
                System.out.println("Connection established");

                inStream = connection.getInputStream();
                inputDataStream = new DataInputStream(inStream);

                outStream = connection.getOutputStream();
                outputDataStream = new DataOutputStream(outStream);

                client = inputDataStream.readUTF();
                System.out.println("Address of client: " + client);

                while (connected) {
                    first = inputDataStream.readInt();
                    System.out.println("First number: " + first);

                    second = inputDataStream.readInt();
                    System.out.println("Second number: " + second);
                    
                    sum = first + second;
                    System.out.println("Sum is: " + sum);
                    outputDataStream.writeInt(sum);
                }
                // listenSocket.close();
            } catch (Exception e) {
                connected = false;
            }
        }
    }
}