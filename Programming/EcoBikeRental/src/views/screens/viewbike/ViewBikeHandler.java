package views.screens.viewbike;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.bike.Bike;
import entity.bike.Ebike;
import factory.handler.BikeHandlerFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;

public class ViewBikeHandler extends BaseScreenHandler implements Initializable{
	
	@FXML
	private Button bikeBackBtn;
	
	@FXML
	private VBox bikelistVBox;
	
	private ArrayList<Bike> bikelist;
	
	public ViewBikeHandler(Stage stage, String screenPath, ArrayList<Bike> bikelist) throws IOException {
		super(stage, screenPath);
		this.bikelist = bikelist;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bikelistVBox.getChildren().clear();
		try {
			BikeHandler bikeHandler = BikeHandlerFactory.getFactory().create("standard", new Bike());
			bikelistVBox.getChildren().add(bikeHandler.getContent());
			BikeHandler bikeHandler1 = BikeHandlerFactory.getFactory().create("electric", new Ebike());
			bikelistVBox.getChildren().add(bikeHandler1.getContent());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		bikeBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
	}
}
