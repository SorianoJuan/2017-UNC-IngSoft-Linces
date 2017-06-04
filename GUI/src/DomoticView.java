import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Torce on 04/06/2017.
 */
public class DomoticView implements DomoticViewInterface,TemperaturaObserver, HumedadObserver {

    DomoticControllerInterface controller;
    DomoticModelInterface model;

    @FXML
    //Campos correspondientes a la vista Monitor
    public Label Temperatura1;
    public Label Humedad1;
    public Label AC1;
    public Label Estufa1;
    public Label Humidificador1;

    //Campos correspondientes a la vista Preset
    public Label Temperatura2;
    public Label Humedad2;
    public Label AC2;
    public Label Estufa2;
    public Label Humidificador2;

    //Valores ingresados por el usuario en la vista Preset
    public TextField Tdeseada;
    public TextField Hdeseada;

    public DomoticView(DomoticController controller, DomoticModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((TemperaturaObserver) this);
        model.registerObserver((HumedadObserver) this);
    }


    @Override
    public void updateHumedad() {
        if (sanitizarHumedad(Hdeseada.getText())) {
            model.setHumedadDeseada((Integer.parseInt(Hdeseada.getText())));
        }
    }

    @Override
    public void updateTemperatura() {
        if (sanitizarTemperatura(Tdeseada.getText())) {
            model.setTemperaturaDeseada(Integer.parseInt(Tdeseada.getText()));
        }
    }

    //Sanitizado de expresion de Temperatura
    public boolean sanitizarTemperatura(String T) {
        int Temp = Integer.parseInt(T);
        return (Temp >= 0 && Temp <= 40);
    }

    //Sanitizado de expresion de Humedad
    public boolean sanitizarHumedad(String H) {
        int Hum = Integer.parseInt(H);
        return (Hum >= 0 && Hum <= 100);
    }
}

