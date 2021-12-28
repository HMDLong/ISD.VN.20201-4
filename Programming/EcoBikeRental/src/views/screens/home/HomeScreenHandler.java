package views.screens.home;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.RentBikeController;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;
import views.screens.rent.RentHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {
  // get all fxml elements here
  @FXML
  private Button rentBikeBtn;

  @FXML
  private VBox dockListVBox;

  private ArrayList<Dock> docklist;

  @Override
  public void initialize(URL url, ResourceBundle bundle) {
    rentBikeBtn.setOnMouseClicked(e -> {
      RentHandler rentScreen;
      try {
        rentScreen = new RentHandler(this.stage, Configs.RENT_SCREEN_PATH);
        rentScreen.setHomeScreenHandler(this);
        rentScreen.setBaseController(new RentBikeController());
        rentScreen.show();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    });
    this.docklist = Dock.getAllDocks();
    showDockList();
  }

  public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
    super(stage, screenPath);
  }

  @Override
  public void show() {
    super.show();
  }

  private void showDockList() {
    dockListVBox.getChildren().clear();
    try {
      for (Dock dock : this.docklist) {
        DockHandler handler = new DockHandler(Configs.DOCK_PATH);
        handler.setDock(dock);
        dockListVBox.getChildren().add(handler.getContent());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
