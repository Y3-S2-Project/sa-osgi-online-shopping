package com.csse_we_26.shopping_cart_manager.view;

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
		System.out.println("====================================");

		while (isContinuing) {
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. View shopping cart by customer ID");
			System.out.println("2. Add item to shopping cart");
			System.out.println("3. Exit");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("\nEnter customer ID:");
				String customerId = scanner.next();
				displayShoppingCartByCustomerId(customerId);
				break;

			case 2:
				System.out.println("\nEnter customer ID:");
				customerId = scanner.next();
				System.out.println("\nEnter product ID:");
				String productId = scanner.next();
				System.out.println("\nEnter quantity:");
				int quantity = scanner.nextInt();
				addItemToCart(customerId, productId, quantity);
				break;

			case 3:
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
