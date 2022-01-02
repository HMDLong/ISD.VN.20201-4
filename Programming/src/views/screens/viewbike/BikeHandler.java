package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import javafx.scene.layout.Pane;
import views.screens.FXMLScreenHandler;

public abstract class BikeHandler extends FXMLScreenHandler {
	protected Pane content;
	protected Bike bike;
	
	protected BikeHandler() {}
	
	public BikeHandler(String screenPath, Bike bike) throws IOException {
		super(screenPath);
		this.content = (Pane) this.getLoader().load();
		this.bike = bike;
	}
	
	public abstract BikeHandler createBikeHandler(Bike bike) throws IOException;
	
	public Pane getContent() {
		return this.content;
	}
}
