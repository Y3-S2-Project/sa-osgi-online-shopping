package com.csse_we_26.shopping_cart_manager.view;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class CartView {

	private ShoppingCartService shoppingCartService;
	private ProductListingGenerator productListingGenerator;

	public void setShoppingCartService(ShoppingCartService shoppingCartService,ProductListingGenerator productListingGenerator) {
		this.shoppingCartService = shoppingCartService;
		this.productListingGenerator =productListingGenerator;
	}

	public void displayShoppingCartByCustomerId(String customerId) {
		ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByCustomerId(customerId);

		if ( shoppingCartDTO != null) {

			System.out.println("Customer ID: " + shoppingCartDTO.getCustomerId());
			System.out.println("Shopping Cart Items:");
            List<CartItemDTO> list = (List<CartItemDTO>) shoppingCartDTO.getItems();
			for (CartItemDTO cartItemDTO : list ) {
				System.out.println("\tProduct Name: " + cartItemDTO.getProduct().getName());
			System.out.println("\tQuantity: " + cartItemDTO.getQuantity());
			System.out.println("\tPrice: " + cartItemDTO.getProduct().getPrice());
			}
		}else {
			System.out.println("No shopping cart found for customer ID : " + customerId);
		}
	}

	public void addItemToCart(String customerId, String productId, int quantity) {
		// Get the shopping cart for the customer
		ShoppingCartDTO shoppingCartDTO = shoppingCartService.getShoppingCartByCustomerId(customerId);

//		// If the shopping cart doesn't exist, create a new one
		if (shoppingCartDTO== null) {
			shoppingCartDTO = new ShoppingCartDTO();
			shoppingCartDTO.setCustomerId(customerId);
			shoppingCartDTO.setItems(new ArrayList<>());
		} 
		System.out.println(shoppingCartDTO.toString());
//		// Get the product for the given product ID
	    ProductDTO productDTO = productListingGenerator.getProductById(productId);

//
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
			shoppingCartService.addItemToCart(productDTO, quantity);
		} else {
			System.out.println("No product found for product ID: " + productId);
		}
	}
	public void removeItemFromCart(String productId) {
		shoppingCartService.removeItemFromCart(productId);
	}
	public void updateItemQuantity(String productId, int itemQuantity) {
		shoppingCartService.updateItemQuantity(productId, itemQuantity);
	}
	public void clearCart(String customerId) {
		shoppingCartService.clearCart(customerId);
	}

}
