package controller.search;

import common.exception.InvalidSearchKeyException;
import entity.dock.Dock;

public class SearchDockAddressController extends SearchDockController {

  @Override
  public Dock searchDock(String address) throws InvalidSearchKeyException {
    validateSearchKey(address);
    // search here
    return null;
  }

}
