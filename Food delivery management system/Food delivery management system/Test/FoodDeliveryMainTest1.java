import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodDeliveryMainTest1 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSignup() {
		String username = "navo";
		String email = "navo@gmail.com";
		String password = "1234";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.signup(username, email, password);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testLogin() {
		String lusername = "navo";
		String lpassword = "1234";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.login(lusername, lpassword);
		int expe = 0;
		
		assertEquals(expe, ans);
	}
	
	@Test
	void testshopSelect() {
		String shopName = "MacDonalds";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.shopSelect(shopName);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testFlavourSelect() {
String flavour = "Bigmac";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.flavourSelect(flavour);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testMealSizeSelect() {
		String size = "Kids meal";
		String flavour = "Bigmac";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.mealSizeSelect(size, flavour);
		int expe = 0;
	}

	@Test
	void testAddOns() {
String addon = "Extra cheese";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.addOns(addon);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testDiningMethod() {
String dining = "Delivery";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.diningMethod(dining);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testQuantitySelect() {
	int quantity = 1;
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.quantitySelect(quantity);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

	@Test
	void testTotalCalc() {
	FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		double ans = fdm.totalCalc();
		double expe = 1000;
		
		assertEquals(expe, ans);
	}

	@Test
	void testDelivery() {
		String dname = "Ashen";
		String daddres = "Malabe";
		String tel = "012345678";
		
		FoodDeliveryMain fdm = new FoodDeliveryMain();
		
		int ans = fdm.delivery(dname, daddres, tel);
		int expe = 0;
		
		assertEquals(expe, ans);
	}

}
