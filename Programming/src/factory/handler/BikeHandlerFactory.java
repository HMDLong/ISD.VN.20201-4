package factory.handler;

import java.io.IOException;
import java.util.HashMap;

import entity.bike.Bike;
import entity.bike.Ebike;
import views.screens.viewbike.BikeHandler;
import views.screens.viewbike.EbikeHandler;
import views.screens.viewbike.StandardBikeHandler;

public class BikeHandlerFactory {
	private static BikeHandlerFactory factory;
	private static HashMap<String, BikeHandler> registerMap = new HashMap<>();
	
	public void register(String bikeType, BikeHandler handler) {
		registerMap.put(bikeType, handler);
	}
	
	private BikeHandlerFactory() {
		register("standard", new StandardBikeHandler());
		register("electric", new EbikeHandler());
	}
	
	public static BikeHandlerFactory getFactory() {
		if(factory == null) factory = new BikeHandlerFactory();
		return factory;
	}
	
	public BikeHandler create(Bike bike) throws IOException {
	    String bikeGenericType = bike.getBikeType().split(" ")[0];
		return registerMap.get(bikeGenericType).createBikeHandler(bike);
	}
}
