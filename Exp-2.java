import java.io.*;
import java.net.*;

public class exp2 {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the website on port 80 (HTTP)
            Socket socket = new Socket("www.martinbroadhurst.com", 80);

            // Get the output stream to send the request
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send an HTTP GET request
            out.println("GET / HTTP/1.1");
            out.println("Host: www.martinbroadhurst.com");
            out.println("Connection: close"); // To indicate the server should close the connection after response
            out.println(); // Blank line to signify end of headers

            // Get the input stream to read the server's response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and print the server's response
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
