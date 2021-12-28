package controller;

import java.util.ArrayList;

import common.exception.EmptyDockException;
import entity.bike.Bike;
import entity.dock.Dock;

public class ViewBikeController extends BaseController {
  public void requestDockList() {
    // TODO
  }
	  
  public void requestViewBikes(Dock dock) throws EmptyDockException {
    // TODO
    ArrayList<Bike> bikelist = dock.getBikes();
    if(bikelist.size() == 0) {
      throw new EmptyDockException("No bikes in the dock");
    }
    
  }
}
