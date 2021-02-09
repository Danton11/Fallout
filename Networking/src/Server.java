import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000); //listening on port 5000

        //waiting for client request
        while (true) {
            Socket s = null;
            try {
                s = ss.accept(); //socket object receives incoming client requests
                System.out.println("A new client is connected : " + s);
                //obtaining input and out streams
                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                System.out.println("Assigning new thread for this client");

                //create a new thread & start it
                Thread t = new ClientHandler(s, inputStream, outputStream);
                t.start();
            } catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket s;

    //FIXME change so that there is a list? of clientHandlers which then allows us to push messages to ALL clients instead of just a 1:1

    public ClientHandler(Socket s, DataInputStream inputStream, DataOutputStream outputStream) {
        this.s = s;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {
                outputStream.writeUTF("Send some info to push to server:"); //prompt client for data
                received = inputStream.readUTF(); //take in data

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("It's not you, it's me");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                String[] ourDataType = received.split("/"); //splits the received data at '/' character to get the name & message separately
                System.out.println("Server received: '" + ourDataType[1] + "' from: " + ourDataType[0]);
                outputStream.writeUTF("What am I supposed to do with that? You idiot sandwich\n"); //politely thank the user

                //FIXME push received info to all connected clients here

            } catch (IOException e) {
                System.out.println("Exception caught:");
                e.printStackTrace();
            }
        }

        try {
            // closing resources 
            this.inputStream.close();
            this.outputStream.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
} 