module com.cuenca.resistencias {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.cuenca.resistencias to javafx.fxml;
    exports com.cuenca.resistencias;
}