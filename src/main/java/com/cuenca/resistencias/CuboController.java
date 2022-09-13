package com.cuenca.resistencias;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class CuboController {
    @FXML
    TextField resistenciaValorLectura;
    @FXML
    Button siguiente;
    @FXML
    Button atras;
    @FXML
    Text resultado;
    @FXML
    ImageView pasos;

    private Double resistenciaValor;

    public void resistenciaValorCambio(){
        try {
            resistenciaValor = Double.parseDouble( resistenciaValorLectura.getText() );
            siguiente.setVisible(true);
            atras.setVisible(false);
            pasos.setVisible(true);
            resultado.setText("");
            if(paso > 1)
                cambio(0);
        }catch(Exception e){
            siguiente.setVisible(false);
            pasos.setVisible(false);
            atras.setVisible(false);
            resultado.setText("Ingrese un valor numerico");
        }
    }

    private final String BASE_IMG = "img/cr/";
    private final int MAX_IMG = 17;
    private int paso = 0;

    private List<UnaryOperator<Double>> operaciones = Arrays.asList(
            (v) -> 3.0*v, //0
            (v) -> (3.0/2.0)*v, //1
            (v) -> (3.0/4.0)*v, //2
            (v) -> (3.0/8.0)*v, //3
            (v) -> 6.0*v, //4
            (v) -> 8.0*v, //5
            (v) -> 2.0*v, //6
            (v) -> (8.0/9.0)*v, //7
            (v) -> (8.0/15.0)*v, //8
            (v) -> (1.0/15.0)*v, //9
            (v) -> (2.0/15.0)*v, //10
            (v) -> (16.0/5.0)*v, //11
            (v) -> (1.0/4.0)*v, //12
            (v) -> (5.0/8.0)*v, //13
            (v) -> (8.0/11.0)*v, //14
            (v) -> (10.0/33.0)*v, //15
            (v) -> (5.0/22.0)*v, //16
            (v) -> (160.0/99.0)*v, //17
            (v) -> (20.0/33.0)*v, //18
            (v) -> (5.0/6.0)*v //19
    );

    private List<String> resultados;

    private List<String> getResultados(){
        return Arrays.asList(
                "", //1
                "R(a)=R(b)=R(c)="+operaciones.get(0).apply(resistenciaValor), //2
                "R(a)=R(b)=R(c)="+operaciones.get(0).apply(resistenciaValor), //3
                "R(eq)="+operaciones.get(1).apply(resistenciaValor), //4
                "R(a)=R(b)=R(c)="+operaciones.get(0).apply(resistenciaValor), //5
                "R(eq)="+operaciones.get(1).apply(resistenciaValor), //6
                "R(1)="+operaciones.get(2).apply(resistenciaValor)+"\nR(2)="+operaciones.get(2).apply(resistenciaValor)+"\nR(3)="+operaciones.get(3).apply(resistenciaValor), //7
                "R(a)="+operaciones.get(4).apply(resistenciaValor)+"\nR(b)="+operaciones.get(5).apply(resistenciaValor)+"\nR(c)="+operaciones.get(6).apply(resistenciaValor), //8
                "R(eq)="+operaciones.get(7).apply(resistenciaValor), //9
                "R(1)="+operaciones.get(8).apply(resistenciaValor)+"\nR(2)="+operaciones.get(9).apply(resistenciaValor)+"\nR(3)="+operaciones.get(10).apply(resistenciaValor), //10
                "R(eq)="+operaciones.get(11).apply(resistenciaValor), //11
                "R(1)="+operaciones.get(6).apply(resistenciaValor)+"\nR(2)="+operaciones.get(10).apply(resistenciaValor)+"\nR(3)="+operaciones.get(12).apply(resistenciaValor), //12
                "R(eq)="+operaciones.get(13).apply(resistenciaValor), //13
                "R(1)="+operaciones.get(14).apply(resistenciaValor)+"\nR(2)="+operaciones.get(15).apply(resistenciaValor)+"\nR(3)="+operaciones.get(16).apply(resistenciaValor), //14
                "R(eq)="+operaciones.get(17).apply(resistenciaValor), //15
                "R(eq)="+operaciones.get(18).apply(resistenciaValor), //16
                "R(T)="+operaciones.get(19).apply(resistenciaValor) //17
        );
    }

    private void cambio(int cambio){
        atras.setVisible(true);
        siguiente.setVisible(true);
        paso += cambio;

        if(paso == 0){
            paso = 1;
        }else if (paso > MAX_IMG){
            paso = MAX_IMG;
        }

        if(paso == 1){
            atras.setVisible(false);
        } else if (paso == MAX_IMG) {
            siguiente.setVisible(false);
        }

        var image = new Image(getClass().getResourceAsStream(
                BASE_IMG + "paso" + paso + ".png"
        ));
        pasos.setImage( image );
        resultados = getResultados();
        resultado.setText(resultados.get( (paso - 1) ));
    }

    public void onSiguiente(){
        cambio(1);
    }

    public void onAtras(){
        cambio(-1);
    }

}
