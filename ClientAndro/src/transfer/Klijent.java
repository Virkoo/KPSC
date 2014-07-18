/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author DjordjeD
 */
public class Klijent {
    private Socket soket;
    public static int port;
    public static String ip;
   
    private static Klijent instance;

    public Klijent() throws IOException {
        soket = new Socket(ip,port);
        System.out.println("Uspesno povezivanje sa serverom");       
    }
    
    public static Klijent vratiObjekat() throws IOException{
        instance = new Klijent();
        return instance;
    }
    
    public void posaljiZahtev(TransferObjekat toZahtev) throws IOException{
        ObjectOutputStream outSocket = new ObjectOutputStream(soket.getOutputStream());
        outSocket.writeObject(toZahtev);      
    }
    
    public TransferObjekat procitajOdgovor() throws IOException, ClassNotFoundException{
        ObjectInputStream inSocket = new ObjectInputStream(soket.getInputStream());
        return (TransferObjekat) inSocket.readObject();
    }       
   
}
