package controller.search;

import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import entity.dock.Dock;

public class SearchDockAddressController extends SearchDockController {

  @Override
  public ArrayList<Dock> searchDock(String address) throws InvalidSearchKeyException {
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
