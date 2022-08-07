import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class C206_CaseStudyTest {
	private boolean deleteStatus;
	private boolean logoutStatus;
	private LocalDate today;

	private UserAccount ll1;
	private UserAccount ll2;
	private UserAccount ll3;
	private UserAccount ll4;

////	bidlist
//	private Bid bl1;

	private Item il1;
	private Item il2;
	private Item il3;
	private Item il4;
	private Item il5;
	private Item il6;
	private Item il7;

	ArrayList<UserAccount> currentUser = new ArrayList<UserAccount>();
	ArrayList<UserAccount> loginList = new ArrayList<UserAccount>();
	ArrayList<Bid> bidList = new ArrayList<Bid>();
	ArrayList<Item> itemList = new ArrayList<Item>();

	public C206_CaseStudytest() {
		super();
	}

	void setUp() throws Exception {

		ll1 = new UserAccount("Kyle", "admin", "admin@ds.", "pw", "valid", 0);
		ll2 = new UserAccount("Darren", "user", "user@ds.", "pw", "valid", 0);
		ll3 = new UserAccount("Amy", "user", "invalid@d.", "pw", "invalid", 0);
		ll4 = new UserAccount("Ben", "user", "block@ds.", "pw", "blocked", 0);

//		bidList

		il1 = new Item("Glow Stick", "THE BEST STICK IN THE WORLD!", 10.0, today, null, 1, "Light utilities", 1);
		il2 = new Item("AK47", "Stand Still for more Accuracy!", 69.0, today, null, 3, "Weapons", 2);
		il3 = new Item("Hammer", "Build build build", 25.0, today, null, 2, "tools", 3);
		il4 = new Item("Jett Toy Figure", "WATCH THIS!", 100.0, today, null, 10, "Toys", 4);
		il5 = new Item("Darren Lee", "I am for sale!!", 10000.0, today, null, 10, "Human", 5);
		il6 = new Item("", "I am for sale!!", 10000.0, today, null, 10, "Electronics", 6);
		il7 = new Item("Torch Glow", "Glow test", 10000.0, today, null, 10, "Electronics", 7);

		itemList.add(il1);
		itemList.add(il2);
		itemList.add(il3);
		itemList.add(il4);
		itemList.add(il5);
		itemList.add(il6);
		itemList.add(il7);

		loginList = new ArrayList<UserAccount>();
		bidList = new ArrayList<Bid>();
		itemList = new ArrayList<Item>();

	}

	
	@Test 
	public void testViewAllItems() {
		
	}
		
	@Test 
	public void testAddItems() {
	}
		
	@Test 
	public void testDeleteItems() {
	}
	
	@Test 
	public void testViewAllUsers() {
	}
	
	@Test 
	public void testRegister() {
	}
	
	@Test 
	public void testDeleteAccount() {
	}
		
	@Test 
	public void testAddCategory() {
		
	}
		
	@Test 
	public void testViewAllCategory() {
	}
	
	@Test 
	public void testDeleteCategory() {
		
	}
	
	@Test 
	public void testViewAllBids() {
		
	}
		
	@Test 
	public void testAddBid() {
			
		}
			
	@Test 
	public void testDeleteBid() {
	}
				

	@After
	public void tearDown() throws Exception {
		ll1 = null;
		ll2 = null;
		ll3 = null;
		ll4 = null;

		il1 = null;
		il2 = null;
		il3 = null;
		il4 = null;
		il5 = null;
		il6 = null;
		il7 = null;

		loginList = null;
		bidList = null;
		itemList = null;
	}
}
