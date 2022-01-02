package factory.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import entity.bike.Bike;
import entity.bike.Ebike;
import views.screens.viewbike.BikeHandler;
import views.screens.viewbike.EbikeHandler;
import views.screens.viewbike.StandardBikeHandler;

/**
 * Represent for handle bike factory.
 *
 * @author Group4
 *
 */
public class BikeHandlerFactory {
 
	private static BikeHandlerFactory factory;
	private static HashMap<String, BikeHandler> registerMap = new HashMap<>();
	
	/**
	 * 
	 * @param bikeType
	 * @param handler
	 */
	public void register(String bikeType, BikeHandler handler) {
		registerMap.put(bikeType, handler);
	}
	
	/**
	 * This method for create bike
	 *
	 */
	private BikeHandlerFactory() {
		register("standard", new StandardBikeHandler());
		register("electric", new EbikeHandler());
	}
	
	public static BikeHandlerFactory getFactory() {
		if(factory == null) factory = new BikeHandlerFactory();
		return factory;
	}
	
	 /**
	   * 
	   * @param res
	   * @return bike
	   * @throws SQLException throws if error occurs during query
	   */
	public BikeHandler create(Bike bike) throws IOException {
	    String bikeGenericType = bike.getBikeType().split(" ")[0];
		return registerMap.get(bikeGenericType).createBikeHandler(bike);
	}
}
