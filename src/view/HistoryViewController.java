package view;

import javafx.scene.layout.Region;
import viewmodel.HistoryViewModel;


public class HistoryViewController {
    private ViewHandler viewHandler;
    private HistoryViewModel viewModel;
    private Region root;

    public HistoryViewController(){}

    public void init(ViewHandler viewHandler, HistoryViewModel viewModel, Region root) {
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
