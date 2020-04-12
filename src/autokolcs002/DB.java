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
 *kapcsolódások az adatbázishoz
 * @author fuged Marcell
 */
public class DB {
    private final String db = "jdbc:mysql://localhost:3306/autokolcsonzo"
            + "?useUnicode=true&characterEncoding=UTF-8";
    private final String user = "root";
    private final String pass = "";
    
    /**
 * Autók lekérdezése
 * @param tabla autók minden adatával van feltöltve
 * @param lista az autók tipusát tartalmazza, ha nincs bérelve
 */
    public void autokBe(ObservableList<auto> tabla, ObservableList<String> lista) {
     /**
     * SQL lekérdezés
     */
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
        Panel.hiba("hiba", ex.getMessage());
    }
}

    /**
 * Bérlők lekérdezése és listába töltése
 *
 * @param tabla a bérlők minden adatával van feltöltve
 * @param lista a bérlők neveit tartalmazza
 */
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

    /**
* A folyamatban lévő kölcsönzések lekérdezése és táblába töltése
* @param tabla A kölcsönzések minden adatával van feltöltve
*/
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

    /**
 * adatbázisban az autok táblában új rekor hozzáadása
 * input adatok:
 * @param tipus autó tipusa
 * @param szin autó szine
 * @param jogtipus autó vezetési engedéj tipusa
 * @param rendszam autó rendszáma
 * @param berdij autó napi bérleti díja
 * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
 */
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
              Panel.hiba("Hiba", ex.getMessage());
                return 0;
            }
    }

    /**
 * Adatbázisban a bérlők táblához új rekord hozzáadása az azonosító automatikus kerül megadásra
 * inputok:
 * @param nev bérlő neve
 * @param jogositvanyszam bérlő jogosítvány száma
 * @param telefonszam bérlő telefonszáma
 * @param jogtipus berlő jogtipus
 * @param cim bérlő címe /irányítószám, város, utca házszám
 * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
 */
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

    /**
        * A kölcsönzések rögzítése
        * inputok:
        * @param autoid a bérlendő autó azonoítója
        * @param berloid a bérlő autó azonosítója
        * @param kezdet a bérlet kezdetének dátuma
        * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
        */
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
           Panel.hiba("Hiba",ex.getMessage());
           return 0;
        }
    }

    /**
  * Adatbázisba a meglévő autók adatainak módosítása
  * @param id
  * @param tipus
  * @param szin
  * @param jogtipus
  * @param rendszam
  * @param berdij
  * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
  */
    public int autok_modosit(int id, String tipus, String szin, String jogtipus, String rendszam, int berdij) {
    String s = "UPDATE autok SET tipus=?, szin=?, jogtipus=?, rendszam=? ,   berdij=?  "
            + " WHERE id=?";

    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s)) {
        ekp.setString(1, tipus);
        ekp.setString(2, szin);
        ekp.setString(3, jogtipus);
        ekp.setString(4, rendszam);
        ekp.setInt(5,berdij );
        ekp.setInt(6, id);
        System.out.println(ekp);
        return ekp.executeUpdate();


    } catch (SQLException ex) {
        Panel.hiba("Hiba", ex.getMessage());
        return 0;
    }
}

    /**
 * Adatbázisba a meglévő bérlő adatainak módosítása
 * inputok:
 * @param id azonosító
 * @param nev bérlő neve
 * @param jogositvanyszam
 * @param jogtipus
 * @param telefonszam
 * @param cim
 * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
 */
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
        Panel.hiba("Hiba", ex.getMessage());
        return 0;
    }
}

    /**
       * Adatbázisba a meglévő autok adatainak törllése
       * @param id
       * @return ikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
       */
    public int autok_torles(int id){
           String s = "DELETE FROM autok WHERE id=?";

    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s)) {
                ekp.setInt(1, id);
                return ekp.executeUpdate();
            }catch (SQLException ex) {
                Panel.hiba("Hiba", ex.getMessage());
                return 0;
            }
      }

    /**
       * Adatbázisba a meglévő bérlő adatainak törlése
       * @param id
       * @return ikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
       */
    public int berlo_torles(int id){
           String s = "DELETE FROM berlok WHERE id=?";

    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s)) {
                ekp.setInt(1, id);
                return ekp.executeUpdate();
            }catch (SQLException ex) {
                Panel.hiba("Hiba", ex.getMessage());
                return 0;
            }
      }

    /**
 * A folyamatban lévő kölcsönzések lezárására, rögzíti az inputokat
 * inputok:
 * @param id kölcsönzés azonosítója
 * @param datum visszaadás dátuma
 * @param fizetett a bérleti díj amit fizetett az ügyfél
 * @return sikeres rögzítés esetén nem ad vissza értéket hiba esetén a hibaüzenettel tér vissza
 */
     public String kolcsonzesVissza(Integer id, String datum, Integer fizetett) {
    String s = "UPDATE kolcsonzesek SET vege=?, fizetett=?"
            + " WHERE kolcsonzesek.id=?";

    String v = "UPDATE autok JOIN kolcsonzesek ON autok.id=kolcsonzesek.autoid SET berelve=0 WHERE kolcsonzesek.id=?;";

    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s);
            PreparedStatement ekp2 = kapcs.prepareStatement(v)) {
        ekp.setString(1, datum);
        ekp.setInt(2, fizetett);
        ekp.setInt(3, id);
        ekp.executeUpdate();
        ekp2.setInt(1, id);
        ekp2.executeUpdate();
        return "";
    } catch (SQLException ex) {
        return ex.getMessage();
    }
}

    /**
 * Összesítés
 * @param tabla az összes ügylet adataival van feltöltve
 * @param s SQL lekérdező parancs
 */
    public void osszesBe(ObservableList<osszes> tabla, String s) {

    try (Connection kapcs = DriverManager.getConnection(db, user, pass);
            PreparedStatement ekp = kapcs.prepareStatement(s)) {
        ResultSet eredmeny = ekp.executeQuery();
        tabla.clear();

        while (eredmeny.next()) {
            tabla.add(new osszes(
                    eredmeny.getInt("id"),
                    eredmeny.getString("tipus"),
                    eredmeny.getString("rendszam"),
                    eredmeny.getString("nev"),
                    eredmeny.getString("jogositvanyszam"),
                    eredmeny.getString("kezdete"),
                    eredmeny.getString("vege"),
                    eredmeny.getInt("fizetett")
            ));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
}