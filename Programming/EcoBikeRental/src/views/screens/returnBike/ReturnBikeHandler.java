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
import javafx.stage.Stage;
import views.screens.BaseScreenHandler;

public class ReturnBikeHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private Button backBtn;
//	@FXML
//	private Label rentIdLabel, startRentLabel, returnTimeLabel, returnDockLabel, bikeIdLabel, rentTypeLabel, depositLabel, rentFeeLabel, refundLabel, amoutLabel;
	private Dock dock;
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
//		
//		this.rentIdLabel.setText(invoice.get("INVOICE_ID"));
//		this.startRentLabel.setText(invoice.get("START"));
//		this.returnTimeLabel.setText(invoice.get("REN_TIME"));
//		this.returnDockLabel.setText(invoice.get("BIKE_ID"));
//		this.bikeIdLabel.setText(invoice.get("BIKE_ID"));
//		this.rentTypeLabel.setText(invoice.get("RENT_TYPE"));
//		this.depositLabel.setText(invoice.get("DEPOSIT_MONEY"));
//		this.rentFeeLabel.setText(invoice.get("RENT_FEE"));
//		this.refundLabel.setText(invoice.get("REFUND"));
//		this.amoutLabel.setText(invoice.get("AMOUNT"));

		this.backBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
	}
	
}
