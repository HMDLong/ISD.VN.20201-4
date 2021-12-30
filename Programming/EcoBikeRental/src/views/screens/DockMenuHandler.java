package views.screens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.dock.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DockMenuHandler extends BaseScreenHandler implements Initializable{
	
	@FXML
	private Button dockBackBtn, returnBtn, rentBtn, viewBikeBtn;
	
	
	
	private Dock dock;
	
	public DockMenuHandler(Stage stage, String screenPath, Dock dock) throws IOException {
		super(stage, screenPath);
		this.dock = dock;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
}
