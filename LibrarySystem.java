import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

	private static ArrayList<Device> deviceList = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Import scanner
		Scanner scnr = new Scanner(System.in);
				
		//Initialize variables to store the user selection
		int decision;
				
		//Adding the pre-loaded 5 devices to the AeeayList
		deviceList.add(new Device("6757A","Apple 9.7-inch iPad Pro",true));
		deviceList.add(new Device("93P51B","Amazon Kindle Fire Kids Edition",true));
		deviceList.add(new Device("10N8C","LeapFrog Epic Learning Tablet",true));
		deviceList.add(new Device("85U20","Amazon Kindle Fire HD 8",false));
		deviceList.add(new Device("91H2D","HP Envy 8 Note",true));
				
		//Use do while loop to check if the condition meets the requirement for "decision"
		do
		{
			displayMenu();
					
			System.out.print("\n\nSelect menu options 1-7: ");
			decision = Integer.parseInt(scnr.nextLine());
					
		//Use switch statement to determine different functions user seek for
		switch (decision)
		{
			//Case for displays devices list
			case 1:
					displayDeviceList();
					System.out.println("\nPress Enter to continue...\n\n");
					break;
							
			//Case for adding a new device
			case 2:
					addDevice();
					System.out.println("\nPress Enter to continue...\n\n");
					break;
						
			//Case for editing existing device information
			case 3:
					displayDeviceList();
					editDevice(deviceList);
					System.out.println("\nPress Enter to continue...\n\n");
					break;
						
			//Case for searching the devices
			case 4:
					searchDevice(deviceList);
					System.out.println("\nPress Enter to continue...\n\n");
					break;
							
			//Case for checking out a device
			case 5:
					checkOutDevice(deviceList);
					System.out.println("\nPress Enter to continue...\n\n");
					break;
							
			//Case for checking in a device
			case 6:
					checkInDevice(deviceList);
					System.out.println("\nPress Enter to continue...\n\n");
					break;
						
			//Case for user to exit the program
			case 7:
					exit(); 
					System.out.println("\nPress Enter to continue...\n\n");
					break;
			}
					
		}while(decision != 7);
	}

	// Method 0 - Displays the menu
	public static void displayMenu() 
	{
		//Create the header and options of the menu
	    System.out.println("\t\tLibrary Device Checkout System\n\n");
	    System.out.println("1. List Devices by Title");
	    System.out.println("2. Add New Device");
	    System.out.println("3. Edit Device Information");
	    System.out.println("4. Search by Device Name");
	    System.out.println("5. Check Out Devices");
	    System.out.println("6. Chech In Devices");
	    System.out.println("7. Exit");
	}
		
	// Method 1 - Displays devices list
	public static void displayDeviceList()
	{
		//Create the header of the devices list
		System.out.println("\n\n\t\tLibrary Device Checkout System - List\n\n");
			
		System.out.printf("%s %-6s\t%-32s\n","#","SKU","Name");
			 
		for (Device newDevice : deviceList)
		{
			System.out.printf("%s %-6s\t%-35s %s\n",(deviceList.indexOf(newDevice)+1),newDevice.getSKU(), newDevice.getName(), newDevice.getAvailability());
			
		}
	}
		
	// Method 2 - Adds a new device
	public static void addDevice()
	{
		//Import scanner
		Scanner scnr = new Scanner(System.in);
			
		String SKU = "";
		String name = "";
			
		//Create the header of the adding new device
		System.out.println("\n\n\t\tLibrary Device Checkout System - Add New Device\n\n");
			
		System.out.print("Sku: ");
		SKU = scnr.nextLine();
		System.out.print("Name: ");
		name = scnr.nextLine();
			
		Device newDevice = new Device(SKU,name,true); 
		deviceList.add(newDevice);
			
		System.out.printf("Added %s to Catalog.\n", name);
	}
		
	// Method 3 - Editing existing device information
	public static void editDevice(ArrayList<Device> deviceList)
	{
		//Import scanner
		Scanner scnr = new Scanner(System.in);

		String SKU = "SKU";
		String name = "Name";
		int deviceNum = 0;

		System.out.print("\nEnter Device number to edit (1-6): ");
		deviceNum = Integer.parseInt(scnr.nextLine());
			
		if(deviceNum < 1)
		{
			System.out.println("\nInvaild number. ");
		}
		else
		{
			System.out.print("Sku: ");
			SKU = scnr.nextLine();
			System.out.print("Name: ");
			name = scnr.nextLine();
				
			deviceList.get(deviceNum - 1).setSKU(SKU);
			deviceList.get(deviceNum - 1).setName(name);
				
			System.out.println("\n\nDevice information updated.");
		}
	}
		
	// Method 4 - Searches for devices
	public static void searchDevice(ArrayList<Device> deviceList)
	{
		//Import scanner
		Scanner scnr = new Scanner(System.in);

		String device = ""; 
			
		System.out.println("\n\n\t\tLibrary Device Checkout System - Search\n\n");
		System.out.print("Enter Device to search for: ");
		device = scnr.nextLine();
			
		for (Device newDevice : deviceList)
		{
			if(newDevice.getName().toLowerCase().contains(device))
			{
				System.out.printf("%s %-6s\t%-35s\n",(deviceList.indexOf(newDevice)+1),newDevice.getSKU(), newDevice.getName());
			}
		}
	}
		
	// Method 5 - Check out a device
	public static void checkOutDevice(ArrayList<Device> deviceList)
	{
		//Import scanner
		Scanner scnr = new Scanner(System.in);

		int deviceNum = 0;
			
		System.out.println("\n\n\t\tLibrary Device Checkout System - Check Out Device\n\n");
		System.out.println("Avaliable Devices");
			
		System.out.printf("%s %-6s\t%-32s\n","#","SKU","Name");
			
		for (Device newDevice : deviceList)
		{
			if(newDevice.getAvailability().equalsIgnoreCase("Avaliable"))
			{
				System.out.printf("%s %-6s\t%-35s\n", (deviceList.indexOf(newDevice)+1),newDevice.getSKU(), newDevice.getName());
			}
		}
			
		System.out.print("\nEnter device number: ");
		deviceNum = Integer.parseInt(scnr.nextLine());
			
		for (Device newDevice : deviceList)
		{
			if(deviceNum == (deviceList.indexOf(newDevice)+1) && newDevice.getAvailability()==("Available"))
			{
				System.out.println("This device is already checked out.");
				break;
			}
			if(deviceNum == (deviceList.indexOf(newDevice)+1) && newDevice.getAvailability()!=("Available"))
			{
				newDevice.setAvailability(false);
				System.out.println("Device Checked Out");
				break;
			}
			if(deviceNum > deviceList.size())
			{
				System.out.println("Invalid number.");
				break;
			}
		}
	}
		
	// Method 6 - Check in a device
	public static void checkInDevice(ArrayList<Device> deviceList)
	{
		//Import scanner
		Scanner scnr = new Scanner(System.in);
		
		int deviceSelection = 0;
			
		System.out.println("\n\n\t\tLibrary Device Checkout System - Check In Device\n\n");
		System.out.println("Cheched Out Devices\n");
			
		System.out.printf("%s %-6s\t%-32s\n","#","SKU","Name");
		for (Device newDevice : deviceList)
		{
			if(newDevice.getAvailability().equalsIgnoreCase("Checked Out"))
			{
				System.out.printf("%s %-6s\t%-35s\n", (deviceList.indexOf(newDevice)+1),newDevice.getSKU(), newDevice.getName());
			}
		}
			
		System.out.print("\nEnter device number: ");
			
		deviceSelection = Integer.parseInt(scnr.nextLine());
			
		for (Device newDevice : deviceList)
		{
			if(deviceSelection == (deviceList.indexOf(newDevice)+1) && newDevice.getAvailability().equalsIgnoreCase("Checked Out"))
			{
				newDevice.setAvailability(true);
				System.out.println("Device Checked In.");
				break;
			}
			if(deviceSelection > deviceList.size())
			{
				System.out.println("This device is not checked out.");
				break;
			}
		}
	}
		
	// Method 7 - Exit the program
	public static void exit() 
	{
		//Print the exit message
	    System.out.println("Good bye!");
	        
	     //Use the exit() method to exit the program
	     System.exit(0);
	}
}
