package com.csse_we_26.shopping_cart_manager.view;

import java.util.ArrayList;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.product_listing_generator.service.impl.ProductListingGeneratorImpl;
import com.csse_we_26.shopping_cart_generator.DTO.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class CartView {

	private ShoppingCartService shoppingCartService;
	private ProductListingGenerator productListingGenerator;

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public void displayShoppingCartByCustomerId(String customerId) {
		ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByCustomerId(customerId);
		if (shoppingCartDTO != null) {
			System.out.println("Customer ID: " + shoppingCartDTO.getCustomerId());
			System.out.println("Shopping Cart Items:");

			for (CartItemDTO cartItemDTO : shoppingCartDTO.getItems()) {
				System.out.println("\tProduct Name: " + cartItemDTO.getProduct().getName());
				System.out.println("\tQuantity: " + cartItemDTO.getQuantity());
				System.out.println("\tPrice: " + cartItemDTO.getProduct().getPrice());
			}
		} else {
			System.out.println("No shopping cart found for customer ID : " + customerId);
		}
	}

	public void addItemToCart(String customerId, String productId, int quantity) {
		// Get the shopping cart for the customer
		ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByCustomerId(customerId);

		// If the shopping cart doesn't exist, create a new one
		if (shoppingCartDTO == null) {
			shoppingCartDTO = new ShoppingCartDTO();
			shoppingCartDTO.setCustomerId(customerId);
			shoppingCartDTO.setItems(new ArrayList<>());
		}

		// Get the product for the given product ID
		ProductDTO productDTO = productListingGenerator.getProductById(productId);

		if (productDTO != null) {
			// Check if the product is already in the shopping cart
			boolean itemFound = false;
			for (CartItemDTO cartItemDTO : shoppingCartDTO.getItems()) {
				if (cartItemDTO.getProduct().getId() == productId) {
					// If the product is already in the shopping cart, update the quantity
					cartItemDTO.setQuantity(cartItemDTO.getQuantity() + quantity);
					itemFound = true;
					break;
				}
			}

			// If the product is not already in the shopping cart, add it
			if (!itemFound) {
				CartItemDTO cartItemDTO = new CartItemDTO();
				cartItemDTO.setQuantity(quantity);
				cartItemDTO.setProduct(productDTO);
				shoppingCartDTO.getItems().add(cartItemDTO);
			}

			// Save the shopping cart
			shoppingCartService.saveShoppingCart(shoppingCartDTO);
		} else {
			System.out.println("No product found for product ID: " + productId);
		}
	}

}
