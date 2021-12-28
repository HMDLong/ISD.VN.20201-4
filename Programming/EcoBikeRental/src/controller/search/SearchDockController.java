package controller.search;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.BaseController;
import entity.dock.Dock;

public abstract class SearchDockController extends BaseController {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws NoResultException
	 * @throws InvalidSearchKeyException
	 */
  public abstract Dock searchDock(String key) throws NoResultException, InvalidSearchKeyException;
  
  /**
   * This method validates search key inputed from user.
   *
   * @param key the search key that user entered
   * @throws InvalidSearchKeyException throws if the given search key is invalid(empty/full whitespace) 
   */
  public void validateSearchKey(String key) throws InvalidSearchKeyException {
	  if(key.isBlank()) {
		  throw new InvalidSearchKeyException("Empty search key");
	  }
  }
}
