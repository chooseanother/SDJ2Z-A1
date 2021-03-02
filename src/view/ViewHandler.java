package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private CentralHeatingViewController temperatureViewController;
    private LogViewController heaterViewController;


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
                root = loadTemperatureView("CentralHeatingView.fxml");
                break;
            case "log":
                root = loadHeaterView("LogView.fxml");
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

    private Region loadTemperatureView(String fxmlFile)
    {
        if (temperatureViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                temperatureViewController = loader.getController();
                temperatureViewController
                        .init(this, viewModelFactory.getTemperatureViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            temperatureViewController.reset();
        }
        return temperatureViewController.getRoot();
    }

    private Region loadHeaterView(String fxmlFile)
    {
        if (heaterViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                heaterViewController = loader.getController();
                heaterViewController
                        .init(this, viewModelFactory.getHeaterViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            heaterViewController.reset();
        }
        return heaterViewController.getRoot();
    }
}
