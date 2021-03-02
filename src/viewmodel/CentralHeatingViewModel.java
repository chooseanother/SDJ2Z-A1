package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CentralHeatingViewModel implements PropertyChangeListener {
    private Model model;
    private StringProperty t0,t1,t2,t0Warn,t1Warn,t2Warn,heatLvl;

    public CentralHeatingViewModel(Model model){
        this.model = model;
        t0 = new SimpleStringProperty();
        t1 = new SimpleStringProperty();
        t2 = new SimpleStringProperty();
        t0Warn = new SimpleStringProperty();
        t1Warn = new SimpleStringProperty();
        t2Warn = new SimpleStringProperty();
        heatLvl = new SimpleStringProperty();
    }

    public void clear(){
        t0Warn.setValue(null);
        t1Warn.setValue(null);
        t2Warn.setValue(null);
    }

    public void up(){
//        model.up();
    }

    public void down(){
//        model.down();
    }

    public StringProperty getT0(){
        return t0;
    }

    public StringProperty getT1(){
        return t1;
    }

    public StringProperty getT2(){
        return t2;
    }

    public StringProperty getT0Warn(){
        return t0Warn;
    }

    public StringProperty getT1Warn(){
        return t1Warn;
    }

    public StringProperty getT2Warn(){
        return t2Warn;
    }

    public StringProperty getHeatLvl(){
        return heatLvl;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(()->{
            if (event.getPropertyName().equals("t0")){
                t0.setValue((String) event.getNewValue());
                if ((Integer)event.getNewValue()>9000){
                    t0Warn.setValue("ITS OVER 9000!");
                }
                else if ((Integer)event.getNewValue()<-100){
                    t0Warn.setValue("Du ka' ikk' frys' mig, for jeg' allerede is");
                }
                else {
                    t0Warn.setValue(null);
                }
            }
            if (event.getPropertyName().equals("t1")){
                t1.setValue((String) event.getNewValue());
                if ((Integer)event.getNewValue()>9000){
                    t1Warn.setValue("ITS OVER 9000!");
                }
                else if ((Integer)event.getNewValue()<-100){
                    t1Warn.setValue("Du ka' ikk' frys' mig, for jeg' allerede is");
                }
                else {
                    t1Warn.setValue(null);
                }
            }
            if (event.getPropertyName().equals("t2")){
                t2.setValue((String) event.getNewValue());
                if ((Integer)event.getNewValue()>9000){
                    t2Warn.setValue("ITS OVER 9000!");
                }
                else if ((Integer)event.getNewValue()<-100){
                    t2Warn.setValue("Du ka' ikk' frys' mig, for jeg' allerede is");
                }
                else {
                    t2Warn.setValue(null);
                }
            }
            if (event.getPropertyName().equals("heatLvl")){
                heatLvl.setValue((String) event.getNewValue());
            }
        });
    }
}
