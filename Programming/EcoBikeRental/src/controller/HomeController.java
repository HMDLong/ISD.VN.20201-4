package controller;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.search.SearchDockController;
import entity.dock.Dock;

public class HomeController extends BaseController {
  private SearchDockController searchController;
  
  /**
   * 
   * @param searchController
   */
  public void setSearchController(SearchDockController searchController) {
	  this.searchController = searchController;
  }
  
  /**
   * This method search for a dock match user key.
   *
   * @param key the search key user enter
   * @return Dock the matching dock if there is any
   * @throws InvalidSearchKeyException if user input blank key
   * @throws NoResultException if there is no matching dock found
   */
  public Dock search(String key) throws InvalidSearchKeyException, NoResultException {
	  Dock result = this.searchController.searchDock(key);
	  return result;
  }
}
