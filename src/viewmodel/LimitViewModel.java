package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LimitViewModel implements PropertyChangeListener {
    private Model model;
    private SimpleStringProperty errorProperty, upperProperty, lowerProperty;
    private SimpleDoubleProperty setUpperProperty, setLowerProperty;

    public LimitViewModel(Model model){
        this.model = model;
        this.model.addListener(this);
        errorProperty = new SimpleStringProperty();
        upperProperty = new SimpleStringProperty(model.getUpperLimit()+"");
        lowerProperty = new SimpleStringProperty(model.getLowerLimit()+"");
        setUpperProperty = new SimpleDoubleProperty();
        setLowerProperty = new SimpleDoubleProperty();
    }

    public void clear(){
        errorProperty.setValue(null);
        upperProperty.setValue(model.getUpperLimit()+"");
        lowerProperty.setValue(model.getLowerLimit()+"");
        setLowerProperty.setValue(null);
        setUpperProperty.setValue(null);
    }

    public void setUpper(){
        errorProperty.setValue(null);
        try {
            model.setUpperLimit(setUpperProperty.getValue());
            setUpperProperty.setValue(null);
        }
        catch (Exception e){
            errorProperty.setValue(e.getMessage());
        }
    }

    public void setLower(){
        errorProperty.setValue(null);
        try {
            model.setLowerLimit(setLowerProperty.getValue());
            setLowerProperty.setValue(null);
        }
        catch (Exception e){
            errorProperty.setValue(e.getMessage());
        }
    }

    public SimpleStringProperty getErrorProperty() {
        return errorProperty;
    }

    public SimpleStringProperty getUpperProperty(){
        return upperProperty;
    }

    public SimpleStringProperty getLowerProperty(){
        return lowerProperty;
    }

    public SimpleDoubleProperty getSetUpperProperty(){
        return setUpperProperty;
    }

    public SimpleDoubleProperty getSetLowerProperty(){
        return setLowerProperty;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(()->{
            if (evt.getPropertyName().equals("setUpperLimit")){
                upperProperty.setValue(String.format("%.1f",((Double)evt.getNewValue())));
            }
            else if (evt.getPropertyName().equals("setLowerLimit")){
                lowerProperty.setValue(String.format("%.1f",((Double)evt.getNewValue())));
            }
        });
    }
}
