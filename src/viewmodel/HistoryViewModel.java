package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HistoryViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<SimpleTemperatureViewModel> list;



    public HistoryViewModel(Model model){
        this.model = model;
        this.model.addListener(this);
        this.list = FXCollections.observableArrayList();

    }



    public ObservableList<SimpleTemperatureViewModel> getAll(){
        return list;
    }

    @Override public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("temperature")) {
                if (list.size() >= 20) {
                    list.remove(list.size() - 1);
                }
                list.add(0,new SimpleTemperatureViewModel(model.getLastInsertedTemperature()));
            }
        });
    }
}
