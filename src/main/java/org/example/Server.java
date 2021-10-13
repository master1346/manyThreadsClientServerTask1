package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22225);
        DeleteSpace deleteSpace = new DeleteSpace();
        while (true) {
            try(Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                String line;
                while((line = in.readLine()) != null){
                    out.println( "Строка без пробелов: " + deleteSpace.deleteAllSpace(line));
                    if(line.equals("end")) {
                        break;
                    }
                }
            }catch(IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
