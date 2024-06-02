package com.example.test;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class User extends Bdd{
    private String identifiant;
    private String mail;
    private String mdp;

    public User(String id, String m,String mdp)
    {

        this.identifiant=id;
        this.mail = m;
        this.mdp = mdp;
    }

    public String getIdentifiant()
    {
        return identifiant;
    }

    public String getMail()
    {
        return mail;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setIdentifiant(String identifiant)
    {
        this.identifiant = identifiant;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }



    @Override
    public String toString()
    {
        return "User{" + "identifiant='" + identifiant + '\'' + ", mail='" + mail + '\'' + ", mdp='" + mdp + '\'' + '}';
    }
}
