package views.screens.menu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.exception.EmptyDockException;
import controller.RentBikeController;
import controller.ReturnBikeController;
import controller.ViewBikeController;
import entity.bike.Bike;
import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;
import views.screens.rent.RentHandler;
import views.screens.returnBike.ReturnBikeHandler;
import views.screens.viewbike.ViewBikeHandler;

public class MenuHandler extends BaseScreenHandler implements Initializable{
	
	@FXML
	private Button dockBackBtn, returnBtn, rentBtn, viewBikeBtn;
	
	@FXML
	private Label dockAddressLabel, dockAreaLabel, distanceLabel, walktimeLabel, dockNameLabel;
	
	@FXML
	private ImageView dockImage;
	
	private Dock dock;
	
	public MenuHandler(Stage stage, String screenPath, Dock dock) throws IOException {
		super(stage, screenPath);
		this.dock = dock;
		this.dockAddressLabel.setText(dock.getAddress());
		this.dockAreaLabel.setText("" + dock.getArea());
		this.distanceLabel.setText("100m");
		this.walktimeLabel.setText("10 min");
		this.dockNameLabel.setText(dock.getName());
	    // setup image
	    File file = new File(this.dock.getImageUrl());
	    Image img = new Image(file.toURI().toString());
	    dockImage.setImage(img);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dockBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		returnBtn.setOnMouseClicked(e -> {
			ReturnBikeController returnctrl = new ReturnBikeController();
			try {
				ReturnBikeHandler returnScreen = new ReturnBikeHandler(this.stage, Configs.RETURN_SCREEN_PATH, this.dock);
				returnScreen.setPreviousScreen(this);
				returnScreen.setBaseController(returnctrl);
				returnScreen.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		);
		
		rentBtn.setOnMouseClicked(e -> {
			RentBikeController rentCtrl = new RentBikeController();
			// do something if necessary here
			try {
				RentHandler rentScreen = new RentHandler(this.stage, Configs.RENT_SCREEN_PATH, this.dock);
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
				System.out.println(ex.getMessage());
			}
		});
	}
}
