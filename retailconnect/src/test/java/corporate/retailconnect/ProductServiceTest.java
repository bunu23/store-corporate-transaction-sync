package corporate.retailconnect;

import corporate.retailconnect.dto.ProductDTO;
import corporate.retailconnect.model.Product;
import corporate.retailconnect.repository.ProductRepository;
import corporate.retailconnect.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;


import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @Test
    public void testAddProduct(){
        ProductDTO productDto=new ProductDTO();
        productDto.setName("Sample Product");
        productDto.setSku("SP001");
        productDto.setPrice(BigDecimal.valueOf(100.0));
        productDto.setTaxRate(BigDecimal.valueOf(15.0));

        productService.addProduct(productDto);
        verify(productRepository,times(1)).save(any(Product.class));


    }
}
