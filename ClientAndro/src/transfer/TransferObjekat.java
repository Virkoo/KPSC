/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transfer;

import domen.Pazar;
import domen.Artikal;
import java.io.Serializable;

/**
 *
 * @author DjordjeD
 */
public class TransferObjekat implements Serializable{
    private Artikal artikal;
    private Pazar dnevniPazar;
    private int kod;

    public TransferObjekat() {
    }

    public TransferObjekat(Artikal artikal, Pazar dnevniPazar, int kod) {
        this.artikal = artikal;
        this.dnevniPazar = dnevniPazar;
        this.kod = kod;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Pazar getDnevniPazar() {
        return dnevniPazar;
    }

    public void setDnevniPazar(Pazar dnevniPazar) {
        this.dnevniPazar = dnevniPazar;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }   
}