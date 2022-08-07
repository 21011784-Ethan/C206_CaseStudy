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
	}

	@Test
	public void testRegister() {
	}

	@Test
	public void testDeleteAccount() {
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
		
		cl1 = null;
		cl2 = null;

		loginList = null;
		bidList = null;
		itemList = null;
		categoryList = null;
	}
}
