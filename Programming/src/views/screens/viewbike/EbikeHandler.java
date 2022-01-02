package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import factory.handler.BikeHandlerFactory;
import utils.Configs;

public class EbikeHandler extends BikeHandler {
//	static {
//		BikeHandlerFactory.getFactory().register("electric", new EbikeHandler());
//	}
	
	public EbikeHandler(String screenPath, Bike bike) throws IOException {
		super(screenPath, bike);
	}
	
	public EbikeHandler() {}

	@Override
	public EbikeHandler createBikeHandler(Bike bike) throws IOException {
		// TODO Auto-generated method stub
		return new EbikeHandler(Configs.E_BIKE_PATH, bike);
	}
}
