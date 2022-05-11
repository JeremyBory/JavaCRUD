/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.control;

import javacrud.gestUtil.Utilisateur;
import javacrud.gestUtil.Commune;
import java.util.HashMap;

/**
 *
 * @author j.bory
 */
public interface VilleDAO {
    public HashMap<Integer, Commune> ville(String codePostal);
}
