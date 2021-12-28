package controller.search;

import common.exception.InvalidSearchKeyException;
import entity.dock.Dock;

public class SearchDockNameController extends SearchDockController {
  
  @Override
  public Dock searchDock(String name) throws InvalidSearchKeyException {
    validateSearchKey(name);
    // search here
    return null;
  }
}
