import static org.junit.Assert.assertTrue;
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

	private Category cl1;
	private Category cl2;

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
	ArrayList<Category> categoryList = new ArrayList<Category>();

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

		cl1 = new Category("Light");
		cl2 = new Category("Toy");

		loginList = new ArrayList<UserAccount>();
		bidList = new ArrayList<Bid>();
		itemList = new ArrayList<Item>();
		categoryList = new ArrayList<Category>();

	}
	
	
	@Test
	public void testviewAllItems() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Item arraylist to retrieve item", itemList);

		// test if the list of items retrieved from the SourceCentre is empty - boundary
		String allItems = C206_CaseStudy.viewAllItems(itemList);
		String testOutput = "";
		assertEquals("Check that viewAllItems", testOutput, allItems);

		// Given an empty list, after adding 7 items, test if the size of the list is 7
		// - normal
		itemList.add(il1);
		itemList.add(il2);
		itemList.add(il3);
		itemList.add(il4);
		itemList.add(il5);
		itemList.add(il6);
		itemList.add(il7);
		assertEquals("Test that Item arraylist size is 7", 7, itemList.size());

		// test if the expected output string same as the list of items retrieved
		allItems = C206_CaseStudy.viewAllItems(itemList);
		for (Item i : itemList) {
			testOutput += ("\nItem Name: " + Item.getItemName() + "\nDescription: " + Item.getDescription()
					+ "\nCategory: " + Item.getCategory() + "\nMinimum Bid Price: $" + Item.getMinimumBidPrice()
					+ "\nBid Increment: $" + Item.getBidIncrement() + "\nAuction Start Date: " + Item.getAuctionStart()
					+ "\n");
		}
		assertEquals("Test that viewAllItems", testOutput, allItems);
	}

	@Test
	public void testAddItems() {
		// Test if Item list is not null but empty - boundary
		assertNotNull(itemList);

		// Test that list is empty
		itemList.add(il1);
		assertEquals(1, itemList.size());
		assertSame(il1, itemList.get(0));

		// Test add second item
		itemList.add(il2);
		assertEquals(2, itemList.size());
		assertSame(il2, itemList.get(1));

	}

	@Test
	public void testDeleteItems() {
		// Test if Item list is not null but empty - boundary
		assertNotNull(itemList);

		// Test itemList size
		assertEquals(7, itemList.size());

		// Test item delete
		itemList.remove(il1);

	}

	@Test
	public void testViewAllUsers() {
		
	    //Test that list is empty (no accoutns added).
	    String allAccount= C206_CaseStudy.retrieveAccounts(accountList);
	    String testOutput = "";
	    assertEquals(testOutput, allAccount);
	    
	    //After adding 2 accounts, test that the list now has 2 accounts.
	    C206_CaseStudy.addAccount(accountList, "Kyle", "admin", "admin@ds.", "pw", "valid");
	    C206_CaseStudy.addAccount(accountList, "Darren", "user", "user@ds.", "pw", "valid");
	    assertEquals(2, accountList.size());
	    
	    //Test if the expected output string same as the list of accounts retrieved from the store
	    allAccount= C206_CaseStudy.retrieveAccounts(accountList);
	    testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n","Kyle", "admin", "admin@ds.", "pw", "valid");
	    testOutput += String.format("%-20s %-10s %-30s %-20s %-10s\n","Darren", "user", "user@ds.", "pw", "valid");
	    assertEquals(testOutput, allAccount);
	  }
	}

	@Test
	public void testRegister() {
		   // Test that account list is not null, so that a new account can be added to (boundary)
	    assertNotNull(accountList);
	    
	    //Test that when an item is added, the list has one variable. 
	    //•  The size of the list is 1 (start). 
	    //•  The account just added is identical to the first account added to the list (details are correct).

	    a1 = C206_CaseStudy.addAccount(accountList, "kyle","admin","admin@ds.","ps","valid", 0);
	    assertEquals(1, accountList.size());
	    assertSame(a1,accountList.get(0));
	    
	    //Test that we can add another item. 
	    //•  The size of the list is now 2.
	    //•  The account added is different from the first account.
	    //•  The account is similar to the list item 2.

	    a2 = C206_CaseStudy.addAccount(accountList, "Darren", "user", "user@ds.", "pw", "valid", 0);
	    assertEquals( 2, accountList.size());
	    assertSame(a2, accountList.get(1));
	    
	    //Test that when the account details are invalid: account will not be added.
	    C206_CaseStudy.addAccount(accountList,"Amy", "user", "invalid@d.", "pw", "invalid", 0);
	    assertEquals(2, accountList.size());
	    
	    //Test that when an account is blocked, the account is temporarily banned.
	    C206_CaseStudy.addAccount(accountList,"Ben", "user", "block@ds.", "pw", "blocked", 0;
	    assertEquals(2, accountList.size());
	  }
	  
	}
	}

	@Test
	public void testDeleteAccount() {
		 // Account list is initially not null
	    assertNotNull(accountList);
	    
	    //Account list has two accounts as mentioned above (The first 2 accounts)
	    C206_CaseStudy.addAccount(accountList, "Kyle", "admin", "admin@ds.", "pw", "valid", 0);
	    C206_CaseStudy.addAccount(accountList, "Darren", "user", "user@ds.", "pw", "valid", 0);
	    assertEquals(2,accountList.size());
	    
	    //After deleting 1 account, test if the size of the list is 1 (delete Kyle's account)
	    C206_CaseStudy.removeAccount(accountList, "admin@ds.");
	    assertEquals(1,accountList.size());
	    
	    //Test if the expected output string same as the list of accounts retrieved from the store
	    String allAccount= C206_CaseStudy.retrieveAccounts(accountList);
	    String testOutput = String.format("%-20s %-10s %-30s %-20s %-10s\n","Darren", "user", "user@ds.", "pw", "valid", 0);
	    assertEquals(testOutput, allAccount);
	    
	    //Test if email is not found, no user is deleted
	    C206_CaseStudy.removeAccount(accountList, "wrongEmail@gmail.com");
	    assertEquals(1,accountList.size());
	  }
	}

	@Test
	public void testAddCategory() {
		// Test if category list is not null but empty - boundary
		assertNotNull(categoryList);

		// Test that list is empty
		categoryList.add(cl1);
		assertEquals(1, categoryList.size());
		assertSame(cl1, categoryList.get(0));

		// Test add second category
		categoryList.add(cl2);
		assertEquals(2, categoryList.size());
		assertSame(cl2, categoryList.get(1));
	}

	@Test
	public void testViewAllCategory() {
		// Test if category list is not null but empty - boundary
		assertNotNull(categoryList);

		// test if the category of items retrieved from the SourceCentre is empty -
		// boundary
		String allItems = C206_CaseStudy.manageCategory(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllCategory", testOutput, allCategories);

		// Given an empty list, after adding 7 items, test if the size of the list is 7
		// - normal
		categoryList.add(cl1);
		categoryList.add(cl2);
		assertEquals("Test that Category arraylist size is 2", 2, categoryList.size());
	}

	@Test
	public void testDeleteCategory() {
		// Test if Category list is not null but empty - boundary
		assertNotNull(categoryList);

		// Test categoryList size
		assertEquals(2, categoryList.size());

		// Test category delete
		categoryList.remove(cl1);

	}
	boolean bidChecker = false;

	@Test
	public void testViewAllBids() {
		boolean allBids = C206_CaseStudy.viewAllBids(bidList);
		String testOutput = "";
		assertTrue("check if successfully printed out bids", allBids);
	}

	@Test
	public void testAddBid() {
		C206_CaseStudy.bidItem(itemList, currentUser);
		assertTrue("Check if item successfully bid", bidChecker);
	}

	@Test
	public void testDeleteBid() {
		boolean deleted = C206_CaseStudy.testDeleteBid();
		assertTrue("Check if bid deleted", deleted);
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
		
		cl1 = null;
		cl2 = null;

		loginList = null;
		bidList = null;
		itemList = null;
		categoryList = null;
	}
	

}
