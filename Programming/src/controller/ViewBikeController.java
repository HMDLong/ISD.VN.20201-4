package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.EmptyDockException;
import entity.bike.Bike;
import entity.dock.Dock;

public class ViewBikeController extends BaseController {
  public void requestDockList() {
    // TODO
  }
	  
  public ArrayList<Bike> requestViewBikes(Dock dock) throws EmptyDockException, SQLException {
    // TODO
    ArrayList<Bike> bikelist = dock.getBikes();
    if(bikelist.size() == 0) {
      throw new EmptyDockException("No bikes in the dock");
    }
    return bikelist;
  }
}
