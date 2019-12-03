package hello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class sss {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(45654);
        System.out.println("!");
        Socket socket = server.accept();
        System.out.println(new DataInputStream(socket.getInputStream()).readUTF());
        new DataOutputStream(socket.getOutputStream()).writeUTF("ABC");
        System.out.println("!");

    }
}
