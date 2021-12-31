package views.screens;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLScreenHandler {
	
	protected FXMLLoader loader;
	
	protected FXMLScreenHandler() {}
	
	public FXMLScreenHandler(String screenPath) throws IOException {
		this.loader = new FXMLLoader(getClass().getResource(screenPath));
		// Set this class as the controller
		this.loader.setController(this);
	}

	public FXMLLoader getLoader() {
		return this.loader;
	}

	public void setImage(ImageView imv, String path){
		File file = new File(path);
		Image img = new Image(file.toURI().toString());
		imv.setImage(img);
	}
}
