import poznyak.Phone;

import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {


        try( ServerSocket server = new ServerSocket(8000);){
            System.out.println("server started!");
            while (true)
            try(Phone phone = new Phone(server))
            {
                new Thread(() ->{}).start();
                String request = phone.readLine();
                System.out.println("Request: " + request);
                String response = (int) (Math.random() * 30 - 10) + "";
                Thread.sleep(4000);
                phone.writeLine(response);
                System.out.println("Response: " + response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}