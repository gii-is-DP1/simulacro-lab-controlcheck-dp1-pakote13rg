package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ps;
	
	
    public List<Product> getAllProducts(){
        return ps.findAll();
    }
    
    public List<ProductType>findAllProductTypes(){
    	return ps.findAllProductTypes();
    }
    


    public List<Product> getProductsCheaperThan(double price) {
    	List<Product> p=this.ps.findByPriceLessThan(price);
    	return p;
    }

    public ProductType getProductType(String typeName) {
        return ps.findProductType(typeName);
    }

    public Product save(Product p){
    	return ps.save(p);
               
    }

    
}
