package Simulador;

import Model.*;

public class SimuladorH implements Runnable{

    DomoticModel model;

    public SimuladorH(DomoticModel model){
        this.model = model;
    }

    public void run() {
        System.out.println(model.getHumedadDeseada());
        while (true) {
            System.out.println(model.getHumedadDeseada());
            while (model.getHumedadDeseada() > model.getHumedadSensor()) {
                System.out.println("aumentando H");
                model.setHumidificador(true);
                model.setHumedadSensor(model.getHumedadSensor() + 1);
                try {
                    Thread.sleep(1000);
                    model.notifyHumidificadorObservers();
                    model.notifyHumedadObservers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            model.setHumidificador(false);

            while (model.getHumedadDeseada() < model.getHumedadSensor()) {
                System.out.println("disminuyendo H");
                model.setHumidificador(false);
                model.setHumedadSensor(model.getHumedadSensor() - 1);
                try {
                    Thread.sleep(1000);
                    model.notifyHumidificadorObservers();
                    model.notifyHumedadObservers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            model.setHumidificador(false);
        }

    }
}