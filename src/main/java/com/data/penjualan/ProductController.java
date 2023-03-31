package com.data.penjualan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService prod;

    @GetMapping
    public ResponseEntity<Response> list() {
        Response resp = Response.builder()
                .code("200")
                .data(prod.list())
                .message("OK")
                .build();
        return new ResponseEntity<Response>(resp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Product product) {
        Response resp = Response.builder()
                .code("200")
                .data(prod.save(product))
                .message("horey")
                .build();
                return new ResponseEntity<Response>(resp, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update (@PathVariable("id") Long id, @RequestBody Product product) {
        Response resp = Response.builder()
        .code("200")
        .data(prod.update(id, product))
        .message("horey")
        .build();
        return new ResponseEntity<Response>(resp, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete (@PathVariable("id") Long id){
        Response resp =Response.builder()
                        .code("200")
                        .data(prod.delete(id))
                        .message("delete data")
                        .build();
        return new ResponseEntity<Response>(resp,HttpStatus.OK);                
    }
}
