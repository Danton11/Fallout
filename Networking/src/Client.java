import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String userName;
        try {
            //get client's name (mainly for debugging)
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a username:");
            userName = in.nextLine();

            Socket s = new Socket(InetAddress.getByName("localhost"), 5000);
            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            //while server connected
            while (true) { //FIXME change to X pings per second
                //data sent to server
                System.out.println(inputStream.readUTF());
                String toSend = in.nextLine(); //TODO create a *better* data type that acts as a wrapper for useful data (name, co-ords, score etc)

                if(toSend.equals("Exit")) {
                    System.out.println(userName + "'s Connection closed");
                    break;
                }

                outputStream.writeUTF(userName + "/" + toSend);

                //data returned from server:
                String received = inputStream.readUTF();
                System.out.println(received);
            }

            in.close();
            inputStream.close();
            outputStream.close();

        } catch(Exception e) {
            System.out.println("Error caught:");
            e.printStackTrace();
        }
    }
} 