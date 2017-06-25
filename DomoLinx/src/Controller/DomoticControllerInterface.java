package Controller;

public interface DomoticControllerInterface {
    void setearTemperatura(int t);
    void setearHumedad(int hum);
    String estadoAC();
    String estadoEstufa();
    String estadoHumidificador();
    void generarTxt();
}
