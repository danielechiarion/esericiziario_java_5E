import java.io.*;
import java.net.*;

public class Server implements Runnable{
    @Override
    public void run(){
        main();
    }

    public static void main() {
        /* define constant for socket connection */
        final int PORT = 12345;

        try{
            /* create socket by the server side */
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server in ascolto sulla porta "+PORT);

            /* accepting client socket */
            Socket clientSocket = serverSocket.accept();
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Connessione ricevuta da: "+ clientSocket.getRemoteSocketAddress().toString());

            /* read data  */
            String result = reader.readLine();
            System.out.println("Ricevuto dal client: "+result);
            /* send acknowledgement and
            * close the IO instances */
            writer.println(true);
            writer.close();
            reader.close();
            clientSocket.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
