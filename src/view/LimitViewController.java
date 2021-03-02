package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.LimitViewModel;

public class LimitViewController {
    @FXML private Label t1UpperLabel, t1LowerLabel, t2UpperLabel,t2LowerLabel,errorLabel;
    @FXML private TextField t1UpperText, t1LowerText, t2UpperText, t2LowerText;
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

    @FXML private void t1UpperSet(ActionEvent event) {
    }

    @FXML private void t1LowerSet(ActionEvent event) {
    }

    @FXML private void t2UpperSet(ActionEvent event) {
    }

    @FXML private void t2LowerSet(ActionEvent event) {
    }

    @FXML private void back(ActionEvent event) {
        viewHandler.openView("home");
    }
}
