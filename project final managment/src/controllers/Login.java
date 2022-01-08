package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private JFXToggleButton chooseToggle;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXTextField passwordTextField;

    @FXML
    private JFXButton loginButton;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../pages/managment/managementPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("./pages/css/homePageStyle.css");
        primaryStage.setTitle("managment");
        primaryStage.setScene(scene);
        primaryStage.setX(450);
        primaryStage.setY(110);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    void toggleAction(ActionEvent event) {

    }

}