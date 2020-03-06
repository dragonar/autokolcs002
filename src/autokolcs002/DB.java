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

/**
 *
 * @author fuged
 */
public class DB {
    private final String db = "jdbc:mysql://localhost:3306/autokolcsonzo"
            + "?useUnicode=true&characterEncoding=UTF-8";
    private final String user = "root";
    private final String pass = "";
    
    
    
    public void autokBe(ObservableList<auto> tabla, ObservableList<String> lista) {
    
    String s = "SELECT * FROM autok ;";

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
                        eredmeny.getInt("berelve"),
                        eredmeny.getInt("berdij"))
                );
                if (eredmeny.getInt("berelve") == 0) {
                    lista.add((eredmeny.getString("tipus")));

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            panel.Panel.hiba("hiba", ex.getMessage());
        }
    }
        public void berlokBe(ObservableList<berlok> tabla, ObservableList<String> lista) {
    
    String s = "SELECT * FROM berlok ORDER BY nev;";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ResultSet eredmeny = ekp.executeQuery();
            tabla.clear();
            lista.clear();

            while (eredmeny.next()) {
                tabla.add(new berlok(
                        eredmeny.getInt("id"),
                        eredmeny.getString("nev"),
                        eredmeny.getString("jogositvanyszam"),
                        eredmeny.getString("telefonszam"),
                        eredmeny.getString("cim"),
                        eredmeny.getString("jogtipus"))
                );
                    lista.add(eredmeny.getString("nev"));  
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
         
            public int autok_hozzad(String tipus, String szin, String jogtipus, String rendszam,int berelve, int berdij) {
        String s = "INSERT INTO autok (tipus, szin, jogtipus, rendszam,berelve, berdij) VALUES (?,?,?,?,?,?);";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, tipus);
            ekp.setString(2, szin);
            ekp.setString(3, jogtipus);
            ekp.setString(4, rendszam);
            ekp.setInt(5, berelve);
            ekp.setInt(6, berdij);

            return ekp.executeUpdate();
          
                } catch (SQLException ex) {
                  panel.Panel.hiba("Hiba", ex.getMessage());
                    return 0;
                }
        }
            
            
          public String berlo_hozzad(String nev, String jogositvanyszam,String jogtipus, String telefonszam, String cim) {
        String s = "INSERT INTO berlok (nev, jogositvanyszam, jogtipus, telefonszam, cim) VALUES (?,?,?,?,?);";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, nev);
            ekp.setString(2, jogositvanyszam);
            ekp.setString(3, jogtipus);
            ekp.setString(4, telefonszam);
            ekp.setString(5, cim);
            ekp.executeUpdate();
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
          
        public int kolcsonzes_hozzad(Integer autoid, Integer berloid, String kezdet) {
            String s = "INSERT INTO kolcsonzesek (autoid, berloid, kezdete) "
                    + "VALUES (?,?,?);";
            String v = "UPDATE autok SET berelve=1 WHERE id=?;";

            try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                    PreparedStatement ekp = kapcs.prepareStatement(s);
                    PreparedStatement ekp2 = kapcs.prepareStatement(v)) {
                ekp.setInt(1, autoid);
                ekp.setInt(2, berloid);
                ekp.setString(3, kezdet);
                ekp.executeUpdate();
                ekp2.setInt(1, autoid);
                return ekp2.executeUpdate();
                
            } catch (SQLException ex) {
               panel.Panel.hiba("Hiba",ex.getMessage());
               return 0;
            }
        }
     
           public int autok_modosit(int id, String tipus, String szin, String jogtipus,
                   String rendszam, int berdij) {
        String s = "UPDATE autok SET (tipus=?, szin=?, jogtipus=?, rendszam=? , berdij=? "
                + " WHERE id=?";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, tipus);
            ekp.setString(2, szin);
            ekp.setString(3, jogtipus);
            ekp.setString(4, rendszam);
            ekp.setInt(5,berdij );
            ekp.setInt(6, id);
            return ekp.executeUpdate();
            
        } catch (SQLException ex) {
            panel.Panel.hiba("Hiba", ex.getMessage());
            return 0;
        }
    }
          
          public int berlo_modosit(int id, String nev, String jogositvanyszam, String jogtipus, String telefonszam, String cim) {
        String s = "UPDATE berlok SET nev=?, jogositvanyszam=?, jogtipus=?, telefonszam=?, "
                + "cim=? WHERE id=?";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, nev);
            ekp.setString(2, jogositvanyszam);
            ekp.setString(3, jogtipus);
            ekp.setString(4, telefonszam);
            ekp.setString(5, cim);
            ekp.setInt(6, id);
            return ekp.executeUpdate();
            
        } catch (SQLException ex) {
            panel.Panel.hiba("Hiba", ex.getMessage());
            return 0;
        }
    }
          
           public int autok_torles(int id){
               String s = "DELETE FROM autok WHERE id=?";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
                    ekp.setInt(1, id);
                    return ekp.executeUpdate();
                }catch (SQLException ex) {
                    panel.Panel.hiba("Hiba", ex.getMessage());
                    return 0;
                }
          }
          
        public int berlo_torles(int id){
               String s = "DELETE FROM berlok WHERE id=?";

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
                    ekp.setInt(1, id);
                    return ekp.executeUpdate();
                }catch (SQLException ex) {
                    panel.Panel.hiba("Hiba", ex.getMessage());
                    return 0;
                }
          }
}