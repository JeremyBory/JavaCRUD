/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.tech;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author j.bory
 */
public class UtilDB {

    static Connection con;
    //static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/gestion_utilisateur";
    static String user = "root";
    static String pass = "";

    public static Connection getConnect() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        return con;

    }

    public void closeConnect() throws Exception {
        con.close();
    }
}
