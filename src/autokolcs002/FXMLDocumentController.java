/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
        void batAmodosit(ActionEvent event) {

        }

        @FXML
        void batAtorles(ActionEvent event) {

        }

        @FXML
        void betAment(ActionEvent event) {

        }

        @FXML
        void betAuj(ActionEvent event) {

        }

        @FXML
        void betBju(ActionEvent event) {

        }

        @FXML
        void betBment(ActionEvent event) {

        }

        @FXML
        void betBmodosit(ActionEvent event) {

        }

        @FXML
        void betBtorles(ActionEvent event) {

        }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
