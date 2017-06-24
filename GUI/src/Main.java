import Controller.DomoticController;
import Model.DomoticModel;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        DomoticModel domoticModel = new DomoticModel();
        new DomoticController(domoticModel);
        Application.launch(GUILauncher.class, args);//Para correr la vista
    }
}