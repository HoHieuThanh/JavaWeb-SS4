package com.restaurant.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }

    public String createOrder() {
        return "Tao don hang thanh cong";
    }

    public String deleteOrder(Long id) {
        return "Da huy don hang ID: " + id;
    }
}
