package com.views.pm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        //AnchorPane ap = new AnchorPane();
        EnviromentController evm = new EnviromentController();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
//        stage.resizableProperty().setValue(false);
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume(); // cancel no shut
            evm.signOut(stage);
        });
    }
}
