package com.csse_we_26.shopping_cart_generator.mapper;

import java.util.ArrayList;
import java.util.List;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.shopping_cart_generator.DTO.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.model.CartItem;
import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;

public class ShoppingCartMapper {
	
	public static ShoppingCart mapToShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        List<CartItem> items = new ArrayList<>();
        for (CartItemDTO itemDTO : shoppingCartDTO.getItems()) {
            items.add(mapToCartItem(itemDTO));
        }
        return new ShoppingCart(items);
    }

	 public static CartItem mapToCartItem(CartItemDTO cartItemDTO) {
	        ProductMapper productMapper = new ProductMapper();
	        Product product = productMapper.mapToProduct(cartItemDTO.getProduct());
	        CartItem cartItem = new CartItem(cartItemDTO.getQuantity(), product);
	        return cartItem;
	 }
	 
    public static ShoppingCartDTO mapToShoppingCartDTO(ShoppingCart shoppingCart) {
        List<CartItemDTO> itemDTOs = new ArrayList<>();
        for (CartItem item : shoppingCart.getItems()) {
            itemDTOs.add(mapToCartItemDTO(item));
        }
        return new ShoppingCartDTO(itemDTOs);
    }

    public static CartItemDTO mapToCartItemDTO(CartItem cartItem) {
        ProductMapper productMapper = new ProductMapper();
        ProductDTO productDTO = productMapper.mapToProductDTO(cartItem.getProduct());
        CartItemDTO cartItemDTO = new CartItemDTO(productDTO, cartItem.getQuantity());
        return cartItemDTO;
    }

//	    public static ShoppingCart mapToShoppingCart(ShoppingCartDTO shoppingCartDTO) {
//	        ShoppingCart shoppingCart = new ShoppingCart();
//	        shoppingCart.setId(shoppingCartDTO.getId());
//	        shoppingCart.setUserId(shoppingCartDTO.getUserId());
//
//	        List<CartItem> cartItems = new ArrayList<>();
//	        for (CartItemDTO cartItemDTO : shoppingCartDTO.getCartItems()) {
//	            CartItem cartItem = new CartItem();
//	            cartItem.setId(cartItemDTO.getId());
//	            cartItem.setQuantity(cartItemDTO.getQuantity());
//	            cartItem.setProduct(ProductMapper.mapToProduct(cartItemDTO.getProduct()));
//	            cartItems.add(cartItem);
//	        }
//	        shoppingCart.setCartItems(cartItems);
//
//	        return shoppingCart;
//	    }
//
//	    public static ShoppingCartDTO mapToShoppingCartDTO(ShoppingCart shoppingCart) {
//	        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
//	        shoppingCartDTO.setId(shoppingCart.getId());
//	        shoppingCartDTO.setUserId(shoppingCart.getUserId());
//
//	        List<CartItemDTO> cartItemDTOs = new ArrayList<>();
//	        for (CartItem cartItem : shoppingCart.getCartItems()) {
//	            CartItemDTO cartItemDTO = new CartItemDTO();
//	            cartItemDTO.setId(cartItem.getId());
//	            cartItemDTO.setQuantity(cartItem.getQuantity());
//	            cartItemDTO.setProduct(ProductMapper.mapToProductDTO(cartItem.getProduct()));
//	            cartItemDTOs.add(cartItemDTO);
//	        }
//	        shoppingCartDTO.setCartItems(cartItemDTOs);
//
//	        return shoppingCartDTO;
//	    }
	
}
