/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DjordjeD
 */
public class Pazar implements Serializable{
    private Date datum;
    private double iznos;
    private String imeIPrezimeRadnika;
    private static Pazar instance;

    
    public static Pazar vratiObjekat(){
        if (instance == null) instance = new Pazar(new Date(), 0 , null);
        return instance;
    }
    
    private Pazar() {
    }

    public Pazar(Date datum, double iznos, String imeIPrezimeRadnika) {
        this.datum = datum;
        this.iznos = iznos;
        this.imeIPrezimeRadnika = imeIPrezimeRadnika;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getImeIPrezimeRadnika() {
        return imeIPrezimeRadnika;
    }

    public void setImeIPrezimeRadnika(String imeIPrezimeRadnika) {
        this.imeIPrezimeRadnika = imeIPrezimeRadnika;
    }  

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        
        return  sdf.format(datum) + "  " + iznos + "0  " + imeIPrezimeRadnika;
    }
    
}