package com.alguienconoce.ecommerce.controller;

import com.alguienconoce.ecommerce.domain.Product;
import com.alguienconoce.ecommerce.dto.BooleanMessage;
import com.alguienconoce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Page<Product> list(@PageableDefault(size = 12) Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable UUID id) {
        /*Product product = Product.builder()
                .name("Dibujos a lapiz scaneados de tema que quieras")
                .category("Arte")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sollicitudin, dolor a " +
                        "interdum tempus, odio augue suscipit nulla, ut posuere tortor eros non velit. Integer nec " +
                        "lectus non est vestibulum faucibus. Vestibulum ante ipsum primis in faucibus orci luctus et " +
                        "ultrices posuere cubilia curae; Pellentesque pretium lorem vitae lorem dignissim, sagittis " +
                        "consectetur leo euismod. Quisque in eros a neque hendrerit commodo ultrices sit amet eros. " +
                        "Fusce accumsan in enim a varius. Proin nec hendrerit diam. Nam ante orci, pretium eget metus " +
                        "ut, bibendum fringilla justo. Vestibulum risus nisi, faucibus et diam eget, convallis " +
                        "ullamcorper dolor. Mauris aliquet enim sodales vehicula facilisis. Proin nec erat justo. " +
                        "Praesent ac iaculis arcu.")
                .tags(Arrays.asList("Dibujo", "Lapiz", "Artista", "Colores"))
                .plans(Map.of(
                        ProductPlan.Plan.BASIC.name(), ProductPlan.builder()
                                .plan(ProductPlan.Plan.BASIC)
                                .price(45000)
                                .description("Pocos detalles, máximo 10 colores, incluye 1 revisiones, una charla " +
                                        "inicial para entender que quieres y 1 diseño inicial rápido")
                                .deliveryTime("1 Semana")
                                .build(),
                        ProductPlan.Plan.STANDARD.name(), ProductPlan.builder()
                                .plan(ProductPlan.Plan.STANDARD)
                                .price(70000)
                                .description("Más detalles, sin máximo de colores, incluye 2 revisiones, una charla " +
                                        "inicial para entender que quieres y 1 diseño inicial rápido")
                                .deliveryTime("5 días")
                                .build(),
                        ProductPlan.Plan.PREMIUM.name(), ProductPlan.builder()
                                .plan(ProductPlan.Plan.PREMIUM)
                                .price(150000)
                                .description("Cualquier pedido, sin máximo de colores, incluye 3 revisiones, una " +
                                        "charla inicial para entender que quieres y 1 diseño inicial rápido")
                                .deliveryTime("3 días")
                                .build()
                ))
                .images(Arrays.asList(
                        ProductImage.builder()
                                .original("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing.png")
                                .medium("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing-medium.png")
                                .large("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing-large.png")
                                .build(),

                        ProductImage.builder()
                                .original("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing2.jpg")
                                .medium("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing2-medium.png")
                                .large("https://storage.googleapis.com/static-product-image/product/a3945e92-1201-4918-ac71-ba85d7023996/drawing2-large.png")
                                .build()
                ))
                .build();
        return Optional.of(product);*/
        return productService.getProduct(id);
    }

    @PostMapping
    public Product get(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BooleanMessage> delete(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.ok(BooleanMessage.ok());
    }

}
