public class Main {
    public static void main() {
        /* define thread  */
        Client client = new Client();
        Server server = new Server();
        Thread clientThread = new Thread(client);
        Thread serverThread = new Thread(server);

        try{
            serverThread.start();
            clientThread.start();
            clientThread.join();
            serverThread.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}