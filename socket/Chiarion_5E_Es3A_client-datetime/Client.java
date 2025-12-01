import java.net.*;
import java.io.*;

public class Client implements Runnable {
    @override
    public void run(){
        /* define constants for connection with server */
        const String IPADDRESS = "127.0.0.1";
        const int SERVERPORT = 1450;

        /* socket istantiation for the 
        connection with the server */
        Socket socket = new Socket();
        InetSocketAddress addressServer = new InetSocketAddress(IPADDRESS, SERVERPORT);
        socket.connect(addressServer);
        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream(), "ISO-8859-1"); // implement ascii code

        /* get the data and then
        close the connection */
        System.out.println("L'ora corrente è: ", inputStream.read());
        inputStream.close();
        socket.close();
    }
}