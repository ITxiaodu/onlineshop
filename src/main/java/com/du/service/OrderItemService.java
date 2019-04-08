package com.du.service;

import com.du.pojo.Order;
import com.du.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem c);
    void delete(int id);
    void update(OrderItem c);
    List list ();
    void fill(List<Order> os);
    void fill(Order o);
    OrderItem get(int id);

    int getSaleCount(int pid);

    List<OrderItem> listByUser(int uid);
}
