/**
 * Created by Torce on 04/06/2017.
 */
public class DomoticController implements DomoticControllerInterface{

    DomoticModelInterface model;
    DomoticViewInterface view;

    public DomoticController() {
        //this.model = model;
        view = new DomoticView(this, model);
        view.crearDomoticGUI();
    }

    @Override
    public void setearTemperatura(int t){
        if(sanitizarTemperatura(t)){
            model.setTemperaturaDeseada(t);
        }
        else{
            //PLACEHOLDER DE TIRAR ERROR
            //view.TIRAR_ERROR_DE_TEMPERATURA
        }
    }

    //Sanitizado de expresion de Temperatura
    private boolean sanitizarTemperatura(int T) {
        return (T >= 0 && T <= 40);
    }


    @Override
    public void setearHumedad(int hum) {
        if(sanitizarTemperatura(hum)){
            model.setHumedadDeseada(hum);
        }
        else{
            //PLACEHOLDER DE TIRAR ERROR
            //view.TIRAR_ERROR_DE_HUMEDAD
        }
    }

    //Sanitizado de expresion de Humedad
    private boolean sanitizarHumedad(int H) {
        return (H >= 0 && H <= 100);
    }

    //Muestra ON u OFF en AC
    public String estadoAC() {
        if (model.getAC()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en Estufa
    public String estadoEstufa() {
        if (model.getEstufa()) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en humidificador
    public String estadoHumidificador() {
        if (model.getHumidificador()) {
            return "ON";
        } else {
            return "OFF";
        }
    }




}
