package views.screens.viewbike;

import java.io.IOException;
import java.util.ArrayList;

import entity.bike.Bike;
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class ViewBikeHandler extends BaseScreenHandler{
	
	
	private ArrayList<Bike> bikelist;
	
	public ViewBikeHandler(Stage stage, String screenPath, ArrayList<Bike> bikelist) throws IOException {
		super(stage, screenPath);
		this.bikelist = bikelist;
	}
}
