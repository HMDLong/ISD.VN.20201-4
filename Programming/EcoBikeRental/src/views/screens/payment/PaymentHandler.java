package views.screens.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class PaymentHandler extends BaseScreenHandler implements Initializable {
	@FXML
	private TextField ownerField, cardNumField, expiryField, cvvField;
	
	@FXML
	private Button cancelBtn, submitBtn;
	
	@FXML
	private RadioButton creditCardRadio;

	public PaymentHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.cancelBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		this.submitBtn.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
	}
}
