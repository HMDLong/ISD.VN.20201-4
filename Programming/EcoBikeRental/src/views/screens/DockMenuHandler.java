package views.screens;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.exception.EmptyDockException;
import controller.ViewBikeController;
import entity.bike.Bike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.viewbike.ViewBikeHandler;

public class DockMenuHandler extends BaseScreenHandler implements Initializable{
	
	@FXML
	private Button dockBackBtn, returnBtn, rentBtn, viewBikeBtn;
	
	@FXML
	private Label dockAddressLabel, dockAreaLabel, distanceLabel, walktimeLabel, dockNameLabel;
	
	private Dock dock;
	
	public DockMenuHandler(Stage stage, String screenPath, Dock dock) throws IOException {
		super(stage, screenPath);
		this.dock = dock;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.dockAddressLabel.setText(this.dock.getAddress());
		this.dockAreaLabel.setText("" + this.dock.getArea());
		this.distanceLabel.setText("100m");
		this.walktimeLabel.setText("10 min");
		dockBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		returnBtn.setOnMouseClicked(e -> {
			
		});
		
		rentBtn.setOnMouseClicked(e -> {
			
		});
		
		viewBikeBtn.setOnMouseClicked(e -> {
			ViewBikeController bikeCtrl = new ViewBikeController();
			try {
				ArrayList<Bike> bikelist = bikeCtrl.requestViewBikes(this.dock);
				ViewBikeHandler bikeScreen = new ViewBikeHandler(this.stage, Configs.VIEW_BIKES_PATH, bikelist);
				bikeScreen.setPreviousScreen(this);
				bikeScreen.show();
			} catch (EmptyDockException e1) {
				e1.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
	
	
}
