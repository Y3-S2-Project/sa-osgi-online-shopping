package com.csse_we_26.shopping_cart_manager.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class CartManagerView {

	private final CartView cartView;
	private final Scanner scanner;

	public CartManagerView(ShoppingCartService shoppingCartService,ProductListingGenerator productListingGenerator) {
		this.cartView = new CartView();
		this.cartView.setShoppingCartService(shoppingCartService, productListingGenerator);
		scanner = new Scanner(System.in);
	}

	public void displayShoppingCartByCustomerId(String customerId) {
		cartView.displayShoppingCartByCustomerId(customerId);
	}

	public void addItemToCart(String customerId, String productId, int quantity) {
		cartView.addItemToCart(customerId, productId, quantity);
	}

	public void displayUI() {
		boolean isContinuing = true;

		System.out.println("Welcome to the Shopping Cart Manager");

		while (isContinuing) {
			System.out.println("====================================");
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. View shopping cart by customer ID");
			System.out.println("2. Add item to shopping cart");
			System.out.println("3. Update quatity of an item in the shopping cart");
			System.out.println("4. Remove item in the shopping cart");
			System.out.println("5. Clear the shopping cart");
			System.out.println("6. Exit");
			System.out.println("====================================");
			
		    System.out.println("");

	            // Read the user's choice
	        System.out.print("Enter your choice (1-7): ");
			int option = scanner.nextInt();
			String productId =null;
			String customerId=null;
			switch (option) {
			case 1:
				System.out.println("\nEnter customer ID:");
				customerId = scanner.next();
				displayShoppingCartByCustomerId(customerId);
				break;
			case 2:
			    List<String> itemsAdded = new ArrayList<>();
			    System.out.println("\nEnter Product Details:");
			    String continueAdding="Y";
			    System.out.println("\nEnter customer ID:");
		        customerId = scanner.next();
				do {
			       
			        System.out.println("\nEnter product ID:");
			        productId = scanner.next();
			        System.out.println("\nEnter quantity:");
			        int quantity = scanner.nextInt();
			        
			        cartView.addItemToCart(customerId, productId, quantity);
			        String itemAdded = customerId + " added " + quantity + " of product " + productId;
			        itemsAdded.add(itemAdded);
			       
			        System.out.println("\nAdd another item? (Y/N)");
			        continueAdding = scanner.next();
			    } while (continueAdding.equalsIgnoreCase("Y"));
                
				
			    // Print out all items added
			    System.out.println("\nItems added to cart:");
			    for (String item : itemsAdded) {
			        System.out.println(item);
			    }

			    break;
			case 3:
				 System.out.println("\nEnter product ID:");
			     productId = scanner.next();
			     System.out.println("\nEnter quantity:");
			     int quantity = scanner.nextInt();			     
			     cartView.updateItemQuantity(productId, quantity);
			     
			     System.out.println("\nProduct quantity updated:");

				break;
			case 4:
					System.out.println("\nEnter product ID:");
				    productId = scanner.next();
				    
				    cartView.removeItemFromCart(productId);
				break;
			case 5:
				System.out.println("\nEnter customer ID:");
				customerId = scanner.next();
				
				 cartView.clearCart(customerId);
				 
			     System.out.println("\nCartItemRemoved");
				 
				break;		


			case 6:
				System.out.println("\nExiting the system...");
				isContinuing = false;
				break;

			default:
				System.out.println("\nInvalid option.");
				break;
			}
		}
	}
}
