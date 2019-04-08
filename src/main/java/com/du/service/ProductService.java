package com.du.service;

import com.du.pojo.Category;
import com.du.pojo.Product;

import java.util.List;

public interface ProductService {
    List list(int cid);
    Product get(int id);
    void add(Product product);
    void update(Product product);
    void delete(int id);
    public void fill(List<Category> categories);
    public void fill(Category category);
    public void fillByRow(List<Category> categorys);
    void setFirstProductImage(Product p);
    void setSaleAndReviewNumber(Product p);
    void setSaleAndReviewNumber(List<Product> ps);
    List<Product> search(String keyword);
}
