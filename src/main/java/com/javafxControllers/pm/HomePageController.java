package com.javafxControllers.pm;

import com.views.pm.EnviromentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomePageController {
    @FXML private Button btnMcustomer;
    @FXML private Button btnMproduct;
    @FXML private Button btnMreceipt;
    @FXML private  Button btnStatistic;
    @FXML private  Button btnPrevious;

    public void previousPage(ActionEvent event) throws IOException {
        EnviromentController evm = new EnviromentController();
        evm.switchScene(event, "Login.fxml");
    }
    public void switchManageProduct(ActionEvent event) throws IOException {
        EnviromentController evm = new EnviromentController();
        evm.switchScene(event, "ManageProduct.fxml");
    }

}
