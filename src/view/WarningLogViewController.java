package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewmodel.WarningLogViewModel;

public class WarningLogViewController {
    public Label WarningLog;
    public Button back;
    public ListView logTable;
    public Label newWarning;
    private ViewHandler viewHandler;
    private WarningLogViewModel viewModel;
    private Region root;

    public WarningLogViewController(){}

    public void init(ViewHandler viewHandler, WarningLogViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        logTable.setItems(viewModel.getLog());
        newWarning.textProperty().bind(viewModel.getWarning());

        //bind
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }

    public void back(ActionEvent actionEvent) {
        viewHandler.openView("home");
    }
}
