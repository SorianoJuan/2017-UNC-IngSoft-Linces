import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

/**
 * Created by Torce on 02/06/2017.
 */

public class GUIController {

    private int Temperatura=30;
    private int Humedad=50;
    private boolean AC=true;
    private boolean Estufa=true;
    private boolean Humidificador=true;

    @FXML

    public Label Temperatura1;
    public Label Temperatura2;
    public Label Humedad1;
    public Label Humedad2;
    public Label AC1;
    public Label AC2;
    public Label Estufa1;
    public Label Estufa2;
    public Label Humidificador1;
    public Label Humidificador2;
    public TextField Tdeseada;
    public TextField Hdeseada;

    private void Valores(){
        Temperatura1.setText(Integer.toString(Temperatura));
        Temperatura2.setText(Integer.toString(Temperatura));
        Humedad1.setText(Integer.toString(Humedad));
        Humedad2.setText(Integer.toString(Humedad));
        AC1.setText(acTextField());
        AC2.setText(acTextField());
        Estufa1.setText(estufaTextField());
        Estufa2.setText(estufaTextField());
        Humidificador1.setText(humidificadorTextField());
        Humidificador2.setText(humidificadorTextField());

    }

    public void txtButtonClicked() {
        System.out.println("Boton de txt clickeado");
        Valores();
    }

    public void submitButtonClicked(){
        System.out.println("Boton de enviar clickeado");
        temperaturaTextField();
        humedadTextField();
        Valores();
    }

    private void temperaturaTextField(){
        Temperatura=Integer.parseInt(Tdeseada.getText());
    }

    private void humedadTextField(){
        Humedad=Integer.parseInt(Hdeseada.getText());
    }
    private String acTextField(){
        if(AC){
            return "ON";
        }
        else {
            return "OFF";
        }
    }

    private String estufaTextField(){
        if(Estufa){
            return "ON";
        }
        else {
            return "OFF";
        }
    }
    private String humidificadorTextField(){
        if(Humidificador){
            return "ON";
        }
        else {
            return "OFF";
        }
    }


}
