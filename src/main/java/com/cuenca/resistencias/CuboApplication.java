package com.cuenca.resistencias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CuboApplication{

    static void showApplication() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cuboresistencias.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        Stage stage = new Stage();
        stage.setTitle("Cubo de Resistencias");
        stage.setScene(scene);
        stage.show();
    }
}
