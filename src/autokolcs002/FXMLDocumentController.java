/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author fuged
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtAszin;

    @FXML
    private TextField txtAtipus;

    @FXML
    private TableView<auto> tblAutok;

    @FXML
    private TableColumn<auto, String> oArendszam;

    @FXML
    private TableColumn<auto, String> oAtipus;

    @FXML
    private TableColumn<auto, String> oAszin;

    @FXML
    private TableColumn<auto, String> oAjogtipus;

    @FXML
    private TableColumn<auto, Integer> oAberdij;

    @FXML
    private TableColumn<auto,Boolean > oAberelheto;

    @FXML
    private TextField txtArendszam;

    @FXML
    private TextField txtAjogtipus;

    @FXML
    private TextField txtAberdij;

    @FXML
    private TextField txtBnev;

    @FXML
    private TextField txtBcim;

    @FXML
    private TextField txtBjogszam;

    @FXML
    private TextField txtBtelszam;

    @FXML
    private TextField txtBjogtipus;

        @FXML
        void batAmodosit() {
            int index = tblAutok.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            panel.Panel.hiba("Hiba", "Nincs kiválasztva a módosítandó gépjármű!");
            return;
        }
        
        String tipus = txtAtipus.getText().trim();
        if (tipus.isEmpty() || tipus.length() > 100) {
            panel.Panel.hiba("Hiba", "Add meg az autó tipusát, ami maximum 100 karakter lehet!");
            txtAtipus.requestFocus();
            return;
        }
        
        String szin = txtAszin.getText().trim();
        if (szin.isEmpty() || szin.length() > 50) {
            panel.Panel.hiba("Hiba", "Add meg az autó szinét ami maximum 50 karakter lehet!!");
            txtAszin.requestFocus();
            return;
        }

        if (txtAjogtipus.getText().isEmpty()) {
            panel.Panel.hiba("Hiba", "Add meg a jógositványtipusodat");
            txtAjogtipus.requestFocus();
            return;
        }

        


        String rendszam = txtArendszam.getText().trim();
        if (rendszam.length() != 7) {
            panel.Panel.hiba("Hiba", "A rendszám 7 karakterből áll!");
            txtArendszam.requestFocus();
            return;
        }

        if (txtAberdij.getText().isEmpty()) {
            panel.Panel.hiba("Hiba", "Add meg a napi bérleti díjat!");
            txtAberdij.requestFocus();
            return;
        }

        Integer napidij;

        try {
            napidij = Integer.parseInt(txtAberdij.getText().trim());
            if (napidij < 3000) {
                panel.Panel.hiba("Hiba", "Az autó napi bérleti díja nem lehet 3000 Ft-nál kevesebb!");
                txtAberdij.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            panel.Panel.hiba("Hiba!", "Az ár nem szám!");
            txtAberdij.requestFocus();
            return;
        }

        int id = tblAutok.getItems().get(index).getId();
        /*
        if (!panel.Panel.igennem("Mentés", "Mented a módisított adatokat")) {
            return;
        }
        
        String v = ab.auto_modosit(id, tipus, szin, evjarat, rendszam, napidij);
        
        if (v.isEmpty()) {
            ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            beolvas();
            for (int i = 0; i < tblAutok.getItems().size(); i++) {
                if (tblAutok.getItems().get(i).getId() == id) {
                    tblAutok.getSelectionModel().select(i);
                    break;
                }
            }
        } else {
           panel.Panel. hiba("hiba", v);
        }*/
    
        }

        @FXML
        void batAtorles() {

        }

        @FXML
        void betAment() {
            String tipus = txtAtipus.getText().trim();
        if (tipus.isEmpty() || tipus.length() > 100) {
             panel.Panel.hiba("Hiba", "Add meg az autó tipusát, ami maximum 100 karakter lehet!");
            txtAtipus.requestFocus();
            return;
        }

        String szin = txtAszin.getText().trim();
        if (szin.isEmpty() || szin.length() > 50) {
             panel.Panel.hiba("Hiba", "Add meg az autó szinét ami maximum 50 karakter lehet!!");
            txtAszin.requestFocus();
            return;
        }

        if (txtAjogtipus.getText().isEmpty()) {
             panel.Panel.hiba("Hiba", "Add meg a jógósitványod Tipusát!");
            txtAjogtipus.requestFocus();
            return;
        }

        String rendszam = txtArendszam.getText().trim();
        if (rendszam.length() != 7) {
             panel.Panel.hiba("Hiba", "A rendszám 7 karakterből áll!");
            txtArendszam.requestFocus();
            return;
        }

        if (txtAberdij.getText().isEmpty()) {
             panel.Panel.hiba("Hiba", "Add meg a napi bérleti díjat!");
            txtAberdij.requestFocus();
            return;
        }

        Integer berdijj;

        try {
            berdijj = Integer.parseInt(txtAberdij.getText().trim());
            if (berdijj < 3000) {
                panel.Panel.hiba("Hiba", "Az autó napi bérleti díja nem lehet 3000 Ft-nál kevesebb!");
                txtAberdij.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            panel.Panel.hiba("Hiba!", "Az ár nem szám!");
            txtAberdij.requestFocus();
            return;
        }

        if (!panel.Panel.igennem("Mentés", "Mented az új autó adatait?")) {
            return;
        }

        
    
        }

        @FXML
        void betAuj() {
        txtAtipus.requestFocus();
        txtAtipus.clear();
        txtArendszam.clear();
        txtAszin.clear();
        txtAjogtipus.clear();
        txtAberdij.clear();

        }

        @FXML
        void betBju() {

        }

        @FXML
        void betBment() {

        }

        @FXML
        void betBmodosit() {

        }

        @FXML
        void betBtorles() {

        }
    
    DB ab = new DB();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     
}
