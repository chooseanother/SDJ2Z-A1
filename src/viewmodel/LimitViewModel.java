package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import mediator.Model;

public class LimitViewModel {
    private Model model;
    private SimpleStringProperty upperProperty, lowerProperty, errorProperty,
            setUpperProperty, setLowerProperty;

    public LimitViewModel(Model model){
        this.model = model;

    }

    public void clear(){
        errorProperty.setValue(null);
        upperProperty.setValue(model.getUpperLimit);
    }
}
