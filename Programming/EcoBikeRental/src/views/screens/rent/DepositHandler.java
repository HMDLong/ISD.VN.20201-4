package views.screens.rent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.PaymentController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Configs;
import views.screens.BaseScreenHandler;
import views.screens.payment.PaymentHandler;

public class DepositHandler extends BaseScreenHandler implements Initializable{

	@FXML
	private Button backBtn, confirmBtn;
	
	@FXML
	private Label bikeIdLabel, bikeTypeLabel, rentTypeLabel, depositLabel;
	
	@FXML
	private ImageView bikeImage;
	
	public DepositHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.backBtn.setOnMouseClicked(e -> {
			this.getPreviousScreen().show();
		});
		
		this.confirmBtn.setOnMouseClicked(e -> {
			try {
				PaymentHandler payScreen = new PaymentHandler(this.stage, Configs.PAYMENT_PATH);
				payScreen.setBaseController(new PaymentController());
				payScreen.setPreviousScreen(this);
				payScreen.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
}
