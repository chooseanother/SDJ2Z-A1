package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import viewmodel.HistoryViewModel;
import viewmodel.SimpleTemperatureViewModel;

public class HistoryViewController {
    @FXML private TableView<HistoryViewController> temperatureTable;
    @FXML private TableColumn<SimpleTemperatureViewModel, String> IDColumn;
    @FXML private TableColumn<SimpleTemperatureViewModel, Double> temperatureColumn;
    private ViewHandler viewHandler;
    private HistoryViewModel viewModel;
    private Region root;

    public HistoryViewController(){}

    public void init(ViewHandler viewHandler, HistoryViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        //IDColumn.setCellValueFactory(cellData -> cellData.getValue().);
        //bind
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }

    public void backOnAction(ActionEvent actionEvent) {
        viewHandler.openView("home");
    }
}
