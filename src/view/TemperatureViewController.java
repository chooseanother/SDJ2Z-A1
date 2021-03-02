package view;

import javafx.scene.layout.Region;
import viewmodel.TemperatureViewModel;

public class TemperatureViewController {
    private ViewHandler viewHandler;
    private TemperatureViewModel viewModel;
    private Region root;

    public TemperatureViewController(){}

    public void init(ViewHandler viewHandler, TemperatureViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        //bind
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }
}
