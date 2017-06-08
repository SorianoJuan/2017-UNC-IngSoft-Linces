/*
public class SimuladorH implements Runnable{

    public void run(){
        simularH();
    }

    private void simularH(){
        while (HumedadDeseada > HumedadSensor) {
            System.out.println("aumentando H");
            Humidificador = true;
            HumedadSensor++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Humidificador = false;
                Valores();
            }
        }
        while (HumedadDeseada < HumedadSensor) {
            System.out.println("disminuyendo H");
            Humidificador = false;
            HumedadSensor--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Humidificador = false;
                Valores();
            }
        }
    }
}
*/