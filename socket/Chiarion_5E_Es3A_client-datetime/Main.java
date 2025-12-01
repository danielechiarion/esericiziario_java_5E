import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /* define constants for
        * the execution of the program */
        final int SERVERPORT = 1450;

        /* define the thread to start
        * for the program */
        Client client = new Client(SERVERPORT);
        Thread clientThread = new Thread(client);
        Server server;
        Thread serverThread;
        try{
            server = new Server(SERVERPORT);
            serverThread = new Thread(server);
        }catch(IOException e){
            System.out.println("Error in creating the server socket");
            return;
        }

        /* execute the program */
        try{
            serverThread.start();
            clientThread.start();
            clientThread.join();
            serverThread.interrupt();
            serverThread.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}