package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.NumberStringConverter;
import viewmodel.LimitViewModel;

public class LimitViewController {
    @FXML private Label upperLabel, lowerLabel, errorLabel;
    @FXML private TextField upperText, lowerText;
    private ViewHandler viewHandler;
    private LimitViewModel viewModel;
    private Region root;

    public LimitViewController(){}

    public void init(ViewHandler viewHandler, LimitViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        //bind
        upperLabel.textProperty().bind(viewModel.getUpperProperty());
        lowerLabel.textProperty().bind(viewModel.getLowerProperty());
        errorLabel.textProperty().bind(viewModel.getErrorProperty());
        Bindings.bindBidirectional(upperText.textProperty(), viewModel.getSetUpperProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(lowerText.textProperty(), viewModel.getSetLowerProperty(), new NumberStringConverter());
    }

    public Region getRoot(){
        return root;
    }

    public void reset(){
        viewModel.clear();
    }


    @FXML private void upperSet(ActionEvent event) {
        viewModel.setUpper();
    }

    @FXML private void lowerSet(ActionEvent event) {
        viewModel.setLower();
    }

    @FXML private void back(ActionEvent event) {
        viewHandler.openView("home");
    }


    @FXML private void onEnterUpper(ActionEvent event) {
        upperSet(event);
    }

    @FXML private void onEnterLower(ActionEvent event) {
        lowerSet(event);
    }
}
