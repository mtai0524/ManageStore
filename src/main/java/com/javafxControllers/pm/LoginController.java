package com.javafxControllers.pm;

import com.views.pm.EnviromentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private Button btnSignin;
    @FXML private Stage stage;
    @FXML private Label lbChangePass;
    @FXML private Hyperlink hplChangePass;
    public void switchSceneHomePage(ActionEvent event) throws IOException {
        EnviromentController evm = new EnviromentController();
        evm.switchScene( event,"HomePage.fxml");
    }
    public void switchSceneChangePass(ActionEvent event) throws IOException {
        EnviromentController evm = new EnviromentController();
        evm.switchScene( event,"ChangePassword.fxml");
    }
    public void signout(Stage stage){
        EnviromentController evm = new EnviromentController();
        evm.signOut(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
