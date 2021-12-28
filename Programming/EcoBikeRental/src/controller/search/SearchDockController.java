package controller.search;

import controller.BaseController;
import entity.dock.Dock;

public abstract class SearchDockController extends BaseController {
  public abstract Dock searchDock(String key);
}
