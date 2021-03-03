package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.CentralHeatingViewModel;

public class CentralHeatingViewController {
    @FXML Label t0,t1,t2,warnLabel,heatLvl;
    @FXML Button up, down;
    private ViewHandler viewHandler;
    private CentralHeatingViewModel viewModel;
    private Region root;

    public CentralHeatingViewController(){}

    public void init(ViewHandler viewHandler, CentralHeatingViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        //bind
        t0.textProperty().bind(viewModel.getT0());
        t1.textProperty().bind(viewModel.getT1());
        t2.textProperty().bind(viewModel.getT2());
        warnLabel.textProperty().bind(viewModel.getWarning());
        heatLvl.textProperty().bind(viewModel.getHeatLvl());
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }

    @FXML
    private void onUp(){
        viewModel.up();
    }

    @FXML
    private void onDown(){
        viewModel.down();
    }

    @FXML
    private void onLog(){
        viewHandler.openView("log");
    }

    @FXML
    private void onCritical(){
        viewHandler.openView("limit");
    }

    @FXML
    public void onHistory() {
        viewHandler.openView("history");
    }
}
