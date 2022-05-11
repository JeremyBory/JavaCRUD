/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.gestUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author j.bory
 */
public class Commune {

    private String Code_Postal, Num_Postal, Nom_Commune;

    public Commune(String Code_Postal, String Num_Postal, String Nom_Commune) {
        this.Code_Postal = Code_Postal;
        this.Num_Postal = Num_Postal;
        this.Nom_Commune = Nom_Commune;
    }

    public Commune() {

    }

    public String getCode_Postal() {
        return Code_Postal;
    }

    public void setCode_Postal(String Code_Postal) {
        this.Code_Postal = Code_Postal;
    }

    public String getNum_Postal() {
        return Num_Postal;
    }

    public void setNum_Postal(String Num_Postal) {
        this.Num_Postal = Num_Postal;
    }

    public String getNom_Commune() {
        return Nom_Commune;
    }

    public void setNom_Commune(String Nom_Commune) {
        this.Nom_Commune = Nom_Commune;
    }

    @Override
    public String toString() {
        return "Commune{" + "Code_Postal=" + Code_Postal + ", Num_Postal=" + Num_Postal + ", Nom_Commune=" + Nom_Commune + '}';
    }

    public static void Commune() {
        Connection con;
        String url = "jdbc:mysql://localhost:3306/gestion_utilisateur";
        String user = "mysql";
        String pass = "azerty";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

            String rqSql = "SELECT * FROM codes_postaux";
            PreparedStatement ps = con.prepareStatement(rqSql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.print(result.getString("Code_Postal") + " "
                        + result.getString("Nom_Commune") + " " + result.getString("Num_Postal") + "\n");
            }

        } catch (Exception e) {/* … */
        }

    }

}
