package view;

import javafx.scene.layout.Region;
import viewmodel.LimitViewModel;

public class LimitViewController {
    private ViewHandler viewHandler;
    private LimitViewModel viewModel;
    private Region root;

    public LimitViewController(){}

    public void init(ViewHandler viewHandler, LimitViewModel viewModel, Region root) {
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
