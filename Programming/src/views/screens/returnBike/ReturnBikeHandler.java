package views.screens.returnBike;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import controller.ReturnBikeController;
import entity.dock.Dock;
import entity.invoice.Invoice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class ReturnBikeHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private Button backBtn, returnBtn;
	@FXML
	private Label aLabel, rentIdLabel, startRentLabel, returnTimeLabel, bikeIdLabel, rentTypeLabel, depositLabel, rentFeeLabel, refundLabel, amoutLabel
	, rentLabel, startLabel, timeLabel, bikeLabel, typeLabel, dLabel, reLabel, refLabel, ownLabel, caLabel, exLabel, seLabel;
	private Dock dock;
	@FXML
	private TextField ownerRField, cardNumRField, expiryRField, cvvRField;
	
	@FXML
	private Label ownerRLabel, numberRLabel, dateRLabel, cvvRLabel, rentRInfo;
	public ReturnBikeHandler(Stage stage, String screenPath, Dock dock) throws IOException {
		super(stage, screenPath);
		this.dock = dock;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ReturnBikeController returnBike = new ReturnBikeController();
		returnBike.setCurrentDock(this.dock);
		Map<String, String> invoiceInfo = returnBike.getInvoiceInfo();
		if(invoiceInfo.get("STATE").equals("RETING")) {
			this.rentIdLabel.setText(invoiceInfo.get("INVOICE_ID"));
			this.startRentLabel.setText(invoiceInfo.get("START"));
			this.returnTimeLabel.setText(invoiceInfo.get("REN_TIME"));
			this.bikeIdLabel.setText(invoiceInfo.get("BIKE_ID"));
			this.rentTypeLabel.setText(invoiceInfo.get("RENT_TYPE"));
			this.depositLabel.setText(invoiceInfo.get("DEPOSIT_MONEY"));
			this.rentFeeLabel.setText(invoiceInfo.get("RENT_FEE"));
			this.refundLabel.setText(invoiceInfo.get("REFUND"));
			this.amoutLabel.setText(invoiceInfo.get("AMOUNT"));
			this.returnBtn.setOnMouseClicked(e -> {
				returnBike.setCurrentDock(this.dock);
				returnBike.returnBike(cardNumRField.getText(), ownerRField.getText(), expiryRField.getText(), cvvRField.getText());
			});
		}else {
			disable();
		}
		
		this.backBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
	}
	
	private void disable() {
		this.rentIdLabel.setDisable(true);
		this.rentIdLabel.setOpacity(0);
		this.startRentLabel.setDisable(true);
		this.startRentLabel.setOpacity(0);
		this.returnTimeLabel.setDisable(true);
		this.returnTimeLabel.setOpacity(0);
		this.bikeIdLabel.setDisable(true);
		this.bikeIdLabel.setOpacity(0);
		this.rentTypeLabel.setDisable(true);
		this.rentTypeLabel.setOpacity(0);
		this.depositLabel.setDisable(true);
		this.depositLabel.setOpacity(0);
		
		this.rentFeeLabel.setDisable(true);
		this.rentFeeLabel.setOpacity(0);
		this.refundLabel.setDisable(true);
		this.refundLabel.setOpacity(0);
		this.amoutLabel.setDisable(true);
		this.amoutLabel.setOpacity(0);
		this.rentLabel.setDisable(true);
		this.rentLabel.setOpacity(0);
		
		this.startLabel.setDisable(true);
		this.startLabel.setOpacity(0);
		
		this.timeLabel.setDisable(true);
		this.timeLabel.setOpacity(0);
		this.bikeLabel.setDisable(true);
		this.bikeLabel.setOpacity(0);
		this.typeLabel.setDisable(true);
		this.typeLabel.setOpacity(0);
		this.dLabel.setDisable(true);
		this.dLabel.setOpacity(0);
		
		this.reLabel.setDisable(true);
		this.reLabel.setOpacity(0);
		this.refLabel.setDisable(true);
		this.refLabel.setOpacity(0);this.ownLabel.setDisable(true);
		this.ownLabel.setOpacity(0);
		this.caLabel.setDisable(true);
		this.caLabel.setOpacity(0);
		
		this.exLabel.setDisable(true);
		this.exLabel.setOpacity(0);this.seLabel.setDisable(true);
		this.seLabel.setOpacity(0);
		
		this.ownerRField.setDisable(true);
		this.ownerRField.setOpacity(0);
		this.cardNumRField.setDisable(true);
		this.cardNumRField.setOpacity(0);
		this.expiryRField.setDisable(true);
		this.expiryRField.setOpacity(0);
		this.cvvRField.setDisable(true);
		this.cvvRField.setOpacity(0);
		this.returnBtn.setDisable(true);
		this.returnBtn.setOpacity(0);
		this.aLabel.setDisable(true);
		this.aLabel.setOpacity(0);
	
	}
	
}
