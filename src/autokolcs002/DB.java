/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

/**
 *
 * @author fuged
 */
public class DB {
    private final String db = "jdbc:mysql://localhost:3306/autokolcsonzo"
            + "?useUnicode=true&characterEncoding=UTF-8";
    private final String user = "root";
    private final String pass = "";
    
    
    
    public void autokBe(ObservableList<auto> tabla/*, ObservableList<String> lista*/) {
    
    String s = "SELECT * FROM autok ;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
           // lista.clear();

            while (eredmeny.next()) {
                tabla.add(new auto(
                        eredmeny.getInt("id"),
                        eredmeny.getString("tipus"),
                        eredmeny.getString("szin"),
                        eredmeny.getString("jogtipus"),
                        eredmeny.getString("rendszam"),
                        eredmeny.getInt("berdij"))
                );
               /* if (eredmeny.getInt("berelve") == 0) {
                    lista.add((eredmeny.getString("tipus")));

                }*/
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            panel.Panel.hiba("hiba", ex.getMessage());
        }
    }
        public void berlokBe(ObservableList<berlok> tabla/*, ObservableList<String> lista*/) {
    
    String s = "SELECT * FROM berlok ORDER BY nev;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
           // lista.clear();

            while (eredmeny.next()) {
                tabla.add(new berlok(
                        eredmeny.getInt("id"),
                        eredmeny.getString("nev"),
                        eredmeny.getString("jogositvanyszam"),
                        eredmeny.getString("telefonszam"),
                        eredmeny.getString("cim"),
                        eredmeny.getString("jogtipus"))
                );
               
                 //   lista.add((eredmeny.getString("nev")));

                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        }
         public void kolcsonzesekBe(ObservableList<kolcsonzes> tabla) {
        String s = "SELECT* FROM kolcsonzesek "
                + "JOIN autok ON kolcsonzesek.autoid=autok.id JOIN berlok ON kolcsonzesek.berloid=berlok.id WHERE kolcsonzesek.vege IS NULL;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();

            while (eredmeny.next()) {
                tabla.add(new kolcsonzes(
                        eredmeny.getInt("id"),
                        eredmeny.getString("tipus"),
                        eredmeny.getString("rendszam"),
                        eredmeny.getString("nev"),
                        eredmeny.getString("jogositvanyszam"),
                        eredmeny.getString("kezdete"),
                        eredmeny.getInt("berdij")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}