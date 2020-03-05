/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
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
    private MenuButton cbxKnev;

    @FXML
    private MenuButton cbxKtipus;

    @FXML
    private MenuButton cbxKrendszam;

    
    

        @FXML
        void batAmodosit() {
         
        }

        @FXML
        void batAtorles() {

        }

        @FXML
        void betAment() {
        
    
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
        
          @FXML
    void betKju() {

    }

    @FXML
    void betKment() {

    }

    
    DB ab = new DB();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        oAberdij.setCellValueFactory(new PropertyValueFactory<>(""));
        oArendszam.setCellValueFactory(new PropertyValueFactory<>("nev"));
       
        
        ab.autokBe(tblAutok.getItems());
        
         tblAutok.getSelectionModel().selectedIndexProperty().addListener(
                (o, regi, uj) -> autokTablabol(uj.intValue()));
         
         
        oBnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        oBcim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        oBtelefon.setCellValueFactory(new PropertyValueFactory<>("telefonszam"));
        oBjogszam.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        oBjogtipus.setCellValueFactory(new PropertyValueFactory<>("jogtipus"));
         
         ab.berlokBe(tblBerlok.getItems());
         
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
     
}
