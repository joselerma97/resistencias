package com.cuenca.resistencias;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OctaedroApplication {

    static void showApplication() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("octaedroresistencias.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        Stage stage = new Stage();
        stage.setTitle("Octaedro de Resistencias");
        stage.setScene(scene);
        stage.show();
    }

}
