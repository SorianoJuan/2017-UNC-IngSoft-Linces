package Simulador;

import Model.*;

public class SimuladorH implements Runnable{

    DomoticModel model;

    public SimuladorH(DomoticModel model){
        this.model = model;
    }

    public void run() {
        while (true) {
            System.out.println("Deseada");
            System.out.println(model.getHumedadDeseada());
            System.out.println("Sensor");
            System.out.println(model.getHumedadSensor());
            System.out.println("Deseada");
            System.out.println(model.getHumedadDeseada());
            System.out.println("Sensor");
            System.out.println(model.getHumedadSensor());
            while (model.getHumedadDeseada() > model.getHumedadSensor()) {
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