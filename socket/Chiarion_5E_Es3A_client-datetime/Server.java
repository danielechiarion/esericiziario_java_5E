import java.io.*;
import java.util.*;
import java.net.*;

public class Server implements Runnable {
    private ServerSocket server;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        server.setSoTimeout(1000); // 1000ms = 1s
    }

    public Server() throws IOException {
        // la porta TCP standard del servizio daytime è 13
        server = new ServerSocket(13);
        server.setSoTimeout(1000); // 1000ms = 1s
    }

    @Override
    public void run() {
        Socket connection = null;

        while (!Thread.interrupted()) {
            try {
                // attesa richiesta connessione da parte del client (attesa massima 1s)
                connection = server.accept();
                System.out. println("Data/ora richiesta da: " +
                        connection.getInetAddress().toString() + ":" + connection.getPort());
                // creazione stream di output con codifica ISO-8859-1
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
                // creazione oggetto data/ora corrente
                Date now = new Date();
                // invio al client della stringa che rappresenta la data/ora corrente con terminatori di riga
                out.write(now.toString()+"\r\n");
                out.flush();
                // chiusura stream di output e socket di connessione
                out.close();
                connection.shutdownOutput();
                connection.close();
            }
            catch (SocketTimeoutException exception) {
            }
            catch (IOException exception) {
            }
            finally {
                if (connection != null) {
                    try {
                        connection.shutdownOutput();
                        connection.close();
                    }
                    catch (IOException exception) {
                    }
                }
            }
        }
        // chiusura socket di ascolto del server
        try {
            server.close();
        }
        catch (IOException exception) {
        }
    }
}