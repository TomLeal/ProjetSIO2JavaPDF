package com.karimandco.pdf;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author t.leal
 */
public class Connexion {

    public Connection connexion;

    public Connexion() {
        connexion = null;
    }

    public void connexionBDD(String adresse, String port, String nomBDD, String mdpBDD, String utilisateurBDD) {
        if (this.connexion == null) {
            try {
                String ChaineConnexion = "jdbc:mysql://" + adresse;
                if (!port.equals("")) {
                    ChaineConnexion += ":" + port;
                }
                ChaineConnexion += "/" + nomBDD;

                this.connexion = (Connection) DriverManager.getConnection(ChaineConnexion, utilisateurBDD, mdpBDD);
            } catch (SQLException ex) {
                System.out.println("Erreur");
            }
        } else {
            System.out.println("Erreur");
            this.connexion = null;
        }
    }

    public String selectUtilisateur(Integer id) {
        String nom = "";
        if (this.connexion != null) {
            try {
                Statement maRequete = this.connexion.createStatement();
                ResultSet lesTuples = maRequete.executeQuery("select * from utilisateurs where id=" + id);
                if (lesTuples.next()) { 	// (c)
                    nom = lesTuples.getString("nom");
                } else {
                    System.out.println("Erreur");
                }
            } catch (SQLException ex) {
                System.out.println("Erreur");
            }
        }
        return nom;
    }
}
