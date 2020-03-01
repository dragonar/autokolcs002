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
class auto {
     private Integer id;
    private String tipus;
    private String szin;
    private String jogtipus;
    private String rendszam;
    private Integer berdij;

    public auto(Integer id, String tipus, String szin, String jogtipus, String rendszam, Integer berdij) {
        this.id = id;
        this.tipus = tipus;
        this.szin = szin;
        this.jogtipus = jogtipus;
        this.rendszam = rendszam;
        this.berdij = berdij;
    }

    public void setId(Integer id) {
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

    public void setBerdij(Integer berdij) {
        this.berdij = berdij;
    }

    public Integer getId() {
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

    public Integer getBerdij() {
        return berdij;
    }



}
