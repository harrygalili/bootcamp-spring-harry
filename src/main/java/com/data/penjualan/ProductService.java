package com.data.penjualan;

import java.util.List;

public interface ProductService {
    public List<Product> list();
    public Product save(Product product);
    public Product update(Long id, Product product);
    public Product delete(Long id);
}
