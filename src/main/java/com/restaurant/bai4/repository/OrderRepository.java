package com.restaurant.bai4.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sách toàn bộ đơn hàng";
    }

    public String getOrderById(Long id) {
        return "Thông tin đơn hàng với ID: " + id;
    }
}
