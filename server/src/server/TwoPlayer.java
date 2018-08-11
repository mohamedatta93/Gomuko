/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamed
 */
public class TwoPlayer implements Runnable {

    public Socket socket1, socket2;
    ServerSocket serv;
    String messgeplayer1 = " hello i'm server you are the first client wait another client to connect 1";
    String messgeplayer2 = "hello i'm server you are the second  client there are client wait to play with you now you can play with him 0";
    win w;

    public TwoPlayer(ServerSocket serv, Socket s, Socket s2) throws UnknownHostException, IOException {
        w = new win();
        this.serv = serv;
        socket1 = s;
        socket2 = s2;
        run();

    }
///////////// function to recieve message drom second player

    String RecMessFSPlayer() throws IOException {

        InputStreamReader in2 = new InputStreamReader(socket2.getInputStream());

        BufferedReader br2 = new BufferedReader(in2);

        String mess2 = br2.readLine();
        //if (mess2 != null) {
        //  System.out.println("  server not recieve any message yet" + mess2);
        // }
        return mess2;
    }

    ///////////// function to recieve message drom first player
    String RecMessFFPlayer() throws IOException {
        InputStreamReader in = new InputStreamReader(socket1.getInputStream());
        BufferedReader br = new BufferedReader(in);
String mess="";
        if(br!=null)
        mess = br.readLine();

        //      if (mess != null) {
        //        System.out.println(mess + "  server not recieve any message yet");
        //  }

        return mess;
    }

    void sendmessageTFplayer() throws IOException {
        PrintStream ps = new PrintStream(socket1.getOutputStream());

        ps.println(messgeplayer1);



    }

    void sendmessageTSplayer() throws IOException {
        PrintStream ps2 = new PrintStream(socket2.getOutputStream());

        ps2.println(messgeplayer2);
//        messgeplayer1 = " there is player can play with you now play now your turn ";

    }
/////// function to manage the turn of each player to the end of the game

    void manageTurns() throws IOException {
        String s;
        int i = 0;
        int x, y, x1, y2, number;
        while (true) {
            System.out.println("i " + i);
            if (i % 2 == 0) {
                s = RecMessFFPlayer();
               number = Integer.parseInt(s);
                x = number / 14;
                y = number % 14;

                x = w.play(x, y, 1);
                if (x == 1) {
                    s = "lose";
                } else if (x == 2) {
                    s = "win";
                } else if (x == 3) {
                    s = "draw";
                
                }

                messgeplayer2 = s;
                sendmessageTSplayer();
if(Character.isLetter(s.charAt(0)))
{ messgeplayer1 = "win";
                sendmessageTFplayer();
break;
}        
            } else {

                s = RecMessFSPlayer();
               
             
                number = Integer.parseInt(s);
                x = number / 14;
                y = number % 14;

                x = w.play(x, y, 2);
                if (x == 1) {
                    s = "lose";
                } else if (x == 2) {
                    s = "lose";
                } else if (x == 3) {
                    s = "draw";
                }

                messgeplayer1 = s;

                sendmessageTFplayer();
 if(!Character.isDigit(s.charAt(0)))        
    {   messgeplayer2 = "win";

                sendmessageTSplayer();
break;
}
            }
            i++;




        }


socket1.close();
socket2.close();


    }

    @Override
    public void run() {
        try {
            this.sendmessageTFplayer();
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.sendmessageTSplayer();
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* try {
         this.sendmessageTFplayer();
         } catch (IOException ex) {
         Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
         this.RecMessFFPlayer();
         } catch (IOException ex) {
         Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
         this.RecMessFSPlayer();
         } catch (IOException ex) {
         Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
         }*/
       
        try {
            this.manageTurns();
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
