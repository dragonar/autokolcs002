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
public class berlok {
    private Integer id;
    private String nev;
    private String jogositvanyszam;
    private String telefonszam;
    private String cim;
    private String jogtipus;
    
    public berlok(Integer id, String nev, String jogositvanyszam, String telefonszam, String cim, String jogtipus) {
        this.id = id;
        this.nev = nev;
        this.jogositvanyszam = jogositvanyszam;
        this.telefonszam = telefonszam;
        this.cim = cim;
        this.jogtipus = jogtipus;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setJogositvanyszam(String jogositvanyszam) {
        this.jogositvanyszam = jogositvanyszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public void setJogtipus(String jogtipus) {
        this.jogtipus = jogtipus;
    }

    public Integer getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getJogositvanyszam() {
        return jogositvanyszam;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public String getCim() {
        return cim;
    }

    public String getJogtipus() {
        return jogtipus;
    }
    
}
