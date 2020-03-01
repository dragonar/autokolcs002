/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcs002;



import java.sql.Connection;
import java.sql.DriverManager;
import javafx.collections.ObservableList;

/**
 *
 * @author fuged
 */
public class DB {
    private final String db = "jdbc:mysql://localhost:3306/autokolcs002"
            + "?useUnicode=true&characterEncoding=UTF-8";
    private final String user = " ";
    private final String pass = " ";
    
    public void autokBe(ObservableList<auto> tabla, ObservableList<String> lista) {}
    
    String s = "SELECT * FROM autok ORDER BY tipus;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
            lista.clear();

            while (eredmeny.next()) {
                tabla.add(new auto(
                        eredmeny.getInt("id"),
                        eredmeny.getString("tipus"),
                        eredmeny.getString("szin"),
                        eredmeny.getString("jogtipus"),
                        eredmeny.getString("rendszam"),
                        eredmeny.getInt("berdij"))
                );
                if (eredmeny.getInt("berelve") == 0) {
                    lista.add((eredmeny.getString("tipus")));

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            hiba("hiba", ex.getMessage());
        }

    }
    
    
    

