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
import javafx.scene.control.ComboBox;
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
            /*if (szin.length()> 1 || szin.length() < 4) {
                panel.Panel.hiba("Hiba", "Add meg az autó vezető engedéjét 4 karakter lehet!!");
                txtAjogtipus.requestFocus();
                return;
            }*/

        
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
            
            String jogtipus = txtAjogtipus.getText().trim();
            if (szin.length()>1 || szin.length() < 4) {
                panel.Panel.hiba("Hiba", "Add meg az autó vezető engedéjét 4 karakter lehet!!");
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
            
            int v = ab.autok_hozzad( tipus, szin, jogtipus,  rendszam, berdij);
            

            if (v > 0) {
                ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            } else {
                panel.Panel.hiba("Hiba", "");
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
            panel.Panel.hiba("Hiba","" );
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
       // cbxKjogositvanyszam.setText(null);
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

      /*  int tipusID = get_tipusId(cbxKrendszam.getValue());
        int berloID = get_nevId(cbxKjogositvanyszam.getText());
*/
        String datum = LocalDate.now().toString();

        if (!panel.Panel.igennem("Mentés", "Mented az új kölcsönzést?")) {
            return;
        }

        //int v = ab.kolcsonzes_hozzad(tipusID, berloID, datum);
        int v = ab.kolcsonzes_hozzad(Integer.BYTES, Integer.BYTES, datum);
        if (v > 0) {
            ab.kolcsonzesekBe(tblKolcsonzes.getItems());
            ab.kolcsonzesekBe(tblvisszaadas.getItems());
            //beolvas();
            ab.autokBe(tblAutok.getItems(), cbxKtipus.getItems());
            cbxKtipus.setValue(null);
            cbxKrendszam.setValue(null);
            cbxKtipus.getSelectionModel().selectedIndexProperty().addListener(
                    (o, regi, uj) -> tipusRendszam(uj.intValue()));

        } else {
            panel.Panel.hiba("Hiba", "");
        }
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
         
         ab.kolcsonzesekBe(tblKolcsonzes.getItems());
        
        oKtipus.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        oKrendszam.setCellValueFactory(new PropertyValueFactory<>("rendszam"));
        oKnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oKjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oKberdij.setCellValueFactory(new PropertyValueFactory<>("berdij"));
        
        
        
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

  
}
