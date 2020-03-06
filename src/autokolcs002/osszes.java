/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

/**
 *
 * @author fuged
 */
public class osszes {
    private Integer id;
    private String tipus;
    private String rendszam;
    private String nev;
    private String jogositvanyszam;
    private String kezdete;
    private String vege;
    private Integer fizetett;

    public osszes(Integer id, String tipus, String rendszam, String nev, String jogositvanyszam, String kezdete, String vege, Integer fizetett) {
        this.id = id;
        this.tipus = tipus;
        this.rendszam = rendszam;
        this.nev = nev;
        this.jogositvanyszam = jogositvanyszam;
        this.kezdete = kezdete;
        this.vege = vege;
        this.fizetett = fizetett;
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

    public String getVege() {
        return vege;
    }

    public Integer getFizetett() {
        return fizetett;
    }
    
}
