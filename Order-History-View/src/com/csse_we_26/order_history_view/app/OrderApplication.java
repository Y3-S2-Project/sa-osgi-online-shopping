package com.csse_we_26.order_history_view.app;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.csse_we_26.order_history_generator.Order;

import com.csse_we_26.order_history_view.OrderHistoryViewService;

import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class OrderApplication {

	private OrderHistoryViewService orderHistoryViewService;
	private ShoppingCartService shoppingCartService;

	public OrderApplication(OrderHistoryViewService orderHistoryViewService, ShoppingCartService shoppingCartService) {
		this.orderHistoryViewService = orderHistoryViewService;
		this.shoppingCartService = shoppingCartService;
	}

	public String generateOrderId() {
		int randomNumber = new Random().nextInt(Integer.MAX_VALUE);
		return Integer.toString(randomNumber, 36);
	}

	public void getUserGUI() {

		boolean isContinuing = true;
		String orderId, customerId;
		Date orderDate;
		String orderStatus;


		System.out.println("=================================================================");
		System.out.println("PROCESS STARTING");
		System.out.println("=================================================================");

		while (isContinuing) {

			System.out.println("What would you like to do?");
			System.out.println("1. View all orders by customer ID");
			System.out.println("2. View order by order ID");
			System.out.println("3. Create order");
			System.out.println("4. Delete order");
			System.out.println("5. Update order status");
			System.out.println("6. Quit");

			System.out.println("");


			System.out.print("Enter your choice (1-6): ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
	
				System.out.print("Enter the customer ID: ");
				
				customerId = scanner.nextLine();

				List<Order> orders = orderHistoryViewService.getOrderByCustomerId(customerId);


				System.out.println("All orders placed by customer with ID: " + customerId);
				System.out.println("");

				for (Order order : orders) {
					System.out.println("Order ID: " + order.getId());
					System.out.println("Cart ID: " + order.getCartItems().toString());
					System.out.println("Order Date: " + order.getOrderDate());
					System.out.println("Order Status: " + order.getOrderStatus());
					System.out.println("");
				}

				break;

			case 2:
		
				System.out.print("Enter the order ID: ");
				orderId = scanner.nextLine();

				System.out.println("");

				Order order = orderHistoryViewService.getOrderByOrderId(orderId);

	
				System.out.println("Order details for Order with ID: " + orderId);
				System.out.println("");

				System.out.println("Customer Id: " + order.getUserId());
				System.out.println("Cart Items: " + order.getCartItems());
				System.out.println("Order Date: " + order.getOrderDate());
				System.out.println("Order Status: " + order.getOrderStatus());
				System.out.println("");

				break;

			case 3:

				System.out.print("Enter the Customer ID: ");
				customerId = scanner.nextLine();

				ShoppingCartDTO shoppingCart = shoppingCartService.getShoppingCartByCustomerId(customerId);
				List<CartItemDTO> products = shoppingCart.getItems();

				System.out.println("Creating order from the shopping cart...");

				List<String> productIds = new ArrayList<>();
				for (CartItemDTO product : products) {
					productIds.add(product.getProduct().getId());
				}

				orderId = generateOrderId();
				orderDate = new Date();
				orderStatus = "CREATED";

				Order createOrder = new Order(orderId, productIds, customerId, orderDate, orderStatus);

				boolean isOrderCreated = orderHistoryViewService.createOrder(createOrder);

				if (isOrderCreated) {
					System.out.println("Order created successfully");
				} else {
					System.out.println("Failed to create order");
				}

				break;

			case 4:

				System.out.println("Enter Customer ID: ");
				customerId = scanner.nextLine();

				List<Order> displayOrders = orderHistoryViewService.getOrderByCustomerId(customerId);

			
				System.out.println("These are the orders placed by customer: " + customerId);
				System.out.println("");

				for (Order order1 : displayOrders) {
					System.out.println("Order ID: " + order1.getId());
					System.out.println("Cart Items: " + order1.getCartItems().toString());
					System.out.println("Order Date: " + order1.getOrderDate());
					System.out.println("Order Status :" + order1.getOrderStatus());
					System.out.println("");
				}

				System.out.println("Enter the Order Id of the Order you want to delete: ");
				orderId = scanner.nextLine();

				Order toBeDeletedOrder = orderHistoryViewService.getOrderByOrderId(orderId);

				if (toBeDeletedOrder.getOrderStatus() == "DELIVERED") {
					System.out.println("Your order is already Delivered. Cannot cancel order now.");
					break;
				}

				boolean isOrderDeleted = orderHistoryViewService.deleteOrder(orderId);

				if (isOrderDeleted) {
					System.out.println("Order with Order ID: " + orderId + "Deleted Successfully");
				} else {
					System.out.println("Failed to delete order");
				}

				break;

			case 5:

				System.out.println("Enter Customer ID: ");
				customerId = scanner.nextLine();

				List<Order> displayOrdersToUpdate = orderHistoryViewService.getOrderByCustomerId(customerId);

		
				System.out.println("These are the orders placed by customer: " + customerId);
				System.out.println("");

				for (Order order1 : displayOrdersToUpdate) {
					System.out.println("Order ID: " + order1.getId());
					System.out.println("Cart Items: " + order1.getCartItems().toString());
					System.out.println("Order Date: " + order1.getOrderDate());
					System.out.println("Order Status" + order1.getOrderStatus());
					System.out.println("");
				}

				System.out.println("Enter the Order Id of the Order you want to update: ");
				orderId = scanner.nextLine();

				Order toBeUpdatedOrder = orderHistoryViewService.getOrderByOrderId(orderId);

				System.out.println("How would you like to update the order status?");
				System.out.println("1. PAID");
				System.out.println("2. DELIVERED");
				System.out.println("3. REFUNDED");
				System.out.println("4. CANCELLED");

				System.out.println("");
				System.out.print("Enter your choice(1-4): ");

				int orderStatusChoice = scanner.nextInt();

				switch (orderStatusChoice) {
				case 1:
					toBeUpdatedOrder.setOrderStatus("PAID");
					break;

				case 2:
					toBeUpdatedOrder.setOrderStatus("DELIVERED");
					break;

				case 3:
					toBeUpdatedOrder.setOrderStatus("REFUNDED");
					break;

				case 4:
					toBeUpdatedOrder.setOrderStatus("CANCELLED");
					break;

				default:
					toBeUpdatedOrder.setOrderStatus("CREATED");
					break;
				}

				boolean isOrderUpdated = orderHistoryViewService.updateOrder(toBeUpdatedOrder);

				if (isOrderUpdated) {
					System.out.println("Order status updated successfully!");
				} else {
					System.out.println("Failed to update order status");
				}

				break;

			case 6:
			
				isContinuing = false;

				break;

			default:
				System.out.println("Invalid choice, please try again.");

				break;
			}
			System.out.println("=========================================================================");
		}

		System.out.println("PROCESS ENDED");

		System.out.println("=========================================================================");

	}

}
