package entity.bike;

import java.util.Hashtable;
import java.util.Map;

public class Bike {
	private String bikeType;
	private boolean status;
	private String bikeCode;
	private String imageURL;
	
	public String getBikeType() {
		return bikeType;
	}
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBikeCode() {
		return bikeCode;
	}
	public void setBikeCode(String bikeCode) {
		this.bikeCode = bikeCode;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public  Map<String, String> getBikeInfo(){
		Map<String, String> info = new Hashtable<String, String>();
		info.put("TYPE", bikeType);
		info.put("BIKECODE", bikeCode);
		info.put("IMAGE_URL", imageURL);
		return info;
	}
	
}