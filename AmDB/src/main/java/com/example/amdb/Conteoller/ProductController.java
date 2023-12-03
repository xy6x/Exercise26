package com.example.amdb.Conteoller;

import com.example.amdb.Model.Product;
import com.example.amdb.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final  ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct());
    }
    @PostMapping("/add")
    public  ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
            productService.addProducts(product);
            return ResponseEntity.status(HttpStatus.OK).body("added product");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateProduct(@PathVariable String id , @RequestBody @Valid Product product, Errors errors ){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean b2 = productService.updateProducts(id,product);
        if (b2) {


            return ResponseEntity.status(HttpStatus.OK).body("update product");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter number true");
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteProduct(@PathVariable String id){
//        boolean isDelete =productService.deleteProducts(id);
//        if (isDelete) {
//            return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
//        }
//        productService.deleteProducts(id);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter id true");
//
//    }
}
