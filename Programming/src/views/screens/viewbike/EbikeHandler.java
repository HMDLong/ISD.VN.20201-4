package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import entity.bike.Ebike;
import factory.handler.BikeHandlerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import utils.Configs;
import utils.MyTime;

public class EbikeHandler extends BikeHandler {
//	static {
//		BikeHandlerFactory.getFactory().register("electric", new EbikeHandler());
//	}
	@FXML
	private Label remainTimeLabel;
	
	@FXML
	private Label batteryLabel;
	
	public EbikeHandler(String screenPath, Ebike bike) throws IOException {
		super(screenPath, bike);
		this.batteryLabel.setText("" + bike.getBattery() + " %");
		this.remainTimeLabel.setText(MyTime.minutesToTimeFormat(bike.getRemainTime()));
	}
	
	public EbikeHandler() {}

	@Override
	public EbikeHandler createBikeHandler(Bike bike) throws IOException {
		// TODO Auto-generated method stub
		return new EbikeHandler(Configs.E_BIKE_PATH, (Ebike) bike);
	}
}
