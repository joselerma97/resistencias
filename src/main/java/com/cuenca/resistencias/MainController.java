package com.cuenca.resistencias;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {
    @FXML
    public ImageView mainLogo;

    public void showCuboResistencias() throws  Exception{
        CuboApplication.showApplication();
    }

    public void  showOctaedroResistencias() throws Exception{
        OctaedroApplication.showApplication();
    }

}