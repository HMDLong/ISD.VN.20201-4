package views.screens.home;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.HomeController;
import controller.RentBikeController;
import controller.search.SearchDockAddressController;
import controller.search.SearchDockNameController;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;
import views.screens.rent.RentHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {
  // get all FXML elements here
  @FXML
  private Button searchBtn, clearBtn;

  @FXML
  private VBox dockListVBox;
  
  @FXML
  private MenuButton searchByMenuBtn;
  
  @FXML
  private MenuItem searchByName, searchByAddress;
  
  @FXML
  private TextField searchField;

  @Override
  public void initialize(URL url, ResourceBundle bundle) {
    searchByName.setOnAction(e -> {
    	searchByMenuBtn.setText(searchByName.getText());
    	HomeController homeCtrl = (HomeController) this.getBaseController();
    	homeCtrl.setSearchController(new SearchDockNameController());
    	System.out.println("Search by Name, engine set!");
    });
    
    searchByAddress.setOnAction(e -> {
    	searchByMenuBtn.setText(searchByAddress.getText());
    	HomeController homeCtrl = (HomeController) this.getBaseController();
    	homeCtrl.setSearchController(new SearchDockAddressController());
    	System.out.println("Search by address, engine set!");
    });
    
    searchBtn.setOnMouseClicked(e -> {
    	try {
    		HomeController homeCtrl = (HomeController) this.getBaseController();
    		ArrayList<Dock> result = homeCtrl.search(searchField.getText());
    		showDockList(result);
    	} catch(InvalidSearchKeyException ex) {
    		System.out.println(ex.getMessage());
    	} catch(NoResultException ex) {
    		System.out.println(ex.getMessage());
    	} catch(Exception ex) {
    		System.out.println("Something happen unexpectedly");
    		ex.printStackTrace();
    	}
    });
    
    clearBtn.setOnMouseClicked(e -> {
    	showAllDocks();
    	searchField.clear();
    });
    
    showAllDocks();
  }

  public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
    super(stage, screenPath);
    this.setHomeScreenHandler(this);
  }

  @Override
  public void show() {
    super.show();
  }
  
  private void showAllDocks() {
	  showDockList(Dock.getAllDocks());
  }

  private void showDockList(ArrayList<Dock> docks) {
    dockListVBox.getChildren().clear();
    try {
      for (Dock dock : docks) {
        DockHandler handler = new DockHandler(Configs.DOCK_PATH, this);
        handler.setDock(dock);
        dockListVBox.getChildren().add(handler.getContent());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
