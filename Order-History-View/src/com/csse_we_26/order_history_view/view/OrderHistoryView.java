package com.csse_we_26.order_history_view.view;

import java.util.Scanner;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class OrderHistoryView {

	private final OrderView orderView;
	private final Scanner scanner;

	public OrderHistoryView(OrderHistoryService orderHistoryService,ShoppingCartService shoppingCartService) {
		this.orderView = new OrderView();
		this.orderView.setOrderHistoryService(orderHistoryService,shoppingCartService);
		scanner = new Scanner(System.in);
	}

	public void displayOrderByOrderNumber(String orderNumber) {
		orderView.displayOrderByOrderNumber(orderNumber);
	}

	public void displayOrderByCustomerId(String customerId) {
		orderView.displayOrdersByCustomerId(customerId);
	}

	public void createOrder(String customerId, String shippingAddress) {
		orderView.createOrder(customerId, shippingAddress);
	}

	public void displayUI() {
		boolean isContinuing = true;

		System.out.println("Welcome to the Order History System");
		System.out.println("====================================");

		while (isContinuing) {
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. View order by order number");
			System.out.println("2. View orders by customer ID");
			System.out.println("3. Create a new order");
			System.out.println("4. Exit");

			int option = scanner.nextInt();
			System.out.println("\nPlease select an option from 1-4: ");
			scanner.nextLine(); // Consume the newline character

			switch (option) {
			case 1:
				System.out.println("\nEnter order number:");
				String orderNumber = scanner.nextLine();
				orderView.displayOrderByOrderNumber(orderNumber);
				break;
			case 2:
				System.out.println("\nEnter customer ID:");
				String customerId = scanner.nextLine();
				orderView.displayOrdersByCustomerId(customerId);
				break;
			case 3:
				System.out.println("\nEnter customer ID:");
				customerId = scanner.nextLine();
				System.out.println("\nEnter shipping address:");
				String shippingAddress = scanner.nextLine();
				orderView.createOrder(customerId, shippingAddress);
				System.out.println("\nOrder created successfully.");
				break;
			case 4:
				System.out.println("\nExiting the system...");
				isContinuing = false;
				break;
			default:
				System.out.println("\nInvalid option.");
			}
		}
	}

}
