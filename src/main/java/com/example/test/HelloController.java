package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.stage.Stage;

public class HelloController
{
    private static User userConnected;
    private Scene scene;
    String userEmail;

    @FXML
    protected  TextField mailConnexion;
    @FXML
    private TextField mdpConnexion;

    public static User getUserConnectedSession(){
        return HelloController.userConnected;
    }

    public void changerScene1(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void versAccueil(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("accueil_tache.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void test(ActionEvent event) throws IOException, SQLException
    {
        Bdd bdd = new Bdd();
        boolean res = bdd.connexionUtilisateur(mailConnexion.getText(), mdpConnexion.getText());
        HelloController.userConnected = bdd.getUserConnected();
        if (res == true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("accueil_tache.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            System.out.println("Mot de passe ou identifiant incorrect ! ");
        }
    }



}