import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);
        Fibonachi fibonachi = new Fibonachi();
        while(true) {
            try(Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                String line;
                while((line = in.readLine()) != null){
                    out.println( "Число Фибоначчи, под номером " + line + " : " + fibonachi.getNumberFibonachi(Integer.parseInt(line)));
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
