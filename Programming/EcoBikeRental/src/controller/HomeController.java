package controller;

import controller.search.SearchDockController;

public class HomeController extends BaseController {
  private SearchDockController searchController;
  
  public void setSearchController(SearchDockController searchController) {
	  this.searchController = searchController;
  }
}
