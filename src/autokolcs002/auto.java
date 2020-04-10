/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

/**
 * Kölcsönözhető gépjárművek adatai
 * @author Fugedi Marcell
 */
public class auto {
     private int id;
    private String tipus;
    private String szin;
    private String jogtipus;
    private String rendszam;
    private int berelve;
    private int berdij;

    public void setId(int id) {
        this.id = id;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setJogtipus(String jogtipus) {
        this.jogtipus = jogtipus;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public void setBerelve(int berelve) {
        this.berelve = berelve;
    }

    public void setBerdij(int berdij) {
        this.berdij = berdij;
    }

    
    
    public int getId() {
        return id;
    }

    public String getTipus() {
        return tipus;
    }

    public String getSzin() {
        return szin;
    }

    public String getJogtipus() {
        return jogtipus;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getBerelve() {
        return berelve;
    }

    public int getBerdij() {
        return berdij;
    }

    public auto(int id, String tipus, String szin, String jogtipus, String rendszam,int berelve, int berdij) {
        this.id = id;
        this.tipus = tipus;
        this.szin = szin;
        this.jogtipus = jogtipus;
        this.rendszam = rendszam;
        this.berelve=berelve;
        this.berdij = berdij;
    }

   


}
