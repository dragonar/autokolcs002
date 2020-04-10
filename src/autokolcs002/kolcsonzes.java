/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

/**
 *
 *  @author Fugedi Marcell
 */
public class kolcsonzes {
     private Integer id;
    private String tipus;
    private String rendszam;
    private String nev;
    private String jogositvanyszam;
    private String kezdete;
    private Integer berdij ;

    public kolcsonzes(Integer id, String tipus, String rendszam, String nev, String jogositvanyszam, String kezdete, Integer berdij) {
        this.id = id;
        this.tipus = tipus;
        this.rendszam = rendszam;
        this.nev = nev;
        this.jogositvanyszam = jogositvanyszam;
        this.kezdete = kezdete;
        this.berdij = berdij;
    }

    public Integer getId() {
        return id;
    }

    public String getTipus() {
        return tipus;
    }

    public String getRendszam() {
        return rendszam;
    }

    public String getNev() {
        return nev;
    }

    public String getJogositvanyszam() {
        return jogositvanyszam;
    }

    public String getKezdete() {
        return kezdete;
    }

    public Integer getBerdij() {
        return berdij;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setJogositvanyszam(String jogositvanyszam) {
        this.jogositvanyszam = jogositvanyszam;
    }

    public void setKezdete(String kezdete) {
        this.kezdete = kezdete;
    }

    public void setBerdij(Integer berdij) {
        this.berdij = berdij;
    }
    
    
}
