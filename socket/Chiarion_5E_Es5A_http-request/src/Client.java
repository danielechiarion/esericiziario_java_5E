import java.io.*;
import java.net.*;

public class Client implements Runnable {
    @Override
    public void run(){
        main();
    }

    public static void main() {
        final String SERVERIP = "google.it";
        final int SERVERPORT = 80;

        try{
            Socket socket = new Socket(SERVERIP, SERVERPORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println("GET / HTTP/1.1");
            writer.println("Host: google.it");
            writer.println("Connection: close");
            writer.println();

            String response;
            while((response = reader.readLine()) != null)
                System.out.println(response);

            reader.close();
            writer.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}