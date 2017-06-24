package Simulador;

import Model.*;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class SimuladorSensores {

    private Thread th;
    public enum SIMULATOR_TYPE {
        SIMULADOR_HUM, SIMULADOR_TEMP
    }

    private DomoticModel model;
    private SIMULATOR_TYPE type;

    public SimuladorSensores(DomoticModel model, SIMULATOR_TYPE type) {
        this.model = model;
        this.type = type;
    }

    public void simulate() {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                int valorDeseado = type == SIMULATOR_TYPE.SIMULADOR_HUM ? model.getHumedadDeseada() : model.getTemperaturaDeseada();
                int valorSensor = type == SIMULATOR_TYPE.SIMULADOR_HUM ? model.getHumedadSensor() : model.getTemperaturaSensor();
                while (valorDeseado != valorSensor) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (type == SIMULATOR_TYPE.SIMULADOR_HUM) {
                                notifyHumedadChanges();
                            } else if (type == SIMULATOR_TYPE.SIMULADOR_TEMP) {
                                notifyTemperatureChanges();
                            }
                        }
                    });
                    Thread.sleep(1000);
                }
                return null;
            }
        };
        th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    private void notifyHumedadChanges() {
        if (model.getHumedadDeseada() > model.getHumedadSensor()) {
            model.setHumidificador(true);
            model.setHumedadSensor(model.getHumedadSensor() + 1);
        } else {
            model.setHumidificador(false);
            model.setHumedadSensor(model.getHumedadSensor() - 1);
        }

        if (model.getHumedadDeseada() == model.getHumedadSensor()) {
            model.setHumidificador(false);
            th.stop();
        }

        model.notifyHumedadObservers();
        model.notifyHumidificadorObservers();
    }

    private void notifyTemperatureChanges() {

        if (model.getTemperaturaDeseada() > model.getTemperaturaSensor()) {
            model.setEstufa(true);
            model.setAC(false);
            model.setTemperaturaSensor(model.getTemperaturaSensor() + 1);
        } else {
            model.setEstufa(false);
            model.setAC(true);
            model.setTemperaturaSensor(model.getTemperaturaSensor() - 1);
        }

        if (model.getTemperaturaDeseada() == model.getTemperaturaSensor()) {
            model.setEstufa(false);
            model.setAC(false);
            th.stop();
        }

        model.notifyTemperaturaObservers();
        model.notifyEstufaObservers();
        model.notifyACObservers();
    }
}