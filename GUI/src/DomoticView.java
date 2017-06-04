/**
 * Created by Torce on 04/06/2017.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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

    //Constructor de la clase DomoticView
    public DomoticView(DomoticController controller, DomoticModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((TemperaturaObserver) this);
        model.registerObserver((HumedadObserver) this);
    }

    public void crearDomoticGUI(){
        //ACÁ SE CREARÍA LA GUI
    }


    @Override
    public void display() {
        //ACA IRIAN LOS VALORES DE LOS SENSORES, EN DONDE SE ALMACENAN?
        //Temperatura1.setText(Integer.toString());
        //Temperatura2.setText(Integer.toString());
        //Humedad1.setText(Integer.toString());
        //Humedad2.setText(Integer.toString());
        AC1.setText(acTextField());
        AC2.setText(acTextField());
        Estufa1.setText(estufaTextField());
        Estufa2.setText(estufaTextField());
        Humidificador1.setText(humidificadorTextField());
        Humidificador2.setText(humidificadorTextField());
    }


    @Override
    //Actualiza valor de la temperatura
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

    @Override
    public void updateHumedad() {
        if (sanitizarHumedad(Hdeseada.getText())) {
            model.setHumedadDeseada((Integer.parseInt(Hdeseada.getText())));
        }
    }


    //Sanitizado de expresion de Humedad
    public boolean sanitizarHumedad(String H) {
        int Hum = Integer.parseInt(H);
        return (Hum >= 0 && Hum <= 100);
    }

    //Muestra ON u OFF en AC
    public String acTextField() {
        if (model.getAC()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en Estufa
    public String estufaTextField() {
        if (model.getEstufa()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en humidificador
    public String humidificadorTextField() {
        if (model.getHumidificador()) {
            return "ON";
        } else {
            return "OFF";
        }
    }


    @Override
    public void enviarButtonClicked() {
        System.out.println("Boton de enviar clickeado");
    }

    @Override
    public void txtButtonClicked() {
        System.out.println("Boton de txt clickeado");
    }


}

