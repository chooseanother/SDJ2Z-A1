package viewmodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.Model;

public class HistoryViewModel {
    private Model model;
    private ObservableList<SimpleTemperatureViewModel> list;

    public HistoryViewModel(Model model){
        this.model = model;
        this.list = FXCollections.observableArrayList();
    }

    public void clear(){
        list.clear();
    }

    public void load(){
        //for(int x = 0; x < model.)
    }
}
