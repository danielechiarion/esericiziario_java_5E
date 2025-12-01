import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Client implements Runnable {
    private String address;
    private int port;

    public Client(String address, int port){
        this.address = address;
        this.port = port;
    }

    public Client(int port){
        this("127.0.0.1", port);
    }

    @Override
    public void run(){
        /* socket istantiation for the 
        connection with the server */
        Socket socket = new Socket();
        InetSocketAddress addressServer = new InetSocketAddress(this.address, this.port);
        BufferedReader inputStream = null;
        try{
            socket.connect(addressServer);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.ISO_8859_1)); // implement ascii code

            /* get the data and then
            close the connection */
            System.out.println("L'ora corrente è: "+inputStream.readLine());
            inputStream.close();
            socket.close();
        }catch(IOException e) {
            System.out.println("Connection error to the server");
            System.exit(1);
        }
    }
}