package viewmodel;

import javafx.application.Platform;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewModel implements PropertyChangeListener {
    private Model model;

    public TemperatureViewModel(Model model){
        this.model = model;

    }

    public void clear(){
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(()->{

        });
    }
}
