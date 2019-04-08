package com.du.service;

import com.du.pojo.Product;
import com.du.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    List<PropertyValue> list(int pid);
    void init(Product product);
    void update(PropertyValue pv);
    PropertyValue get(int ptid,int pid);
}
