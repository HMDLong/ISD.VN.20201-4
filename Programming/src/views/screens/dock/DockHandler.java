package views.screens.dock;

import java.io.IOException;

import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import utils.Configs;
import views.screens.FXMLScreenHandler;
import views.screens.home.HomeHandler;
import views.screens.menu.MenuHandler;

public class DockHandler extends FXMLScreenHandler {
  @FXML
  private Label dockNameLabel;
  
  @FXML
  private Label addressLabel;
  
  @FXML
  private Label emptySlotLabel;
  
  @FXML
  private Label availableLabel;
  
  @FXML
  private Button toDockBtn;
  
  @FXML
  private Button returnBtn;
  
  private HomeHandler homeScreen;
  private Dock dock;
  private Pane content;
  
  public DockHandler(String screenPath, HomeHandler homeScreen) throws IOException {
      super(screenPath);
      this.content = (Pane) this.getLoader().load();
      this.homeScreen = homeScreen;
  }

  public Pane getContent() {
    return this.content;
  }
  
  public void setDock(Dock dock) {
    this.dock = dock;
    displayDock();
  }
  
  public void displayDock() {
	// setup labels
    this.dockNameLabel.setText(dock.getName());
    this.addressLabel.setText("Address: " + dock.getAddress());
    this.emptySlotLabel.setText("Empty: " + (dock.getMaxSlot() - dock.getAvaiSlot()));
    this.availableLabel.setText("Available: " + dock.getAvaiSlot());
    // setup button
    this.toDockBtn.setOnMouseClicked(e -> {
      try {
        MenuHandler dockMenu = new MenuHandler(this.homeScreen.getStage(), Configs.DOCK_MENU_PATH, this.dock);
        dockMenu.setPreviousScreen(this.homeScreen);
        dockMenu.show();
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    });
  }
}
