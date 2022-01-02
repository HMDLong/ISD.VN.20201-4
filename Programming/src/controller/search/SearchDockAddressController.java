package controller.search;

import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import entity.dock.Dock;

/**
 * 
 * @author Admin
 *
 */
public class SearchDockAddressController extends SearchDockController {

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
