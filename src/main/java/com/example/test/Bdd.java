package com.example.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Bdd extends AccueilTache
{

    private User userConnected;

    public User getUserConnected()
    {
        return this.userConnected;
    }


    public static Connection  Connection() throws SQLException
    {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/szi_taches", "root", "php");
        return conn;
    }
    public boolean connexionUtilisateur(String mail, String password) throws SQLException
    {

        Connection conn = Bdd.Connection();
        String query = "SELECT * FROM user WHERE mail = ? AND mdp = ?";
        PreparedStatement connexion = conn.prepareStatement(query);
        connexion.setString(1, mail);
        connexion.setString(2, password);
        ResultSet rs = connexion.executeQuery();
        if (rs.next())
        {

            String mdpVerif = rs.getString("mdp");
            String mdpDuMec = password;
            if (Objects.equals(mdpVerif, mdpDuMec))
            {
                String id = rs.getString("identifiant");
                String email = rs.getString("mail");
                String mdp = rs.getString("mdp");
                User sessionStart = new User(id,email,mdp);
                this.userConnected = sessionStart;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    public static boolean ajoutUtilisateur(User utilisateur) throws SQLException
    {
        Connection conn = Bdd.Connection();
        String query = "SELECT * FROM user WHERE mail = ?";
        PreparedStatement ajout = conn.prepareStatement(query);
        ajout.setString(1, utilisateur.getMail());
        ResultSet rs = ajout.executeQuery();
        if (rs.next())
        {
            System.out.println("Cette personne est déjà enregistrée.");
            return false;
        }
        else
        {
            String insertQuery = "INSERT INTO user (identifiant, mail, mdp) VALUES (?, ?, ?)";
            PreparedStatement insertMec = conn.prepareStatement(insertQuery);
            insertMec.setString(1, utilisateur.getIdentifiant());
            insertMec.setString(2, utilisateur.getMail());
            insertMec.setString(3, utilisateur.getMdp());
            insertMec.executeUpdate();
            System.out.println("La personne a bien été ajoutée !");
            return true;
        }
    }
    public static void suppUtilisateur(String mail) throws SQLException
    {
        Connection conn = Bdd.Connection();
        String delete = "DELETE FROM Utilisateur WHERE mail = ?";
        PreparedStatement supp = conn.prepareStatement(delete);
        supp.setString(1, mail);
        supp.executeUpdate();
        System.out.println("Vous avez disparu à tout jamais !");
    }
    public static void ajoutTache(Taches laTache, String mail) throws SQLException
    {

        Connection conn = Bdd.Connection();
        String query = "SELECT id_user FROM user WHERE mail = ?";
        PreparedStatement veuxId = conn.prepareStatement(query);
        veuxId.setString(1, mail);
        ResultSet rs = veuxId.executeQuery();
        int ref = 0;
        if (rs.next())
        {
            // Aide GPT
            ref = rs.getInt("id_user");
        }


        String insertQuery = "INSERT INTO taches (nom, description, importance,ref_utilisateur) VALUES (?, ?, ?,?)";
        PreparedStatement insertTache = conn.prepareStatement(insertQuery);
        insertTache.setString(1, laTache.getNom());
        insertTache.setString(2, laTache.getDescription());
        insertTache.setString(3, laTache.getImportance());
        insertTache.setInt(4, ref);
        insertTache.executeUpdate();
        System.out.println("Tahce ajoutée avec succes !");
    }


}