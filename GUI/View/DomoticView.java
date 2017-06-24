package View;

import Controller.*;
import Model.*;
import Observers.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DomoticView implements DomoticViewInterface, TemperaturaObserver, HumedadObserver, ACObserver, EstufaObserver, HumidificadorObserver {

    DomoticControllerInterface controller;
    DomoticModelInterface model;

    @FXML

    //Campos correspondientes a la vista Monitor
    public Label Temperatura1;
    @FXML
    public Label Humedad1;
    @FXML
    public Label AC1;
    @FXML
    public Label Estufa1;
    @FXML
    public Label Humidificador1;

    //Campos correspondientes a la vista Preset
    @FXML

    public Label Temperatura2;
    @FXML
    public Label Humedad2;
    @FXML
    public Label AC2;
    @FXML
    public Label Estufa2;
    @FXML
    public Label Humidificador2;

    //Valores ingresados por el usuario en la vista Preset
    @FXML
    public TextField Tdeseada;
    @FXML
    public TextField Hdeseada;

    //Para inicializar el sistema
    public void initialize() {
        updateHumedad();
        updateAC();
        updateHumidificador();
        updateEstufa();
        updateTemperatura();
    }

    //Setter de la vista
    public DomoticView(Controller.DomoticController controller, Model.DomoticModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((Observers.TemperaturaObserver) this);
        model.registerObserver((Observers.HumedadObserver) this);
        model.registerObserver((Observers.ACObserver) this);
        model.registerObserver((Observers.EstufaObserver) this);
        model.registerObserver((Observers.HumidificadorObserver) this);
    }

    //UPDATES DE LOS OBSERVERS
    @Override
    public void updateHumedad() {
        Humedad1.setText(Integer.toString(model.getHumedadSensor()));
        Humedad2.setText(Integer.toString(model.getHumedadSensor()));
    }

    @Override
    public void updateTemperatura() {
        Temperatura1.setText(Integer.toString(model.getTemperaturaSensor()));
        Temperatura2.setText(Integer.toString(model.getTemperaturaSensor()));
    }

    @Override
    public void updateAC() {
        AC1.setText(acTextField());
        AC2.setText(acTextField());
    }

    @Override
    public void updateEstufa() {
        Estufa1.setText(estufaTextField());
        Estufa2.setText(estufaTextField());
    }

    @Override
    public void updateHumidificador() {
        Humidificador1.setText(humidificadorTextField());
        Humidificador2.setText(humidificadorTextField());
    }

    //Actualiza valor de la temperaturaDeseada del modelo por medio del controlador
    public void actualizarTemperaturaDeseada() {
        controller.setearTemperatura((Integer.parseInt(Tdeseada.getText())));
    }

    //Actualiza valor de la temperaturaDeseada del modelo por medio del controlador
    public void actualizarHumedadDeseada() {
        controller.setearHumedad((Integer.parseInt(Hdeseada.getText())));
    }

    //Muestra ON u OFF en AC
    public String acTextField() {return controller.estadoAC(); }

    //Muestra ON u OFF en Estufa
    public String estufaTextField() {return controller.estadoEstufa();}

    //Muestra ON u OFF en humidificador
    public String humidificadorTextField() { return controller.estadoHumidificador(); }


    @Override
    public void enviarButtonClicked() {
        System.out.println("Boton de enviar clickeado");
        actualizarTemperaturaDeseada();
        actualizarHumedadDeseada();
        model.notifyHumedadObservers();
    }

    @Override
    public void txtButtonClicked() {
        System.out.println("Boton de txt clickeado");
        controller.generarTxt();
    }
}

