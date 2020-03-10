/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField txtArendszam;

    @FXML
    private TextField txtAjogtipus;

    @FXML
    private TextField txtAberdij;

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
    private TableView<berlok> tblBerlok;

    @FXML
    private TableColumn<berlok, String> oBnev;

    @FXML
    private TableColumn<berlok, String> oBcim;

    @FXML
    private TableColumn<berlok, String> oBtelefon;

    @FXML
    private TableColumn<berlok, String> oBjogszam;

    @FXML
    private TableColumn<berlok, String> oBjogtipus;
    
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
    private TextField cbxKjogszam;
    
    @FXML
    private TableView<kolcsonzes> tblKolcsonzes;

    @FXML
    private TableColumn<kolcsonzes,String > oKnev;

    @FXML
    private TableColumn<kolcsonzes, String> oKjogszam;

    @FXML
    private TableColumn<kolcsonzes, String> oKtipus;

    @FXML
    private TableColumn<kolcsonzes, String> oKrendszam;

    @FXML
    private TableColumn<kolcsonzes, String> oKberdij;

    @FXML
    private ComboBox<String> cbxKnev;

    @FXML
    private ComboBox<String> cbxKrendszam;

    @FXML
    private ComboBox<String> cbxKtipus;

    @FXML
    private TableView<kolcsonzes> tblvisszaadas;

    @FXML
    private TableColumn<kolcsonzes, String> oVtipus;

    @FXML
    private TableColumn<kolcsonzes, String> oVrendszam;

    @FXML
    private TableColumn<kolcsonzes, String> oVnev;

    @FXML
    private TableColumn<kolcsonzes, String> oVjogszam;

    @FXML
    private TableColumn<kolcsonzes, String> oVkolcskezdet;

    @FXML
    private TextField txtVnev;

    @FXML
    private TextField txtVtipus;

    @FXML
    private TextField txtVfizetett;
    
    @FXML
    private Label lblVdij;
    @FXML
    private TextField txtOtipus;

    @FXML
    private TextField txtOrendszam;

    @FXML
    private TextField txtOnev;

    @FXML
    private TextField txtOjogszam;

    @FXML
    private TextField txtOelvitt;

    @FXML
    private TextField txtOviszahozot;

    @FXML
    private TextField txtOfizetet;
    
     @FXML
    private TableView<osszes> tblOsszeg;

    @FXML
    private TableColumn<osszes, String> oOtipus;

    @FXML
    private TableColumn<osszes, String> oOrendszam;

    @FXML
    private TableColumn<osszes, String> oOnev;

    @FXML
    private TableColumn<osszes, String> oOjogszam;

    @FXML
    private TableColumn<osszes, String> oOelvitt;

    @FXML
    private TableColumn<osszes, String> oOviszahozot;

    @FXML
    private TableColumn<osszes, Integer> oOfizetett;

    

        @FXML
        void batAmodosit() {
         int index = tblAutok.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            panel.Panel.hiba("Hiba", "Nincs kiválasztva a módosítandó gépjármű!");
            return;
        }
        
        String tipus = txtAtipus.getText();
            if (tipus.isEmpty() || tipus.length() > 100) {
                panel.Panel.hiba("Hiba", "Add meg az autó tipusát, ami maximum 100 karakter lehet!");
                txtAtipus.requestFocus();
                return;
            }

            String szin = txtAszin.getText();
            if (szin.isEmpty() || szin.length() > 50) {
                panel.Panel.hiba("Hiba", "Add meg az autó szinét ami maximum 50 karakter lehet!!");
                txtAszin.requestFocus();
                return;
            }
            
            String jogtipus = txtAjogtipus.getText();
            if (jogtipus.length()< 1 || jogtipus.length() > 4) {
                panel.Panel.hiba("Hiba", "Add meg az autó vezető engedéjét 4 karakter lehet!!");
                txtAjogtipus.requestFocus();
                return;
            }

        
            String rendszam = txtArendszam.getText();
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
            
            
            Integer berdij;

            try {
                berdij = Integer.parseInt(txtAberdij.getText());
                if (berdij < 3000) {
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
        
        if (!panel.Panel.igennem("Mentés", "Mented a módisított adatokat")) {
            return;
        }
       

        int v = ab.autok_modosit(id, tipus, szin, jogtipus, rendszam, berdij);
         
             if (v > 0) {
            ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            //beolvas();
            for (int i = 0; i < tblAutok.getItems().size(); i++) {
                if (tblAutok.getItems().get(i).getId() == id) {
                    tblAutok.getSelectionModel().select(i);
                    break;
                }
            }
        } else {
            panel.Panel.hiba("hiba", "");
        }
        
        }

        @FXML
        void batAtorles() {
            int index = tblAutok.getSelectionModel().getSelectedIndex();
            if (index == -1) 
                return;
            if (!panel.Panel.igennem("Hiba", "Nincs kiválasztva a kivántsor!"))
            return;
            
            int id = tblAutok.getItems().get(index).getId();
            
            int sor = ab.autok_torles(id);
            if(sor >0){
                ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
                
            }
        }

        @FXML
        void betAment() {
        
            String tipus = txtAtipus.getText();
            if (tipus.isEmpty() || tipus.length() > 100) {
                panel.Panel.hiba("Hiba", "Add meg az autó tipusát, ami maximum 100 karakter lehet!");
                txtAtipus.requestFocus();
                return;
            }

            String szin = txtAszin.getText();
            if (szin.isEmpty() || szin.length() > 50) {
                panel.Panel.hiba("Hiba", "Add meg az autó szinét ami maximum 50 karakter lehet!!");
                txtAszin.requestFocus();
                return;
            }
            
            String jogtipus = txtAjogtipus.getText();
            if (jogtipus.length()<1 || jogtipus.length() > 4) {
                panel.Panel.hiba("Hiba", "Add meg az autó vezető engedéjét 4 karakter lehet!!");
                txtAjogtipus.requestFocus();
                return;
            }

        
            String rendszam = txtArendszam.getText();
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
            
            int berelve=0;
         

            Integer berdij;

            try {
                berdij = Integer.parseInt(txtAberdij.getText().trim());
                if (berdij < 3000) {
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
            
            int v = ab.autok_hozzad( tipus, szin, jogtipus,  rendszam, berelve, berdij);
            

            if (v > 0) {
                ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            } else {
                panel.Panel.hiba("Hiba", "autok hozzáad");
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
        txtBnev.requestFocus();
        txtBnev.clear();
        txtBcim.clear();
        txtBjogszam.clear();
        txtBjogtipus.clear();
        txtBtelszam.clear();
        }

        @FXML
        void betBment() {
            String nev =txtBnev.getText();
            if (nev.length() < 3 || nev.length() > 100) {
            panel.Panel.hiba("Hiba", "A név minimum 3 és maximum 100 karakter lehet!");
            txtBnev.requestFocus();
            return ;
        }
            String jogszam=txtBjogszam.getText();
             if (jogszam.length() != 8) {
            panel.Panel.hiba("Hiba", "A jogosatvány száma 8 karakter!");
            txtBjogszam.requestFocus();
            return ;
        }
             String telszam = txtBtelszam.getText();
              if (telszam.length() < 7 || telszam.length() > 25) {
            panel.Panel.hiba("Hiba", "Add meg a telefonszámot!");
            txtBtelszam.requestFocus();
            return ;
        }
              String cim = txtBcim.getText();
             if (cim.length() < 8 || cim.length() > 150) {
            panel.Panel.hiba("Hiba", "Add meg a pontos címet!");
            txtBcim.requestFocus();
            return ;
        }
             String jogtipus = txtBjogtipus.getText();
             if(jogtipus.length() < 1 || jogtipus.length() > 4){
                 panel.Panel.hiba("Hiba", "Add meg a kotegoriádat");
               txtBjogtipus.requestFocus();
               return;
             }
             
             
            if (!panel.Panel.igennem("Mentés", "Mented az új bérlő adataid?")) {
            return;
        }

        String v = ab.berlo_hozzad(nev, jogszam, jogtipus, telszam, cim);

        if (v.isEmpty()) {
            ab.berlokBe(tblBerlok.getItems(), cbxKnev.getItems());
            cbxKtipus.getSelectionModel().selectedIndexProperty().addListener(
                    (o, regi, uj) -> tipusRendszam(uj.intValue()));
        } else {
            panel.Panel.hiba("Hiba", v);
        }

    
        }

        @FXML
        void betBmodosit() {
               int index = tblBerlok.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            panel.Panel.hiba("Hiba", "Nincs kiválasztva a módosítandó ügyvél!");
            return;
        }
            String nev =txtBnev.getText();
            if (nev.length() < 3 || nev.length() > 100) {
            panel.Panel.hiba("Hiba", "A név minimum 3 és maximum 100 karakter lehet!");
            txtBnev.requestFocus();
            return ;
        }
            String jogszam=txtBjogszam.getText();
             if (jogszam.length() != 8) {
            panel.Panel.hiba("Hiba", "A jogosatvány száma 8 karakter!");
            txtBjogszam.requestFocus();
            return ;
        }
             String telszam = txtBtelszam.getText();
              if (telszam.length() < 7 || telszam.length() > 25) {
            panel.Panel.hiba("Hiba", "Add meg a telefonszámot!");
            txtBtelszam.requestFocus();
            return ;
        }
              String cim = txtBcim.getText();
             if (cim.length() < 8 || cim.length() > 150) {
            panel.Panel.hiba("Hiba", "Add meg a pontos címet!");
            txtBcim.requestFocus();
            return ;
        }
             String jogtipus = txtBjogtipus.getText();
             if(jogtipus.length() < 1 || jogtipus.length() > 4){
                 panel.Panel.hiba("Hiba", "Add meg a kotegoriádat");
               txtBjogtipus.requestFocus();
               return;
             }
             
            int id = tblBerlok.getItems().get(index).getId();

        if (!panel.Panel.igennem("Módosítás", "Biztosan módosítod a bérlő adataid?")) {
            return;
        }

        int v = ab.berlo_modosit(id, nev, jogszam, jogtipus, telszam, cim);

        if (v > 0) {
            ab.berlokBe(tblBerlok.getItems(),cbxKtipus.getItems());
            for (int i = 0; i < tblBerlok.getItems().size(); i++) {
                if (tblBerlok.getItems().get(i).getId() == id) {
                    tblBerlok.getSelectionModel().select(i);
                    break;
                }
            }
        } else {
            panel.Panel.hiba("Hiba","berlök modosit" );
        }  
             
             
        }

        @FXML
        void betBtorles() {
            int index = tblBerlok.getSelectionModel().getSelectedIndex();
            if (index == -1) 
                return;
            if (!panel.Panel.igennem("Hiba", "Nincs kiválasztva a kivántsor!"))
            return;
            
            int id = tblBerlok.getItems().get(index).getId();
            
            int sor = ab.berlo_torles(id);
            if(sor >0){
                ab.berlokBe(tblBerlok.getItems(),cbxKnev.getItems());
                
            }
        }
        
          @FXML
    void betKju() {
        cbxKnev.requestFocus();
        cbxKnev.setValue(null);
        cbxKjogszam.setText(null);
        cbxKrendszam.setValue(null);
        cbxKtipus.setValue(null);
      
    }

    @FXML
    void betKment() {
        if (cbxKnev.getValue() == null) {
            panel.Panel.hiba("Hiba", "Válaszd ki a bérlőt!");
            cbxKnev.requestFocus();
            return;
        }

        if (cbxKtipus.getValue() == null) {
            panel.Panel.hiba("Hiba", "Válaszd ki a kölcsönözendő autót!");
            cbxKtipus.requestFocus();
            return;
        }

        if (cbxKrendszam.getValue() == null) {
            panel.Panel.hiba("Hiba", "Válaszd ki a kölcsönözendő autó rendszámát!");
            cbxKrendszam.requestFocus();
            return;
        }

        int tipusID = get_tipusId(cbxKrendszam.getValue());
        int berloID = get_nevId(cbxKjogszam.getText());

        String datum = LocalDate.now().toString();

        if (!panel.Panel.igennem("Mentés", "Mented az új kölcsönzést?")) {
            return;
        }

        int v = ab.kolcsonzes_hozzad(tipusID, berloID, datum);
        
        if (v > 0) {
            ab.kolcsonzesekBe(tblKolcsonzes.getItems());
            ab.kolcsonzesekBe(tblvisszaadas.getItems());
            beolvas();
            ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            cbxKtipus.setValue(null);
            cbxKrendszam.setValue(null);
            cbxKtipus.getSelectionModel().selectedIndexProperty().addListener(
                    (o, regi, uj) -> tipusRendszam(uj.intValue()));

        } else {
            panel.Panel.hiba("Hiba", "");
        }
    }

     @FXML
    void betVment() {
 if (txtVnev.getText().isEmpty()) {
            panel.Panel.hiba("Hiba!", "Válaszd ki a visszahozottat");
            return;
        }
        int l = txtVnev.getText().length();
        int id = get_id(txtVnev.getText().substring(l - 8));

        Integer ar;

        if (txtVfizetett.getText().isEmpty()) {
            panel.Panel.hiba("Hiba", "Tölsd ki a fizetett bérleti díjat");
            txtVfizetett.requestFocus();
            return;
        } else {
            try {
                ar = Integer.parseInt(txtVfizetett.getText());
                if (ar < dij) {
                    panel.Panel.hiba("Hiba!", "A bérleti díj nem lehet kevesebb számítottnál!");
                    txtVfizetett.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                panel.Panel.hiba("Hiba!", "Az ár nem szám!");
                txtVfizetett.requestFocus();
                return;
            }
        }

        String datum = LocalDate.now().toString();

        if (!panel.Panel.igennem("Mentés", "A fizetés megtörtént,\na gépjárművel minden rendben van\nés biztosan menteni szeretnél!")) {
            return;
        }

        String v = ab.kolcsonzesVissza(id, datum, ar);

        if (v.isEmpty()) {
            ab.kolcsonzesekBe(tblvisszaadas.getItems());
            ab.kolcsonzesekBe(tblKolcsonzes.getItems());
            beolvas();
            ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            cbxKtipus.getSelectionModel().selectedIndexProperty().addListener(
                    (o, regi, uj) -> tipusRendszam(uj.intValue()));
            lblVdij.setText("Bérleti díj");
        } else {
            panel.Panel.hiba("Hiba", v);
        }

        txtVnev.clear();
        txtVtipus.clear();
        txtVfizetett.clear();
    }
    
    DB ab = new DB();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        oAberdij.setCellValueFactory(new PropertyValueFactory<>("berdij"));
        oArendszam.setCellValueFactory(new PropertyValueFactory<>("rendszam"));
        oAberelheto.setCellValueFactory(new PropertyValueFactory<>("berelve"));
        oAjogtipus.setCellValueFactory(new PropertyValueFactory<>("jogtipus"));
        oAszin.setCellValueFactory(new PropertyValueFactory<>("szin"));
        oAtipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));
       
        
        ab.autokBe(tblAutok.getItems(),cbxKtipus.getItems());
        
         tblAutok.getSelectionModel().selectedIndexProperty().addListener(
                (o, regi, uj) -> autokTablabol(uj.intValue()));
         
         
        oBnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oBcim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        oBtelefon.setCellValueFactory(new PropertyValueFactory<>("telefonszam"));
        oBjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oBjogtipus.setCellValueFactory(new PropertyValueFactory<>("jogtipus"));
         
         ab.berlokBe(tblBerlok.getItems(),cbxKnev.getItems());
         
         tblBerlok.getSelectionModel().selectedIndexProperty().addListener(
                 (o, regi, uj)-> berlokTablabol(uj.intValue()));
         
         
        oKtipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        oKrendszam.setCellValueFactory(new PropertyValueFactory<>("rendszam"));
        oKnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oKjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oKberdij.setCellValueFactory(new PropertyValueFactory<>("berdij"));
        
        ab.kolcsonzesekBe(tblKolcsonzes.getItems());
        
        cbxKnev.getSelectionModel().selectedIndexProperty().addListener(
                (o, regi, uj) -> berloJogsi(uj.intValue()));

        cbxKtipus.getSelectionModel().selectedIndexProperty().addListener(
                (o, regi, uj) -> tipusRendszam(uj.intValue()));
        
        oVtipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        oVrendszam.setCellValueFactory(new PropertyValueFactory<>("rendszam"));
        oVnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oVjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oVkolcskezdet.setCellValueFactory(new PropertyValueFactory<>("kezdete"));

        ab.kolcsonzesekBe(tblvisszaadas.getItems());
        
        tblvisszaadas.getSelectionModel().selectedIndexProperty().addListener(
                (o, regi, uj) -> visszaadasTablalbol(uj.intValue()));
        
        oOtipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        oOrendszam.setCellValueFactory(new PropertyValueFactory<>("rendszam"));
        oOnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oOjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oOelvitt.setCellValueFactory(new PropertyValueFactory<>("kezdete"));
        oOviszahozot.setCellValueFactory(new PropertyValueFactory<>("vege"));
        oOfizetett.setCellValueFactory(new PropertyValueFactory<>("fizetett"));

        beolvas();
        txtOtipus.textProperty().addListener(e -> beolvas());
        txtOrendszam.textProperty().addListener(e -> beolvas());
        txtOnev.textProperty().addListener(e -> beolvas());
        txtOjogszam.textProperty().addListener(e -> beolvas());
        txtOelvitt.textProperty().addListener(e -> beolvas());
        txtOviszahozot.textProperty().addListener(e -> beolvas());
        txtOfizetet.textProperty().addListener(e -> beolvas());
    }    
    
    private void autokTablabol(int i) {
        if (i == -1) {
            return;
        }
        auto a = tblAutok.getItems().get(i);
        txtAtipus.setText(a.getTipus());
        txtArendszam.setText(a.getRendszam());
        txtAszin.setText(a.getSzin());
        txtAjogtipus.setText("" + a.getJogtipus());
        txtAberdij.setText("" + a.getBerdij());
    }
    
    private void berlokTablabol(int i) {
        if (i == -1) {
            return;
        }
        berlok b = tblBerlok.getItems().get(i);
        txtBcim.setText(b.getCim());
        txtBjogszam.setText(b.getJogositvanyszam());
        txtBjogtipus.setText(b.getJogtipus());
        txtBnev.setText(b.getNev());
        txtBtelszam.setText(b.getTelefonszam());
    }
    long dij;
    private void visszaadasTablalbol(int i) {
        if (i == -1) {
            return;
        }

        kolcsonzes k = tblvisszaadas.getItems().get(i);
        txtVnev.setText(k.getNev() + " / " + k.getJogositvanyszam());
        txtVtipus.setText(k.getTipus() + " / " + k.getRendszam());

        LocalDate mettol = LocalDate.parse(k.getKezdete());
        LocalDate meddig = LocalDate.now();
        long napok = ChronoUnit.DAYS.between(mettol, meddig) + 1;
        dij = napok * k.getBerdij();
        lblVdij.setText("A(z) " + napok + " napos bérelt alapján a bérleti díj: " + dij + " Ft");
        txtVfizetett.setText(dij + "");
    }
    
    private void tipusRendszam(int i) {
        if (i == -1) {
            return;
        }
        cbxKrendszam.getItems().clear();
        for (int j = 0; j < tblAutok.getItems().size(); j++) {
            auto a = tblAutok.getItems().get(j);
            if (cbxKtipus.getValue().equals(a.getTipus())) {
                cbxKrendszam.getItems().add(a.getRendszam());
            }
        }

    }
    
     private void berloJogsi(int i) {
        if (i == -1) {
            return;
        }
        cbxKjogszam.setText(tblBerlok.getItems().get(i).getJogositvanyszam());
    }

    private int get_tipusId(String rendszam) {
        int i = 0;

        while (!tblAutok.getItems().get(i).getRendszam().equals(rendszam)) {
            i++;
        }
        return tblAutok.getItems().get(i).getId();
    }

    
    private int get_nevId(String jogositvanyszam) {
        int i = 0;

        while (!tblBerlok.getItems().get(i).getJogositvanyszam().equals(jogositvanyszam)) {
            i++;
        }

        return tblBerlok.getItems().get(i).getId();

    }
  
     private int get_id(String jogositvanyszam) {
        int i = 0;

        while (!tblvisszaadas.getItems().get(i).getJogositvanyszam().equals(jogositvanyszam)) {
            i++;
        }

        return tblvisszaadas.getItems().get(i).getId();
    }
      private void beolvas() {
        String sz1 = "'%" + txtOtipus.getText() + "%' ";
        String sz2 = "'%" + txtOrendszam.getText() + "%' ";
        String sz3 = "'%" + txtOnev.getText() + "%' ";
        String sz4 = "'%" + txtOjogszam.getText() + "%' ";
        String sz5 = "'%" + txtOelvitt.getText() + "%' ";
        String sz6 = "'%" + txtOviszahozot.getText() + "%' ";
        String sz7 = "'%" + txtOfizetet.getText() + "%' ";
        
        String s = "SELECT kolcsonzesek.id, autok.tipus, autok.rendszam, berlok.nev, "
                + "berlok.jogositvanyszam, kolcsonzesek.kezdete, kolcsonzesek.vege, "
                + "kolcsonzesek.fizetett FROM kolcsonzesek "
                + "JOIN autok ON kolcsonzesek.autoid=autok.id "
                + "JOIN berlok ON kolcsonzesek.berloid=berlok.id "
                + "WHERE autok.tipus LIKE " + sz1
                + "AND autok.rendszam LIKE " + sz2
                + "AND berlok.nev LIKE " + sz3
                + "AND berlok.jogositvanyszam LIKE " + sz4
                + "AND kolcsonzesek.kezdete LIKE " + sz5;
        
        if (!txtOviszahozot.getText().isEmpty() || !txtOfizetet.getText().isEmpty()) {
            s += "AND kolcsonzesek.vege LIKE " + sz6
                    + "AND kolcsonzesek.fizetett LIKE " + sz7;
        }

        s += "ORDER BY autok.tipus, berlok.nev, kolcsonzesek.kezdete DESC;";

        ab.osszesBe(tblOsszeg.getItems(), s);
    }
}
