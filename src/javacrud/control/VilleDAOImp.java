/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.control;

import javacrud.tech.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javacrud.gestUtil.Commune;

/**
 *
 * @author j.bory
 */
public class VilleDAOImp implements VilleDAO { //W! créez VilleDAOImp

    public VilleDAOImp() {

    }

    public HashMap<Integer, Commune> ville(Integer codePostal) {
        HashMap<Integer, Commune> listVille = new HashMap<>();
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM `codes_postaux` WHERE `Code_Postal` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codePostal.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commune uneVille = new Commune(rs.getString("Code_Postal"),
                        rs.getString("Num_Postal"),
                        rs.getString("Nom_Commune"));
                listVille.put(rs.getInt("Num_Postal"), uneVille);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : La liste des villes n'a pa pu s'afficher");
        }
        return listVille;
    }

    @Override
    public HashMap<Integer, Commune> ville(String codePostal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
