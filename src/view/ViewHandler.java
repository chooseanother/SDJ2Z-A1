package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.HistoryViewModel;
import viewmodel.LimitViewModel;
import viewmodel.ViewModelFactory;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private CentralHeatingViewController centralHeatingViewController;
    private WarningLogViewController warningLogViewController;
    private LimitViewController limitViewController;
    private HistoryViewController historyViewController;


    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("home");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "home":
                root = loadCentralHeatingView("CentralHeatingView.fxml");
                break;
            case "log":
                root = loadWarningLogView("WarningLogView.fxml");
                break;
            case "limit":
                root = loadLimitView("LimitView.fxml");
                break;
            case "history":
                root = loadHistoryView("HistoryView.fxml");
                break;
        }
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

    private Region loadCentralHeatingView(String fxmlFile)
    {
        if (centralHeatingViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                centralHeatingViewController = loader.getController();
                centralHeatingViewController
                        .init(this, viewModelFactory.getTemperatureViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            centralHeatingViewController.reset();
        }
        return centralHeatingViewController.getRoot();
    }

    private Region loadWarningLogView(String fxmlFile)
    {
        if (warningLogViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                warningLogViewController = loader.getController();
                warningLogViewController
                        .init(this, viewModelFactory.getHeaterViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            warningLogViewController.reset();
        }
        return warningLogViewController.getRoot();
    }

    private Region loadLimitView(String fxmlFile)
    {
        if (limitViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                limitViewController = loader.getController();
                limitViewController
                        .init(this, viewModelFactory.getLimitViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            limitViewController.reset();
        }
        return limitViewController.getRoot();
    }

    private Region loadHistoryView(String fxmlFile)
    {
        if (historyViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                historyViewController = loader.getController();
                historyViewController
                        .init(this, viewModelFactory.getHistoryViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            historyViewController.reset();
        }
        return historyViewController.getRoot();
    }
}
