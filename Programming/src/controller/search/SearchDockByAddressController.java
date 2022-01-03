package controller.search;

import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import entity.dock.Dock;

/**
  * This method search for a dock by dock address.
   *
   * @param key the search key user enter
   * @return ArrayList<Dock> list of the matching dock if there is any
   * @throws InvalidSearchKeyException if user input blank key
   * @throws SQLException throws if error occurs during query 
 */
public class SearchDockByAddressController extends SearchDockController {

  @Override
  public ArrayList<Dock> searchDock(String address) throws InvalidSearchKeyException, SQLException {
    validateSearchKey(address);
    ArrayList<Dock> result = new ArrayList<>();
    for(Dock dock : Dock.getAllDocks()) {
    	if(dock.getAddress().equals(address)) {
    		result.add(dock);
    	}
    }
    return result;
  }
}
