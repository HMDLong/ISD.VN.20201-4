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
public class SearchDockNameController extends SearchDockController {
  
  @Override
  public ArrayList<Dock> searchDock(String name) throws InvalidSearchKeyException, SQLException {
    validateSearchKey(name);
    ArrayList<Dock> result = new ArrayList<>();
    for(Dock dock : Dock.getAllDocks()) {
    	if(dock.getName().equals(name)) {
    		result.add(dock);
    	}
    }
    return result;
  }
}
