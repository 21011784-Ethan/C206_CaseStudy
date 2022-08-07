import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudy {
		public static ArrayList<UserAccount> currentUser = new ArrayList<UserAccount>();
		public static ArrayList<UserAccount> loginList = new ArrayList<UserAccount>();
		public static ArrayList<Bid> bidList = new ArrayList<Bid>();
		public static ArrayList<Item> itemList = new ArrayList<Item>();
		
		public static boolean deleteStatus;
		public static boolean logoutStatus;
		public static LocalDate today;
		public static void main(String[] args) {
			C206_CaseStudy cs = new C206_CaseStudy();
			cs.startApp();
		}
		public void startApp() {
			
			today = LocalDate.now();
			
// login list
			
// bid list
//			public Bid(String itemName, LocalDate auctionStart, LocalDate endDate, double bidIncrement,String category, int bidId,
//					String sellerEmail, String buyerEmail, double bidPrice)

			bidList.add(new Bid("", today, null, 1.0 ,"Electronics",  0, "seller@ds.", null, 100.0, 0));
			
			bidList.add(new Bid("", today, null, 1.0 ,"Electronics",  0, "seller@ds.", null, 100.0, 1));


// item list
//			public Item(String itemName, String description, double minimumBidPrice, LocalDate auctionStart, LocalDate endDate,
//					int bidIncrement, String category)

			AppControls();
		}
		
		public static void AppControls() {

		}
		
		public static String loginChecker(ArrayList<UserAccount> loginList, ArrayList<UserAccount> currentUser, String email, String password, String status, String role) {
		}
		
		public static void login(String email, String status, String role) {
			
			//LOGIN
		}
		
		public static void register(ArrayList<UserAccount> loginList ,String email) {
		}
		
		public static void userControls(String email, String password) {
			
//			System.out.println("1. View All Biding Items");
//			System.out.println("2. Search Item Name");
//			System.out.println("3. Search Biding Items by Category");
//			System.out.println("4. Bid on Item");
//			System.out.println("5. Sell an Item");
//			System.out.println("6. View my Bids");
//			System.out.println("7. View my Items");
//			System.out.println("8. Change Password");
//			System.out.println("9. Delete Account");
//			System.out.println("10. Logout");
		
			
			int userOption = 0;
			while (userOption != 10) {
				userOption = Helper.readInt("Type User option: ");
				if (userOption == 1) {
					// view all biding items
					viewAllItems(itemList);
					userMenu();
				} else if (userOption == 2) {
					searchItem(itemList);
					userMenu();
				} else if (userOption == 3) {
					searchCategory(itemList);
					userMenu();
				} else if (userOption == 4) {
					//Bid on Item
					bidItem(itemList, currentUser);
				} else if (userOption == 5) {
					//Sell an Item
					
				} else if (userOption == 6) {
					//View my Bids
					
				} else if (userOption == 7) {
					//view My Items
					
				} else if (userOption == 8) {
					//Change current password account
					boolean changed = changePassword(currentUser, email,password);
					
					if (changed == true) {
						System.out.println("Password Changed");
						userOption = 10;
					} else {
						System.out.println("Password remains unchanged.");
						userMenu();
					}
		
				} else if (userOption == 9) {
					// Delete Current Account
					String confirmation = Helper.readString("Are you sure you want to DELETE your Account? (Y/N): ");
					if (confirmation.equalsIgnoreCase("y")) {
						userOption = 10;
						deleteStatus = true;
					} else {
						System.out.println("Account has not been deleted.");
					}
				}
			}
			
			logoutStatus = true;
			System.out.println("Successfully Logged out!");
		}
		
		public static void adminControls(ArrayList<UserAccount> loginList) {

			System.out.println("Campus Online Auction Shop (COAS)");
			System.out.println("[YOU ARE AN ADMINISTRATOR]");
			Helper.line(70, "-");
			System.out.println("1. Manage Items");
			System.out.println("2. Manage Categories");
			System.out.println("3. Manage Bids");
			System.out.println("4. Manage Users Status");
			System.out.println("5. Logout");
			
		public static void adminControls(ArrayList<UserAccount> loginList, String email, String password) {

			int adminOption = 0;
			while (adminOption != 5) {
				adminOption = Helper.readInt("Type an option: ");

				if (adminOption == 1) {
					//Manage Items


					manageItems(itemList);
					adminMenu();
				} else if (adminOption == 2) {
					//Manage Categories
					manageCategory(itemList);
					adminMenu();
				} else if (adminOption == 3) {
					//Manage Bids


					adminMenu();
				} else if (adminOption == 4) {
					// Manage User Status
					boolean found = false;
					String email = Helper.readString("Type email you want to manage: ");
					int status = 0;
					for (int i = 0; i < loginList.size(); i++) {
						if (loginList.get(i).getEmail().equals(email) && !loginList.get(i).getRole().equals("admin")) {
							found = true;
							System.out.println("1. Valid");
							System.out.println("2. Blocked");
							status = Helper.readInt("Select status for this user: ");

							if (status == 1) {
								loginList.get(i).setStatus("valid");
								System.out.println("Changed to valid user");
							} else if (status == 2) {
								loginList.get(i).setStatus("blocked");
								System.out.println("Changed to blocked user");
							} else {
								System.out.println("Invalid Status selection");
							}
					int choice = 0;
					System.out.println("1. Delete users");
					System.out.println("2. Change user Status (BLOCK USERS)");
					System.out.println("3. View all Users");
					choice = Helper.readInt("Please input your choice of action: ");

					if (choice == 1) {				

							adminDeleteStatus = true;
							adminOption = 5;

					} else if (choice == 2) {
						changeUserStatus();
					}else if (choice == 3) {
						for (UserAccount us : loginList) {
							System.out.println();
							System.out.println("Name: " + us.getName());
							System.out.println("Email: " + us.getEmail());
						}
					} else {
						System.out.println("Invalid choice.");
					}
					if (found == false) {
						System.out.println("Email not found / Not allowed to be changed");
					}
					adminMenu();
				}
			}
			logoutStatus = true;
			System.out.println("Successfully Logged out!");

			if (adminDeleteStatus == false) {
				System.out.println("Successfully Logged out!");
			}
		}
		public static boolean adminDeleteUser(ArrayList<UserAccount> loginList) {
			
		}
				
		public static void changeUserStatus() {
			
		}
		
		public static void manageItems(ArrayList<Item> itemList) {
		}
		
		}
		
		public static boolean manageCategory(ArrayList<Item> itemList) {
			boolean categoryFound = false;
			String category = "";
			int option = 0;
			System.out.println("1. Delete an Item");
			System.out.println("2. View All categories");
			option = Helper.readInt("Type the option you want to select: ");

			if (option == 1) {
				category = Helper.readString("Type item Category you want to Delete: ");
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getCategory().equalsIgnoreCase(category)) {
						categoryFound = true;

					}

					if (categoryFound == true) {
						System.out.println("Category: " + itemList.get(i).getCategory() + " has been removed.");
						itemList.remove(i);
					}
				}

			} else if (option == 2) {
				categoryFound = true;
				for (int i = 0; i < itemList.size(); i++) {
					System.out.println(itemList.get(i).getCategory());
				}
			} else {
				System.out.println("Invalid Option");
			}

			if (categoryFound == false) {
				System.out.println("Category is not found.");
			}
			return categoryFound;
		}
		
		
		public static void deleteUser(ArrayList<UserAccount> currentUser, ArrayList<UserAccount> loginList) {
		}
		
		public static void deleteUser2(ArrayList<UserAccount> currentUser) {
		}
		
		public static boolean changePassword(ArrayList<UserAccount> loginList, String email, String password) {
		}
		
		public static void searchCategory(ArrayList<Item> itemList) {
			// Search biding items by category
			
			String category = Helper.readString("Search category: ");
			
			Helper.line(70, "-");
			System.out.println("ALL ITEMS");
			System.out.println("SEARCHING FOR CATEGORY: " + category);
			Helper.line(70, "-");
			category.toLowerCase();
			System.out.println();
			for (int i = 0; i < itemList.size(); i++) {
				Item item = itemList.get(i);
				String[] categoryArray = item.getCategory().split(" ");
				// System.out.println(Arrays.toString(categoryArray));
				for (int j = 0; j < categoryArray.length; j++) {
					if (category.strip().equalsIgnoreCase(categoryArray[j].strip()) || category.equalsIgnoreCase(item.getCategory())) {
						System.out.println("Item Name: " + item.getItemName() + "\nDescription: " + item.getDescription()
								+ "\nCategory: " + item.getCategory() + "\nMinimum Bid Price: $" + item.getMinimumBidPrice()
								+ "\nBid Increment: $" + item.getBidIncrement() + "\nAuction Start Date: "
								+ item.getAuctionStart());
						System.out.println();
					}
				}
			}
		}
		
		public static void searchItem(ArrayList<Item> itemList) {
			
		}
		
		public static String viewAllItems(ArrayList<Item> itemList) {
			// view all biding items

		}
		
		public static void bidItem(ArrayList<Item> itemList, ArrayList<UserAccount> currentUser) {
			
			itemMenu(itemList);
			
			String search = Helper.readString("Type item name you want to bid on: ");
			
			for (int i = 0; i < itemList.size(); i++) {
				Item item = itemList.get(i);
				String[] itemArray = item.getItemName().split(" ");
				for (int j = 0; j < itemArray.length; j++) {
					if (search.strip().equalsIgnoreCase(itemArray[j].strip()) || search.equalsIgnoreCase(item.getItemName())) {
						System.out.println("Item Name: " + item.getItemName() + "\nDescription: " + item.getDescription()
								+ "\nCategory: " + item.getCategory() + "\nMinimum Bid Price: $" + item.getMinimumBidPrice()
								+ "\nBid Increment: $" + item.getBidIncrement() + "\nAuction Start Date: "
								+ item.getAuctionStart());
						System.out.println();
					} else {
						System.out.println("Item not found.");
					}
				}
			}
			
			
		}
		
		public static void menu() {
			Helper.line(70, "=");
			System.out.println("Campus Online Auction Shop (COAS)");
			Helper.line(70, "=");
			System.out.println("1. View all Biding Items");
			System.out.println("2. Search Item Name");
			System.out.println("3. Search Biding Items by Category");
			System.out.println("4. Login");
			System.out.println("5. Register");
			System.out.println("6. Exit");
		}
		
		public static void userMenu() {
			Helper.line(70, "-");
			System.out.println("Campus Online Auction Shop (COAS)");
			System.out.println("[YOU ARE A VALID USER]");
			Helper.line(70, "-");
			System.out.println("1. View All Biding Items");
			System.out.println("2. Search Item Name");
			System.out.println("3. Search Biding Items by Category");
			System.out.println("4. Bid on Item");
			System.out.println("5. Sell an Item");
			System.out.println("6. View my Bids");
			System.out.println("7. View my Items");
			System.out.println("8. Change Password");
			System.out.println("9. Delete Account");
			System.out.println("10. Logout");
		}
		
		public static void adminMenu() {
			Helper.line(70, "-");
			System.out.println("Campus Online Auction Shop (COAS)");
			System.out.println("[YOU ARE AN ADMINISTRATOR]");
			Helper.line(70, "-");
			System.out.println("1. Manage Items");
			System.out.println("2. Manage Categories");
			System.out.println("3. Manage Bids");
			System.out.println("4. Manage Users Status");
			System.out.println("5. Logout");
		}
		
		public static void itemMenu(ArrayList<Item> itemList) {

	}
}
