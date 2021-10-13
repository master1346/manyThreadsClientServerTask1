
package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1",22225);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(clientSocket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.print("Client: Введите строку с пробелами или end: ");
                msg = scanner.nextLine();
                out.println(msg);
                if ("end".equals(msg)) break;

                System.out.println("SERVER: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}