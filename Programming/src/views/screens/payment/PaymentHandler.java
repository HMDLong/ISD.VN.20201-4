package views.screens.payment;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.ResourceBundle;

import controller.RentBikeController;
import entity.bike.Bike;
import entity.dock.Dock;
import controller.PaymentController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class PaymentHandler extends BaseScreenHandler implements Initializable {
	@FXML
	private TextField ownerField, cardNumField, expiryField, cvvField;
	
	@FXML
	private Label depositRentBike,ownerLabel, numberLabel, dateLabel, cvvLabel, methodLabel, rentInfo;
	@FXML
	private Button cancelBtn, submitBtn, okeBtn, goHomeBtn;
	
	@FXML
	private RadioButton creditCardRadio;
	private Dock dock;

	public PaymentHandler(Stage stage, String screenPath, String deposit, Dock dock) throws IOException {
		super(stage, screenPath);
		depositRentBike.setText("Deposit: " + deposit + "VND");
		this.okeBtn.setOpacity(0);
		this.okeBtn.setDisable(true);
		this.goHomeBtn.setOpacity(0);
		this.goHomeBtn.setDisable(true);
		this.rentInfo.setOpacity(0);
		this.rentInfo.setDisable(true);
		this.dock = dock;

//		this.submitBtn.setDisable(false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.cancelBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		
		this.submitBtn.setOnMouseClicked(e -> {
			if(!cardNumField.getText().equals("")  && !ownerField.getText().equals("") && !expiryField.getText().equals("") && !cvvField.getText().equals("")) {
				disableAllBtn();

				RentBikeController payCtrl = new RentBikeController();
				payCtrl.setCurrentDock(this.dock);
				Map<String, String> responseToPay = new Hashtable<String, String>();
	    		responseToPay = payCtrl.rent(cardNumField.getText(), ownerField.getText(), expiryField.getText(), cvvField.getText());
	    		if(responseToPay.get("RESULT").equals("RENT FAILED!")) {
	    			
	    			this.rentInfo.setOpacity(1);
	    			this.rentInfo.setDisable(false);    			
	    			this.okeBtn.setOpacity(1);
	    			this.okeBtn.setDisable(false);
	    			this.rentInfo.setText(responseToPay.get("MESSAGE"));
	    		}else {
	    			this.rentInfo.setOpacity(1);
	    			this.rentInfo.setDisable(false);
	    			this.goHomeBtn.setOpacity(1);
	    			this.goHomeBtn.setDisable(false);
	    			this.rentInfo.setText("Rent successful");
	    		}
			}
			
    		//homeScreenHandler.show();
		});
		this.okeBtn.setOnMouseClicked(e -> {
			this.okeBtn.setDisable(true);
			this.okeBtn.setOpacity(0);
			this.rentInfo.setDisable(true);
			this.rentInfo.setOpacity(0);
			this.cancelBtn.setOpacity(0);
			this.cancelBtn.setDisable(false);


			undisableAllBtn();
		});
		this.goHomeBtn.setOnMouseClicked(e -> {
			this.goHomeBtn.setDisable(true);
			this.goHomeBtn.setOpacity(0);
			this.rentInfo.setDisable(true);
			this.rentInfo.setOpacity(0);

			homeScreenHandler.show();
		});
	}
	
	private void disableAllBtn() {
		this.ownerField.setOpacity(0);
		this.cardNumField.setOpacity(0);
		this.expiryField.setOpacity(0);
		this.cvvField.setOpacity(0);
		this.submitBtn.setOpacity(0);
		this.depositRentBike.setOpacity(0);
		this.ownerLabel.setOpacity(0);
		this.numberLabel.setOpacity(0);
		this.dateLabel.setOpacity(0);
		this.methodLabel.setOpacity(0);
		this.cancelBtn.setOpacity(0);
		this.cvvLabel.setOpacity(0);
		this.creditCardRadio.setOpacity(0);
		this.ownerField.setDisable(true);
		this.cardNumField.setDisable(true);
		this.expiryField.setDisable(true);
		this.cvvField.setDisable(true);
		this.submitBtn.setDisable(true);
		this.depositRentBike.setDisable(true);
		this.ownerLabel.setDisable(true);
		this.numberLabel.setDisable(true);
		this.dateLabel.setDisable(true);
		this.methodLabel.setDisable(true);
		this.cvvLabel.setDisable(true);
		this.creditCardRadio.setDisable(true);
		this.cancelBtn.setDisable(true);

	}
	private void undisableAllBtn() {
		this.ownerField.setOpacity(1);
		this.cardNumField.setOpacity(1);
		this.expiryField.setOpacity(1);
		this.cvvField.setOpacity(1);
		this.cancelBtn.setOpacity(1);
		this.submitBtn.setOpacity(1);
		this.depositRentBike.setOpacity(1);
		this.ownerLabel.setOpacity(1);
		this.numberLabel.setOpacity(1);
		this.dateLabel.setOpacity(1);
		this.methodLabel.setOpacity(1);
		this.cvvLabel.setOpacity(1);
		this.creditCardRadio.setOpacity(1);
		this.ownerField.setDisable(false);
		this.cardNumField.setDisable(false);
		this.expiryField.setDisable(false);
		this.cvvField.setDisable(false);
		this.submitBtn.setDisable(false);
		this.depositRentBike.setDisable(false);
		this.ownerLabel.setDisable(false);
		this.numberLabel.setDisable(false);
		this.dateLabel.setDisable(false);
		this.methodLabel.setDisable(false);
		this.cvvLabel.setDisable(false);
		this.creditCardRadio.setDisable(false);
	}
}
