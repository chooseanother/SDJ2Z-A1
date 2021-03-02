package viewmodel;

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
        this.list = FXCollections.observableArrayList();
    }


    public void clear(){
        list.clear();
    }

    public ObservableList<SimpleTemperatureViewModel> getAll(){
        return list;
    }

    @Override public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("temperature")) {
            if (list.size() > 20) {
                list.remove(list.size() - 1);
            }
            list.add(new SimpleTemperatureViewModel(model.getLastInsertedTemperature()));
        }

    }
}
