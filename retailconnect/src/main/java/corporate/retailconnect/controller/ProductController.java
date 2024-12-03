package corporate.retailconnect.controller;

import corporate.retailconnect.dto.ProductDTO;
import corporate.retailconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{sku}")
    public ResponseEntity<ProductDTO> getProductBySku(@PathVariable String sku){
        ProductDTO product=productService.getProductBySku(sku);
        return ResponseEntity.ok(product);

    }

}
