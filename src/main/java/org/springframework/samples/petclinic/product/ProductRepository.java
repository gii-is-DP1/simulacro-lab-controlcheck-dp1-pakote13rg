package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    List<Product> findAll();
    
    
    @Query("select p from ProductType p")
    List<ProductType> findAllProductTypes();
    
    
    
    @Query("select p from ProductType p where p.name=?1")
    ProductType findProductType(String nombre);    
    
    
    
    @Query("select p from Product p where p.price<=?1")
    List<Product> findByPriceLessThan(Double price);
    
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
    
    
    
}
