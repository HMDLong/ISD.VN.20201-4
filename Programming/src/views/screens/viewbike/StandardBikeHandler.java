package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import factory.handler.BikeHandlerFactory;
import utils.Configs;

public class StandardBikeHandler extends BikeHandler {
//	static {
//		BikeHandlerFactory.getFactory().register("standard", new StandardBikeHandler());
//	}
	
	public StandardBikeHandler(String screenPath, Bike bike) throws IOException {
		super(screenPath, bike);
	}
	
	public StandardBikeHandler() {}
	
	@Override
	public StandardBikeHandler createBikeHandler(Bike bike) throws IOException {
		return new StandardBikeHandler(Configs.STD_BIKE_PATH, bike);
	}
}
