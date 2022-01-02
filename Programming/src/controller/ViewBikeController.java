package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.EmptyDockException;
import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import entity.bike.Bike;
import entity.dock.Dock;

/**
 * Controller class for view bikes in dock use case.
 *
 * @author Group4
 *
 */
public class ViewBikeController extends BaseController {
	/**
	 * This method view total bike in material dock.
	 *
	 * @param key the dock for view bike
	 * @return ArrayList<Bike> list of result bike
	 * @throws EmptyDockException throws if there is no matching dock
	 * @throws SQLException throws if error occurs during query
	 */
  public ArrayList<Bike> requestViewBikes(Dock dock) throws EmptyDockException, SQLException {
    // TODO
    ArrayList<Bike> bikelist = dock.getBikes();
    if(bikelist.size() == 0) {
      throw new EmptyDockException("No bikes in the dock");
    }
    return bikelist;
  }
}
