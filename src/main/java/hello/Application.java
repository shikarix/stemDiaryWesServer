package hello;

import hello.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.ServerSocket;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        new Thread(){
            @Override
            public void run() {
                SpringApplication.run(Application.class, args);
            }
        }.start();
        ServerSocket socket = new ServerSocket(45654);
        System.out.println("!");
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("!");
                    new GreetingController().createSocket(socket);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(() -> {
           while (true){}
        });
    }

}
