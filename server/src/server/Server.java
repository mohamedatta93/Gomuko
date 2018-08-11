/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;

/**
 *
 * @author mohamed
 */
public class Server {

    String messgeplayer1 = " hello i'm server you are the first client wait another client to connect 1";
    String messgeplayer2 = "hello i'm server you are the second  client there are client wait to play with you now you can play with him 0";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Server ss = new Server();


    }
    ServerSocket serv;
    Socket s;
    Socket s2;

    public Server() throws IOException {
        this.serv = new ServerSocket(444);
        this.s = serv.accept();
        this.s2 = serv.accept();
        TwoPlayer game = new TwoPlayer(serv, s, s2);
        Thread t = new Thread(game);
        t.start();
s.close();
s2.close();


    }
}
