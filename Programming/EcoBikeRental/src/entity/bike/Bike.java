package entity.bike;

public class Bike {
	private String bikeType;
	private boolean status;
	private String bikeCode;
	private String imageURL;
	private int price;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
