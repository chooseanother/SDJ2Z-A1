package view;

import javafx.scene.layout.Region;
import viewmodel.HeaterViewModel;

public class HeaterViewController {
    private ViewHandler viewHandler;
    private HeaterViewModel viewModel;
    private Region root;

    public HeaterViewController(){}

    public void init(ViewHandler viewHandler, HeaterViewModel viewModel, Region root) {
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
