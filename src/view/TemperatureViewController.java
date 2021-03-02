package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.TemperatureViewModel;

public class TemperatureViewController {
    @FXML Label t0,t1,t2,t0Warn,t1Warn,t2Warn,heatLvl;
    private ViewHandler viewHandler;
    private TemperatureViewModel viewModel;
    private Region root;

    public TemperatureViewController(){}

    public void init(ViewHandler viewHandler, TemperatureViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        //bind
        t0.textProperty().bind(viewModel.getT0());
        t1.textProperty().bind(viewModel.getT1());
        t2.textProperty().bind(viewModel.getT2());
        t0Warn.textProperty().bind(viewModel.getT0Warn());
        t1Warn.textProperty().bind(viewModel.getT1Warn());
        t2Warn.textProperty().bind(viewModel.getT2Warn());
        heatLvl.textProperty().bind(viewModel.getHeatLvl());
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }

    @FXML
    private void onHeater(){
        viewHandler.openView("heater");
    }
}
