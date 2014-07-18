/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;

/**
 *
 * @author DjordjeD
 */
public class Artikal implements Serializable{
    private String barkod;
    private String naziv;
    private String opis;
    private int zaliha;
    private double cena;
    private Kategorija kategorija;

    public Artikal() {
    }

    public Artikal(String barkod, String naziv, String opis, int zaliha, double cena, Kategorija kategorija) {
        this.barkod = barkod;
        this.naziv = naziv;
        this.opis = opis;
        this.zaliha = zaliha;
        this.cena = cena;
        this.kategorija = kategorija;
    }  
    
    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getZaliha() {
        return zaliha;
    }

    public void setZaliha(int zaliha) {
        this.zaliha = zaliha;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return barkod + " " + naziv + " " + cena ;
    }   
}