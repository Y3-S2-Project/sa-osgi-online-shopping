package mongodb_service;



import java.util.List;

import org.bson.Document;

public class ProductMapper {

    public Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        return product;
    }

    public ProductDTO mapToProductDTO(Product product, List<ReviewDTO> list) {
    	  ProductDTO productDTO =null;
    	if(list !=null) {
    	  productDTO = new ProductDTO.Builder().
    	            setRating(product.getRating()).setPrice(product.getPrice()).
    	            setId(product.getId()).setCategory(product.getCategory()).
    	            setDescription(product.getDescription()).
    	            setName(product.getName()).setReviews(list).build();
    	}else {
    		  productDTO = new ProductDTO.Builder().
      	            setRating(product.getRating()).setPrice(product.getPrice()).
      	            setId(product.getId()).setCategory(product.getCategory()).
      	            setDescription(product.getDescription()).
      	            setName(product.getName()).build();
    	}
    


        return productDTO;
    }
   

    public Document mapToDocument(Product product) {
        Document document = product.toDocument();

        return document;
    }

    public Product mapToProduct(Document document) {
        Product product = new Product(document);

		return product;
    }
}