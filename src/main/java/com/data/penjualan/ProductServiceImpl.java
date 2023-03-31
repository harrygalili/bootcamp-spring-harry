package com.data.penjualan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product productupdate = productRepository.findById(id).get();
       productupdate.setName(product.getName());
       productupdate.setHarga(product.getHarga());
       productupdate.setStock(product.getStock());
       return productRepository.save(productupdate);
    } 

    @Override
    public Product delete(Long id) {
        Optional <Product> productdelete = productRepository.findById(id);
        if (productdelete.isPresent()){
            productRepository.delete(productdelete.get());
        }
        return productdelete.get();        
    }

    @Override
    public List<Product> list() {
        // TODO Auto-generated method stub
        List<Product> list = productRepository.findAll();
        return list;
    }

    
    
}
