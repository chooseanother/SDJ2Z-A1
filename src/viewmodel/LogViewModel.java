package viewmodel;


import model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements  PropertyChangeListener  {
    private Model model;
    private ObservableList<String> log;

    public LogViewModel(Model model) {
        this.model = model;
        log = FXCollections.observableArrayList();

    }

    public ObservableList<String> getLog() {
        return log;
    }

    public void clear(){
        log.clear();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(()->log.add(0,evt.getOldValue()+": "+evt.getNewValue()));
    }
}
