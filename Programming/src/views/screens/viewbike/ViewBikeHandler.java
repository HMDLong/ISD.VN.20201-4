package views.screens.viewbike;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.bike.Bike;
import factory.handler.BikeHandlerFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class ViewBikeHandler extends BaseScreenHandler implements Initializable {

  @FXML
  private Button bikeBackBtn;

  @FXML
  private VBox bikelistVBox;

  private ArrayList<Bike> bikelist;

  public ViewBikeHandler(Stage stage, String screenPath, ArrayList<Bike> bikelist) throws IOException {
    super(stage, screenPath);
    bikelistVBox.getChildren().clear();
    this.bikelist = bikelist;
    try {
      for (Bike bike : this.bikelist) {
        BikeHandler bikeHandler = BikeHandlerFactory.getFactory().create(bike);
        bikelistVBox.getChildren().add(bikeHandler.getContent());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    bikeBackBtn.setOnMouseClicked(e -> {
      this.getPreviousScreen().show();
    });
  }
}
