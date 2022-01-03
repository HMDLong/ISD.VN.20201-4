package views.screens.rent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import common.exception.EmptyDockException;
import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.HomeController;
import controller.PaymentController;
import controller.RentBikeController;
import controller.ViewBikeController;
import controller.search.SearchDockByNameController;
import entity.dock.Dock;
import factory.handler.BikeHandlerFactory;
import entity.bike.Bike;
import entity.bike.Ebike;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;
import views.screens.dock.DockHandler;
import views.screens.payment.PaymentHandler;
import views.screens.viewbike.BikeHandler;
import views.screens.viewbike.ViewBikeHandler;

public class RentHandler extends BaseScreenHandler implements Initializable {
	
	@FXML
	private Button rentBackBtn, confirmBtn, selectBike;
	@FXML
	private Label bikeStatus, bikeType, bikeBattery, bikeId,  rentMethodInfo, notAvaiableBike;
	@FXML
	private TextField barcodeField;
	
	@FXML
	private RadioButton stdRentRadio;
	private Dock dock;

	public RentHandler(Stage stage, String screenPath, Dock dock) throws IOException {
		super(stage, screenPath);
		this.dock = dock;
		disableAllBtn();
	}
	private Map<String, String> result = null ;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.selectBike.setOnMouseClicked(e -> {
			try {
//				ArrayList<Bike> bikelist = bikeCtrl.requestViewBikes(this.dock);
	    		RentBikeController rentCtrl = (RentBikeController) this.getBaseController();
	    		rentCtrl.setCurrentDock(dock);
	    		result = rentCtrl.getBikeInfo(barcodeField.getText());
	    		System.out.printf(result.get("RESULT"));
	    		
	    		if(result.get("RESULT").equals("SUCESSFULL")) {
	    			String bikeType = result.get("TYPE");
	    			String bikeCode = result.get("BIKECODE");
	    			String image_url = result.get("IMAGE_URL");
	    			String battery = result.get("BATTERY");
	    			String bikeId = result.get("BIKECODE");
	    			showRentBike(bikeType, bikeCode, image_url, battery, bikeId);
		    		showRentMethodInfo(result.get("RENTINFO"));
		    		undisableAllBtn(false,1);
		    		if(result.get("STATE").equals("Renting")) {
		    			this.confirmBtn.setOpacity(0);
		    			this.confirmBtn.setDisable(true);
		    		}
		    		
	    		}else if(result.get("RESULT").equals("BIKE NOT AVAILBLE")){
	    			this.notAvaiableBike.setText("BIKE NOT AVAILBLE");
	    			undisableAllBtn(true,0);
	    		}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    });
		this.rentBackBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		this.confirmBtn.setOnMouseClicked(e -> {
			try {
//				if(rentBike != null) {
					PaymentHandler payScreen = new PaymentHandler(this.stage, Configs.PAYMENT_PATH, result.get("DEPOSIT"), this.dock);
					payScreen.setBaseController(new PaymentController());
					payScreen.setPreviousScreen(this);
					payScreen.show();
//				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		this.stdRentRadio.setOnMouseClicked(e -> {
			stdRentRadio.setSelected(true);
		});
		
		this.barcodeField.clear();
	}
	private void showRentBike(String bikeType, String bikeCode, String img_url, String battery, String bikeId) {
		this.bikeId.setText("Bike ID: " + bikeId);
	    this.bikeType.setText("Bike Type: " + bikeType);
	    if(battery != null) {
		    this.bikeBattery.setText("Battery: " + battery + "%");
	    }
	    this.bikeStatus.setText("Status: Ready");

	  }
	private void showRentMethodInfo(String info) {
		this.rentMethodInfo.setText(info);
	}
	private void disableAllBtn() {
		
		this.confirmBtn.setOpacity(0);
		this.confirmBtn.setDisable(true);
		this.bikeStatus.setOpacity(0);
		this.bikeStatus.setDisable(true);
		this.bikeType.setOpacity(0);
		this.bikeType.setDisable(true);
		this.bikeBattery.setOpacity(0);
		this.bikeBattery.setDisable(true);
		this.bikeId.setOpacity(0);
		this.bikeId.setDisable(true);
		this.rentMethodInfo.setOpacity(0);
		this.rentMethodInfo.setDisable(true);
		this.notAvaiableBike.setOpacity(0);
		this.notAvaiableBike.setDisable(true);
		this.confirmBtn.setOpacity(0);
		this.confirmBtn.setDisable(true);
		this.stdRentRadio.setDisable(true);
		this.stdRentRadio.setOpacity(0);


	}
	private void undisableAllBtn(boolean check, int c) {
		this.confirmBtn.setOpacity(c);
		this.confirmBtn.setDisable(check);
		this.bikeStatus.setOpacity(c);
		this.bikeStatus.setDisable(check);
		this.bikeType.setOpacity(c);
		this.bikeType.setDisable(check);
		this.bikeBattery.setOpacity(c);
		this.bikeBattery.setDisable(check);
		this.bikeId.setOpacity(c);
		this.bikeId.setDisable(check);
		this.rentMethodInfo.setOpacity(c);
		this.rentMethodInfo.setDisable(check);
		this.notAvaiableBike.setOpacity(1-c);
		this.notAvaiableBike.setDisable(!check);
		this.confirmBtn.setOpacity(c);
		this.confirmBtn.setDisable(check);
		this.stdRentRadio.setDisable(check);
		this.stdRentRadio.setOpacity(c);
	}
}
