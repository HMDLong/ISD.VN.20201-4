package entity.dock;

import java.util.ArrayList;

import entity.bike.Bike;

public class Dock {
	  private int id;
	  private String address;
	  private String name;
	  private int maxSlot;
	  private int avaiSlot;
	  private int area;
	  
	  public Dock(int id, String address, String name, int maxSlot, int availSlot, int area) {
	    this.id = id;
	    this.address = address;
	    this.name = name;
	    this.maxSlot = maxSlot;
	    this.avaiSlot = availSlot;
	    this.area = area;
	  }
	  
	  public static ArrayList<Dock> getAllDocks(){
	    ArrayList<Dock> docklist = new ArrayList<>();
	    docklist.add(new Dock(1, "Tower A1", "Dock 1", 20, 10, 200));
		docklist.add(new Dock(2, "Tower A2", "Dock 2", 10, 5, 100));
		docklist.add(new Dock(3, "Tower B3", "Dock 3", 15, 15, 200));
		docklist.add(new Dock(4, "Tower C4", "Dock 4", 15, 15, 200));
		docklist.add(new Dock(5, "Tower C5", "Dock 5", 15, 15, 200));
		docklist.add(new Dock(6, "Tower D3", "Dock 6", 15, 15, 200));
	    return docklist;
	  }
	  
	  public ArrayList<Bike> getBikes(){
	    return new ArrayList<Bike>();
	  }
	  
	  //----------Set get------------------
	
	  public int getId() {
	    return id;
	  }
	
	  public int getAvaiSlot() {
	    return avaiSlot;
	  }
	
	  public void setAvaiSlot(int avaiSlot) {
	    this.avaiSlot = avaiSlot;
	  }
	
	  public String getAddress() {
	    return address;
	  }
	
	  public String getName() {
	    return name;
	  }
	
	  public int getMaxSlot() {
	    return maxSlot;
	  }
	  
	  public int getArea() {
	    return area;
	  }
}
