import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String remoteHost = "127.0.0.1";
        int port = Integer.parseInt(args[0]);

        InputStream inputStream;
        DataInputStream inDataStream;

        OutputStream outputStream;
        DataOutputStream outDataStream;

        Socket connection;

        try {
            connection = new Socket(remoteHost, port);
            System.out.println("Connection Established");

            inputStream = connection.getInputStream();
            inDataStream = new DataInputStream(inputStream);

            outputStream = connection.getOutputStream();
            outDataStream = new DataOutputStream(outputStream);

            outDataStream.writeUTF(connection.getLocalAddress().getHostAddress());
        } catch (IOException ioe) {
            System.out.println("Network exception");
        }
    }
}