package view;

import javafx.scene.layout.Region;
import viewmodel.LogViewModel;

public class LogViewController {
    private ViewHandler viewHandler;
    private LogViewModel viewModel;
    private Region root;

    public LogViewController(){}

    public void init(ViewHandler viewHandler, LogViewModel viewModel, Region root) {
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
