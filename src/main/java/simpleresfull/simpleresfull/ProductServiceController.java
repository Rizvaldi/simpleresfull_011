/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleresfull.simpleresfull;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSI 65 SERIES
 */
@RestController
public class ProductServiceController {
   private static Map<String, Product> productRepo = new HashMap<>();
   static {
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      honey.setQuantity("3");
      honey.setPrice("Rp.25.000");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      almond.setQuantity("1");
      almond.setPrice("Rp.35.000");
      productRepo.put(almond.getId(), almond);
      
      Product kelapa = new Product();
      kelapa.setId("3");
      kelapa.setName("Kelapa");
      kelapa.setQuantity("1");
      kelapa.setPrice("Rp.6.000");
      productRepo.put(kelapa.getId(), kelapa);
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.remove(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        // Membuat kondisi di bagian update atau PUT 
        // jika tidak ada productRepo dengan nilai id yg di setting maka data tidak bisa di update
        // karena tidak bisa menemukan id yg di cari
        if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Product Not Found, Please check again", HttpStatus.NOT_FOUND);
        }
        // sedangkan productRepo nilai id nya ada dan sama maka data bisa di update
        // karena id nya ada di dalam hashmap
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new  ResponseEntity<>("Product is updated Successfully",HttpStatus.OK);
        }
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
     public ResponseEntity<Object> createProduct(@RequestBody Product product){
        if(productRepo.containsKey(product.getId())){ 
            return new ResponseEntity<>("ID Product Cannot be the Same, please check again", HttpStatus.OK);
        }
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
    }
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}
