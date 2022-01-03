package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import utils.Utils;
import views.screens.FXMLScreenHandler;

public abstract class BikeHandler extends FXMLScreenHandler {
    @FXML
    private Label bikeTypeLabel, bikecodeLabel, depositLabel, bikeName;
  
	protected Pane content;
	protected Bike bike;
	
	protected BikeHandler() {}
	
	public BikeHandler(String screenPath, Bike bike) throws IOException {
		super(screenPath);
		this.content = (Pane) this.getLoader().load();
		this.bike = bike;
		this.bikeTypeLabel.setText(bike.getBikeType());
		this.bikecodeLabel.setText(bike.getBikeCode());
		this.depositLabel.setText(Utils.getCurrencyFormat(bike.getDeposit()));
		this.bikeName.setText("Bike " + bike.getId());
	}
	
	public abstract BikeHandler createBikeHandler(Bike bike) throws IOException;
	
	public Pane getContent() {
		return this.content;
	}
}
