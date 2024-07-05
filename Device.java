// MP2; LK. Wang; CIS 340 T/TH 3:00PM
public class Device {

	//Declare attributes
	private String SKU;
	private String name;
	private boolean availability = false;
	
	
	//"constructor"
	public Device(String SKU, String name)
	{
		setSKU(SKU);
		setName(name);
		setAvailability(availability);
	}
	
	public Device(String SKU, String name, boolean availability)
	{
		setSKU(SKU);
		setName(name);
		setAvailability(availability);
	}
	
	//"Getter" methods
	public String getSKU()
	{
		return SKU;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAvailability()
	{
		if(availability)
			return "Avaliable";
		else
			return "Checked Out";
	}
	
	//"Setter" methods
	public void setSKU(String SKU)
	{
		this.SKU = SKU.toUpperCase();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAvailability(boolean availability)
	{
		this.availability = availability;
	}
}
