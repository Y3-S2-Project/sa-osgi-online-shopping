package com.csse_we_26.order_history_view.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.csse_we_26.order_history_generator.dto.OrderHistoryDTO;
import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;
import com.csse_we_26.shopping_cart_generator.service.impl.ShoppingCartServiceImpl;



public class OrderView {

	private OrderHistoryService orderHistoryService;
	private ShoppingCartService shoppingCartService ;
	public void setOrderHistoryService(OrderHistoryService orderHistoryService,ShoppingCartService shoppingCartService) {
		this.orderHistoryService = orderHistoryService;
		this.shoppingCartService= shoppingCartService;
	}

	private static String generateOrderNumber() {
		// Get the current timestamp
		long timestamp = System.currentTimeMillis();

		// Generate a random string
		String random = UUID.randomUUID().toString().substring(0, 8);

		// Combine the timestamp and random string to create the order number
		String orderNumber = String.format("%d-%s", timestamp, random);

		return orderNumber;
	}

	public void displayOrderByOrderNumber(String orderNumber) {
		OrderHistoryDTO orderHistoryDTO = orderHistoryService.getOrderByOrderNumber(orderNumber);
		if (orderHistoryDTO != null) {

			System.out.println("Order Number: " + orderHistoryDTO.getOrderNumber());
			System.out.println("Customer ID: " + orderHistoryDTO.getCustomerId());
		//	System.out.println("Order Date: " + orderHistoryDTO.getOrderDate());
			System.out.println("Shipping Address: " + orderHistoryDTO.getShippingAddress());
			System.out.println("Order Status: " + orderHistoryDTO.getOrderStatus());

			ShoppingCartDTO shoppingCartDTO = orderHistoryDTO.getShoppingCartDTO();

			System.out.println("Shopping Cart Items:");

			for (CartItemDTO cartItemDTO : shoppingCartDTO.getItems()) {
			System.out.println("\tProduct Name: " + cartItemDTO.getProduct().getName());
				System.out.println("\tQuantity: " + cartItemDTO.getQuantity());
				System.out.println("\tPrice: " + cartItemDTO.getProduct().getPrice());
			}
		} else {
			System.out.println("No orders found for order number : " + orderNumber);
		}
	}

	public void displayOrdersByCustomerId(String customerId) {
		List<OrderHistoryDTO> orders = orderHistoryService.getOrderHistoryByCustomerId(customerId);

		if (!orders.isEmpty()) {
			System.out.println("Orders for customer with ID: " + customerId);
			for (OrderHistoryDTO order : orders) {
				System.out.println("Order Number: " + order.getOrderNumber());
		//		System.out.println("Order Date: " + order.getOrderDate());
				System.out.println("Shipping Address: " + order.getShippingAddress());
				System.out.println("Order Status: " + order.getOrderStatus());

				// Display items in the shopping cart for this order
				ShoppingCartDTO shoppingCart = order.getShoppingCartDTO();
				System.out.println("Items in the shopping cart:");
				List<CartItemDTO> cartItems = shoppingCart.getItems();
				for (CartItemDTO cartItem : cartItems) {
					System.out.println("\t" + cartItem.getQuantity() + " x " + cartItem.getProduct().getName()
							+ " (Product ID: " + cartItem.getProduct().getId() + ")");
				}

				System.out.println(); // Add an empty line to separate orders
			}
		} else {
			System.out.println("No orders found for customer with ID: " + customerId);
		}
	}

	public void createOrder(String customerId, String shippingAddress) {
		// Get the shopping cart by customerID

		ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByCustomerId(customerId);

		// Check if the shopping cart belongs to the customer
		if (!shoppingCartDTO.getCustomerId().equals(customerId)) {
			System.out.println("Shopping cart does not belong to the customer.");
		} else {
			// Create a new order
			OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO(OrderView.generateOrderNumber());
			orderHistoryDTO.setCustomerId(customerId);

			orderHistoryDTO.setOrderStatus("Procession");
			orderHistoryDTO.setShippingAddress(shippingAddress);
			orderHistoryDTO.setShoppingCartDTO(shoppingCartDTO);

			// Save the order history
			orderHistoryService.createOrder(orderHistoryDTO);

			// Clear the shopping cart
			shoppingCartService.clearCart();
		}
	}
}
