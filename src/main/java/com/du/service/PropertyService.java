package com.du.service;

import com.du.pojo.Category;
import com.du.pojo.Property;

import java.util.List;

public interface PropertyService {
    void  add(Property property);
    List list(int cid);
    void delete(int id);
    Property get(int id);
    void update(Property property);
}
