package views.screens;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.exception.EmptyDockException;
import controller.RentBikeController;
import controller.ViewBikeController;
import entity.bike.Bike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.rent.RentHandler;
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
		this.dockAddressLabel.setText(dock.getAddress());
		this.dockAreaLabel.setText("" + dock.getArea());
		this.distanceLabel.setText("100m");
		this.walktimeLabel.setText("10 min");
		this.dockNameLabel.setText(dock.getName());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dockBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		returnBtn.setOnMouseClicked(e -> {
			
		});
		
		rentBtn.setOnMouseClicked(e -> {
			RentBikeController rentCtrl = new RentBikeController();
			// do something if necessary here
			try {
				RentHandler rentScreen = new RentHandler(this.stage, Configs.RENT_SCREEN_PATH);
				rentScreen.setPreviousScreen(this);
				rentScreen.setBaseController(rentCtrl);
				rentScreen.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		viewBikeBtn.setOnMouseClicked(e -> {
			ViewBikeController bikeCtrl = new ViewBikeController();
			try {
				ArrayList<Bike> bikelist = bikeCtrl.requestViewBikes(this.dock);
				ViewBikeHandler bikeScreen = new ViewBikeHandler(this.stage, Configs.VIEW_BIKES_PATH, bikelist);
				bikeScreen.setPreviousScreen(this);
				bikeScreen.show();
			} catch (EmptyDockException e1) {
				System.out.println(e1.getMessage());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
