package views.screens.rent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;

public class RentHandler extends BaseScreenHandler implements Initializable {
	
	@FXML
	private Button rentBackBtn, confirmBtn;
	
	@FXML
	private TextField bikecodeField;
	
	@FXML
	private RadioButton stdRentRadio, dayRentRadio;
	
	public RentHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.rentBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		this.confirmBtn.setOnMouseClicked(e -> {
			try {
				DepositHandler depositScreen = new DepositHandler(this.stage, Configs.DEPOSIT_PATH);
				depositScreen.setPreviousScreen(this);
				depositScreen.show();
			} catch(Exception ex) {
				System.out.println("Something happened!!");
			}
		});
		
		this.stdRentRadio.setOnMouseClicked(e -> {
			stdRentRadio.setSelected(true);
			dayRentRadio.setSelected(false);
		});
		
		this.dayRentRadio.setOnMouseClicked(e -> {
			stdRentRadio.setSelected(false);
			dayRentRadio.setSelected(true);
		});
		
		this.bikecodeField.clear();
	}
}
