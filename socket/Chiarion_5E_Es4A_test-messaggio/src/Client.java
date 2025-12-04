import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable{
    @Override
    public void run(){
        main();
    }

    public static void main() {
        /* Define constants to create
        * a socket */
        final String SERVERIP = "127.0.0.1";
        final int SERVERPORT = 12345;

        /* creating socket */
        try{
            Socket socket = new Socket(SERVERIP, SERVERPORT); // putting the server ip and address avoids using the connect method
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true); // set the autoflush to clear the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // get the reader
            socket.setSoTimeout(5000);

            /* input request for a string */
            System.out.println("Connesso al server...");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci una stringa: ");
            String msg = scanner.nextLine();

            /* send the data to the server and wait for a result */
            writer.println(msg);
            System.out.println("Il risultato della ricezione è: "+reader.readLine());

            /* close all the socket parts opened */
            writer.close();
            reader.close();
            socket.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}