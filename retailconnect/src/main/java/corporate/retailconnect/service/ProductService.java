package corporate.retailconnect.service;

import corporate.retailconnect.dto.ProductDTO;
import corporate.retailconnect.exception.ProductNotFoundException;
import corporate.retailconnect.model.Product;
import corporate.retailconnect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setSku(productDTO.getSku());
        product.setPrice(productDTO.getPrice());
        product.setTaxRate(productDTO.getTaxRate());
        productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
       List<Product> products=productRepository.findAll();
       return products.stream().map(product -> new ProductDTO(product.getName(),product.getSku(),product.getPrice(),product.getTaxRate())).collect(Collectors.toList());
    }

    public ProductDTO getProductBySku(String sku){
 Product product= productRepository.findBySku(sku).orElseThrow(()->new ProductNotFoundException("Product not found with SKU: "+sku));
 return ProductDTO.fromEntity(product);
    }
}
