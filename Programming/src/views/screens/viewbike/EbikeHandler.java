package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import entity.bike.Ebike;
import factory.handler.BikeHandlerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import utils.Configs;

public class EbikeHandler extends BikeHandler {
//	static {
//		BikeHandlerFactory.getFactory().register("electric", new EbikeHandler());
//	}
	@FXML
	private Label batteryLabel, optTimeLabel;
	
	public EbikeHandler(String screenPath, Ebike bike) throws IOException {
		super(screenPath, bike);
		this.batteryLabel.setText("" + bike.getBattery());
		this.optTimeLabel.setText("1:30:00");
	}
	
	public EbikeHandler() {}

	@Override
	public EbikeHandler createBikeHandler(Bike bike) throws IOException {
		// TODO Auto-generated method stub
		return new EbikeHandler(Configs.E_BIKE_PATH, (Ebike) bike);
	}
}
