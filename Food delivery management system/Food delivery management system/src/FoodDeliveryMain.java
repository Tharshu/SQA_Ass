import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodDeliveryMain {
	
	String username = "", email = "", password = "", lusername = "", lpassword = "", nameD ="", addressD = "", contactD = "", deliveryType = "", shopName = "", flavour = "", mealSize = "", addOnsType = "",  kidsMeal = "", mediumMeal = "", largeMeal = "";
	double total = 0;
	int quantity = 0;
	
	public int signup(String username, String email, String password)
	{		
		int ans = 0;

		this.username = username;
		
		this.email = email;
		
		this.password = password;
			
		
		System.out.println("Your signin details: \n\tusername: "+username +"\temail: " +email+"\tpassword: "+password);
		
		return ans;
	}
	
	
	public int login(String username, String password)
	{
		int ans = 0;
		
		if(lusername.equals(username))
		{
			this.lusername = username;
			
			if(lpassword.equals(password))
			{
				this.lpassword = password;
				//ans = 0;
				System.out.println("Successfully logged in");
			}
			else
			{
				//ans = 1;
				System.out.println("Incorrect password\n");
			}
		}
		else
		{
			//ans = 1;
			System.out.println("Incorrect username\n");
		}
		
		System.out.println("Your Login details: \n\tusername: "+username +"\temail: " +email+"\tpassword: "+password);
		
		return ans;
	}
	
	public int shopSelect(String shopName) {
		
		int ans = 0;
				
		System.out.println("Shop Name: \n\n\tMacDonalds\n\tBurger King\n\tMr Burger\n");
	
		this.shopName = shopName;
		
		return ans;
	}
	
	public int flavourSelect(String flavour) {
		
		int ans = 0;
				
		System.out.println("FLavours: \n\n\tBigmac\n\tMacdouble\n\tCheese burger\n");
	
		this.flavour = flavour;
		
		return ans;
	}
	
	
	public int mealSizeSelect(String size, String flavour) {
		
		int ans = 0;
		
		if(flavour.equalsIgnoreCase("Bigmac"))
		{
			System.out.println("Meal sizes: \n\n\tKids meal:\t550\n\tMedium meal:\t750\n\tLarge meal:\t950\n");
		}
		else if(flavour.equalsIgnoreCase("Macdouble"))
		{
			System.out.println("Meal sizes: \n\n\tKids meal:\t550\n\tMedium meal:\t750\n\tLarge meal:\t950\n");
		}
		else if(flavour.equalsIgnoreCase("Cheese burger"))
		{
			System.out.println("Meal sizes: \n\n\tKids meal:\t550\n\tMedium meal:\t750\n\tLarge meal:\t950\n");
		}
		
		this.mealSize = size;
		
		if(mealSize.equalsIgnoreCase("Kids meal"))
		{
			total = total + 550;
		}
		else if(mealSize.equalsIgnoreCase("Medium meal"))
		{
			total = total + 750;
		}
		else if(mealSize.equalsIgnoreCase("Large meal"))
		{
			total = total + 950;
		}
		
		return ans;
	}
	
	
	public int addOns(String addon) {
		
		int ans = 0;
		
		System.out.println("Add Ons: \n\n\tExtra cheese\t150\n\tExtra meat\t200\n\tExtra Lettuce\t100\n");
		
		this.addOnsType = addon;
		
		if(addOnsType.equalsIgnoreCase("Extra cheese"))
		{
			total = total + 150;
		}
		else if(addOnsType.equalsIgnoreCase("Extra meat"))
		{
			total = total + 200;
		}
		else if(addOnsType.equalsIgnoreCase("Extra Lettuce"))
		{
			total = total + 100;
		}
	
		return ans;
	}
	
	
	public int diningMethod(String dining) {
		
		int ans = 0;
				
		System.out.println("Enter quantity: ");

		this.deliveryType = dining;
		
		if(deliveryType.equalsIgnoreCase("Dining"))
		{
			total = total + 0;
		}
		else if(deliveryType.equalsIgnoreCase("Takeaway"))
		{
			total = total + 0;
		}
		else if(deliveryType.equalsIgnoreCase("Delivery"))
		{
			total = total + 300;
		}
			
		return ans;
	}
	
	
	public int quantitySelect(int quantity) {
		
		int ans = 0;
		
		System.out.println("Enter quantity: ");

		this.quantity = quantity;
		
		total = total + this.quantity;
		
		return ans;
	}
	
	
	public double totalCalc() {
		
		System.out.println("Total price: "+total);
		
		return total;
	}
	
	
	public int delivery(String dname, String daddres, String tel)
	{
		int ans = 0;
		
		System.out.println("Enter the name: ");
		
		nameD = dname;
		
		addressD = daddres;
		
		contactD = tel;
		
		
		System.out.println("Your delivery details: \n\tname: "+nameD +"\taddress: " +addressD+"\tcontact: "+contactD);
		
		System.out.println("\n\n----------------------------------------\nThank you. Come again\n----------------------------------------\n\n");
	
		return ans;
	}
	
	
	public int orderAgain()
	{
		int ans = 0;
		
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		fdm.shopSelect("MacDonalds");
		fdm.flavourSelect("Bigmac");
		fdm.mealSizeSelect("Kids meal", "Bigmac");
		fdm.addOns("Extra cheese");
		fdm.quantitySelect(1);
		fdm.diningMethod("Delivery");
		fdm.totalCalc();// not equal to 0
		fdm.delivery("Ashen", "Malabe", "012345678");
		
		System.out.println("Do you want to order again?");
		
		try {
			String orderAgainAns = br.readLine();
			
			if(orderAgainAns.equalsIgnoreCase("Yes"))
			{
				fdm.orderAgain();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ans;
	}
	
	
//	public static void main(String[] args) {
//		
//		InputStreamReader r = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(r);
//		
//		FoodDeliveryMain fdm = new FoodDeliveryMain();
//		
//		fdm.signup();
//		fdm.login();
//		fdm.flavourSelect();
//		fdm.mealSizeSelect();
//		fdm.addOns();
//		fdm.quantitySelect();
//		fdm.diningMethod();
//		fdm.totalCalc();
//		fdm.delivery();
//		
//		System.out.println("Do you want to order again?");
//		
//		try {
//			String orderAgainAns = br.readLine();
//			
//			if(orderAgainAns.equalsIgnoreCase("Yes"))
//			{
//				fdm.orderAgain();
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
