/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logika;

import domen.Artikal;
import util.Konstante;
import domen.Pazar;

import java.io.IOException;

import android.util.Log;
import transfer.Klijent;
import transfer.TransferObjekat;

/**
 *
 * @author DjordjeD
 */
public class Kontroler {

    private static Kontroler instance;
    private final static String TAG = "ThreadingAsyncTask";

    
    public static Kontroler vratiObjekat(){
    	Log.e(TAG, "Usli u vratiObjekat");
        if (instance == null) instance = new Kontroler();
        return instance;
    }
    
    private Kontroler() {

    }
    
    public Artikal traziArtikal(String barkod) throws IOException, ClassNotFoundException, Exception{
        TransferObjekat tz = new TransferObjekat(new Artikal(barkod, null, null, 0, 0, null), null, 1);
        Klijent k = Klijent.vratiObjekat();
        k.posaljiZahtev(tz);
        TransferObjekat to = k.procitajOdgovor();
        switch (to.getKod()){
            case Konstante.ARTIKAL_ODGOVOR :{
                return to.getArtikal();
                
            }
            case Konstante.GRESKA: {
                throw new Exception("doslo je do greske na serveru");
            }   
            default:{
                throw new Exception();
            }
        }     
    }
        
    public Pazar traziPazar() throws IOException, ClassNotFoundException, Exception{
        TransferObjekat tz = new TransferObjekat(null, null, 2);
        Klijent k = Klijent.vratiObjekat();
        k.posaljiZahtev(tz);
        TransferObjekat to = k.procitajOdgovor();
        switch (to.getKod()){
            case Konstante.PAZAR_ODGOVOR :{
                return to.getDnevniPazar();
            }
            case Konstante.GRESKA: {
                throw new Exception("doslo je do greske na serveru");
            }   
            default:{
                throw new Exception();
            }
        }
    }   
    
    
    public void konektujSeNaServer() throws IOException{
        Klijent.vratiObjekat();
    }
}