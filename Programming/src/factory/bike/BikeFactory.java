package factory.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import entity.bike.Bike;
import entity.bike.Ebike;

/**
 * Represent for bike factory.
 *
 * @author Group4
 *
 */
public class BikeFactory {
  
  private HashMap<String, Bike> registryMap = new HashMap<>();
  private static BikeFactory factory;
  /**
	 * This method for create bike
	 *
	 */
  public BikeFactory() {
    register("standard", new Bike());
    register("electric", new Ebike());
  }
  
  /**
   * 
   * @param bikeType
   * @param bike
   */
  public void register(String bikeType, Bike bike) {
    this.registryMap.put(bikeType, bike);
  }
  
  public static BikeFactory getFactory() {
    if(factory == null) factory = new BikeFactory();
    return factory;
  }
  
  /**
   * 
   * @param res
   * @return bike
   * @throws SQLException throws if error occurs during query
   */
  public Bike create(ResultSet res) throws SQLException {
    String bikeGenericType = res.getString("type_name").split(" ")[0];
    return this.registryMap.get(bikeGenericType).createBike(res);
  }
}
