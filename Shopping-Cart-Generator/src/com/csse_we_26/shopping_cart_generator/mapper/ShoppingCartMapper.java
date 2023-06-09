package com.csse_we_26.shopping_cart_generator.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.model.CartItem;
import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;



public class ShoppingCartMapper {
	
	public static ShoppingCart mapToShoppingCart(ShoppingCartDTO shoppingCartDTO) {

		List<CartItem> items = new ArrayList<>();
        for (CartItemDTO itemDTO : shoppingCartDTO.getItems()) {
        	
            items.add(mapToCartItem(itemDTO));
        }
        return new ShoppingCart(items, shoppingCartDTO.getCustomerId());
    }

	 public static CartItem mapToCartItem(CartItemDTO cartItemDTO) {

	        Product product = ProductMapper.mapToProduct(cartItemDTO.getProduct());

	        CartItem cartItem = new CartItem(cartItemDTO.getQuantity(), product);
	        return cartItem;
	 }
	 
    public static ShoppingCartDTO mapToShoppingCartDTO(ShoppingCart shoppingCart) {
 
    	List<CartItemDTO> itemDTOs = new ArrayList<>();
        for (CartItem item : shoppingCart.getItems()) {

            itemDTOs.add(mapToCartItemDTO(item));
        }
        return new ShoppingCartDTO(itemDTOs, shoppingCart.getCustomerId());
    }

    public static CartItemDTO mapToCartItemDTO(CartItem cartItem) {

    	
        ProductDTO productDTO = ProductMapper.mapToProductDTO(cartItem.getProduct(), null);
      
        CartItemDTO cartItemDTO = new CartItemDTO(productDTO, cartItem.getQuantity());

        return cartItemDTO;
    }
    
    public static ShoppingCart mapToShoppingCart(Document document) {

    	ShoppingCart shoppingCart = new ShoppingCart(document);
    	return shoppingCart;
    }
    
    public static Document mapToDocument(ShoppingCart shoppingCart) {
    	return shoppingCart.toDocument();
    }
    
    public static Document mapToDocument(CartItem cartItem) {
    	return cartItem.toDocument();
    }
    
    public static ShoppingCartDTO mapToShoppingCartDTO(Document document) {
    	return new ShoppingCartDTO(document);
    }
    
    public static CartItemDTO mapToCartItemDTO(Document document) {
    	return new CartItemDTO(document);
    }
	
}
