package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AjoutTache
{
    private Scene scene;
    @FXML
    private TextField nomTache;
    @FXML
    private TextField Description;
    @FXML
    private RadioButton faible;
    @FXML
    private RadioButton eleve;



    public void versAccueil(ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("accueil_tache.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deconnexion(ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ajoutTache(ActionEvent event) throws IOException, SQLException {
        String importance;
        if (faible.isSelected())
        {
            importance = "Faible";



        }
        else
        {
            importance = "Elevé";

        }
        Taches laTache = new Taches(nomTache.getText(),Description.getText(),importance);
        Bdd.ajoutTache(laTache,HelloController.getUserConnectedSession().getMail());

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
