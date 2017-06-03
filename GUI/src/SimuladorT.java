/**
 * Created by Torce on 03/06/2017.
 */

/*
public class Simulador implements Runnable{

    public void run(){
    simularT();
    }

   private void simularT() {
        while (TemperaturaDeseada > TemperaturaSensor) {
            System.out.println("aumentando T");
            AC = false;
            Estufa = true;
            TemperaturaSensor++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Estufa = false;
                Valores();
            }
        }
        while (TemperaturaDeseada < TemperaturaSensor) {
            System.out.println("disminuyendo T");
            AC = true;
            Estufa = false;
            TemperaturaSensor--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                AC = false;
                Valores();
            }
        }
    }

}
*/