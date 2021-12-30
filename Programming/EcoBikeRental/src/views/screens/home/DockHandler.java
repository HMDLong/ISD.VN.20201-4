package views.screens.home;

import java.io.IOException;

import common.exception.EmptyDockException;
import controller.ViewBikeController;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import utils.Configs;
import views.screens.DockMenuHandler;
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
  
  @FXML
  private Button returnBtn;
  
  private HomeScreenHandler dockScreen;
  private Dock dock;
  private Pane content;
  
  public DockHandler(String screenPath, HomeScreenHandler homeScreen) throws IOException {
      super(screenPath);
      this.content = (Pane) this.getLoader().load();
      this.dockScreen = homeScreen;
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
    this.emptySlotLabel.setText("Empty: " + (dock.getMaxSlot() - dock.getAvaiSlot()));
    this.availableLabel.setText("Available: " + dock.getAvaiSlot());
    this.viewBikeBtn.setOnMouseClicked(e -> {
      try {
        DockMenuHandler dockMenu = new DockMenuHandler(dockScreen.getStage(), Configs.DOCK_MENU_PATH, this.dock);
        dockMenu.show();
      } catch(Exception ex) {
        
      }
    });
  }
}
