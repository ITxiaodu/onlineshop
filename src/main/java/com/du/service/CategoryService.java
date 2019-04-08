package com.du.service;

import com.du.pojo.Category;
import com.du.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    void add(Category category);
    void update(Category category);
    void delete(int id);
    Category get(int id);

}
