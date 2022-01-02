package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.search.SearchDockController;
import controller.search.SearchDockNameController;
import entity.dock.Dock;

/**
 * 
 * @author Admin
 *
 */
public class HomeController extends BaseController {
  private SearchDockController searchController;
  
  public HomeController() {
	  this.searchController = new SearchDockNameController(); // set default search mode = by name
  }
  
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
   * @return ArrayList<Dock> list of the matching dock if there is any
   * @throws InvalidSearchKeyException if user input blank key
   * @throws NoResultException if there is no matching dock found
   * @throws SQLException 
   */
  public ArrayList<Dock> search(String key) throws InvalidSearchKeyException, NoResultException, SQLException {
	  ArrayList<Dock> result = this.searchController.searchDock(key);
	  return result;
  }
}
