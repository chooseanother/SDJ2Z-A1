package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.converter.IntegerStringConverter;
import viewmodel.HistoryViewModel;
import viewmodel.SimpleTemperatureViewModel;


public class HistoryViewController {
    @FXML private TableView<SimpleTemperatureViewModel> temperatureTable;
    @FXML private TableColumn<SimpleTemperatureViewModel, String> IDColumn;
    @FXML private TableColumn<SimpleTemperatureViewModel, String> temperatureColumn;
    @FXML private TableColumn<SimpleTemperatureViewModel, String> timeColumn;

    private ViewHandler viewHandler;
    private HistoryViewModel viewModel;
    private Region root;

    public HistoryViewController(){}

    public void init(ViewHandler viewHandler, HistoryViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        IDColumn.setCellValueFactory(cellData -> cellData.getValue().getIDProperty());
        temperatureColumn.setCellValueFactory(cellData -> cellData.getValue().getValueProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeProperty());
        temperatureTable.setItems(viewModel.getAll());
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
    }

    public void backOnAction(ActionEvent actionEvent) {
        viewHandler.openView("home");
    }
}
