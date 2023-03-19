package mongodb_service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;



public class ShoppingCartMapper {
	
	public static ShoppingCart mapToShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        List<CartItem> items = new ArrayList<>();
        for (CartItemDTO itemDTO : shoppingCartDTO.getItems()) {
            items.add(mapToCartItem(itemDTO));
        }
        return new ShoppingCart(items, shoppingCartDTO.getCustomerId());
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
        return new ShoppingCartDTO(itemDTOs, shoppingCart.getCustomerId());
    }

    public static CartItemDTO mapToCartItemDTO(CartItem cartItem) {
        ProductMapper productMapper = new ProductMapper();
        ProductDTO productDTO = productMapper.mapToProductDTO(cartItem.getProduct(),null);
        CartItemDTO cartItemDTO = new CartItemDTO(productDTO, cartItem.getQuantity());
        return cartItemDTO;
    }
    
    public static ShoppingCart mapToShoppingCart(Document document) {
    	ShoppingCart shoppingCart = new ShoppingCart();
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
