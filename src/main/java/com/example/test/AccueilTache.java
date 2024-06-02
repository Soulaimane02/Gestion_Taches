package com.example.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AccueilTache extends HelloController implements Initializable
{
    private Scene scene;
    @FXML
    private Label labelSessionStart;




    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        String idUser = HelloController.getUserConnectedSession().getIdentifiant();
        labelSessionStart.setText("Bonjour : " + idUser );
    }
    public void versAjoutTache(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ajoutTache.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void seDeco(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void suppTache(ActionEvent event) throws IOException, SQLException
    {
        Parent root = FXMLLoader.load(getClass().getResource("accueil_tache.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void finProjet(ActionEvent event) throws IOException, SQLException
    {

        Parent root = FXMLLoader.load(getClass().getResource("fin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void disparaitre(ActionEvent event) throws IOException, SQLException
    {
        Bdd.suppUtilisateur(mailConnexion.getText());
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }







}
