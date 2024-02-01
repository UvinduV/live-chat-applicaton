package org.example.Server;

import org.example.Client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server  {
    /*private static Server server;
    private final ServerSocket serverSocket;


    private Server() throws IOException {
        serverSocket = new ServerSocket(1236);
        System.out.println("Server Started");
    }

    public static Server getServerSocket() throws IOException {
        return server == null ? server = new Server() : server;
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            System.out.println("listening.......");
            try {
                Socket accepted = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(accepted);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
    private ServerSocket serverSocket;
    private Socket socket;
    private static Server server;

    private List<ClientHandler> clients = new ArrayList<>();

    private Server() throws IOException {
        serverSocket = new ServerSocket(3001);
        System.out.println("server started!");
    }

    public static Server getInstance() throws IOException {
        return server!=null? server:(server=new Server());
    }

    public void makeSocket(){
        while (!serverSocket.isClosed()){
            try{
                socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket,clients);
                clients.add(clientHandler);
                System.out.println("client socket accepted "+socket.toString());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
