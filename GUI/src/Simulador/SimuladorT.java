package Simulador;

import Model.*;

public class SimuladorT implements Runnable{

    DomoticModel model;

    public SimuladorT(DomoticModel model){
        this.model = model;
    }

    public void run() {
        while (true) {
            while (model.getTemperaturaDeseada() > model.getTemperaturaSensor()) {
                System.out.println("aumentando T");
                model.setEstufa(true);
                model.setAC(false);
                model.setTemperaturaSensor(model.getTemperaturaSensor() + 1);
                try {
                    model.notifyTemperaturaObservers();
                    model.notifyEstufaObservers();
                    model.notifyACObservers();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            model.setEstufa(false);
            model.setAC(false);

            while (model.getTemperaturaDeseada() < model.getTemperaturaSensor()) {
                System.out.println("disminuyendo T");
                model.setEstufa(false);
                model.setAC(true);
                model.setTemperaturaSensor(model.getTemperaturaSensor() - 1);
                try {
                    Thread.sleep(1000);
                    model.notifyTemperaturaObservers();
                    model.notifyEstufaObservers();
                    model.notifyACObservers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            model.setEstufa(false);
            model.setAC(false);
        }

    }
}