package com.example.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Inscription {
    private Scene scene;
    @FXML
    private TextField identifiant;
    @FXML
    private TextField mail;
    @FXML
    private TextField mdp;
    public void changerScene2(ActionEvent event) throws IOException, SQLException
    {
        User ajout = new User(identifiant.getText(),mail.getText(),mdp.getText());
        Bdd.ajoutUtilisateur(ajout);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void retourArriere(ActionEvent event) throws IOException, SQLException
    {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
