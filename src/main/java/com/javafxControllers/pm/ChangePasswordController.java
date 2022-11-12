package com.javafxControllers.pm;

import com.views.pm.EnviromentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ChangePasswordController {
    @FXML private Button btnCancel;
    private EnviromentController evm;
    public void backPageLogin(ActionEvent event) throws IOException {
        evm = new EnviromentController();
        evm.switchScene(event, "Login.fxml");
    }
}
