package controller.search;

import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import entity.dock.Dock;

public class SearchDockNameController extends SearchDockController {
  
  @Override
  public ArrayList<Dock> searchDock(String name) throws InvalidSearchKeyException {
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
