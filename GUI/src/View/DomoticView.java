package View;

import Controller.*;
import Model.*;
import Observers.*;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DomoticView implements DomoticViewInterface, TemperaturaObserver, HumedadObserver, ACObserver, EstufaObserver, HumidificadorObserver {

    private static final DomoticView INSTANCE = new DomoticView();
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

    //Constructor de la clase View
    public DomoticView(){}

    //Para inicializar el sistema
    public void initialize() {
        updateHumedad();
        updateAC();
        updateHumidificador();
        updateEstufa();
        updateTemperatura();
    }

    public static DomoticView getInstance() {
        return INSTANCE;
    }

        //Intento de crear la setear la vista con el constructor vacio
        public void setView(Controller.DomoticController controllera, Model.DomoticModelInterface modela){
            System.out.println("Seteando");
            this.controller = controllera;
            this.model = modela;
            model.registerObserver((Observers.TemperaturaObserver) this);
            model.registerObserver((Observers.HumedadObserver) this);
            model.registerObserver((Observers.ACObserver) this);
            model.registerObserver((Observers.EstufaObserver) this);
            model.registerObserver((Observers.HumidificadorObserver) this);
        }

    //UPDATES DE LOS OBSERVERS
    @Override
    public void updateHumedad() {
        Humedad1.setText(Integer.toString(getInstance().model.getHumedadSensor()));
        Humedad2.setText(Integer.toString(getInstance().model.getHumedadSensor()));
    }

    @Override
    public void updateTemperatura() {
        Temperatura1.setText(Integer.toString(getInstance().model.getTemperaturaSensor()));
        Temperatura2.setText(Integer.toString(getInstance().model.getTemperaturaSensor()));
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
            getInstance().controller.setearTemperatura((Integer.parseInt(Tdeseada.getText())));
        }

    //Actualiza valor de la temperaturaDeseada del modelo por medio del controlador
    public void actualizarHumedadDeseada() {
        getInstance().controller.setearHumedad((Integer.parseInt(Hdeseada.getText())));
    }


    //Muestra ON u OFF en AC
    public String acTextField() {return getInstance().controller.estadoAC(); }

    //Muestra ON u OFF en Estufa
    public String estufaTextField() {return getInstance().controller.estadoEstufa();}

    //Muestra ON u OFF en humidificador
    public String humidificadorTextField() { return getInstance().controller.estadoHumidificador(); }


    @Override
    public void enviarButtonClicked() {
        System.out.println("Boton de enviar clickeado");
        actualizarTemperaturaDeseada();
        actualizarHumedadDeseada();
    }

    @Override
    public void txtButtonClicked() {
        System.out.println("Boton de txt clickeado");
        getInstance().controller.generarTxt();
    }
}

