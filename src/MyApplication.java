import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.Model;
import mediator.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application {
    Thread t1;
    Thread t2;

    public void start(Stage primaryStage) {

        // Model

        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);

        t1 = new Thread(new Thermometer(model, "t1", 0, 1));
        t2 = new Thread(new Thermometer(model, "t2", 0, 7));

        t1.start();
        t2.start();

        // View

        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);
    }

    @Override
    public void stop()
    {
        t1.stop();
        t2.stop();
    }


}
