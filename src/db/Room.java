package db;

public class Room {
	
	private String name;
	private Integer temperature;
	private Integer humidity;
	private Integer quanOfFacility;
	private Integer maxQuantity;

	
	public Room(String name, Integer temperature, Integer humidity, Integer quanOfFacility, Integer maxQuantity) {
		super();
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.quanOfFacility = quanOfFacility;
		this.maxQuantity = maxQuantity;
	}


	public Room() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getTemperature() {
		return temperature;
	}


	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}


	public Integer getHumidity() {
		return humidity;
	}


	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}


	public Integer getQuanOfFacility() {
		return quanOfFacility;
	}


	public void setQuanOfFacility(Integer quanOfFacility) {
		this.quanOfFacility = quanOfFacility;
	}


	public Integer getMaxQuantity() {
		return maxQuantity;
	}


	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	
	@Override
	public String toString() {
		return "Room [name=" + name + ", temperature=" + temperature + ", humidity=" + humidity + ", quanOfFacility="
				+ quanOfFacility + ", maxQuantity=" + maxQuantity + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
