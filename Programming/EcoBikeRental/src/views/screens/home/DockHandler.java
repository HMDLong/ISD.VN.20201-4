package views.screens.home;

import java.io.IOException;

import common.exception.EmptyDockException;
import controller.ViewBikeController;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
//import views.screens.FXMLScreenHandler;
import views.screens.FXMLScreenHandler;

public class DockHandler extends FXMLScreenHandler{
  @FXML
  private Label dockNameLabel;
  
  @FXML
  private Label addressLabel;
  
  @FXML
  private Label emptySlotLabel;
  
  @FXML
  private Label availableLabel;
  
  @FXML
  private Button viewBikeBtn;
  
  //private HomeScreenHandler dockScreen;
  private Dock dock;
  private Pane content;
  
  public DockHandler(String screenPath/*, HomeScreenHandler homeScreen*/) throws IOException {
      super(screenPath);
      this.content = (Pane) this.getLoader().load();
      //this.dockScreen = homeScreen;
  }

  public Pane getContent() {
      return this.content;
  }
  
  public void setDock(Dock dock) {
    this.dock = dock;
    displayDock();
  }
  
  public void displayDock() {
    this.dockNameLabel.setText(dock.getName());
    this.addressLabel.setText("Address: " + dock.getAddress());
    this.emptySlotLabel.setText("Empty: " + 10);
    this.availableLabel.setText("Available: " + 8);
    this.viewBikeBtn.setOnMouseClicked(e -> {
      try {
        ViewBikeController viewBikeCtrl = new ViewBikeController();
        viewBikeCtrl.requestViewBikes(this.dock);
      } catch(EmptyDockException ex) {
        
      } catch(Exception ex) {
        
      }
    });
  }
}
