package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewmodel.SimpleTemperatureViewModel;
import viewmodel.WarningLogViewModel;

public class WarningLogViewController {
    public Label WarningLog;
    public Button back;
    public ListView<String> logTable;

    private ViewHandler viewHandler;
    private WarningLogViewModel viewModel;
    private Region root;

    public WarningLogViewController(){}

    public void init(ViewHandler viewHandler, WarningLogViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        logTable.setItems(viewModel.getLog());

        //add to list
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
    }

    public void back(ActionEvent actionEvent) {
        viewHandler.openView("home");
    }
}
