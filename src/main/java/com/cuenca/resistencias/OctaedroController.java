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

public class OctaedroController {

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

    private final String BASE_IMG = "img/oct/";
    private final int MAX_IMG = 11;
    private int paso = 0;

    private List<UnaryOperator<Double>> operaciones = Arrays.asList(
            (v) -> 3.0*v, //0
            (v) -> (3.0/4.0)*v, //1
            (v) -> 2.0*v, //2
            (v) -> 6.0*v, //3
            (v) -> 8.0*v, //4
            (v) -> (2.0/3.0)*v, //5
            (v) -> (4.0/7.0)*v, //6
            (v) -> (1.0/21.0)*v, //7
            (v) -> (2.0/21.0)*v, //8
            (v) -> (15.0/7.0)*v, //9
            (v) -> (30.0/329.0)*v, //10
            (v) -> (58.0/47.0)*v, //11
            (v) -> (58.0/105.0)*v //11
    );

    private List<String> resultados;

    private List<String> getResultados(){
        return Arrays.asList(
                "", //1
                "R(a)=R(b)=R(c)="+operaciones.get(0).apply(resistenciaValor), //2
                "R(eq)="+operaciones.get(1).apply(resistenciaValor), //2
                "R(1)="+operaciones.get(0).apply(resistenciaValor)+"\t\t\tR(2)="+resistenciaValor+"\t\t\tR(3)="+operaciones.get(1).apply(resistenciaValor)
                +"\n"+"R(a)="+operaciones.get(2).apply(resistenciaValor)+"\t\t\tR(b)="+operaciones.get(3).apply(resistenciaValor)+"\t\t\tR(c)="+operaciones.get(4).apply(resistenciaValor), //4
                "R(eq)="+operaciones.get(5).apply(resistenciaValor), //5
                "R(a)="+operaciones.get(5).apply(resistenciaValor)+"\t\t\tR(b)="+operaciones.get(5).apply(resistenciaValor)+"\t\t\tR(c)="+operaciones.get(4).apply(resistenciaValor)
                        +"\n"+"R(1)="+operaciones.get(6).apply(resistenciaValor)+"\t\t\tR(2)="+operaciones.get(6).apply(resistenciaValor)+"\t\t\tR(3)="+operaciones.get(7).apply(resistenciaValor), //6
                "R(eq)="+operaciones.get(8).apply(resistenciaValor), //7
                "R(eq)="+operaciones.get(9).apply(resistenciaValor), //8
                "R(eq)="+operaciones.get(10).apply(resistenciaValor), //9
                "R(eq)="+operaciones.get(11).apply(resistenciaValor), //10
                "Resultado Final="+operaciones.get(12).apply(resistenciaValor) //11
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
