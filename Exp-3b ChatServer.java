import java.io.*;
import java.net.*;
import java.util.*;

public class exp3bChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for client...");

            Socket s = ss.accept();
            System.out.println("Client connected.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);

            String senddata;
            String recievedata = "";

            while (!recievedata.equalsIgnoreCase("stop")) {
                recievedata = din.readUTF();
                System.out.println("CLIENT SAYS: " + recievedata);

                if (recievedata.equalsIgnoreCase("stop")) {
                    break;
                }

                System.out.print("TO CLIENT: ");
                senddata = input.nextLine();
                dout.writeUTF(senddata);
            }

            din.close();
            dout.close();
            s.close();
            ss.close();
            input.close();

            System.out.println("Chat ended.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
